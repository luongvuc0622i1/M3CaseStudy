<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/7/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/foods?action=">Add New User</a>
  </h2>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
      <th>ID</th>
      <th>Shop_id</th>
      <th>Tags_id</th>
      <th>Deal_id</th>
      <th>Name</th>
      <th>Price</th>
      <th>Description</th>
      <th>Image</th>
      <th>Cook Time</th>
      <th>Day Create</th>
      <th>Last Update</th>
      <th>Status</th>
    </tr>
    <c:forEach var="food" items="${foods}">
      <tr>
        <td><c:out value="${food.id}"/></td>
        <td><c:out value="${food.shop_id}"/></td>
        <td><c:out value="${food.tag_id}"/></td>
        <td><c:out value="${food.deal_id}"/></td>
        <td><c:out value="${food.name}"/></td>
        <td><c:out value="${food.price}"/></td>
        <td><c:out value="${food.description}"/></td>
        <td><img height="150px" width="150px" src="<c:out value="${food.image}"/>" alt="Ảnh món ăn"></td>
        <td><c:out value="${food.cookTime}"/></td>
        <td><c:out value="${food.dayCreate}"/></td>
        <td><c:out value="${food.lastUpdate}"/></td>
        <td><c:out value="${food.status}"/></td>
        <td>
          <a href="/users?action=edit&id=${user.id}">Edit</a>
          <a href="/users?action=delete&id=${user.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
