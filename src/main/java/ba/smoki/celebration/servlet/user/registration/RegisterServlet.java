package ba.smoki.celebration.servlet.user.registration;

import ba.smoki.celebration.Router;
import ba.smoki.celebration.ejb.town.Town;
import ba.smoki.celebration.ejb.town.TownServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registrationServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
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

    }
}