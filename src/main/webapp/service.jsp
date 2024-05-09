<%@ page import="java.util.List" %>
<%@ page import="ba.smoki.celebration.ejb.service.ServiceType" %><%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/9/2024
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service Types</title>
</head>
<body>
<%
    List<ServiceType> serviceTypes = (List<ServiceType>) request.getAttribute("serviceTypes");
%>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Cost Per Unit</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (ServiceType serviceType : serviceTypes) {
    %>
    <tr>
        <td><%=serviceType.getName()%>
        </td>
        <td><%=serviceType.getCostPerUnit()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
