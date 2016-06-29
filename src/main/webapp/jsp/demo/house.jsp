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
				<button class="btn btn-info btn-small" id="clear">清空</button>
			</div>
		</nav>
	</header>

	<div class="main">
		<table class="table table-hover">
			<thead>
				<tr>
					<th width="5%">序号</th>
					<th width="10%">名称</th>
					<th width="10%">面积</th>
					<th width="10%">托管状态</th>
					<th width="10%">出租状态</th>
					<th width="15%">出租单价</th>
					<th width="15%">租金</th>
					<th width="15%">建造日期</th>
					<th width="10%">租房</th>
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
				<th>类型</th>
				<td id="type"><label><input type="radio" name="type" value="house">整租</label> <label><input type="radio" name="type" value="room">单租</label></td>
			</tr>
			<tr>
				<th><input type="hidden" id="id">名称</th>
				<td><input class="text" id="name" readonly></td>
			</tr>
			<tr>
				<th>面积</th>
				<td><input class="text" id="area" readonly placeholder="//TODO : 根据选择自动计算..."></td>
			</tr>
			<tr>
				<th>房间</th>
				<td><input class="text" id="rooms" readonly placeholder="//TODO : 根据选择自动计算..."></td>
			</tr>
			<tr>
				<th>租金</th>
				<td><input class="text" id="money" readonly placeholder="//TODO : 根据选择自动计算..."></td>
			</tr>
			<tr>
				<table class="table">
					<thead>
						<tr>
							<th><input type="checkbox" id="room-parent"></th>
							<th>名称</th>
							<th>面积</th>
							<th>单价</th>
							<th>租金</th>
							<th>出租状态</th>
						</tr>
					</thead>
					<tbody id="room-data"></tbody>
				</table>
			</tr>
		</table>
	</div>

	<script src="js/lib/require.js" data-main="module/demo/house"></script>
</body>
</html>

