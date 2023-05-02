package dal;

import bo.User;
import dal.jdbc.ArticleDaoImpl;
import dal.jdbc.UserDaoImpl;

public class DaoFactory {
    public static ArticleDao getArticleDao(){
        return new ArticleDaoImpl();
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
