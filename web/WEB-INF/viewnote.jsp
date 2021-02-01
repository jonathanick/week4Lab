<%-- 
    Document   : viewnote
    Created on : Jan 30, 2021, 7:53:28 PM
    Author     : 828200
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>View Note</h2><br>
        <p>title: ${note.title}</p><br>
        <p>Contents: <br> ${note.contents}</p><br>
        <a href="note?edit">Edit</a>
    </body>
</html>
