package com.inventine.controller.dashboard.employee;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/dashboard/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String get_condition = "";
        String totalq= null;

        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            card1_condition = "status = 'A'";
            card2_condition = "select count(DISTINCT projectid) from payment";
            card3_condition = "select count(DISTINCT investorid) from payment";
            card4_condition = "select sum(amount/(1000)) from payment";
            get_condition = "";
        }

//        if (role == 'C'){
//            card2_condition = "select count(DISTINCT projectid) from payment";
//            card3_condition = "select count(DISTINCT investorid) from payment";
//            card4_condition = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }
//
//        if (role == 'I'){
//            card2_condition = "select count(DISTINCT projectid) from payment";
//            card3_condition = "select count(DISTINCT investorid) from payment";
//            card4_condition = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }

//        String creators = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String projects = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String meetings = String.format("select count(investorid) from acceptmeeting where investorid=%s;",investorId);
//        String transactions = String.format("select sum(amount/(1000)) from payment where investorid=%s;",investorId);

        List<User> users = userDao.getUsers(get_condition);
        List<Creds> creds = credsDao.getManyCreds(get_condition);

        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        for (Creds cred : creds) {

            System.out.println(cred.getUserId());

            if(Character.compare(cred.getStatus(),'A') == 0){
                card1_count += 1;
            }
            if(Character.compare(cred.getStatus(),'B') == 0){
                card2_count += 1;
            }
            if(Character.compare(cred.getStatus(),'D') == 0){
                card3_count += 1;
            }


        }

        card4_count = card1_count+card2_count+card3_count;

        // Add card labels
        request.setAttribute("card1_label","Active");
        request.setAttribute("card2_label","Blocked");
        request.setAttribute("card3_label","Deleted");
        request.setAttribute("card4_label","Total");

        // Add card values
        request.setAttribute("card1_count",card1_count);
        request.setAttribute("card2_count",card2_count);
        request.setAttribute("card3_count",card3_count);
        request.setAttribute("card4_count",card4_count);

        // Add card colors
        request.setAttribute("card1_color","#03D815");
        request.setAttribute("card2_color","#FFC400");
        request.setAttribute("card3_color","#FF004C");
        request.setAttribute("card4_color","#006EFF");

        // Add card icons
        request.setAttribute("card1_icon","fa-lightbulb");
        request.setAttribute("card2_icon","fa-lightbulb");
        request.setAttribute("card3_icon","fa-lightbulb");
        request.setAttribute("card4_icon","fa-lightbulb");

        // Add table data
        request.setAttribute("users",users);
        request.setAttribute("creds",creds);

        request.setAttribute("title","Employee");
        request.getRequestDispatcher("/WEB-INF/dashboard/employee/employee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("id");
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        Creds creds = credsDao.getCreds(userId);

        creds.setStatus('D');
        credsDao.update(creds);

    }
}