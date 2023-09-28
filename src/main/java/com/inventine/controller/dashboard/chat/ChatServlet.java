package com.inventine.controller.dashboard.chat;

import com.inventine.dao.ChatDaoImplementation;
import com.inventine.dao.ChatDaoImplementation;
import com.inventine.model.Chat;
import com.inventine.model.Chat;
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

@WebServlet(name = "ChatServlet", value = "/dashboard/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }
        response.setContentType("text/html");

        ChatDaoImplementation chatDao = new ChatDaoImplementation();
        List<Chat> chats = chatDao.getChats((String)session.getAttribute("userid"));
        request.setAttribute("chats",chats);
        System.out.println(chats.get(0).getMessage());


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        request.setAttribute("title","Chat");
        request.getRequestDispatcher("/WEB-INF/dashboard/chat/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        // JSON parameters
//        JSONObject json = new JSONObject();
//        List<String> messages = new ArrayList<>();
//        boolean ok = true;
//
//        // Models and DAOs
//        Chat chat = new Chat();
//        ChatDaoImplementation chatDao = new ChatDaoImplementation();
//        HttpSession session = request.getSession();
//
//        // Parse request data
//        String organizationId = "61";
//
//
//
//
//        // char status = 'A';
//
//        String senderid = "11";
//        String receiverid = "55";
//
//        String message = request.getParameter("messages");
//
//
//
//
//        // Data to be processed
//        Timestamp endingAt = null;
//
//
//        // Data preprocessing
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(endingAt_);
//            endingAt = new java.sql.Timestamp(date.getTime());
//
//        }catch (Exception e){
//            ok = false;
//            messages.clear();
//            messages.add("Something went wrong at get data!");
//            e.printStackTrace();
//        }
//        Timestamp startingAt = null;
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(startingAt_);
//            startingAt = new java.sql.Timestamp(date.getTime());
//
//        }catch (Exception e){
//            ok = false;
//            messages.clear();
//            messages.add("Something went wrong at get data!");
//            e.printStackTrace();
//        }
//
//        // Logic
////        if(chatDao.getCount("WHERE chatname=vicky") >= 1){
////            ok=false;
////            messages.add("chatname is already found!");
////        }
//
//        // Transactions
//        if(ok){
//
//            ok = chat.setOrganizationId(organizationId);
//            System.out.println(chat.getOrganizationId());
//            ok = chat.setSupportTeamId(supportTeamId);
//            System.out.println(chat.getSupportTeamId());
//            //   ok = chat.setProjectId(projectId);
//            ok = chat.setHeaderId(headerId);
//            System.out.println(chat.getHeaderId());
//
//
//            //    ok = chat.setFinancialStatus(financialStatus);
//            //  ok = chat.setStatus(status);
//            ok = chat.setEndingAt(endingAt);
//            System.out.println(chat.getEndingAt());
//            ok = chat.setStartingAt(startingAt);
//            System.out.println(chat.getStartingAt());
//            ok = chat.setPrizeMoney(prizeMoney);
//            System.out.println(chat.getPrizeMoney());
//            //ok = chat.setCategory(category);
//            ok = chat.setChatName(chatName);
//            System.out.println(chat.getChatName());
//            ok = chat.setRules(rules);
//            System.out.println(chat.getRules());
//            ok = chat.setCType(cType);
//            System.out.println(chat.getCType());
//            ok = chat.setPType(pType);
//            System.out.println(chat.getPType());
//            ok = chat.setOverView(overView);
//            System.out.println(chat.getOverView());
//            ok = chat.setStatus(status);
//            System.out.println(chat.getStatus());
//
//            if(!ok){
//
//                messages.clear();
//                messages.add("Something went wrong at get data!");
//                System.out.println("There is a issue with setting attributes!");
//
//            }
//
//            // Pass model to DAO
//            if(!chatDao.create(chat)){
//                ok=false;
//                messages.clear();
//                messages.add("Something went wrong!");
//                System.out.println("There is a issue with dao!");
//
//            }
//        }
//
//        // JSON response
//        json.put("ok", ok);
//        json.put("messages", messages);
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print(json);
//        out.flush();
//
//    }

    }
}