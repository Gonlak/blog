package dal;

import bo.Article;

import java.time.LocalDate;
import java.util.List;

public interface ArticleDao {

    public List<Article> selectAll();
    public Article selectOne(int id);
    public void insert(Article article);
    void deleteArticle(int id);
    void update(Article article);
}
