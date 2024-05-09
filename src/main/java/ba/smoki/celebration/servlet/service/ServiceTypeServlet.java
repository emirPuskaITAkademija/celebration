package ba.smoki.celebration.servlet.service;

import ba.smoki.celebration.ejb.service.ServiceTypeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/services"})
public class ServiceTypeServlet extends HttpServlet {

    @Inject
    private ServiceTypeService serviceTypeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter();) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Service</title></head>");
            out.println("<body>");
            out.println("<h1>Vozdra</h1>");
            out.println("<p>" + serviceTypeService.findAll().get(0).getName() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
