//package com.inventine.controller.dashboard.financeAdmin;
//
//import com.inventine.dao.ForumTopicDaoImplementation;
//import com.inventine.dao.PostDaoImplementation;
//import com.inventine.dao.RefundDaoImplementation;
//import com.inventine.model.ForumTopic;
//import com.inventine.model.Post;
//import com.inventine.model.Refund;
//import com.inventine.util.DotEnv;
//import org.json.simple.JSONObject;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "FinanceAdminCreateServlet", value = "/dashboard/financeAdmin/create")
//public class FinanceAdminCreateServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//
//        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
//        request.setAttribute("title","FinanceAdmin");
//        request.getRequestDispatcher("/WEB-INF/dashboard/financeAdmin/create.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // JSON parameters
//        JSONObject json = new JSONObject();
//        List<String> messages = new ArrayList<>();
//        boolean ok = true;
//
//        // Models and DAOs
//        Refund refund = new Refund();
//        RefundDaoImplementation refundDao = new RefundDaoImplementation();
//
//        Post post = new Post();
//        PostDaoImplementation postDao = new PostDaoImplementation();
//
//        System.out.println("pass 1");
//
//        // Parse request data
//        String userId = "1";
//        String description = request.getParameter("description");
//
//        String postId ;
//        String title = request.getParameter("title");
//
//        System.out.println("pass 2");
//
//        // Logic
////        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
////            ok=false;
////            messages.add("projectname is already found!");
////        }
//
//        // Transactions
//
//        if(ok){
//
//            ok = post.setUserId(userId);
//            System.out.println(ok);
//            ok = post.setDescription(description);
//            System.out.println(ok);
//            postId = String.valueOf(postDao.create(post));
//            ok = forumTopic.setPostId(postId);
//            System.out.println(ok);
//            ok = forumTopic.setTitle(title);
//            System.out.println(ok);
//
//            System.out.println(postId);
//
//            if(!ok || (postId.equals("-1"))){
//
//                messages.clear();
//                messages.add("Something went wrong at get data!");
//                System.out.println("There is a issue with setting attributes!");
//
//            }
//
//            // Pass model to DAO
//
//            if(!forumTopicDao.create(forumTopic)){
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
//    }
//    }
//}