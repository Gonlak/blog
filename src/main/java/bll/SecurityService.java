package bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bll.exception.BLLException;
import bo.User;
import dal.DaoFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityService {
    @Getter
    private static SecurityService instance = new SecurityService();// lazy singleton


    public static SecurityService getInstance() {
        return instance;
    }

    public void addUser(User user) {
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        DaoFactory.getUserDao().insert(user);
    }

    public User login(String username, String password) throws BLLException {
        User user = DaoFactory.getUserDao().selectByUsername(username);
        if(user == null){
            throw new BLLException("Utilisateur non trouvé!");
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if(!result.verified){
            throw new BLLException("Le mot de passe est eronné");
        }
        return user;
    }
}
