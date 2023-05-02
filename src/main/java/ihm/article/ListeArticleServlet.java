package ihm.article;

import bll.ArticleManager;
import bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * lsite articles => /tutos
 * detail d'un article => /tutos/detail
 * ajouter un article => /tuto/ajouter
 * modifier un article => /tuto/modifier
 * supprimer un article => /tuto/supprimer
 *
 */
@WebServlet("/tutos")
public class ListeArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Article> articles = ArticleManager.getInstance().getAllArticles();
        // création ("Clé d'accet, Data"
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/WEB-INF/jsp/article/list.jsp").forward(req, resp);
    }

}
