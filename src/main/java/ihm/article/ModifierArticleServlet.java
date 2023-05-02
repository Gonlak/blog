package ihm.article;

import bll.ArticleManager;
import bll.exception.BLLException;
import bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//womdcard
@WebServlet("/tutos/modifier/*")
public class ModifierArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get id
        String[] params = req.getPathInfo().split("/");
        int id = Integer.parseInt(params[1]);

        Article article = ArticleManager.getInstance().getArticle(id);
        if(article == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute("article",article);

        req.getRequestDispatcher("/WEB-INF/jsp/article/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //get id
            String[] params = req.getPathInfo().split("/");
            int id = Integer.parseInt(params[1]);

            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String author = req.getParameter("author");

            Article article = new Article(title, content, author);
            article.setId(id);

            ArticleManager.getInstance().updateArticle(article);

            resp.sendRedirect(req.getContextPath()+"/tutos/detail/"+article.getId());
        }catch (BLLException e){
            e.printStackTrace();
            doGet(req,resp);
        }
    }
}
