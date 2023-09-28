package com.inventine.controller.dashboard.project;

import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.RateProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Project;
import com.inventine.model.RateProject;
import com.inventine.model.User;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProjectRatingServlet", value = "/dashboard/project/rate/*")
public class ProjectRatingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        response.setContentType("text/html");

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String projectId =  uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        Project project = new Project();
        project = projectDao.getProject(projectId);



        request.setAttribute("project",project);
        request.setAttribute("host_url", System.getenv("HOST_URL"));
        request.getRequestDispatcher("/WEB-INF/dashboard/project/rate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs

        Project project = new Project();
        RateProject rateProject = new RateProject();
        UserDaoImplementation userDao = new UserDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        RateProjectDaoImplementation rateProjectDao = new RateProjectDaoImplementation();

        // Parse request data

        String projectId = request.getParameter("projectId");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String userId = (String)request.getSession().getAttribute("userId");


        System.out.println(projectId);
        System.out.println(rating);
        System.out.println(userId);

        // Data to be processed
        Timestamp dateOfExpiry = null;

        // Data preprocessing


        // Logic
//        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
//            ok=false;
//            messages.add("projectname is already found!");
//        }

        // Transactions
        if(ok){


            ok = rateProject.setProjectRating(rating);
            ok = rateProject.setInvestorId(userId);
            ok = rateProject.setProjectId(projectId);


            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            //           Pass model to DAO
            if(!rateProjectDao.create(rateProject)){
                ok=false;
                messages.clear();
                messages.add("Something went wrong!");
                System.out.println("There is a issue with dao!");

            }



        }

        // JSON response
        json.put("ok", ok);
        json.put("messages", messages);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}

