package com.inventine.controller;

import com.inventine.dao.*;
import com.inventine.model.*;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProjectViewServlet", value = "/project/*")
public class ProjectDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");



        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();


        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String projectId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        if(projectId.isEmpty()){
            System.out.println("Project ID is empty");
        }

        Project project = projectDao.getProject(projectId);
        User user = userDao.getUser(project.getCreatorId());
        Creds creds = credsDao.getCreds(project.getCreatorId());

        String query = String.format("select sum(amount) from payment where projectid=%s;",projectId);
        String query1 = String.format("select count(DISTINCT investorid) from payment where projectid=%s",projectId);
//        String query2 = String.format("select dateOfExpiry::DATE - NOW()::DATE from project where projectid=%s",projectId);
//        String condition = "select dateOfExpiry::DATE - NOW()::DATE from project where projectid=%s";

        int projectsdate = 128;


//        String condition1;
//
//        List<Project> project1 = projectDao.getProjects("");
//        List<User> users=new ArrayList<>();
//        List<Creds> cred=new ArrayList<>();
//        for (final Project project2: project1){
//            condition1 = String.format("%s",project2.getCreatorId());
//            users.add(userDao.getUser(condition1));
//            cred.add(credsDao.getCreds(condition1));
//            project.setProjectName(project2.getProjectName());
//            project.setCreatedAt(project2.getCreatedAt());
//        }

//        request.setAttribute("projects",project1);
//        request.setAttribute("users",users);
//        request.setAttribute("cred", cred);

        request.setAttribute("project",project);
        request.setAttribute("user",user);
        request.setAttribute("creds",creds);
        ResultSet rs = paymentDao.executeQuery(query);
        try {
            request.setAttribute("pledge", rs.getInt("sum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs1 = paymentDao.executeQuery(query1);
        try {
            request.setAttribute("investors", rs1.getInt("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("projectsdate",projectsdate);
        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Project-Details");
        request.getRequestDispatcher("/WEB-INF/project-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
