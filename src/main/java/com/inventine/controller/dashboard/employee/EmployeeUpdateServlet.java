package com.inventine.controller.dashboard.employee;

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
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeUpdateServlet", value = "/dashboard/employee/update/*")
public class EmployeeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A');
        }

        response.setContentType("text/html");

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();
        String employeeId = uri.substring(uri.lastIndexOf('/') + 1);

        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        User user = userDao.getUser(employeeId);
        Creds creds = credsDao.getCreds(employeeId);

        request.setAttribute("employee",user);
        request.setAttribute("creds",creds);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Employee");
        request.getRequestDispatcher("/WEB-INF/dashboard/employee/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("img_id"));

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
        char type = request.getParameter("role").charAt(0);;

        String username = request.getParameter("username");
        String email= request.getParameter("email");
        char role = request.getParameter("role").charAt(0);
        char status = request.getParameter("status").charAt(0);



        // Data to be processed
        Timestamp dob = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dob_);
            dob = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        //////////////////////   Logic    //////////////////////////

        String condition = "";

        // Username availability check
        condition = String.format("WHERE username=%s",username);
        if(credsDao.getCount(condition) == 1){
            ok=false;
            messages.add("Username is already found!");
        }

        //////////////////////////////////////////////////////////

        //Transactions
        if(ok){

            ok = user.setFirstName(first_name);
            ok = user.setLastName(last_name);
            ok = user.setDob(dob);
            ok = user.setGender(gender);
            ok = user.setPhone(phone);
            ok = user.setAddress(address);
            ok = user.setDistrict(district);
            ok = user.setType(type);

            ok = creds.setEmail(username);
            ok = creds.setEmail(email);
            ok = creds.setRole(role);
            ok = creds.setStatus(status);

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            ok = userDao.update(user);

            // Pass model to DAO
            if(ok && !credsDao.update(creds)){
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
