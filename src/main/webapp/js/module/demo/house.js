require([ "jquery", "modal", "page", "checkctrl", "crud", "validate", "tool" ], function($, modal, page, checkctrl, crud, validate, tool) {
	checkctrl.table($(".main table"));
	// dialog();
	search();
	find();
	// remove();

	function dialog() {
		$("#editor").modal({
			width : 300,
			top : 100,
			before : function() {
				return merge();
			},
			reset : function() {
				loadDialog();
			}
		});
		$("#add").on("click", function() {
			$("#editor").modal("title", "");
			$("#editor").removeData("row");
			loadDialog();
			$("#editor").modal("open");
		});
		$("table").on("click", ".update", function() {
			$("#editor").modal("title", "");
			var row = $(this).parents("tr").data("row");
			$("#editor").data("row", row);
			loadDialog();
			$("#editor").modal("open");
		});

		function loadDialog() {
			var row = $("#editor").data("row");
			if (row) {
				$("#id").val(row.id);
				$("#name").val(row.name);
			} else {
				$("#editor").modal("clear");
			}
		}
	}

	function merge() {
		var id = parseInt($("#id").val()) || null;
		var name = $.trim($("#name").val());
		var url = id ? "json/Style_update" : "json/Style_save";

		if (validate.isEmpty(name)) {
			$.alert("名称不能为空");
			return false;
		}

		var params = {
			id : id,
			name : name
		};

		var exist = true;
		$.ajax({
			url : "json/Style_exist",
			async : false,
			data : params,
			success : function(data) {
				exist = data.exist;
			}
		});
		if (exist) {
			$.alert("");
			return false;
		}

		crud.merge(url, params, find);
	}

	function remove() {
		var url = "json/Style_delete";
		$("#data").on("click", ".del", function() {
			var id = parseInt($(this).parents("tr").find(":checkbox").val());
			crud.del(url, id, find);
		});
		$("#del-all").on("click", function() {
			var ids = [];
			$('#data :checkbox:checked').each(function() {
				var id = parseInt($(this).val());
				ids.push(id);
			});
			crud.del(url, ids, find);
		});
	}

	function search() {
		crud.page(null, find);
		$("#find").on("click", function() {
			$("#page").page({
				pageNo : 1
			});
			find();
		});
		$("nav").on("change", "select", function() {
			$("#page").page({
				pageNo : 1
			});
			find();
		});
	}

	function find() {
		var name = $.trim($("#search-name").val());
		var state = $.trim($("#search-state").val());
		var used = $.trim($("#search-used").val());
		var options = $("#page").page("options");
		$.ajax({
			url : "grid/list",
			data : {
				name : name,
				state : state,
				used : used,
				pageNo : options.pageNo,
				pageSize : options.pageSize
			},
			success : function(data) {
				load(data);
				crud.page(data, find);
			}
		});

		function load(data) {
			$("#data").empty();
			$("#check-parent").prop("checked", false);

			console.log(data);

			var str = "<tr>";
			str += "<td class='index'></td>";
			str += "<td class='name'></td>";
			str += "<td class='area'></td>";
			str += "<td class='state'></td>";
			str += "<td class='used'></td>";
			str += "<td class='build'></td>";
			str += "<td class='operation'></td>";
			str += "</tr>";

			var btn = "<button class='btn btn-small btn-success'>选房</button>";

			$.each(data, function(index, row) {
				var tr = $(str).data("row", row);
				tr.find(".index").text(index + 1);
				tr.find(".name").text(row.name);
				tr.find(".area").text(row.area);

				var state = row.rentState;
				var used = row.used;

				tr.find(".used").text(used ? "已出租" : "未出租");
				tr.find(".build").text(new Date(row.buildTime).format("yyyy-MM-dd HH:mm:ss"));

				switch (state) {
				case "BOTH":
					tr.find(".state").text("自选");
					break;
				case "WHOLE":
					tr.find(".state").text("整租");
					break;
				case "SINGLE":
					tr.find(".state").text("单租");
					break;
				case "STOP":
					tr.find(".state").text("冻结");
					break;
				}

				if (!row.used && state != "STOP") {
					tr.find(".operation").html(btn);
				}

				$("#data").append(tr);
			});
		}
	}
});
