package com.inventine.controller.dashboard.competition;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CompetitionServlet", value = "/dashboard/competition")
public class CompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }
//
//        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
       CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();
//      //  ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
//
//
//        String topic= "Competition Dashboard";
//        request.setAttribute("title",topic);
//
//        request.setAttribute("competition",competitionDao.getCount("organizationid=20"));
//        request.setAttribute("project", competitionDao.getCount("organizationid=17"));
//        request.setAttribute("total", competitionDao.getCount("organizationid=20"));
//        request.setAttribute("deleted", competitionDao.getCount("creatorid=5"));
//
////

        String get_condition = "";
//        String totalq= null;
        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            get_condition = "";
        }

        if (role == 'C'){
            get_condition = String.format("organizationid=%s", session.getAttribute("userid"));
        }


//

        List<Competition> competitions = competitionDao.getCompetitions(get_condition);

        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        for (Competition competition : competitions) {

            if(Character.compare(competition.getStatus(),'A') == 0){
                card1_count += 1;
            }
            if(Character.compare(competition.getStatus(),'B') == 0){
                card2_count += 1;
            }
            if(Character.compare(competition.getStatus(),'D') == 0){
                card3_count += 1;
            }


        }

        card4_count = card1_count + card2_count + card3_count;






        // Add card labels
        request.setAttribute("card1_label", "Active");
        request.setAttribute("card2_label", "Block");
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
        request.setAttribute("card3_color", "#0097E6");
        request.setAttribute("card4_color", "#FF0000");
//
        // Add card icons
        request.setAttribute("card1_icon", "far fa-building");
        request.setAttribute("card2_icon", "far fa-building");
        request.setAttribute("card3_icon", "far fa-building");
        request.setAttribute("card4_icon", "far fa-building");

//
        List<Competition> competition = competitionDao.getCompetitions("");
        request.setAttribute("competitions",competitions);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/index.jsp").forward(request, response);
      

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
