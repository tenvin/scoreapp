<%--
  Created by IntelliJ IDEA.
  User: tenvin
  Date: 2017/7/28
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="form-inline">
        <label>学期 :</label>
        <select name="XueqiMenu" data-placeholder="--选择学期--" class="chosen-select form-control">
            <option value=""></option>
            <c:forEach items="${xueqis}" var="xueqi">
                <option value="${xueqi.xqName}">${xueqi.xqName}</option>
            </c:forEach>
        </select>

        <label>专业 :</label>
        <select name="XueqiMenu" data-placeholder="--选择专业--" class="chosen-select form-control">
            <option value=""></option>
            <c:forEach items="${xueqis}" var="xueqi">
                <option value="${xueqi.xqName}">${xueqi.xqName}</option>
            </c:forEach>
        </select>

        <label>班级 :</label>
        <select name="XueqiMenu" data-placeholder="--选择班级--" class="chosen-select form-control">
            <option value=""></option>
            <c:forEach items="${xueqis}" var="xueqi">
                <option value="${xueqi.xqName}">${xueqi.xqName}</option>
            </c:forEach>
        </select>

    </div>
    <div class="form-inline">
        <div class="form-group">
            <label>学号 </label>
            <input type="text" class="form-control" placeholder="学号">
        </div>
        <span></span>
        <div class="form-group">
            <label>姓名 </label>
            <input type="text" class="form-control" placeholder="姓名">
        </div>
        <a id="chaxun" class="btn btn-primary" href="#">查询</a>
    </div>


    <!-- toolbar-->
    <div id="toolbar" class="btn-group">
        <button type="button" class="btn btn-default" id="save">
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button type="button" class="btn btn-default">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
    <!-- table list-->
    <table id="table"
           data-toggle="table"
           data-height="550"
           data-url="#"
           data-search="true"
           data-pagination="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="true"
           data-striped="true"
           data-toolbar="#toolbar">
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th data-field="N_ID">ID</th>--%>
            <%--<th data-field="VC_NAME">NAME</th>--%>
            <%--<th data-field="VC_LIKE">LIKE</th>--%>
            <%--<th data-field="VC_NOTE">NOTE</th>--%>
            <%--<th data-field="N_ID" data-events="actionEvents" data-formatter="actionFormatter">ACTION</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
    </table>
    <!-- table list-->

    <!-- edit modal-->
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content" id="content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">Edit Data</h4>
                </div>
                <div class="modal-body" id="editBody">
                </div>
            </div>
        </div>
    </div>
    <!-- edit modal-->
    <!-- save modal-->
    <div id="saveModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content" id="content1">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel1">Edit Data</h4>
                </div>
                <div class="modal-body" id="editBody1">
                </div>
            </div>
        </div>
    </div>
    <!-- save modal-->
</div>

</body>

<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/layer/2.4/layer.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<%----%>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->--%>
<%--<script src="/resources/lib/zui-1.6.0/js/zui.min.js"></script>--%>
<%--<script src="/resources/lib/zui-1.6.0/lib/datetimepicker/datetimepicker.min.js"></script>--%>
<%--<script src="/resources/lib/zui-1.6.0/lib/chosen/chosen.min.js"></script>--%>
<%--<script src="/resources/lib/zui-1.6.0/lib/uploader/zui.uploader.min.js"></script>--%>
<%--<script src="/resources/lib/zui-1.6.0/lib/datatable/zui.datatable.min.js"></script>--%>

<script src="/resources/js/scoreapp.js"></script>
<script type="text/javascript">

</script>
</html>