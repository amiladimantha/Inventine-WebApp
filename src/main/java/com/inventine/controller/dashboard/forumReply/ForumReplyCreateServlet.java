package com.inventine.controller.dashboard.forumReply;

import com.inventine.dao.*;
import com.inventine.model.ForumReply;
import com.inventine.model.ForumTopic;
import com.inventine.model.Post;
import com.inventine.model.User;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ForumReplyCreateServlet", value = "/forum/forumreply")
public class ForumReplyCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        String forumTopicId = request.getParameter("id");
//        System.out.println(forumTopicId);
////        String cd = request.getParameter("sc");
//        System.out.println("that servlet");
//
//        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
////        int id = Integer.parseInt(request.getParameter("id"));
////        System.out.println(id);
//
//        PostDaoImplementation postDao = new PostDaoImplementation();
//        ForumReplyDaoImplementation forumReplyDao = new ForumReplyDaoImplementation();
//        ForumTopicDaoImplementation forumTopicDao = new ForumTopicDaoImplementation();
//        UserDaoImplementation userDao = new UserDaoImplementation();
//        PostLikeDaoImplementation postLikeDao = new PostLikeDaoImplementation();
//
//
//        String condition;
//        String forumReplyId;
//        condition = null;
//
//
//
//
//
//
//        List<ForumReply> forumReplys = forumReplyDao.getForumReplys(forumTopicId);
//        for (final ForumReply forumReply : forumReplys) {
//            condition = String.format("%s", forumReply.getPostId());
//            Post post;
//            post = postDao.getPost(condition);
//            condition = String.format("%s", post.getUserId());
//            User user = userDao.getUser(condition);
//            forumReply.setAmount(postLikeDao.getCount(post.getPostId()));
//            forumReply.setDescription(post.getDescription());
//            forumReply.setCreatedAt(post.getCreatedAt());
//            forumReply.setFirstName(user.getFirstName());
//            forumReply.setLastName(user.getLastName());
//        }
//        ForumTopic forumTopic = forumTopicDao.getForumTopic(forumTopicId);
//
//        condition = String.format("%s", forumTopic.getPostId());
//        Post post = postDao.getPost(condition);
//        condition = String.format("%s", post.getUserId());
//        User user = userDao.getUser(condition);
//        forumTopic.setLikeAmount(postLikeDao.getCount(post.getPostId()));
//        forumTopic.setDescription(post.getDescription());
//        forumTopic.setCreatedAt(post.getCreatedAt());
//        forumTopic.setFirstName(user.getFirstName());
//        forumTopic.setLastName(user.getLastName());
//        forumTopic.setPostId(post.getPostId());
//        forumTopic.setReplyAmount(forumReplyDao.getCount("forumtopicid=" + forumTopic.getForumTopicId()));
//
//        request.setAttribute("forumTopic", forumTopic);
//        request.setAttribute("forumReply", forumReplys);
//        request.getRequestDispatcher("/WEB-INF/forum/postView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        ForumReply forumReply = new ForumReply();
        ForumReplyDaoImplementation forumReplyDao = new ForumReplyDaoImplementation();


        Post post = new Post();
        PostDaoImplementation postDao = new PostDaoImplementation();


        // Parse request data
        String userId = (String)request.getSession().getAttribute("userId");
        String postId;
        String forumTopicId = request.getParameter("forumTopicID");
        String description = request.getParameter("description-reply");


        // Logic
//        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
//            ok=false;
//            messages.add("projectname is already found!");
//        }

        // Transactions

        if(ok){

            ok = post.setUserId(userId);
            ok = post.setDescription(description);
            postId = String.valueOf(postDao.create(post));
            ok = forumReply.setPostId(postId);
            ok = forumReply.setForumTopicId(forumTopicId);


            if(!ok || (postId.equals("-1"))){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO

            if(!forumReplyDao.create(forumReply)){
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