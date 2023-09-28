package com.inventine.controller;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "OrganizationProfileServlet", value = "/organization-profile/*")
public class OrganizationProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A');
        }


        response.setContentType("text/html");
        //CompetitionDaoImplementation CompetitionDao = new CompetitionDaoImplementation();
        OrganizationDaoImplementation OrganazationDao = new OrganizationDaoImplementation();




        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String organizationId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        if(organizationId.isEmpty()){
            System.out.println("Organization ID is empty");
        }

        //Competition competition = CompetitionDao.getCompetition(competitionId);

        Organization organization = OrganazationDao.getOrganization(organizationId);
        request.setAttribute("organization",organization);
       // request.setAttribute("competition",competition);

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","OrganizationProfile");
        request.getRequestDispatcher("/WEB-INF/organization-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
