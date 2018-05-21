<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>join</title>
    </head>
    <body>


        <sf:form action="/save/car/user" method="post" modelAttribute="carModel">
            <sf:input path="model"/>
            <sf:select path="user">
                <c:forEach items="${users}" var="user">
                    <sf:option value="${user.id}">
                        ${user.name}
                    </sf:option>

                </c:forEach>

            </sf:select>

            <input type="submit" name="" placeholder="">

        </sf:form>


    </body>
</html>
