package ba.smoki.celebration.servlet.country;

import ba.smoki.celebration.ejb.country.Country;
import ba.smoki.celebration.ejb.country.CountryServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "countryServlet", urlPatterns = {"/countries"})
public class CountryServlet extends HttpServlet {

    @Inject
    private CountryServiceLocal countryServiceLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter();) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Service</title></head>");
            out.println("<body>");
            out.println("<h1>Service Type</h1>");
            out.println("<ol>");
            for(Country country: countryServiceLocal.findAll()){
                out.println("<li>" + country.getName() + "</li>");
            }
            out.println("</ol>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
