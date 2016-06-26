<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/jsp/commons.jsp" %>
<html>
<head>
    <title>房源管理</title>
    <link rel="stylesheet" href="css/util/layout.css">
    <link rel="stylesheet" href="js/lib/zhsy/css/modal.css">
    <link rel="stylesheet" href="js/lib/zhsy/css/page.css">
</head>
<body>
<header>
    <h3>
        房源管理
    </h3>
    <nav>
        <div class="inline group">
            <label class="addon" for="search"></label><input id="search" class="text">
        </div>
        <div class="inline">
            <button class="btn btn-primary btn-small" id="find"> 查询</button>
        </div>
        <div class="inline">
            <button class="btn btn-success btn-small" id="add">
            </button>
        </div>
        <ul class="inline" id="check-ctrl">
            <li class="inline">
                <button class="btn btn-info btn-small" id="check-all">
                </button>
            </li>
            <li class="inline">
                <button class="btn btn-info btn-small" id="check-inverse">
                </button>
            </li>
            <li class="inline">
                <button class="btn btn-info btn-small" id="check-cancel">
                </button>
            </li>
            <li class="inline">
                <button class="btn btn-danger btn-small" id="del-all">
                </button>
            </li>
        </ul>
    </nav>
</header>

<div class="main">
    <table class="table table-hover">
        <thead>
        <tr>
            <th width="10%"><input id="check-parent" type="checkbox"></th>
            <th width="15%"></th>
            <th width="35%"></th>
            <th width="40%"></th>
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

<script src="js/lib/require.js" data-main=""></script>
</body>
</html>

