<%--
  Created by IntelliJ IDEA.
  User: minhhuyduc
  Date: 10/10/2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8;" pageEncoding="UTF-8" language="java" %>
<html>
<head>
<<<<<<< HEAD
    <title>edit client pass</title>
</head>
<body>
<center>
    <h1>Client </h1>
    <h2><a href="/client?action=add">edit pass</a></h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>edit clientPass</h2>
            </caption>
<%--            <c:if test="${client !=null}">--%>
<%--                <input type="hidden" name="client_id" value="<c:out value="${client.client_id}"/>"/>--%>
<%--            </c:if>--%>
            <tr>
                <th>password:</th>
                <td><input type="text" name="client_password" size="50" value="<c:out value="${client.client_password}"/>"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="save"/></td>
            </tr>
        </table>
    </form>
=======
  <title>edit client pass</title>
</head>
<body>
<center>
  <h1>Client </h1>
  <h2><a href="/client?action=add">edit pass</a></h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>edit clientPass</h2>
      </caption>
      <%--            <c:if test="${client !=null}">--%>
      <%--                <input type="hidden" name="client_id" value="<c:out value="${client.client_id}"/>"/>--%>
      <%--            </c:if>--%>
      <tr>
        <th>password:</th>
        <td><input type="text" name="client_password" size="50" value="<c:out value="${client.client_password}"/>"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="save"/></td>
      </tr>
    </table>
  </form>
>>>>>>> d275e5e767c43b212ef872b530ee39b60286747d
</div>
</body>
</html>
