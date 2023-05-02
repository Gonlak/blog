package ihm.article;

import bll.ArticleManager;
import bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// /tutos/detail?id=1
@WebServlet("/tutos/detail/*")
public class DetailArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int id = Integer.parseInt(req.getParameter("id"));
        String params = req.getPathInfo();
        int id = Integer.parseInt(params.substring(1));
        Article article = ArticleManager.getInstance().getArticle(id);
        req.setAttribute("article",article);
        req.getRequestDispatcher("/WEB-INF/jsp/article/detail.jsp").forward(req,resp);
    }
}
