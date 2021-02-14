<%--
  Created by IntelliJ IDEA.
  User: 25712
  Date: 2021/1/6
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改分类</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="/category/categorys/${category.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="${category.id}">
        类别名:<input type="text" name="name" value="${category.name}">
        <input type="submit" class="btn btn-primary" value="确定"/>
    </form>
</body>
</html>
