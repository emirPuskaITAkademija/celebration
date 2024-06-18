package ba.smoki.celebration.filter;

import ba.smoki.celebration.ejb.user.User;
import ba.smoki.celebration.ejb.user.UserServiceLocal;
import ba.smoki.celebration.servlet.user.login.AuthenticationModel;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Base64;

@WebFilter(urlPatterns = {"/api/*", "/dashboard/*"})
public class AuthenticationFilter implements Filter {

    @Inject
    private UserServiceLocal userServiceLocal;
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.servletContext.log("Authentication filter initialized..");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String authorizationValue = req.getHeader("Authorization");

        if (authorizationValue != null && authorizationValue.startsWith("Basic ")) {
            String base64EncodedUsernamePassword = authorizationValue.substring("Basic ".length());
            String base64DecodeUsernamePassword = new String(Base64.getDecoder().decode(base64EncodedUsernamePassword));
            String[] decodedCredentiasl = base64DecodeUsernamePassword.split(":");
            String username = decodedCredentiasl[0];
            String plainPassword = decodedCredentiasl[1];
            boolean isUsernamePasswordValid = checkCredentialValidity(username, plainPassword);
            if (isUsernamePasswordValid) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            HttpSession session = req.getSession(false);
            if (session == null){
                res.sendRedirect(req.getContextPath() + "/login");
            }else{
                User user = (User) session.getAttribute("user");
                if(user !=null){
                    chain.doFilter(request, response);
                }else{
                    res.sendRedirect(req.getContextPath() + "/login");
                }
            }
        }
    }

    private boolean checkCredentialValidity(String username, String password) {
        AuthenticationModel authenticationModel = new AuthenticationModel();
        authenticationModel.setUsername(username);
        authenticationModel.setPlainPassword(password);
        return userServiceLocal.login(authenticationModel) != null;
    }
}
