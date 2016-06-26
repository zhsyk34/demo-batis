<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons.jsp"%>
<html>
<head>
<title>房源管理</title>
<link rel="stylesheet" href="css/util/layout.css">
<link rel="stylesheet" href="js/lib/zhsy/css/modal.css">
<link rel="stylesheet" href="js/lib/zhsy/css/page.css">
</head>
<body>
	<header>
		<h3>房源管理</h3>
		<nav>
			<div class="inline group">
				<label class="addon" for="search-name">名称</label><input id="search-name" class="text">
			</div>
			<div class="inline group">
				<label class="addon" for="search-state">托管状态</label> <select class="text" id="search-state">
					<option value="">全部</option>
					<option value="both">均可</option>
					<option value="whole">整租</option>
					<option value="single">单租</option>
					<option value="stop">冻结</option>
				</select>
			</div>
			<div class="inline group">
				<label class="addon" for="search-used">出租状态</label> <select class="text" id="search-used">
					<option value="">全部</option>
					<option value="1">已出租</option>
					<option value="0">未出租</option>
				</select>
			</div>
			
			<div class="inline">
				<button class="btn btn-primary btn-small" id="find">查询</button>
			</div>
		</nav>
	</header>

	<div class="main">
		<table class="table table-hover">
			<thead>
				<tr>
					<th width="5%"><input id="check-parent" type="checkbox"></th>
					<th width="15%">名称</th>
					<th width="15%">面积</th>
					<th width="15%">托管状态</th>
					<th width="15%">出租状态</th>
					<th width="20%">建造日期</th>
					<th width="15%">租房</th>
				</tr>
			</thead>
			<tbody id="data"></tbody>
		</table>
	</div>

	<footer>
		<div id="page"></div>
	</footer>

	<div id="editor">
		<table class="table table-hover table-edit">
			<tr>
				<th><input type="hidden" id="id"></th>
				<td><input class="text" id="name"></td>
			</tr>
		</table>
	</div>

	<script src="js/lib/require.js" data-main="module/demo/house"></script>
</body>
</html>

