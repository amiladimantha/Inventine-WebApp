package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.User;
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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private UserDaoImplementation userDao = new UserDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Home");
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        User user = new User();
        UserDaoImplementation userDao = new UserDaoImplementation();
        Creds creds = new Creds();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        // Parse request data

        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");
        String dob_ = request.getParameter("dob");
        char gender = request.getParameter("gender").charAt(0);
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        char type = 'A';

        int userId = 0;
        String username = request.getParameter("username");
        String email= request.getParameter("email");
        String password_ = request.getParameter("password");
        char role = request.getParameter("role").charAt(0);
        char status = 'A';


        // Data to be processed
        Timestamp dob = null;
        String password = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dob_);
            dob = new java.sql.Timestamp(date.getTime());

            SHA256 hasher = new SHA256();
            password = hasher.getHexString(password_);

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        //////////////////////   Logic    //////////////////////////

        String condition = "";

        // Username availability check
        condition = String.format("username='%s'",username);
        if(credsDao.getCount(condition) == 1){
            ok=false;
            messages.add("Username is already found!");
        }

        // Email availability check
        condition = String.format("email='%s'",email);
        if(credsDao.getCount(condition) == 1){
            ok=false;
            messages.add("Email is already found!");
        }

        ////////////////////////////////////////////////////////////

        // Transactions
        if(ok){

            ok = user.setFirstName(first_name);
            ok = user.setLastName(last_name);
            ok = user.setDob(dob);
            ok = user.setGender(gender);
            ok = user.setPhone(phone);
            ok = user.setAddress(address);
            ok = user.setDistrict(district);
            ok = user.setType(type);

            ok = creds.setUsername(username);
            ok = creds.setEmail(email);
            ok = creds.setPassword(password);
            ok = creds.setRole(role);
            ok = creds.setStatus(status);

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            } else{

                userId = credsDao.create(creds);
                System.out.println(userId);
                ok = user.setUserId(String.valueOf(userId));
                System.out.println(ok);
                System.out.println(Integer.toString(userId));
                System.out.println(user.getUserId());;
                ok = userDao.create(user);

                System.out.println(ok);

                // Pass model to DAO
                if(!ok){
                    ok=false;
                    messages.clear();
                    messages.add("Something went wrong!");
                    System.out.println("There is a issue with dao!");

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