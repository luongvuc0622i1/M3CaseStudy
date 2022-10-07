<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/7/2022
  Time: 5:26 PM
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
    <a href="foods?action=foods">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New Food</h2>
      </caption>
      <tr>
        <th>food_id</th>
        <td>
          <input type="text" name="food_id" id="food_id" size="45"/>
        </td>
      </tr>

      <tr>
        <th>shop_id</th>
        <td>
          <input type="text" name="shop_id" id="shop_id" size="45"/>
        </td>
      </tr>

      <tr>
        <th>shop_id</th>
        <td>
          <input type="text" name="tags_id" id="tags_id" size="45"/>
        </td>
      </tr>

      <tr>
        <th>deal_id</th>
        <td>
          <input type="text" name="deal_id" id="deal_id" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_name</th>
        <td>
          <input type="text" name="food_name" id="food_name" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_price</th>
        <td>
          <input type="text" name="food_price" id="food_price" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_description</th>
        <td>
          <input type="text" name="food_description" id="food_description" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_image </th>
        <td>
          <input type="text" name="food_image " id="food_image " size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_cooktime</th>
        <td>
          <input type="text" name="food_cooktime" id="food_cooktime" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_daycreate</th>
        <td>
          <input type="text" name="food_daycreate" id="food_daycreate" size="45"/>
        </td>
      </tr>

      <tr>
        <th>food_lastupdate</th>
        <td>
          <input type="text" name="food_lastupdate" id="food_lastupdate" size="45"/>
        </td>
      </tr>

      <tr>
        <th>status</th>
        <td>
          <input type="text" name="status" id="status" size="45"/>
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
