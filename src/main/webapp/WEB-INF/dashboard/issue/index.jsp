<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="com.inventine.model.Issues" %>
<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Creds" %>
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

    <!-- the modal itself -->
    <div style="display: none" class="modal hidden">

        <!-- button to close the modal -->
        <button  class="close-modal">&times;</button>

        <h3 >Do you want to delete the project?</h3>
        <form action="">
            <p style="text-align: left;margin-top: 20px;">Type the project name to delete...</p>
            <input type="email" id="" placeholder="restored-cars">
            <button type="submit">Delete project</button>
        </form>
    </div>
    <div style="display: none" class="overlay hidden"></div>

    <!-- the 4 cards containing data at top -->
    <div class="main-overview">

        <div class="overviewcard" style="background-color:white;color: ${card1_color}">
            <div><i class="far ${card1_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card1_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card1_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card2_color}">
            <div><i class="far ${card2_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card2_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card2_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card3_color}">
            <div><i class="far ${card3_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card3_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card3_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card4_color}">
            <div><i class="far ${card4_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card4_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card4_count}</div>
            </div>
        </div>

    </div>
    <!-- end of 4 data cards -->


    <div class="cbutton">
        <button class="createbutton">Create Issue</button>
    </div>

    <% if (session.getAttribute("role").toString().charAt(0) == 'S'   || session.getAttribute("role").toString().charAt(0) == 'A' ) {

    %>
    <div class="main-tables">
        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>

                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>

                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </tfoot>

            <tbody>
            <%
                List<Issues> issues = (ArrayList<Issues>)request.getAttribute("issues");
                List<User> users = (ArrayList<User>)request.getAttribute("users");
                List<Creds> creds = (ArrayList<Creds>)request.getAttribute("creds");
                Hashtable<Character, String> role_values = new Hashtable<Character, String>();

                role_values.put('A',"Admin");
                role_values.put('F',"Finance Admin");
                role_values.put('S',"Support Team");
                role_values.put('C',"Creator");
                role_values.put('I',"Investor");

                Hashtable<Character, String> status_values = new Hashtable<Character, String>();

                status_values.put('A',"Active");
                status_values.put('B',"Blocked");
                status_values.put('R',"Rejected");
                status_values.put('S',"Solved");


                for (int i=0; i<issues.size();i++){
            %>
            <tr>

                <td><% out.print(issues.get(i).getIssueId());%></td>
                <td><% out.print(users.get(i).getFirstName());%> <% out.print(users.get(i).getLastName());%></td>
                <td><% out.print(creds.get(i).getEmail());%></td>
                <td><% out.print(issues.get(i).getDescription());%></td>
                <td>
                    <button class="deletebutton" id="idDeleteButton" onclick="idDeleteButton_onclick();">Delete</button>

                </td>
            </tr>
            <%}%>



            </tbody>
        </table>
    </div>






</main>


<!-- javascript -->
<script>
    $(document).ready(function() {

        const modal = document.querySelector(".modal"); //selects the modal
        const btnCloseModal = document.querySelector(".close-modal"); //selects the button to close the modal
        const btnOpenModal = document.querySelector(".show-modal"); //selects the button to show the modal
        const overlay = document.querySelector(".overlay"); //selects the overlay

        const toggleModal = function () {
            modal.classList.toggle("hidden");
            overlay.classList.toggle("hidden");
        };

        btnOpenModal.addEventListener("click", toggleModal);

        btnCloseModal.addEventListener("click", toggleModal);

        overlay.addEventListener("click", toggleModal);

        var table = $('#example').DataTable({
            select: false,
        });//End of create main table


        $('#example tbody').on( 'click', 'tr', function () {

            alert(table.row( this ).data()[0]);

        } );

        var table = $('#example1').DataTable({
            select: false,

        });//End of create main table


        $('#example1 tbody').on( 'click', 'tr', function () {

            alert(table.row( this ).data()[0]);

        } );
    });



</script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>

