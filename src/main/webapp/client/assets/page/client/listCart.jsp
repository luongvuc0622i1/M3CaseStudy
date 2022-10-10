<%--
  Created by IntelliJ IDEA.
  User: minhhuyduc
  Date: 10/10/2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Cart Application</title>
</head>
<body>
<center>
  <h1>Cart List</h1>
  <h2><a href="/bill_detail?addCart=addClient">Add New Cart</a></h2>
</center>
<div align="center">
  <table border="1" cellpadding="5"></table>
  <tr>
    <th>id</th>
    <th>bill_id</th>
    <th>food_id</th>
    <th>quantity</th>
    <th>price</th>
    <th>status</th>
  </tr>
  <c:forEach var="bill_detail" items="${listCart}">
    <tr>
      <td><c:out value="${bill_detail.bill_detail_id}"/></td>
      <td><c:out value="${bill_detail.bill_id}"/></td>
      <td><c:out value="${bill_detail.food_id}"/></td>
      <td><c:out value="${bill_detail.quantity}"/></td>
      <td><c:out value="${bill_detail.price}"/></td>
      <td><c:out value="${bill_detail.status}"/></td>
      <td>
        <a href="/bill_detail?action=add&id=${bill_detail.id}">Add</a>
        <a href="/bill_detail?action=delete&id=${bill_detail.id}">Detele</a>
      </td>
    </tr>
  </c:forEach>
</div>
</body>
</html>
