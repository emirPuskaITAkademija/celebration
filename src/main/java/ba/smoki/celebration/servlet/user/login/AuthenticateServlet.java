package ba.smoki.celebration.servlet.user.login;

import ba.smoki.celebration.Router;
import ba.smoki.celebration.ejb.user.User;
import ba.smoki.celebration.ejb.user.UserServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "authenticateServlet", urlPatterns = {"/authenticate"})
public class AuthenticateServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String plainPassword = request.getParameter("password");
        AuthenticationModel authenticationModel = new AuthenticationModel();
        authenticationModel.setUsername(username);
        authenticationModel.setPlainPassword(plainPassword);
        User user = userServiceLocal.login(authenticationModel);
        if (user != null) {
            request.setAttribute("errorMessage", "");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Router.dashboard);
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Neispravna kombinacija lozinke i passworda");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Router.login);
            requestDispatcher.forward(request, response);
        }
    }
}
