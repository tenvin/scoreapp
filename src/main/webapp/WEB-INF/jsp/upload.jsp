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

<div class="upload">

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

</script>
</html>
