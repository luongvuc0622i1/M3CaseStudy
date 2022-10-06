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
    <a href="home?action=users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit User
        </h2>
      </caption>
      <c:if test="${item != null}">
        <input type="hidden" name="id" value="<c:out value='${item.item_id}' />"/>
      </c:if>

      <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
      </c:if>
      <tr>
        <th> item_code</th>
        <td>
          <input type="text" name="item_code" size="45"
                 value="<c:out value='${item.item_code}' />"
          />
        </td>
      </tr>
      <tr>
        <th>shop_id</th>
        <td>
          <input type="text" name="shop_id" size="45"
                 value="<c:out value='${item.shop_id}' />"
          />
        </td>
      </tr>
      <tr>
        <th>category_id:</th>
        <td>
          <input type="text" name="category_id" size="15"
                 value="<c:out value='${item.category_id}' />"
          />
        </td>
      </tr>

      <tr>
        <th>deal_id:</th>
        <td>
          <input type="text" name="deal_id" size="15"
                 value="<c:out value='${item.deal_id}' />"
          />
        </td>
      </tr>

      <tr>
        <th>item_name:</th>
        <td>
          <input type="text" name="item_name" size="15"
                 value="<c:out value='${item.item_name}' />"
          />
        </td>
      </tr>

      <tr>
        <th>item_price:</th>
        <td>
          <input type="text" name="item_price" size="15"
                 value="<c:out value='${item.item_price}' />"
          />
        </td>
      </tr>

      <tr>
        <th>item_description:</th>
        <td>
          <input type="text" name="item_description" size="15"
                 value="<c:out value='${item.item_description}' />"
          />
        </td>
      </tr>

      <tr>
        <th>item_image:</th>
        <td>
          <input type="text" name="item_image" size="15"
                 value="<c:out value='${item.item_image}' />"
          />
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