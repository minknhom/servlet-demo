<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form action="add_employee" method="post">
        First Name: <input type="text" name="firstName"><br>
        Last Name: <input type="text" name="lastName"><br>
        Phone Number: <input type="text" name="phoneNumber"><br>
        Date of Birth: <input type="date" name="dateOfBirth"><br>
        Gender: <input type="text" name="gender"><br>
        Username: <input type="text" name="username"><br>
        Email: <input type="text" name="email"><br>
        Password: <input type="password" name="password"><br>
        Address: <input type="text" name="address"><br>
        Department: <input type="text" name="department"><br>
        Remark: <input type="text" name="remark"><br>
        <input type="submit" value="Add Employee">
    </form>
    <p>${error}</p> <!-- Display error message if any -->
</body>
</html>
