<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>

<html>
<head>
    <title>成绩管理系统</title>
    <%@include file="common/head.jsp" %>
</head>

<body>

<div class="wrapper">
    <!-- header页面 -->
    <div class="header">
        <div class="logo_text" style="cursor: pointer;">学生成绩系统</div>
        <div class="btn-container">
            <a href=""><img title="个人信息" src="/resources/img/user.png"></a>
            <a href="" onclick="logOut()"><img title="退出" src="/resources/img/exit.png"></a>
        </div>
    </div>
    <%--<div class="ct"></div>--%>
    <div style="width: 100%; height: 100%">
        <!-- 左侧菜单列表 -->
        <div class="left">
            <nav class="menu" data-ride="menu" style="width: 100%">
                <ul class="nav nav-primary nav-stacked">
                    <%--<li><a href="/upload" target="rightFrame"><i class="icon icon-list-ul"></i> 成绩管理</a></li>--%>
                    <li><a href="/score" target="rightFrame"><i class="icon icon-user"></i> 成绩管理</a></li>


                </ul>
            </nav>
        </div>
        <!-- 右侧内容区域 -->
        <div class="right">
            <iframe name="rightFrame"
                    id="rightFrame"
                    src=""
                    width="100%"
                    height="100%"
                    frameborder="0"
            ></iframe>
        </div>
    </div>

</div>

</body>
<script type="text/javascript" src="/resources/lib/jquery-1.7.2.min.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="/resources/lib/zui-1.6.0/js/zui.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/chosen/chosen.min.js"></script>
<script src="/resources/js/scoreapp.js" type="text/javascript"></script>
</html>