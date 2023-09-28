package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import com.inventine.util.SHA256;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrganizationApplyServlet", value = "/apply")
public class OrganizationApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");


        request.setAttribute("host_url", System.getenv("HOST_URL"));

        String topic = "Organization Apply-page";
        request.setAttribute("title", topic);
        // request.setAttribute("title","Organization");
        request.getRequestDispatcher("/WEB-INF/organizationapply.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Organization organization = new Organization();
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();

        Creds creds = new Creds();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        // Parse request data

        String supportTeamId = "11";
        String logoId = "1640618179717";
        String headerId = "1640618091700";

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");
        char orgtype = request.getParameter("orgtype").charAt(0);

        String username = request.getParameter("username");
        String email= request.getParameter("email");
        String password_ = request.getParameter("password");
        char role ='O';

        char status = 'U';

        String password = null;

        // Data preprocessing
        try {

            SHA256 hasher = new SHA256();
            password = hasher.getHexString(password_);

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        String condition = "";

        // Username availability check
        condition = String.format("WHERE name=%s",username);
        if(credsDao.getCount(condition) == 1){
            ok=false;
            messages.add("Username is already found!");
        }

        // Transactions
        if(ok){

           // ok = organization.setCreatorId(creatorId);

            ok = organization.setSupportTeamId(supportTeamId);
            System.out.println(organization.getSupportTeamId());
            ok = organization.setHeaderId(headerId);
            System.out.println(organization.getHeaderId());
            ok = organization.setLogoId(logoId);
            System.out.println(organization.getLogoId());
            ok = organization.setName(name);
            System.out.println(organization.getName());
            ok = organization.setAddress(address);
            System.out.println(organization.getAddress());
            ok = organization.setDistrict(district);
            System.out.println(organization.getDistrict());
            ok = organization.setContactNumber(contactnumber);
            System.out.println(organization.getContactNumber());
            ok = organization.setOrgType(orgtype);
            System.out.println(organization.getOrgType());
            ok = creds.setStatus(status);
            System.out.println(creds.getStatus());


            ok = creds.setRole(role);
            System.out.println(creds.getRole());
            ok = creds.setUsername(username);
            System.out.println(creds.getUsername());
            ok = creds.setEmail(email);
            System.out.println(creds.getEmail());
            ok = creds.setPassword(password);
            System.out.println(creds.getPassword());



            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }
            int userid = credsDao.create(creds);
            System.out.println(userid);
            ok=organization.setOrganizationId(String.valueOf(userid));
            System.out.println(organization.getOrganizationId());
            ok=organizationDao.create(organization);
//            creds.setUserId(Integer.toString(organizationid));
            System.out.println(ok);

            // Pass model to DAO
            if(userid==0 && !ok ){
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
