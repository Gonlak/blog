package dal.mock;

import bo.Article;
import dal.ArticleDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private List<Article> articles = new ArrayList<>();

    public ArticleDaoImpl() {
        articles.add(new Article(1, "Tuto Java POO", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(2, "Tuto Java SE", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(3, "Tuto Java EE", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(4, "Tuto Python", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(5, "Tuto Python", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(6, "Tuto Python", "Blablabla", "Seb", LocalDate.now(), true));
        articles.add(new Article(7, "Tuto Python", "Blablabla", "Seb", LocalDate.now(), true));
    }

    @Override
    public List<Article> selectAll() {
        return articles;
    }

    @Override
    public Article selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Article article) {

    }

    @Override
    public void deleteArticle(int id) {

    }

    @Override
    public void update(Article article) {

    }
}
