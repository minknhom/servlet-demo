<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    
    <form action="employee_list" method="get">
        <input type="text" name="searchName" placeholder="Search by Name" value="${searchName}">
        <input type="submit" value="Search">
    </form>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <!-- Other columns -->
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.firstName} ${employee.lastName}</td>
                <td>${employee.gender}</td>
                <!-- Other columns -->
            </tr>
        </c:forEach>
    </table>

    <div>
        <c:if test="${currentPage > 1}">
            <a href="employee_list?page=${currentPage - 1}&searchName=${searchName}">Previous</a>
        </c:if>
        <c:forEach var="page" begin="1" end="${totalPages}">
            <c:choose>
                <c:when test="${page == currentPage}">
                    ${page}
                </c:when>
                <c:otherwise>
                    <a href="employee_list?page=${page}&searchName=${searchName}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${currentPage < totalPages}">
            <a href="employee_list?page=${currentPage + 1}&searchName=${searchName}">Next</a>
        </c:if>
    </div>
</body>
</html>
