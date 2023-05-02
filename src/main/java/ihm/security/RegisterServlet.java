package ihm.security;

import bll.SecurityService;
import bo.User;
import helpers.Flash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Security;
import java.time.LocalDate;

@WebServlet("/inscription")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/security/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, email, password , firstname, lastname, LocalDate.now());
        SecurityService.getInstance().addUser(user);

        Flash.send("success","Votre compte a bien été créé", req.getSession());
        resp.sendRedirect(req.getContextPath()+"/connexion");
    }
}
