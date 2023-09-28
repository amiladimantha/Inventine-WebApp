package com.inventine.controller.dashboard.competition;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UpdateServlet", value = "/dashboard/competition/update/*")
public class CompetitionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }


        response.setContentType("text/html");


        String uri = URLDecoder.decode(request.getRequestURI(), "UTF-8").toLowerCase();

        String competitionId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();
        Competition competition = new Competition();
        competition = competitionDao.getCompetition(competitionId);


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("competition",competition);

        String topic = "Competition update-page";
        request.setAttribute("title", topic);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Competition competition = new Competition();
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();;

        // Parse request data
        String organizationId = (String) request.getSession().getAttribute("userId");
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
        String competitionid = request.getParameter("competitionid");

        //char pType = 'A';

        // Data to be processed
        Timestamp endingAt = null;
        Timestamp startingAt = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(endingAt_);
            endingAt = new java.sql.Timestamp(date.getTime());
            date = dateFormat.parse(startingAt_);
            startingAt = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }


        // Transactions
        if(ok){
            ok = competition.setCompetitionId(competitionid);
            ok = competition.setOrganizationId(organizationId);
            ok = competition.setSupportTeamId(supportTeamId);
            ok = competition.setHeaderId(headerId);
            ok = competition.setStartingAt(startingAt);
            ok = competition.setEndingAt(endingAt);
            ok = competition.setPrizeMoney(prizeMoney);
            ok = competition.setCompetitionName(competitionName);
            ok = competition.setRules(rules);
            ok = competition.setCType(cType);
            ok = competition.setPType(pType);
            ok = competition.setOverView(overView);
            ok = competition.setStatus(status);


            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }
            ok = competitionDao.update(competition);

            // Pass model to DAO
            if(!ok){
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
