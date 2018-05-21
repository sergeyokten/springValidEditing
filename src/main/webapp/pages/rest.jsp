<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


        <script>
            $(function () {
                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
                $(document).ajaxSend(function(e, xhr, options) {
                    xhr.setRequestHeader(header, token);
                });
            });
        </script>
    </head>
    <body>
        <h1>oktenweb</h1>

        <input type="" name="name" placeholder="name">
        <button id="add">add</button>


        <button id="get">get</button>

        <div class="wrap">

        </div>

        <hr>

        <c:forEach items="${users}" var="user">
            <div>
                ${user}
                    <button id="delete-${user.id}"></button>

            </div>


        </c:forEach>

        <script>


            $("#add").click(function () {
                let name = $("[name=name]").val();

                $.ajax({
                    url: "/saveUserRest/" + name,
                    type: "PUT",
                    success: function () {
                        console.log("ok");
                    },
                    error: function (err) {
                        console.log(err);
                    }


                });
                // $.ajax({
                //     url: '/saveUserRest',
                //     type: "post",
                //     headers: {
                //         'Accept': 'application/json',
                //         'Content-Type': 'application/json'
                //     },
                //     data: JSON.stringify({name}),
                //     success: function () {
                //         console.log("ok");
                //     },
                //     error: function (err) {
                //         console.log(err);
                //     }
                //
                //
                // });
            })

            $("#get").click(function () {
                $(".wrap").empty();
                $.ajax({
                    url: '/giveAllUsers',
                    type: 'GET',
                    contentType: 'application/json',
                    success: function (res) {
                        console.log(res);
                        for (let obj of res) {
                            var $div = $("<div/>", {text: obj.id + " " + obj.name});
                            $(".wrap").append($div);


                        }

                    },
                    error: function (err) {
                        console.log(err);
                    }

                })

            })

        </script>

    </body>
</html>
