<%-- 
    Document   : form-tag
    Created on : Aug 29, 2017, 4:39:52 PM
    Author     : Dias
--%>

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
        <title>Edit tag page</title>
        <style type="text/css">
            .error {
                color: red;
                font-size: 0.9em;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Edit tag page</h1>
        <p>Here you can add a new tag.</p>
        <form:form method="POST" modelAttribute="tag" action="${pageContext.request.contextPath}/tag/edit/${tag.id}.html">
            <table>
                <tbody>
                    <tr>
                        <td>Description</td>
                        <td>
                            <form:input path="description" autocomplete="off"/>
                            <form:errors path="description" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Edit" /></td>
                        <td><input type="button"  onclick="location.href='${pageContext.request.contextPath}/index'" value="Cancel"/></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

    </body>
</html>
