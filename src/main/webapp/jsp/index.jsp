<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons.jsp"%>
<html>
<head>
<link rel="stylesheet" href="css/lib/init.css">
<link rel="stylesheet" href="css/module/index.css">
<title>简陋首页</title>
</head>
<body>
	<div id="container">
		<nav id="nav">
			<div class="accordion">
				<p>房屋</p>
				<ul>
					<li><a href="jsp/demo/house.jsp">房源</a></li>
					<li><a href="jsp/demo/order.jsp">订单</a></li>
				</ul>
			</div>
		</nav>
		<div id="content">
			<iframe src=""></iframe>
		</div>
	</div>

	<div id="footer">
		<span id="date"></span>
	</div>

	<script src="js/lib/require.js" data-main="module/index"></script>
</body>
</html>

