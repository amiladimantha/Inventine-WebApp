package com.inventine.controller.dashboard.organization;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
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

@WebServlet(name = "OrganizationCreateServlet", value = "/dashboard/organization/create")
public class OrganizationCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }
        response.setContentType("text/html");


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic = "Organization Create-page";
        request.setAttribute("title", topic);
        // request.setAttribute("title","Organization");
        request.getRequestDispatcher("/WEB-INF/dashboard/organization/create.jsp").forward(request, response);


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

        // Parse request data

        HttpSession session = request.getSession();

     //   String creatorId = session.getAttribute("userId").toString();
        String supportTeamId = "11";
        String logoId = "1640618179717";
        String headerId = "1640618091700";

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");
        char orgtype = request.getParameter("orgtype").charAt(0);




        // Transactions
        if(ok){


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




            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO
            if(organizationDao.create(organization)){
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
