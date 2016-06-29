require([ "jquery", "modal", "page", "checkctrl", "crud", "validate", "tool" ], function($, modal, page, checkctrl, crud, validate, tool) {
	checkctrl.table($(".main table"));
	dialog();
	search();
	find();
	// remove();

	function dialog() {
		$("#editor").modal({
			width : 500,
			top : 100,
			before : function() {
				return save();
			},
			reset : function() {
				loadDialog();
			}
		});
		$("table").on("click", ".operation", function() {

			var row = $(this).parents("tr").data("row");
			$("#editor").modal("title", row.rentState + "选房");
			$("#editor").data("row", row);
			loadDialog();
			$("#editor").modal("open");
		});

		function loadDialog() {
			var row = $("#editor").data("row");
			if (row) {
				var houseId = row.id;
				$("#id").val(houseId);
				$("#name").val(row.name);
				// $("#area").val(row.area);
				// $("#rooms").val(row.rooms);

				$.ajax({
					url : "grid/room",
					data : {
						houseId : houseId
					},
					success : function(data) {
						loadRoom(row.rentState, data);
					}
				});
			} else {
				$("#editor").modal("clear");
			}

			function select() {
				function check() {
					var type = $("#type").find(":radio:checked").val();
					if (type == "house") {
						$("#room-data").find(":checkbox").prop("checked", true).prop("disabled", true);
					} else {
						$("#room-data").prop("disabled", false);
					}
				}
				$("#type").on("change", ":radio", function() {
					check();
				});

			}

			function loadRoom(state, data) {
				var type = $("#type");

				$("#room-data").empty();
				$("#room-parent").prop("checked", false).prop("disabled", false);// 取消禁用

				var str = "<tr>";
				str += "<td><input type='checkbox'></td>";
				str += "<td class='name'></td>";
				str += "<td class='area'></td>";
				str += "<td class='price'></td>";
				str += "<td class='total'></td>";
				str += "<td class='used'></td>";
				str += "</tr>";

				var btn = "<button class='btn btn-small btn-success'>选房</button>";

				$.each(data, function(index, row) {
					var used = row.used;

					var tr = $(str).data("row", row);
					tr.find(":checkbox").val(row.id);
					tr.find(".name").text(row.name);
					tr.find(".area").text(row.area);
					tr.find(".price").text(row.price + " " + row.unit);

					switch (row.calcType) {
					case "COUNT":
						tr.find(".total").text(row.price);
						break;
					case "RULING":
						tr.find(".total").text((row.price * row.area).toFixed(2));
						break;
					}

					tr.find(".used").text(used ? "已出租" : "未出租");

					used && (tr.find(":checkbox").prop("checked", false).prop("disabled", true));

					$("#room-data").append(tr);
				});

				// 托管类型
				switch (state) {
				case "BOTH":
					type.find(":radio:first").prop("checked", true);
					type.find(":radio").prop("disabled", false);
					break;
				case "WHOLE":
					type.find(":radio[value='house']").prop("checked", true);
					type.find(":radio").prop("disabled", true);
					// 整租不允许选择
					$("#room-parent").prop("checked", true).prop("disabled", true);
					break;
				case "SINGLE":
					type.find(":radio[value='room']").prop("checked", true);
					type.find(":radio").prop("disabled", true);
					break;
				case "STOP":
					// 正常操作不会出现...
					$.alert("不是吧?");
					type.find(":radio").prop("checked", false);
					type.find(":radio").prop("disabled", true);
					break;
				}
				select();

				checkctrl.general($("#room-parent"), $("#room-data").find("td :checkbox"));
			}
		}
	}

	function save() {// 保存订单
		var houseId = parseInt($("#id").val()) || null;

		var type = $(":radio[name='type']:checked").val();

		var roomIds = [];
		$("#room-data").find(":checkbox:checked").each(function() {
			var roomId = parseInt($(this).val());
			roomIds.push(roomId);
		});

		if (!houseId) {
			$.alert("不会吧?");
			return false;
		}

		if (validate.isEmpty(type)) {
			$.alert("请选择出租类型");
			return false;
		}

		if (roomIds.length == 0) {
			$.alert("请选择房间");
			return false;
		}

		var url = "grid/save";
		var params = {
			houseId : houseId,
			type : type,
			roomIds : roomIds
		};

		crud.merge(url, params, find);
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
		$("#clear").on("click", function() {
			$("#search-name").val("");
			$("nav").find("select").each(function() {
				$(this).find("option:first").prop("selected", true);
			});

		});
	}

	function find() {
		var name = $.trim($("#search-name").val());
		var state = $.trim($("#search-state").val());
		var used = $.trim($("#search-used").val());
		var options = $("#page").page("options");
		$.ajax({
			url : "grid/house",
			data : {
				name : name,
				state : state,
				used : used,
				pageNo : options.pageNo,
				pageSize : options.pageSize
			},
			success : function(data) {
				console.log(data);
				load(data.list || []);
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
			str += "<td class='price'></td>";
			str += "<td class='total'></td>";
			str += "<td class='build'></td>";
			str += "<td class='operation'></td>";
			str += "</tr>";

			var btn = "<button class='btn btn-small btn-success'>选房</button>";

			$.each(data, function(index, row) {
				var tr = $(str).data("row", row);
				tr.find(".index").text(index + 1);
				tr.find(".name").text(row.name);
				tr.find(".area").text(row.area);
				tr.find(".price").text(row.price + "  " + row.unit);

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

				switch (row.calcType) {
				case "COUNT":
					tr.find(".total").text(row.price);
					break;
				case "RULING":
					tr.find(".total").text((row.price * row.area).toFixed(2));
					break;
				}

				!row.used && state != "STOP" && (tr.find(".operation").html(btn));

				$("#data").append(tr);
			});
		}
	}
});
