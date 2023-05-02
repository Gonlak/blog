<%@ page import="java.util.List" %>
<%@ page import="bo.Article" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% List<Article> articles = (List<Article>) request.getAttribute("articles"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <title>Accueil</title>
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <%@ include file="/WEB-INF/jsp/parts/menu.jsp"%>
    </header>

    <main class="row mt-5">
        <div class="row text-center">
            <h1>Tuto</h1>
        </div>
        <div class="col-8 offset-2 mt-5">
            <div class="row">
                <% for (Article article : articles) { %>
                <div class="col-4">
                    <div class="card text-white bg-info mb-3" style="max-width: 20rem;">
                        <div class="card-header"><%= article.getTitle() %>
                        </div>
                        <div class="card-body">
                            <h4 class="card-title"><%= article.getTitle() %> </h4>
                            <p class="card-text"><%= article.getContent() %> </p>
                            <a href="<%= request.getContextPath()%>/tutos/detail/<%= article.getId()%>" class="card-link btn btn-danger">Détail</a>
                        </div>
                    </div>
                </div>
                <% } %>
                <a href="<%= request.getContextPath()%>/tutos/ajouter" class="card-link btn btn-info">Nouveau Article</a>
            </div>
        </div>
    </main>

    <footer class="row"></footer>

    <footer class="row text-center">
        <%@ include file="/WEB-INF/jsp/parts/footer.jsp"%>
    </footer>
</div>
</body>
</html>