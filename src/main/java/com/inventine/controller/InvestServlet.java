package com.inventine.controller;

import com.inventine.dao.*;
import com.inventine.model.*;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InvestServlet", value = "/invest")
public class InvestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();

        String userId = (String)request.getSession().getAttribute("userId");


        User user = userDao.getUser(userId);

        Creds creds = credsDao.getCreds(userId);
        String projectId = request.getParameter("projectId");


        request.setAttribute("project",projectDao.getProject(projectId));
        request.setAttribute("user",user);
        request.setAttribute("creds",creds);
        System.out.println("this servlet");


        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Invest");
        request.getRequestDispatcher("/WEB-INF/invest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


//        String login_redirect = System.getenv("HOST_URL")+"/login";
//
//
//        if (session.getAttribute("role") == null) {
//           session.setAttribute("login_redirect",login_redirect);
//            LoginServlet login_servlet = new LoginServlet();
//            login_servlet.doGet(request,response);
//        }

        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs

        Project project = new Project();
        Payment payment = new Payment();
        UserDaoImplementation userDao = new UserDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();

        // Parse request data

        String projectId = request.getParameter("projectId");
        String userId = (String)request.getSession().getAttribute("userId");
        String financialDetailsId = "1";
        int amount = Integer.parseInt(request.getParameter("amount"));


        System.out.println(projectId);
        System.out.println(userId);
        System.out.println(financialDetailsId);
        System.out.println(amount);



        // Logic
//        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
//            ok=false;
//            messages.add("projectname is already found!");
//        }

        // Transactions
        if(ok){


            ok = payment.setProjectId(projectId);
            ok = payment.setInvestorId(userId);
            ok = payment.setFinancialDetailsId(financialDetailsId);
            ok = payment.setAmount(amount);


            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            //           Pass model to DAO
            if(!paymentDao.create(payment)){
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
