package dal.jdbc;

import bo.Article;
import config.ConnectionProvider;
import dal.ArticleDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private final static String SELECT_ALL_ARTICLE = "SELECT * FROM articles;";
    private final static String SELECT_ONE_ARTICLE = "SELECT * FROM articles WHERE ID=?;";
    private final static String UPDATE_ARTICLE = "UPDATE articles SET title = ?, content = ?, author = ? WHERE ID=?;";
    private final static String INSERT_ARTICLE = "INSERT INTO articles (title,content,author,date_creation,is_published) VALUES(?,?,?,?,?);";
    private final static String DELETE_ARTICLE = "DELETE FROM articles WHERE ID=?;";

    @Override
    public List<Article> selectAll() {

        try (Connection connection = ConnectionProvider.getConnection()){
            List<Article> articles = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ARTICLE);

            while (resultSet.next()){
                articles.add(new Article(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("author"),
                        resultSet.getDate("date_creation").toLocalDate(),
                        resultSet.getBoolean("is_published")));
            }
            return articles;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Article selectOne(int id) {

        try(Connection connection = ConnectionProvider.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SELECT_ONE_ARTICLE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Article(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("author"),
                        resultSet.getDate("date_creation").toLocalDate(),
                        resultSet.getBoolean("is_published"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Article article) {
        try(Connection connection = ConnectionProvider.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            statement.setString(3, article.getAuthor());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            statement.setBoolean(5, true);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                article.setId(resultSet.getInt(1)); // pour la redirection
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int id) {
        try(Connection connection = ConnectionProvider.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE);
            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Article article) {
        try(Connection connection = ConnectionProvider.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ARTICLE);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setString(3,article.getAuthor());
            preparedStatement.setInt(4,article.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
