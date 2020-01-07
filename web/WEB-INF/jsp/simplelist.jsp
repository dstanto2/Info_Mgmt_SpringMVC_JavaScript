<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>${currentList.name}</h3>
            <c:forEach var="item" items="${listOfItems}">
                <li><a href="${contextPath}/showitem/${item.itemid}">${item}</a></li>
            </c:forEach>
        </div>
        <div>
            <p>Add New Item</p>
            <form:form action="${contextPath}/additem/${currentList.listid}" method="post" modelAttribute="newItem">
                <form:input path="name"/>
                <input type="submit" value="Submit"/>
            </form:form>
        </div>
        
    </body>
</html>

