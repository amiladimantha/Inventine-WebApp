package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Project;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProfileServlet", value = "/profile/*")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();
        String userId = uri.substring(uri.lastIndexOf('/') + 1);
        String userID = request.getParameter("id");
        System.out.println(userID);

        User user = userDao.getUser(userId);
        Creds cred = credsDao.getCreds(userId);
        String condition= "creatorid="+userID;
        System.out.println(condition);

        List<Project> projects = projectDao.getProjects(condition);
        List<User> users=new ArrayList<>();
        List<Creds> creds=new ArrayList<>();
        for (final Project project: projects){
            condition = String.format("%s",project.getCreatorId());
            users.add(userDao.getUser(condition));
            creds.add(credsDao.getCreds(condition));
            project.setProjectName(project.getProjectName());
            project.setCreatedAt(project.getCreatedAt());
        }

        request.setAttribute("user", user);
        request.setAttribute("users", users);
        request.setAttribute("creds", creds);
        request.setAttribute("cred", cred);
        request.setAttribute("project",projects);
        request.setAttribute("title",cred.getUsername());
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
