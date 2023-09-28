package com.inventine.controller.dashboard.organization;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
import com.inventine.model.Organization;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrganizationServlet", value = "/dashboard/organization")
public class OrganizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();



        String get_condition = "";
//        String totalq= null;
        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            get_condition = "";
        }

        if (role == 'C'){
            get_condition = String.format("organizationid=%s", session.getAttribute("userid"));
        }




        List<Organization> organizations = organizationDao.getOrganizations(get_condition);
        List<Creds> creds = credsDao.getManyCreds(get_condition);

        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        int i = 0;

        for (Organization organization : organizations) {

            System.out.println(creds.get(i).getUserId());
            if (Character.compare(creds.get(i).getStatus(), 'D') == 0) {
                card4_count += 1;}
                if (Character.compare(organization.getOrgType(), 'S') == 0) {
                    card2_count += 1;}
                    if (Character.compare(organization.getOrgType(), 'U') == 0) {
                        card3_count += 1;}
                        if (Character.compare(organization.getOrgType(), 'P') == 0) {
                            card1_count += 1;
                        }

                            i++;
                    }

                    card4_count = card1_count + card2_count + card3_count;

                    // Add card labels
                    request.setAttribute("card1_label", "P.Organizations");
                    request.setAttribute("card2_label", "Schools");
                    request.setAttribute("card3_label", "Universities");
                    request.setAttribute("card4_label", "Total");

                    // Add card values
                    request.setAttribute("card1_count", card1_count);
                    request.setAttribute("card2_count", card2_count);
                    request.setAttribute("card3_count", card3_count);
                    request.setAttribute("card4_count", card4_count);

                    // Add card colors
                    request.setAttribute("card1_color", "#03D815");
                    request.setAttribute("card2_color", "#FFC400");
                    request.setAttribute("card3_color", "#0097E6");
                    request.setAttribute("card4_color", "#FF0000");

                    // Add card icons
                    request.setAttribute("card1_icon", "far fa-building");
                    request.setAttribute("card2_icon", "far fa-building");
                    request.setAttribute("card3_icon", "far fa-building");
                    request.setAttribute("card4_icon", "far fa-building");


                    request.setAttribute("organizations", organizations);

                    request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
                    request.setAttribute("title", "Organization");
                    response.setContentType("text/html");
                    request.getRequestDispatcher("/WEB-INF/dashboard/organization/index.jsp").forward(request, response);
                }

                @Override
                protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {


                }



        }