package com.inventine.controller.dashboard.payment;

import com.inventine.dao.AcceptMeetingDaoImplementation;
import com.inventine.dao.CreatorDaoImplementation;
import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.*;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/dashboard/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }
        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();
        String investorId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String get_condition = null;
        String totalq= null;

        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            card1_condition = "sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('month', current_date - interval '10' month)\n" +
                    "  and createdat < date_trunc('month', current_date)";
            card2_condition = "sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('week', current_date - interval '100 week')\n" +
                    "  and createdat < date_trunc('week', current_date)";
            card3_condition = "count(DISTINCT paymentid)";
            card4_condition = "sum(amount/(1000))";
            get_condition = "";
        }

        if (role == 'C'){
            card1_condition = "select sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('month', current_date - interval '1 month')\n" +
                    "  and createdat < date_trunc('month', current_date) and projectid=(select projectid from project where creatorid=%s)";
            card2_condition = "select sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('week', current_date - interval '1 week')\n" +
                    "  and createdat < date_trunc('week', current_date) and projectid=(select projectid from project where creatorid=%s)";;
            card3_condition = "select count(DISTINCT paymentid) from payment where projectid=(select projectid from project where creatorid=%s)";
            card4_condition = "select sum(amount/1000) from payment where projectid=(select projectid from project where creatorid=%s)";
            get_condition = "";
        }

        if (role == 'I'){
            card1_condition = "select sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('month', current_date - interval '1 month')\n" +
                    "  and createdat < date_trunc('month', current_date) and investorid=%s";
            card2_condition = "select sum(amount/(1000)) from payment\n" +
                    "WHERE createdat >= date_trunc('week', current_date - interval '1 week')\n" +
                    "  and createdat < date_trunc('week', current_date) and investorid=%s";;
            card3_condition = "select count(DISTINCT paymentid) from payment where investorid=%s";
            card4_condition = "select sum(amount/1000) from payment where inevestorid=%s";
            get_condition = "";

        }

//        String creators = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String projects = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String meetings = String.format("select count(investorid) from acceptmeeting where investorid=%s;",investorId);
//        String transactions = String.format("select sum(amount/(1000)) from payment where investorid=%s;",investorId);

        List<Payment> payments = paymentDao.getPayments(get_condition);
        List<Project> projects = projectDao.getProjects(get_condition);


        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

//        for (Project project : projects) {
//
//            if(Character.compare(project.getStatus(),'A') == 0){
//                card1_count += 1;
//            }
//            if(Character.compare(project.getStatus(),'B') == 0){
//                card2_count += 1;
//            }
//            if(Character.compare(project.getStatus(),'D') == 0){
//                card3_count += 1;
//            }
//
//
//        }

//        card4_count = card1_count+card2_count+card3_count;

        // Add card labels
            request.setAttribute("card1_label", "This Month");
            request.setAttribute("card2_label", "This Week");
            request.setAttribute("card3_label", "Transactions");
            request.setAttribute("card4_label", "Total Funds");


        // Add card values
        request.setAttribute("card1_count",card1_count);
        request.setAttribute("card2_count",card2_count);
        request.setAttribute("card3_count",card3_count);
        request.setAttribute("card4_count",card4_count);
        System.out.println(card1_count);
        System.out.println(card2_count);
        System.out.println(card3_count);
        System.out.println(card4_count);
        // Add card colors
        request.setAttribute("card1_color","#006EFF");
        request.setAttribute("card2_color","#3AC3FF");
        request.setAttribute("card3_color","#7EFC00");
        request.setAttribute("card4_color","#03D815");

        // Add card icons
        request.setAttribute("card1_icon","fas fa-funnel-dollar");
        request.setAttribute("card2_icon","fas fa-funnel-dollar");
        request.setAttribute("card3_icon","fas fa-funnel-dollar");
        request.setAttribute("card4_icon","fas fa-funnel-dollar");

        // Add table data
//        request.setAttribute("payments",payments);
//        request.setAttribute("projects",projects);
//
//        request.setAttribute("title","Project");
//        request.getRequestDispatcher("/WEB-INF/dashboard/project/index.jsp").forward(request, response);
//        List<Payment> payments = paymentDao.getPayments("");
//
//
//        String creatorsq= null;
//        String projectsq= null;
//        String investorsq= null;
//        String transactionsq= null;
//        String totalq= null;
//        char role = (char)request.getSession().getAttribute("role");
//
//        if (role == 'A' || role == 'F' || role == 'S'){
//            creatorsq = "select count(DISTINCT creatorid) from project where projectid=(select distinct projectid from payment)";
//            projectsq = "select count(DISTINCT projectid) from payment";
//            investorsq = "select count(DISTINCT investorid) from payment";
//            transactionsq = "select sum(amount/(1000)) from payment";
//        }
//
//        if (role == 'C'){
//            projectsq = "select count(DISTINCT projectid) from payment";
//            investorsq = "select count(DISTINCT investorid) from payment";
//            transactionsq = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }
//
//        if (role == 'I'){
//            projectsq = "select count(DISTINCT projectid) from payment";
//            investorsq = "select count(DISTINCT investorid) from payment";
//            transactionsq = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }
//
//        String creators = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String projects = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String meetings = String.format("select count(investorid) from acceptmeeting where investorid=%s;",investorId);
//        String transactions = String.format("select sum(amount/(1000)) from payment where investorid=%s;",investorId);
//
//
//
//
//        if(investorId.isEmpty()){
//            System.out.println("Investor ID is empty");
//        }
//
//        ResultSet rsc = paymentDao.executeQuery(creatorsq);
//        ResultSet rsp = paymentDao.executeQuery(projectsq);
//        ResultSet rsm = paymentDao.executeQuery(investorsq);
//        ResultSet rst = paymentDao.executeQuery(transactionsq);
//        try {
//            request.setAttribute("creatorsq", rsc.getInt("count"));
//            request.setAttribute("projectsq", rsp.getInt("count"));
//            request.setAttribute("investorsq", rsm.getInt("count"));
//            request.setAttribute("transactionsq", rst.getInt("sum"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        request.setAttribute("payments",payments);
        request.setAttribute("projects",projects);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Payment");
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/dashboard/payment/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
