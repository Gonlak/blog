package ihm.article;

import bll.ArticleManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tutos/supprimer/*")
public class SupprimerArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = req.getPathInfo();
        int id = Integer.parseInt(params.substring(1));
        ArticleManager.getInstance().deleteArticle(id);
        resp.sendRedirect(req.getContextPath()+"/tutos");
    }
}
