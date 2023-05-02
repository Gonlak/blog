package ihm.article;

import bll.ArticleManager;
import bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        //Article article = ArticleManager.getInstance().editArticle();
        //req.setAttribute("article",article);
        req.getRequestDispatcher("/WEB-INF/jsp/article/edit.jsp").forward(req,resp);
    }
}
