<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <form action="/zxc" method="post">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            <input type="" name="usernameX" placeholder="usernameX">
            <input type="" name="passwordX" placeholder="passwordX">
            <input type="submit" name="" placeholder="">

        </form>

    </body>
</html>
