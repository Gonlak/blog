<%@ page import="bo.Article" %>
<%@ page import="helpers.Flash" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Article article = (Article) request.getAttribute("article"); %>
<% String info = Flash.getMessage("success", session);%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/style.css">
    <title>Detail</title>
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
    </header>

    <main class="row mt-5">
        <div class="col-8 offset-2 mt-5">
            <% if (info != null) {%>
            <div class="alert alert-success">
                <%=info%>
            </div>
            <%}%>
            <div class="row text-center">
                <h1>Detail <%= article.getTitle() %>
                </h1>
            </div>
            <div class="row mt-5 text-center">
                <p>Contenu: <%= article.getContent() %>
                </p>
                <p>Auteur: <%= article.getAuthor() %>
                </p>
                <p>Date de création: <%= article.getDateCreation() %>
                </p>
            </div>
            <div class="row mt-5 text-center">
                <div class="col-2 offset-4">
                    <a href="<%= request.getContextPath()%>/tutos/modifier/<%=article.getId()%>" class="btn btn-info">Modifier</a>
                </div>
                <div class="col-2">
                    <a onclick="return confirm('Voulez-vous suprimer cet article?');"
                       href="<%= request.getContextPath()%>/tutos/supprimer/<%=article.getId()%>"
                       class="btn btn-danger">Supprimer</a>
                </div>
            </div>
        </div>
    </main>

    <footer class="row"></footer>

    <footer class="row text-center">
        <%@ include file="/WEB-INF/jsp/parts/footer.jsp" %>
    </footer>
</div>
</body>
</html>