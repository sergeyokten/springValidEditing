<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>

        <link rel="stylesheet" href="/xxx/main.css">
    </head>
    <body>

        <form action="/saveMe" method="post">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input type="" name="username" placeholder="username">
            <input type="" name="password" placeholder="password">
            <input type="submit" name="" placeholder="">

        </form>


        <sec:authorize access="isAuthenticated()">

            <form action="/logoutME" method="post">
                <input type="submit" name="" placeholder="">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>

            </form>

        </sec:authorize>


        <a href="asd/"${x}">path</a>
        <%--<form action="/save/user" method="post">--%>
        <%--<input type="" name="name" placeholder="name">--%>
        <%--<input type="submit" name="" placeholder="">--%>

        <%--</form>--%>

        <%--<form action="/save/car" method="post">--%>
        <%--<input type="" name="model" placeholder="model">--%>
        <%--<input type="submit" name="" placeholder="">--%>

        <%--</form>--%>

        <sf:form action="/save/user" method="post" modelAttribute="userModel">
            <sf:input path="name"/>
            <sf:errors path="name"/>
            <input type="submit" name="" placeholder="">
        </sf:form>

        <sf:form action="/save/car" method="post" modelAttribute="carModel">
            <sf:input path="model"/>
            <input type="submit" name="" placeholder="">

        </sf:form>


        <form action="sc" method="post" enctype="multipart/form-data">
            <input type="email" name="email" placeholder="email">
            <input type="file" name="file" placeholder="file">
            <input type="submit" name="" placeholder="">


        </form>


    </body>
</html>
