package ba.smoki.celebration.servlet.service;

import ba.smoki.celebration.ejb.service.ServiceType;
import ba.smoki.celebration.ejb.service.ServiceTypeService;
import ba.smoki.celebration.ejb.service.ServiceTypeServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/services"})
public class ServiceTypeServlet extends HttpServlet {

    @Inject
    private ServiceTypeServiceLocal serviceTypeService;

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
            out.println("<h1>Service Type</h1>");
            List<ServiceType> serviceTypes = serviceTypeService.findAll();
            out.println("<ol>");
            for(ServiceType serviceType: serviceTypes){
                out.println("<li>" + serviceType.getName() + "</li>");
            }
            out.println("</ol>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
