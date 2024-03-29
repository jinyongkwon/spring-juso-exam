package site.metacoding.addressapitest.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import site.metacoding.addressapitest.config.auth.LoginUser;
import site.metacoding.addressapitest.domain.User;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        User principal = loginUser.getUser();

        HttpSession session = request.getSession();
        session.setAttribute("principal", principal);
        response.sendRedirect("/s/update-form");
    }
}
