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
    <%@include file="common/head.jsp" %>
    <link href="/resources/lib/zui-1.6.0/lib/uploader/zui.uploader.min.css" rel="stylesheet">
    <link href="/resources/lib/zui-1.6.0/lib/datatable/zui.datatable.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="panel">
        <div class="panel-body">

            <div id="uploaderExcel" class="uploader">
                <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i>导入excel</button>
            </div>
            <br>
            <div class="form-inline">
                <div class="form-group select-margin">
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
            </div>
            <br>
            <div class="form-inline">
                <div class="form-group">
                    <label>学号</label>
                    <input type="text" class="form-control" placeholder="学号">
                </div>
                <span></span>
                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" class="form-control" placeholder="姓名">
                </div>
                <a class="btn btn-primary" href="#">查询</a>
            </div>

            <br>
            <table class="table datatable">
                <thead>
                <tr>
                    <th>专业</th>
                    <th>班级</th>
                    <th>科目</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>得分</th>

                </tr>
                </thead>
                <tbody>
                <tr></tr>
                <tr></tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="/resources/lib/jquery-1.7.2.min.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="/resources/lib/zui-1.6.0/js/zui.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/chosen/chosen.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/uploader/zui.uploader.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/datatable/zui.datatable.min.js"></script>
<script>
    var opts = {
        autoUpload: true,            // 当选择文件后立即自动进行上传操作
        url: '/upload',  // 文件上传提交地址
        file_data_name: 'file',			//定义表单参数
        filters: {						//指定上传文件的类型、大小
            mime_types: [
                {title: 'excel文件', extensions: 'xls,xlsx'}
            ],
            max_file_size: '10mb'
        },
        chunk_size: '0',
        multipart_params: {
            randNum: Math.random()
        }

    };
    $('#uploaderExcel').uploader(opts);

    $('table.datatable').datatable({checkable: true, sortable: true});
</script>
</html>
