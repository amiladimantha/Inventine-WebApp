package com.inventine.controller.dashboard.meeting;

import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.model.Meeting;
import com.inventine.model.Payment;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MeetingServlet", value = "/dashboard/meeting")
public class MeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }

        MeetingDaoImplementation meetingDao = new MeetingDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String get_condition = "";
        String totalq= null;

//        String totalq= null;
        char role = (char) request.getSession().getAttribute("role");



        if (role == 'C') {

        }

        if (role == 'I') {
            get_condition = String.format("meetingid=(select meetingid from acceptmeeting where investorid=%s)", session.getAttribute("userId"));
        }



        if (role == 'A' || role == 'F' || role == 'S'){
            card1_condition = "select count(DISTINCT projectid) from project where status = 'A'";
            card2_condition = "select count(DISTINCT projectid) from project where status = 'B'";
            card3_condition = "select count(DISTINCT projectid) from project where status = 'D'";
            card4_condition = "select count(DISTINCT projectid) from project";
            get_condition = "";
        }

        if (role == 'C'){
            card1_condition = "select count(DISTINCT projectid) from project where status='A' and creatorId=%s;";
            card2_condition = "select count(DISTINCT projectid) from project where status='B' and creatorId=%s;";
            card3_condition = "select count(DISTINCT projectid) from project where status='D' and creatorId=%s;";
            card4_condition = "sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s);";
            get_condition = String.format("creatorId=%s", session.getAttribute("userId"));
        }



        if (role == 'I'){
            card1_condition = "select count(DISTINCT projectid) from project";
            card2_condition = "(select count from payment where projectid=(select projectid from project where financialstatus='C') && investorid=%s)";
            card3_condition = "select count(DISTINCT investorid) from payment";
            card4_condition = "select sum(amount/(1000)) from payment where investorid=%s";
            get_condition = String.format("meetingId=(select projectid from payment where investorid=%s)", session.getAttribute("userId"));
            //            get_condition = "select * from project where projectid=(select projectid from payment where investorid=%s)";
        }


        List<Meeting> meetings = meetingDao.getMeetings(get_condition);
        List<Project> projects = new ArrayList<Project>();

        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        for (Meeting meeting : meetings) {

            if (Character.compare(meeting.getStatus(), 'A') == 0) {
                card1_count += 1;
            }
            if (Character.compare(meeting.getStatus(), 'R') == 0) {
                card2_count += 1;
            }
            if (Character.compare(meeting.getStatus(), 'D') == 0) {
                card3_count += 1;
            }




        }

        card4_count = card1_count + card2_count + card3_count;

        // Add card labels
        request.setAttribute("card1_label", "Accepted");
        request.setAttribute("card2_label", "Rejected");
        request.setAttribute("card3_label", "Deleted");
        request.setAttribute("card4_label", "Total");

        // Add card values
        request.setAttribute("card1_count", card1_count);
        request.setAttribute("card2_count", card2_count);
        request.setAttribute("card3_count", card3_count);
        request.setAttribute("card4_count", card4_count);

        // Add card colors
        request.setAttribute("card1_color", "#03D815");
        request.setAttribute("card2_color", "#FFC400");
        request.setAttribute("card3_color", "#FF0000");
        request.setAttribute("card4_color", "#0097E6");

        // Add card icons
        request.setAttribute("card1_icon", "fas fa-people-carry");
        request.setAttribute("card2_icon", "fas fa-people-carry");
        request.setAttribute("card3_icon", "fas fa-people-carry");
        request.setAttribute("card4_icon", "fas fa-people-carry");


        request.setAttribute("meetings", meetings);


        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title", "Meeting");
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/dashboard/meeting/index.jsp").forward(request, response);
        response.setContentType("text/html");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
