<%--
  Created by IntelliJ IDEA.
  User: minhhuyduc
  Date: 10/10/2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
<<<<<<< HEAD
    <title>addClient</title>
</head>
<body>
<center>
    <h1>client Application</h1>
    <h2><a href="/client?action=client"> List All Client</a></h2>
</center>
<div align="1">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New clientr</h2>
            </caption>
            <tr>
                <th>client code:</th>
                <td><input type="text" name="client_code" size="50" placeholder="client_code"></td>
            </tr>
            <tr>
                <th>client name:</th>
                <td><input type="text" name="client_name" size="50" placeholder="client_name"></td>
            </tr>
            <tr>
                <th>client phone:</th>
                <td><input type="text" name="client_phone" size="50" placeholder="client_phone"></td>
            </tr>
            <tr>
                <th>client address:</th>
                <td><input type="text" name="client_address" size="50" placeholder="client_address"></td>
            </tr>
            <tr>
                <th>client email:</th>
                <td><input type="text" name="client_code" size="50" placeholder="client_email"></td>
            </tr>
            <tr>
                <th>client account:</th>
                <td><input type="text" name="client_account" size="50" placeholder="client_account"></td>
            </tr>
            <tr>
                <th>client password:</th>
                <td><input type="text" name="client_password" size="50" placeholder="client_password"></td>
            </tr>
            <tr>
                <th>client status:</th>
                <td><input type="text" name="client_status" size="50" placeholder="client_ststus chỉ có 1 hoặc 0"></td>
            </tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </table>
    </form>
=======
  <title>addClient</title>
</head>
<body>
<center>
  <h1>client Application</h1>
  <h2><a href="/client?action=client"> List All Client</a></h2>
</center>
<div align="1">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New clientr</h2>
      </caption>
      <tr>
        <th>client code:</th>
        <td><input type="text" name="client_code" size="50" placeholder="client_code"></td>
      </tr>
      <tr>
        <th>client name:</th>
        <td><input type="text" name="client_name" size="50" placeholder="client_name"></td>
      </tr>
      <tr>
        <th>client phone:</th>
        <td><input type="text" name="client_phone" size="50" placeholder="client_phone"></td>
      </tr>
      <tr>
        <th>client address:</th>
        <td><input type="text" name="client_address" size="50" placeholder="client_address"></td>
      </tr>
      <tr>
        <th>client email:</th>
        <td><input type="text" name="client_code" size="50" placeholder="client_email"></td>
      </tr>
      <tr>
        <th>client account:</th>
        <td><input type="text" name="client_account" size="50" placeholder="client_account"></td>
      </tr>
      <tr>
        <th>client password:</th>
        <td><input type="text" name="client_password" size="50" placeholder="client_password"></td>
      </tr>
      <tr>
        <th>client status:</th>
        <td><input type="text" name="client_status" size="50" placeholder="client_ststus chỉ có 1 hoặc 0"></td>
      </tr>
      <td colspan="2" align="center">
        <input type="submit" value="Save"/>
      </td>
    </table>
  </form>
>>>>>>> d275e5e767c43b212ef872b530ee39b60286747d
</div>
</body>
</html>
