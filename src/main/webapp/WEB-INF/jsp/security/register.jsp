<%--
  Created by IntelliJ IDEA.
  User: schiron2023
  Date: 25/04/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/style.css">
    <title>Inscription</title>
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
    </header>
    <div class="container">
        <div class="registration mx-auto d-block w-100">
            <div class="page-header text-center">
                <h1>Inscription</h1>
            </div>
            <div class="row">
                <div class="col-6 offset-3">
                    <form id="member-registration" action="" method="post" class="form-validate form-horizontal well">
                        <fieldset>
                            <legend>Utilisateur</legend>
                            <div class="form-group">
                                <label for="firstname">Prénom</label>
                                <input type="text" class="form-control" name="firstname" id="firstname">
                            </div>
                            <div class="form-group">
                                <label for="lastname">Nom</label>
                                <input type="text" class="form-control" name="lastname" id="lastname">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email">
                            </div>
                            <div class="form-group">
                                <label for="username">Nom utilisateur</label>
                                <input type="text" class="form-control" name="username" id="username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password">
                            </div>
                            <div class="d-flex justify-content-between align-items-center mt-3">
                                <div class="form-group d-flex justify-content-start">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
