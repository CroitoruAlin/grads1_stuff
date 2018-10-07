<%@ page import="training.hotel.Hotels" %>
<%@ page import="training.hotel.Hotel" %>
<%@ page import="java.io.Console" %><%--
  Created by IntelliJ IDEA.
  User: alcroitoru
  Date: 10/3/2018
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%! Hotels hotels= Hotels.getInstance();%>
<form method="post" action="addresses">
Country: <input type = "text" name = "country">
<input type = "submit" value = "Submit" />
</form >
<form method="GET" action="rooms">
<select name="roomtype">
    <option value="Double">Double</option>
    <option value="Single">Single</option>
    <option value="Apartment">Apartment</option>
</select>
    <br>
<select name="hotels">
    <% for(Hotel hotel:hotels.getHotels()) {%>
    <option value=<%hotel.getName();%>><%hotel.getName();%>  </option>
    <%}%>
</select>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
