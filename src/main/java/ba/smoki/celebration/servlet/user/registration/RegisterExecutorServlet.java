package ba.smoki.celebration.servlet.user.registration;

import ba.smoki.celebration.Router;
import ba.smoki.celebration.ejb.town.Town;
import ba.smoki.celebration.ejb.town.TownServiceLocal;
import ba.smoki.celebration.ejb.user.User;
import ba.smoki.celebration.ejb.user.UserServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/register/execute"})
public class RegisterExecutorServlet extends HttpServlet {
    @Inject
    private UserServiceLocal userServiceLocal;

    @Inject
    private TownServiceLocal townServiceLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RegistrationModel registrationModel = RegistrationModel
                .builder()
                .name(request.getParameter("firstName"))
                .surname(request.getParameter("surname"))
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .contact(request.getParameter("contact"))
                .email(request.getParameter("email"))
                .town(request.getParameter("town"))
                .build();
        User user = userServiceLocal.register(registrationModel);
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
            requestDispatcher.include(request, response);
        } else {
            List<Town> towns = townServiceLocal.findAll();
            request.setAttribute("towns", towns);
            request.setAttribute("message", "Username '" + registrationModel.getUsername() + "' zauzet");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Router.registration);
            requestDispatcher.include(request, response);
        }
    }
}
