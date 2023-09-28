package com.inventine.controller.dashboard.competition;

import com.inventine.dao.CompetitionDaoImplementation;

import com.inventine.model.Competition;

import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CreateServlet", value = "/dashboard/competition/create")
public class CompetitionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A');
        }
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic= "Competition Create-page";
        request.setAttribute("title",topic);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Competition competition = new Competition();
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();



        // Parse request data
        String organizationId = (String) request.getSession().getAttribute("userId");
        System.out.println(organizationId);
        String supportTeamId = "11";
        String headerId = "1640618179717";



        String endingAt_ = request.getParameter("endingAt");
        String startingAt_ = request.getParameter("startingAt");
        int prizeMoney = Integer.parseInt(request.getParameter("prizeMoney"));
        String competitionName = request.getParameter("competitionName");
        String rules = request.getParameter("rules");
        String overView = request.getParameter("overView");
        char cType = request.getParameter("cType").charAt(0);
        char pType = 'I';
        char status = 'A';


        // Data to be processed
        Timestamp endingAt = null;


        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(endingAt_);
            endingAt = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }
        Timestamp startingAt = null;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(startingAt_);
            startingAt = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        // Transactions
        if(ok){

            ok = competition.setOrganizationId(organizationId);
            System.out.println(competition.getOrganizationId());
            ok = competition.setSupportTeamId(supportTeamId);
            System.out.println(competition.getSupportTeamId());
            ok = competition.setHeaderId(headerId);
            System.out.println(competition.getHeaderId());
            ok = competition.setEndingAt(endingAt);
            System.out.println(competition.getEndingAt());
            ok = competition.setStartingAt(startingAt);
            System.out.println(competition.getStartingAt());
            ok = competition.setPrizeMoney(prizeMoney);
            System.out.println(competition.getPrizeMoney());
            ok = competition.setCompetitionName(competitionName);
            System.out.println(competition.getCompetitionName());
            ok = competition.setRules(rules);
            System.out.println(competition.getRules());
            ok = competition.setCType(cType);
            System.out.println(competition.getCType());
            ok = competition.setPType(pType);
            System.out.println(competition.getPType());
            ok = competition.setOverView(overView);
            System.out.println(competition.getOverView());
            ok = competition.setStatus(status);
            System.out.println(competition.getStatus());

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO
            if(!competitionDao.create(competition)){
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


