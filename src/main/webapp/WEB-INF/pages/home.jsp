<%-- 
    Document   : home
    Created on : Aug 29, 2017, 3:25:41 PM
    Author     : Dias
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>List of Books</title>
    </head>
    <body>
        <h1>List of books</h1>
        <table border="1px" cellpadding="0" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th width="10%">id</th><th width="15%">title</th><th width="10%">author</th><th width="10%">actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/edit/${book.id}.html">Edit</a><br/>
                            <a href="${pageContext.request.contextPath}/book/delete/${book.id}.html">Delete</a><br/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="${pageContext.request.contextPath}/book/add.html">Add new book</a><br/>

        <table border="1px" cellpadding="0" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th width="10%">id</th>
                    <th width="15%">description</th>
                    <th width="10%">actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tag" items="${tags}">
                    <tr>
                        <td>${tag.id}</td>
                        <td>${tag.description}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/tag/edit/${tag.id}.html">Edit</a><br/>
                            <a href="${pageContext.request.contextPath}/tag/delete/${tag.id}.html">Delete</a><br/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="${pageContext.request.contextPath}/tag/add.html">Add new tag</a><br/>


    </body>
</html>