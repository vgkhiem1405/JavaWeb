<%-- 
    Document   : index
    Created on : Mar 17, 2022, 10:17:33 AM
    Author     : vgkhiem
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <title>Employees list</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg  navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/home">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="employees">Employees</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="departments">Departments</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="positions">Positions</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container mt-3">
            <h1>Employees</h1>

            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Department</th>
                    <th>Position</th>
                    <th colspan="3">Options</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <th>${item.getId()}</th>
                        <td>${item.getName()}</td>
                        <td>${item.getAge()}</td>
                        <td>${item.getSalary()}</td>
                        <td>${item.getDepartmentName()}</td>
                        <td>${item.getPositionName()}</td>
                        <td><a href="show?id=${item.getId()}">Detail</a></td>
                        <td><a href="edit?id=${item.getId()}">Edit</a></td>
                        <td><a href="delete?id=${item.getId()}" onclick="return confirm('Are u sure want to delete?')">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="new" class="btn btn-primary">New Employee</a>
        </div>


    </body>
</html>