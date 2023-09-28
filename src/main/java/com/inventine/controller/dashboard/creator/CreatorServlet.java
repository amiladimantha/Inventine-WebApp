package com.inventine.controller.dashboard.creator;

import com.inventine.dao.CreatorDaoImplementation;
import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.model.Creator;
import com.inventine.model.Meeting;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CreatorServlet", value = "/dashboard/creator")
public class CreatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        CreatorDaoImplementation creatorDao = new CreatorDaoImplementation();

        String graph_labels = "['Week1', 'Week2', 'Week3', 'Week4']";

        request.setAttribute("graph_labels",graph_labels);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","creator");



        request.setAttribute("creators",creatorDao.getCount("creatorid=3 AND status='A'"));
        request.setAttribute("projects", creatorDao.getCount("creatorid=3 AND status='R'"));
        request.setAttribute("meetings", creatorDao.getCount("creatorid=3 AND launchedAt>=NOW()"));
        ResultSet rs = creatorDao.executeQuery("select sum(amount/(1000)) from payment where investorid=1;");
        try {
            request.setAttribute("payments", rs.getInt("sum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        List<Creator> creators = creatorDao.getCreators("");
        request.setAttribute("creators",creators);
        request.getRequestDispatcher("/WEB-INF/dashboard/creator/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}