package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.User;
import com.inventine.util.DataValidator;
import com.inventine.util.DotEnv;
import com.inventine.util.SHA256;
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

@WebServlet(name = "LoginServlet", value = "/login")
public class
LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Home");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        DataValidator validator = new DataValidator();
        Creds creds = new Creds();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        // Parse request data
        String username = request.getParameter("username");
        String password_ = request.getParameter("password");

        // Data to be processed
        String password = null;

        // Data preprocessing
        try {

            SHA256 hasher = new SHA256();
            password = hasher.getHexString(password_);

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong, Try again!");
            e.printStackTrace();
        }

        //////////////////////   Logic    //////////////////////////

        String condition = "userid=-1";

        // Login

        validator.setTxt(username);
        System.out.println(validator.isAlphaNumeric());
        if(ok && validator.isEmail()){
            condition = String.format("WHERE email=%s AND password=%s",username,password);
        } else if (ok && validator.isAlphaNumeric()){
            condition = String.format("username='%s' AND password='%s'",username,password);
        } else{
            ok = false;
        }

        ////////////////////////////////////////////////////////////

        // Transactions
        if(ok){

            if(credsDao.getCount(condition) == 1){

            } else{
                ok=false;
                messages.add("Given credentials are not found!");
            }

            // Get model from DAO
            if(ok){

                try {

                    creds = credsDao.getManyCreds(condition).get(0);


                    //Login
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", creds.getUserId());
                    session.setAttribute("username", creds.getUsername());
                    session.setAttribute("role", creds.getRole());
                    session.setAttribute("profileId", creds.getProfileId());


                } catch (Exception e){
                    ok = false;
                    messages.clear();
                    messages.add("Something went wrong, Try again!");
                    e.printStackTrace();
                }


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
