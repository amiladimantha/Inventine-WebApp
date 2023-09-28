<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.inventine.model.Payment" %>
<%@ page import="java.util.Hashtable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<main id="main">

    <button style="display: none" class="show-modal">Log       In</button>

    <%--    <!-- the modal itself -->--%>
    <%--    <div style="display: none" class="modal hidden">--%>

    <%--        <!-- button to close the modal -->--%>
    <%--        <button  class="close-modal">&times;</button>--%>

    <%--        <h3 >Do you want to delete the project?</h3>--%>
    <%--        <form action="">--%>
    <%--            <p style="text-align: left;margin-top: 20px;">Type the project name to delete...</p>--%>
    <%--            <input type="email" id="" placeholder="restored-cars">--%>
    <%--            <button type="submit">Delete project</button>--%>
    <%--        </form>--%>
    <%--    </div>--%>
    <%--    <div style="display: none" class="overlay hidden"></div>--%>

    <!-- the 4 cards containing data at top -->
    <div class="main-overview">


    </div>
    <!-- end of 4 data cards -->


    <% if (session.getAttribute("role").toString().charAt(0) == 'S' ||  session.getAttribute("role").toString().charAt(0) == 'A' ) {

    %>
    <div class="main-tables">

        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>ID</th>
                <th>SID</th>
                <th>Proof ID</th>
                <th>PDF ID</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>ID</th>
                <th>SID</th>
                <th>Proof ID</th>
                <th>PDF ID</th>
                <th>Actions</th>
            </tr>
            </tfoot>

            <tbody>


<%--            <%--%>
<%--                List<Project> projects = (ArrayList<Project>)request.getAttribute("projects");--%>
<%--                List<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");--%>
<%--                Hashtable<Character, String> role_values = new Hashtable<Character, String>();--%>

<%--                role_values.put('A',"Admin");--%>
<%--                role_values.put('F',"Finance Admin");--%>
<%--                role_values.put('S',"Support Team");--%>
<%--                role_values.put('C',"Creator");--%>
<%--                role_values.put('I',"Investor");--%>

<%--                Hashtable<Character, String> status_values = new Hashtable<Character, String>();--%>

<%--                status_values.put('A',"Active");--%>
<%--                status_values.put('B',"Blocked");--%>
<%--                status_values.put('D',"Deleted");--%>
<%--                status_values.put('U',"Undecided");--%>

<%--                Hashtable<Character, String> financialstatus_values = new Hashtable<Character, String>();--%>

<%--                financialstatus_values.put('C',"Complete");--%>
<%--                financialstatus_values.put('I',"Incomplete");--%>


<%--                for (int i=0; i<projects.size();i++){--%>
<%--            %>--%>
<%--            <tr>--%>
<%--                <td><% out.print(projects.get(i).getProjectId());%></td>--%>
<%--                <td><% out.print(projects.get(i).getSupportTeamId());%></td>--%>
<%--                <td><% out.print(projects.get(i).getCreatorId());%></td>--%>
<%--                <td><% out.print(projects.get(i).getProjectName());%></td>--%>
<%--                <td><% out.print(projects.get(i).getRequestedAmount());%></td>--%>
<%--                <td>7</td>--%>
<%--                <td><% out.print(status_values.get(projects.get(i).getStatus()));%></td>--%>
<%--                <td><% out.print(financialstatus_values.get(projects.get(i).getFinancialStatus()));%></td>--%>
<%--                <td><% out.print(projects.get(i).getCategory());%></td>--%>
<%--                <td><% out.print(projects.get(i).getCreatedAt());%></td>--%>
<%--                <td><% out.print(projects.get(i).getDateOfExpiry());%></td>--%>
<%--                <td><button class="viewbutton" id="idViewButtonp" onclick="window.location.href='${System.getenv("HOST_URL")}/project/<% out.print(projects.get(i).getProjectId());%>'">View</button>--%>

<%--                    <% if (session.getAttribute("role").toString().charAt(0) == 'S' || session.getAttribute("role").toString().charAt(0) == 'A' ) {--%>

<%--                    %>--%>
<%--                    <button class="updatebutton" id="idUpdateButton" onclick="window.location.href='${System.getenv("HOST_URL")}/dashboard/project/update/<% out.print(projects.get(i).getProjectId());%>'">Update</button>--%>
<%--                    <%}%>--%>
<%--                    <% if (session.getAttribute("role").toString().charAt(0) == 'A' ) {--%>

<%--                    %>--%>
<%--                    <button class="deletebutton" id="idDeleteButton" onclick="idDeleteButton_onclick();">Delete</button>--%>
<%--                    <%}%>--%>
<%--                    <% if (session.getAttribute("role").toString().charAt(0) == 'A' || session.getAttribute("role").toString().charAt(0) == 'F') {--%>

<%--                    %>--%>
<%--                    <button class="paybutton" id="idPayButton" onclick="">Pay</button>--%>
<%--                    <%}%>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <%}%>--%>


            </tbody>
        </table>
    </div>

    <%} %>


</main>


<!-- javascipt -->

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>
