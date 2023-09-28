package com.inventine.controller;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.*;
import com.inventine.model.Competition;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CompetitionsServlet", value = "/competitions")
public class CompetitionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        OrganizationDaoImplementation  organizationsDao= new OrganizationDaoImplementation();

        String condition;

        List<Competition> competitions = competitionDao.getCompetitions("");
        List<User> users=new ArrayList<>();
        List<Creds> creds=new ArrayList<>();
        List<Organization> organizations = new ArrayList<>();
        for (final Competition competition: competitions){
            condition = String.format("%s",competition.getCompetitionId());
            users.add(userDao.getUser(condition));
            creds.add(credsDao.getCreds(condition));
            organizations.add(organizationsDao.getOrganization(condition));
            System.out.println(organizationsDao.getOrganization(condition));
            competition.setCompetitionName(competition.getCompetitionName());
            competition.setCreatedAt(competition.getCreatedAt());
//            System.out.println(credsDao.getCreds(condition).getProfileId());
        }

        request.setAttribute("users",users);
        request.setAttribute("creds", creds);
        request.setAttribute("organizations",organizations);
        request.setAttribute("competition", competitions);
        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Competitions");
        request.getRequestDispatcher("/WEB-INF/competitions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
