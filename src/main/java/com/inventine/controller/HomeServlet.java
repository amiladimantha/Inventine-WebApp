package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.PostDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Project;
import com.inventine.model.Post;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home-servlet", value = "/")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setAttribute("host_url",System.getenv("HOST_URL"));

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        String condition;
        String get_condition = ("status='A'");

        List<Project> projects = projectDao.getProjects(get_condition);
        List<User> users=new ArrayList<>();
        List<Creds> creds=new ArrayList<>();
        for (final Project project: projects){
            condition = String.format("%s",project.getCreatorId());
            users.add(userDao.getUser(condition));
            creds.add(credsDao.getCreds(condition));
            project.setProjectName(project.getProjectName());
            project.setCreatedAt(project.getCreatedAt());
        }

        request.setAttribute("project",projects);
        request.setAttribute("users",users);
        request.setAttribute("creds", creds);
        request.setAttribute("title","Home");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}