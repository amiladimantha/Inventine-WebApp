package com.inventine.controller.dashboard;

import com.inventine.dao.*;
import com.inventine.model.Payment;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DasboardServlet", value = "/dashboard")
public class DasboardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        ProjectDaoImplementation projectsDao = new ProjectDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String card5_condition= null;
        String card6_condition= null;
        String card7_condition= null;
        String card8_condition= null;

        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S' || role == 'C' || role == 'I' || role == 'O') {
            card1_condition = "role = 'I'";
            card2_condition = "select count(DISTINCT creatorId) from project";
            card3_condition = "select count(DISTINCT projectId) from project";
            card4_condition = "select count(DISTINCT competitionId) from competition";
            card5_condition = "orgType = 'P'";
            card6_condition = "orgType = 'S'";
            card7_condition = "where orgType = 'U'";
            card8_condition = "";
        }

        int card1_count = credsDao.getCount(card1_condition);
        int card2_count = projectsDao.getCount(card2_condition);
        int card3_count = projectsDao.getCount(card3_condition);
        int card4_count = competitionDao.getCount(card4_condition);
        int card5_count = organizationDao.getCount(card5_condition);
        int card6_count = organizationDao.getCount(card6_condition);
        int card7_count = organizationDao.getCount(card7_condition);
        int card8_count = organizationDao.getCount(card8_condition);

        // Add card labels
        if (role == 'A' || role == 'F' || role == 'S' || role == 'C' || role == 'I' || role == 'O') {
            request.setAttribute("card1_label", "Investors");
            request.setAttribute("card2_label", "Creators");
            request.setAttribute("card3_label", "Projects");
            request.setAttribute("card4_label", "Competitions");
            request.setAttribute("card5_label", "Private.Orgs");
            request.setAttribute("card6_label", "Schools");
            request.setAttribute("card7_label", "Universities");
            request.setAttribute("card8_label", "Org.Members");
        }



        // Add card values
        request.setAttribute("card1_count",card1_count);
        request.setAttribute("card2_count",card2_count);
        request.setAttribute("card3_count",card3_count);
        request.setAttribute("card4_count",card4_count);
        request.setAttribute("card5_count",card5_count);
        request.setAttribute("card6_count",card6_count);
        request.setAttribute("card7_count",card7_count);
        request.setAttribute("card8_count",card8_count);

        // Add card colors
        request.setAttribute("card1_color","#b600b6");
        request.setAttribute("card2_color","#ff7300");
        request.setAttribute("card3_color","#03d815");
        request.setAttribute("card4_color","#006eff");
        request.setAttribute("card5_color","#00b670");
        request.setAttribute("card6_color","#ffc400");
        request.setAttribute("card7_color","#402cb3");
        request.setAttribute("card8_color","#ff004c");

        // Add card icons
        request.setAttribute("card1_icon","fas fa-money-check-alt fa-2x");
        request.setAttribute("card2_icon","fas fa-chalkboard-teacher fa-2x");
        request.setAttribute("card3_icon","far fa-lightbulb fa-2x");
        request.setAttribute("card4_icon","fas fa-trophy fa-2x");
        request.setAttribute("card5_icon","fas fa-sitemap fa-2x");
        request.setAttribute("card6_icon","fas fa-school fa-2x");
        request.setAttribute("card7_icon","fas fa-university fa-2x");
        request.setAttribute("card8_icon","fas fa-users fa-2x");





        String graph_labels = "['Week1', 'Week2', 'Week3', 'Week4']";

        request.setAttribute("graph_labels",graph_labels);
        request.setAttribute("host_url", System.getenv("HOST_URL"));
        request.setAttribute("title","Creator");
        request.getRequestDispatcher("/WEB-INF/dashboard/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
