<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id='main_center'>

<table>
<c:forEach var="cust" items="${product_list }">
		<tr>
		<td>${cust.id }</td><td>${cust.name }</td><td>${cust.price }</td><td>${cust.regdate }</td><td><img src="img/${cust.imgname }"></td></tr>
</c:forEach>
</table>
</div>