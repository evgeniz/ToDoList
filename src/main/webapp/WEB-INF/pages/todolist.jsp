<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ToDo List</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Welcome menu</a>

<br/>
<br/>

<h1>ToDo List</h1>

<c:if test="${!empty todolist}">
    <table class="tg">
        <tr>
            <th width="60">ID</th>
            <th width="180">TO DO</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${todolist}" var="thing">
            <tr>
                <td>${thing.id}</td>
                <td><a href="/thingdata/${thing.id}" target="_blank">${thing.text}</a></td>
                <td><a href="<c:url value='/edit/${thing.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${thing.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h2>Add what you must do</h2>

<c:url var="addAction" value="/todolist/add"/>

<form:form action="${addAction}" commandName="thing">
    <table>
        <c:if test="${!empty thing.text}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="text">
                    <spring:message text="Text"/>
                </form:label>
            </td>
            <td>
                <form:input path="text"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty thing.text}">
                    <input type="submit"
                           value="<spring:message text="Edit Thing"/>"/>
                </c:if>
                <c:if test="${empty thing.text}">
                    <input type="submit"
                           value="<spring:message text="Add Thing"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
