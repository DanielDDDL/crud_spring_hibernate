<%-- 
    Document   : form-book
    Created on : Aug 29, 2017, 4:38:23 PM
    Author     : Dias
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Add book page</title>
    </head>
    <body>
        <h1>Add book page</h1>
        <p>Here you can add a new book.</p>
        <form:form method="POST" commandName="book" action="${pageContext.request.contextPath}/book/add.html">
            <table>
                <tbody>
                    <tr>
                        <td>Title:</td>
                        <td><form:input path="title" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td>Author:</td>
                        <td><form:input path="author" autocomplete="off" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:checkboxes path="tags" items="${tags}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add" /></td>
                        <td><input type="button"  onclick="location.href = '${pageContext.request.contextPath}/index'" value="Cancel"/></td>
                    </tr>
                </tbody>
            </table>

        </form:form>

    </body>
</html>
