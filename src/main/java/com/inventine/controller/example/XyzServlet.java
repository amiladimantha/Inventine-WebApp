package com.inventine.controller.example;

import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "XyzServlet", value = "/XyzServlet")
public class XyzServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A');
        }


        response.setContentType("text/html");
        UserDaoImplementation userDao = new UserDaoImplementation();

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","xyz");


        request.setAttribute("active",userDao.getCount("status='A'"));
        List<User> users = userDao.getUsers("");
        request.setAttribute("users",users);
        request.getRequestDispatcher("/WEB-INF/Example/xyz.jsp").forward(request, response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
