<%@ page import="com.inventine.model.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sahar
  Date: 12/18/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>
</head>
<body>

<table>
    <tbody>
    <%
        for (User user: (ArrayList<User>)request.getAttribute("users")){
    %>
    <tr>
        <th> <% out.print(user.getUserId());%></th>
        <th> <% out.print(user.getFirstName());%></th>
        <th> <% out.print(user.getLastName());%></th>
      </tr>
    <%}%>
    </tbody>

</table>


</body>
</html>
