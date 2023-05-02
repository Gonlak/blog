package ihm.article;

import bll.ArticleManager;
import bll.exception.BLLException;
import bo.Article;
import helpers.Flash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tutos/ajouter")
public class AddArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/article/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String author = req.getParameter("author");

            Article article = new Article(title,content,author);
            ArticleManager.getInstance().addArticle(article);

            if(article.getId()>0){
                Flash.send("success", "l'article a bien été ajouté", req.getSession());
                resp.sendRedirect(req.getContextPath()+"/tutos/detail/"+article.getId());
            }
        }catch (BLLException e){
            req.setAttribute("erreurs",e.getErreurs());
            doGet(req,resp);
        }
    }
}
