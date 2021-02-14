<%--
  Created by IntelliJ IDEA.
  User: 25712
  Date: 2021/1/6
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增分类</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="/category/categorys" method="post">
        类别名:<input type="text" name="name"><br><br><br>
        <button class="btn btn-primary" type="submit" value="确定">提交</button>
    </form>
</body>
</html>
