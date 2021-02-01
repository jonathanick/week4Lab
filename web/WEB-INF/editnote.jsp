<%-- 
    Document   : editnote
    Created on : Jan 30, 2021, 7:53:53 PM
    Author     : 828200
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit note</title>
    </head>
    <body>
        <form action="note" method="post">
            <h1>Edit Note</h1>
            <p>Title: <input type="text" name="title" value="${note.title}"></p>
            <p>Contents: <input type="text" name="contents" value="${note.contents}" style="height:200px;"></p>
            <input type="submit" value="Save" name="submit">
        </form>
    </body>
</html>
