<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        var obj = {
            name:"jfjfjfjf",
            logo:"jfjfjjfjfjfjf"
        };
        $(document).ready(function () {
            $(".submit").click(function () {
                $.ajax({
                    url:'http://localhost:8080/webapi/organizations',
                    data:obj,
                    contentType:'application/json',
                    type:'POST',
                    success:function (resp) {
                        alert(resp);
                    }
                })
            })
        })



    </script>
</head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    <input class="submit" type="submit" value="click"/>



</body>
</html>
