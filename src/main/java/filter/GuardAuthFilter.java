package filter;

import bo.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(
        dispatcherTypes = {
                DispatcherType.REQUEST
        },
        urlPatterns = {
                "/tutos/ajouter",
                "/tutos/modifier/*",
                "/tutos/supprimer/*",
                "/mon-compte"
        }
)
public class GuardAuthFilter extends HttpFilter implements Filter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/connexion");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Starting... Filter Guard");
    }
}
