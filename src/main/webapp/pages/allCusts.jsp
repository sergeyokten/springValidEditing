<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="/xxx/main.css">
    </head>
    <body>


        <c:forEach items="${customers}" var="customer">
            <div>
                <p>${customer.email}</p>
                <img src="${customer.avatar}" alt="">

            </div>

        </c:forEach>
    </body>
</html>
