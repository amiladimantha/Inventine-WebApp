package com.inventine.controller;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginURI = request.getContextPath() + "/login";

        HttpSession session = request.getSession(false);

        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("role");
        session.removeAttribute("status");

        response.sendRedirect(loginURI);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
