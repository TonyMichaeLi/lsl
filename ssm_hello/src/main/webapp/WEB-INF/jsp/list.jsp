<%--
  Created by IntelliJ IDEA.
  User: 25712
  Date: 2021/1/6
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>类别页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>

    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("#formDelete").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>类别列表 —— 显示所有类别</small>
                    </h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="/category/toAdd">添加分类</a>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>类别</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="l">
                        <tr>
                            <td>${l.id}</td>
                            <td>${l.name}</td>
                            <td>
                                <a href="/category/categorys/${l.id}">更改</a> |
                                <a class="delete" href="/category/categorys/${l.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <form id="formDelete" action="" method="POST" >
                    <input type="hidden" name="_method" value="DELETE">
                </form>

                <div style="text-align: center">
                    <label>
                        共 ${total} 条记录 | 每页 ${page.count} 条记录
                    </label>
                    <a class="btn btn-primary" href="?start=0">首 页</a>
                    <a class="btn btn-primary" href="?start=${page.start-page.count < 0 ? page.start : page.start-page.count}">上一页</a>
                    <label>
                        当前第 ${page.currentPage} 页
                    </label>
                    <a class="btn btn-primary" href="?start=${page.start+page.count >= total ? page.start : page.start+page.count}">下一页</a>
                    <a class="btn btn-primary" href="?start=${page.last}">末 页</a>
                    <label>
                        共 ${totalPage} 页
                    </label>
                </div>

            </div>
            <div>

            </div>
        </div>
</div>
</body>
</html>
