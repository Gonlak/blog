package bll;


import bll.exception.BLLException;
import bo.Article;
import dal.DaoFactory;

import java.util.List;

public class ArticleManager {

    // Singleton
    //1
    private static ArticleManager instance;
    //2
    private ArticleManager(){}
    //3
    public static ArticleManager getInstance(){
        if (instance == null){
            instance = new ArticleManager();
        }
        return instance;
    }

    // get all articles
    public List<Article> getAllArticles(){
        return DaoFactory.getArticleDao().selectAll();
    }

    // recup un article
    public Article getArticle(int id){
        return DaoFactory.getArticleDao().selectOne(id);
    }

    // ajoute un article
    public void addArticle(Article article) throws BLLException{
        // check all fields
        verifAddArticle(article);
        DaoFactory.getArticleDao().insert(article);
    }
    public void verifAddArticle(Article article) throws BLLException {
        checkArticle(article);
        DaoFactory.getArticleDao().insert(article);
    }

    public void checkArticle(Article article) throws BLLException{
        BLLException bll = new BLLException("Utilisateur non trouvé!");
        checkFiled(article.getTitle(),"Titre",bll);
        checkFiled(article.getContent(),"Contenu",bll);
        checkFiled(article.getAuthor(),"Auteur",bll);
        if (bll.getErreurs().size()>0){
            throw bll;
        }
    }
    private void checkFiled(String field, String name, BLLException bll) {
        if(field.isBlank()){
            bll.ajouterErreur("Le champs "+ name +" ne peut pas etre vide!");
        }
    }

    public void deleteArticle(int id) {
        DaoFactory.getArticleDao().deleteArticle(id);
    }

    public void updateArticle(Article article) throws BLLException {
        checkArticle(article);
        DaoFactory.getArticleDao().update(article);
    }
}
