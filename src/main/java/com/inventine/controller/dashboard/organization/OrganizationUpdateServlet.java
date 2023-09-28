package com.inventine.controller.dashboard.organization;

import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrganizationUpdateServlet", value = "/dashboard/organization/update/*")
public class OrganizationUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        response.setContentType("text/html");

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String organizationId =  uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();
        Organization organization = new Organization();
        organization = organizationDao.getOrganization(organizationId);


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("organization",organization);

        request.getRequestDispatcher("/WEB-INF/dashboard/organization/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
//        Competition competition = new Competition();
//        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();

        Organization organization = new Organization();
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();

        // Parse request data

        HttpSession session = request.getSession();

        String organizationId = session.getAttribute("userId").toString();
        String supportTeamId = "11";
        String logoId = "1640618179717";
        String headerId = "1640618091700";


        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");
        char orgtype = request.getParameter("orgtype").charAt(0);
        String organizationid = request.getParameter("organizationid");





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
            ok = organization.setOrganizationId(organizationId);




            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }
            ok = organizationDao.update(organization);
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

