<%@ page import="java.util.List" %>
<%@ page import="bo.Article" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Article article = (Article) request.getAttribute("article");%>
<% List<String> erreurs = (List<String>) request.getAttribute("erreurs");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/style.css">
    <title>Modifier</title>
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
    </header>

    <main class="row mt-5">
        <div class="row text-center">
            <h1>Modifier un Article</h1>
        </div>
        <div class="col-8 offset-2 mt-5">
            <% if (erreurs != null) for (String erreur : erreurs) { %>
            <div class="alert alert-danger">
                <%= erreur %>
            </div>
            <% } %>
            <form action="" method="POST">
                <div class="form-group">

                    <label class="col-form-label mt-4" for="title">Titre</label>
                    <input type="text" class="form-control" placeholder="Nom du titre" id="title" name="title" value="<%=article.getTitle()%>">

                    <label for="content" class="form-label mt-4">Contenu</label>
                    <textarea class="form-control" id="content" name="content" rows="3"
                              style="height: 103px;"><%=article.getContent()%></textarea>

                    <label class="col-form-label mt-4" for="author">Author</label>
                    <input type="text" class="form-control" placeholder="Nom de l'author" id="author" name="author" value="<%=article.getAuthor()%>">
                </div>
                <div class="form-group mt-3 text-center">
                    <button type="submit" class="btn btn-danger">Modifier</button>
                </div>
            </form>
        </div>
    </main>

    <footer class="row"></footer>

    <footer class="row text-center">
        <%@ include file="/WEB-INF/jsp/parts/footer.jsp" %>
    </footer>
</div>
</body>
</html>