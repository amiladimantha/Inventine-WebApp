package com.inventine.controller.forum;

import com.inventine.dao.*;
import com.inventine.model.*;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ForumServlet", value = "/forum")
public class ForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
//        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(id);
        String type = request.getParameter("type");
        String conditiontype= null;
        String conditiontype2= "";

        switch(type){
            case "0":
                conditiontype = "forumtopicid";
                break;
            case "1":
                conditiontype = "views";
                break;
            case "2":
                conditiontype = "views";
                break;
            case "3":
                conditiontype = "views";
                break;
        }

        PostDaoImplementation postDao = new PostDaoImplementation();
        ForumTopicDaoImplementation forumTopicDao = new ForumTopicDaoImplementation();
        ForumReplyDaoImplementation forumReplyDao = new ForumReplyDaoImplementation();
        ForumReply forumreply = new ForumReply();
        UserDaoImplementation userDao = new UserDaoImplementation();
        PostLikeDaoImplementation postLikeDao = new PostLikeDaoImplementation();
        CredsDaoImplementation credDao = new CredsDaoImplementation();

        Integer forumReplyCount;

        String condition;
        String forumReplyId;



        List<ForumTopic> forumTopics = forumTopicDao.getForumTopics(conditiontype,conditiontype2);
        for (final ForumTopic forumTopic : forumTopics) {
            condition = String.format("%s", forumTopic.getPostId());
            Post post = postDao.getPost(condition);
            condition = String.format("%s", post.getUserId());
            User user = userDao.getUser(condition);

            forumTopic.setReplyAmount(forumReplyDao.getCount("forumtopicid=" + forumTopic.getForumTopicId()));
            forumTopic.setLikeAmount(postLikeDao.getCount(post.getPostId()));
            forumTopic.setDescription(post.getDescription());
            forumTopic.setCreatedAt(post.getCreatedAt());
            forumTopic.setFirstName(user.getFirstName());
            forumTopic.setLastName(user.getLastName());
            forumTopic.setPostId(post.getPostId());
            forumTopic.setViews(Integer.toString(Integer.parseInt(forumTopic.getViews())));
            Creds cred = credDao.getCreds(post.getUserId());
            forumTopic.setImage(cred.getProfileId());



//            forumreply = forumReplyDao.getForumReplyLatest(forumTopic.getForumTopicId());
//            System.out.println("this servlet");
//            System.out.println(forumreply.getPostId());
//            post = postDao.getPost(forumreply.getPostId());
//            System.out.println(post.getCreatedAt());
//            forumTopic.setLatest_reply(post.getCreatedAt());
        }
        request.setAttribute("forumTopic", forumTopics);
        request.getRequestDispatcher("/WEB-INF/forum/index2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        ForumTopic forumTopic = new ForumTopic();
        ForumTopicDaoImplementation forumTopicDao  = new ForumTopicDaoImplementation();

        Post post = new Post();
        PostDaoImplementation postDao = new PostDaoImplementation();

//        System.out.println("pass 1");
//        // Parse request data
//        String userId = (String) session.getAttribute("userid");
        String userId = (String)request.getSession().getAttribute("userId");
//        String userId = "1";
        String description = request.getParameter("description");

        String postId ;
        String title = request.getParameter("title");

//        System.out.println("pass 2");

        // Logic
//        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
//            ok=false;
//            messages.add("projectname is already found!");
//        }

        // Transactions

        if(ok){

            ok = post.setUserId(userId);
//            System.out.println(ok);
            ok = post.setDescription(description);
//            System.out.println(ok);
            postId = String.valueOf(postDao.create(post));
            System.out.println(postId);
            ok = forumTopic.setPostId(postId);
//            System.out.println(ok);
            ok = forumTopic.setTitle(title);
//            System.out.println(ok);

//            System.out.println(postId);

            if(!ok || (postId.equals("-1"))){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("this servlet");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO

            if(!forumTopicDao.create(forumTopic)){
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