<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$('#register_form > input[type="button"]').click(function(){
		var id = $('input[name="id"]').val();
		var pwd = $('input[name="pwd"]').val();
		var name = $('input[name="name"]').val();
		var age = $('input[name="age"]').val();
		
		
		if(id == null || id == ''){
			alert('Madatory Filed !');
			$('input[name="id"]').focus();
			return;
		}
		if(pwd == null || pwd == ''){
			alert('Madatory Filed !');
			$('input[name="pwd"]').focus();
			return;
		}
		if(name == null || name == ''){
			alert('Madatory Filed !');
			$('input[name="name"]').focus();
			return;
		}
		if(age == null || age == ''){
			alert('Madatory Filed !');
			$('input[name="age"]').focus();
			return;
		}
		$('#register_form').attr('method','post');
		$('#register_form').attr('action','register.mc');
		$('#register_form').submit();		
	});
});
</script>

<div id="main_center">
<h1>Register Page</h1>
<form id="register_form" action="register.mc">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
NAME<input type="text" name="name"><br>
AGE<input type="number" name="age"><br>
<input type="button" value="REGISTER">
</form>
</div>





