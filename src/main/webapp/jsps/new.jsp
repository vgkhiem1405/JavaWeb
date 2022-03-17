<%-- 
    Document   : new
    Created on : Mar 17, 2022, 11:46:58 AM
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
            <c:if test="${status == 1}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    success !
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:if test="${status == 0}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    something went wrong !!
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${emp != null}">
                <h1>Edit employee</h1>
            </c:if>

            <c:if test="${emp == null}">
                <h1>Create employee</h1>
            </c:if>  



            <form method="post" class="mb-4">
                <c:if test="${emp != null}">
                    <input type="hidden" name="id" value="${emp.getId()}" />
                </c:if> 
                <div class="mb-3">
                    <label for="inputName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="inputName" name="name" value="${emp.getName()}">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <a href="/home/employees">Back to employees</a>

        </div>
    </body>
</html>