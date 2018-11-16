<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $('#product_register > input[type="button"]').click(function(){
        $('#product_register').attr('method','post');
        $('#product_register').attr('action','product.mc?cmd=register');
        $('#product_register').submit();
    });
});

</script>
</head>
<body>
<h1>Product Register Page</h1>
<form  id="product_register" enctype="multipart/form-data">
NAME<input type="text" name="name"><br>
PRICE<input type="number" name="price"><br>
IMGNAME<input type="file" name="imgname"><br>
<input type="button" value="Register">
</form>
</body>
</html>













