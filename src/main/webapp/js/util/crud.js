define([ "jquery", "modal", "page" ], function() {
	return {
		page : function(data, callback, target) {
			var options = {
				onChangePage : function(pageNo, pageSize) {
					typeof callback == "function" && callback();
				}
			};
			if (data) {
				options.pageNo = data.pageNo;
				options.pageSize = data.pageSize;
				options.dataCount = data.count;
			}
			(target || $("#page")).page(options);
		},
		merge : function(url, params, callback) {
			$.ajax({
				url : url,
				async : false,
				traditional : true,
				data : params,
				success : function(data) {
					switch (data.result) {
					case "create":
						$.alert();
						break;
					case "update":
						$.alert();
						break;
					case "enable":
						$.alert();
						break;
					case "disable":
						$.alert();
						break;
					case "deal":
						$.alert();
						break;
					case "revoke":
						$.alert();
						break;
					case "error":
						$.alert();
						return;
					}
					typeof callback == "function" && callback();
				}
			});
		},
		del : function(url, ids, callback) {
			typeof ids == "number" && (ids = [ ids ]);
			if (ids.length == 0) {
				$.alert();
				return;
			}
			$.confirm({
				after : function() {
					$.ajax({
						url : url,
						traditional : true,
						async : false,
						data : {
							ids : ids
						},
						success : function(data) {
							switch (data.result) {
							case "relate":
								$.alert();
								return;
							case "delete":
								$.alert();
								break;
							case "revoke":
								$.alert();
								break;
							}
							$("#page").page({
								pageNo : 1
							});
							typeof callback == "function" && callback();
						}
					});
				}
			});
			$.confirm();
		}
	};
});