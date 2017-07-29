<%--
  Created by IntelliJ IDEA.
  User: tenvin
  Date: 2017/7/27
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <%@include file="common/head.jsp" %>
    <link href="/resources/lib/zui-1.6.0/lib/uploader/zui.uploader.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div>
        <form id="uploadFile" action="/upload" method="post" enctype="multipart/form-data">

            <div>
                <select name="XueqiMenu" >
                    <option value="">---请选择学期--</option>
                    <c:forEach items="${xueqis}" var="xueqi">
                        <option value="${xueqi.xqName}">${xueqi.xqName}</option>
                    </c:forEach>
                </select>
            </div>

            <h1>上传文件</h1>
            <input type="file" name="file">
            <input type="submit" value="upload"/>
        </form>
    </div>

</div>


</body>
<script type="text/javascript" src="/resources/lib/jquery-1.7.2.min.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="/resources/lib/zui-1.6.0/js/zui.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/chosen/chosen.min.js"></script>
<script src="/resources/lib/zui-1.6.0/lib/uploader/zui.uploader.min.js"></script>
<script>
    var opts = {
        autoUpload: true,            // 当选择文件后立即自动进行上传操作
        url: '${path}/score/excelImport',  // 文件上传提交地址
        file_data_name: 'file',			//定义表单参数
        filters: {						//指定上传文件的类型、大小
            mime_types: [
                {title: 'excel文件', extensions: 'xls,xlsx'}
            ],
            max_file_size: '100mb'
        },
        chunk_size: '0',
        multipart_params: {
            randNum: Math.random()
        },
        onFileUpload: function(file) {
            layer.alert('上传成功1111111111111')
        },
        //当某一个文件上传完成后回调
        onFileUploaded: function(file, responseObject) {
            alert('上传成功!');
            var jsonObj = JSON.parse(responseObject.response);
            if (jsonObj.status == 'error') {
                layer.alert('选择Excel文件格式或内容出错!');
            } else if (jsonObj.status == 'success') {
                layer.alert('Excel文件上传成功!');
            } else {
                layer.alert('nothing');
            }
        }
    };
    $('#uploaderExcel').uploader(opts);
</script>
</html>
