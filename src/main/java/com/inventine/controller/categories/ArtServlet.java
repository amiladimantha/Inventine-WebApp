package com.inventine.controller.categories;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Project;
import com.inventine.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ArtServlet", value = "/categories/art")
public class ArtServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("host_url",System.getenv("HOST_URL"));

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        String condition = "category='art';";

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

        request.setAttribute("project",projects);
        request.setAttribute("users",users);
        request.setAttribute("creds", creds);
        request.setAttribute("title","Home");
        request.getRequestDispatcher("/WEB-INF/categories/art.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
