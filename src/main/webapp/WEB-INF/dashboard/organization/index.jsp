<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.inventine.model.Competition" %>
<%@ page import="com.inventine.model.Organization" %>
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
        <a href="http://localhost:8080/inventine_war/dashboard/organization/create">
            <button class="createbutton">Create </button></a>
    </div>
    <% if (session.getAttribute("role").toString().charAt(0) == 'C'
             ) {
    %>

    <div class="main-tables">


        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Organization ID</th>
                <th>Organization Name</th>
                <th> Organization Address</th>
                <th>Organization District</th>
                <%--                <th></th>--%>
                <%--                <th>A</th>--%>
                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Organization ID</th>
                <th>Organization Name</th>
                <th> Organization Address</th>
                <th>Organization District</th>
                <%--                <th></th>--%>
                <%--                <th>A</th>--%>
                <th>Actions</th>

            </tr>
            </tfoot>

            <tbody>
            <%
                for (Organization organization: (ArrayList<Organization>)request.getAttribute("organizations")){
            %>
            <tr>
                <th><% out.print(organization.getOrganizationId());%></th>
                <td><% out.print(organization.getName());%></td>
                <td><% out.print(organization.getAddress());%></td>
                <td><% out.print(organization.getDistrict());%></td>

                <td><button class="viewbutton" id="idViewButtonp" onclick="window.location.href='${System.getenv("HOST_URL")}/organization-profile/<% out.print(organization.getOrganizationId());%>'">View</button>
                    <button class="updatebutton" id="idUpdateButton" onclick="window.location.href='${System.getenv("HOST_URL")}/dashboard/organization/update/<% out.print(organization.getOrganizationId());%>'">Update</button>
                    <button class="deletebutton" id="idDeleteButton" onclick="deleteIt()">Delete</button>

                </td>
            </tr>
            <%}%>


            </tbody>
        </table>
    </div>
    <%} else{%>

    <div class="main-tables">
    <table id="example1" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Organization ID</th>
                <th>Support team ID</th>
                <th>Organization Name</th>
                <th>Organization Address</th>
                <th>Organization District</th>
                <th>Organization Contact_Number</th>
                <th>Organization CreatedAt</th>

                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Organization ID</th>
                <th>Support team ID</th>
                <th>Organization Name</th>
                <th>Organization Address</th>
                <th>Organization District</th>
                <th>Organization Contact_Number</th>
                <th>Organization CreatedAt</th>

            </tr>
            </tfoot>

            <tbody>
            <%
                for (Organization organization: (ArrayList<Organization>)request.getAttribute("organizations")){
            %>
            <tr>
                <td><% out.print(organization.getOrganizationId());%></td>
                <td><% out.print(organization.getSupportTeamId());%></td>
                <td><% out.print(organization.getName());%></td>
                <td><% out.print(organization.getAddress());%></td>
                <td><% out.print(organization.getDistrict());%></td>
                <td><% out.print(organization.getContactNumber());%></td>
                <td><% out.print(organization.getCreatedAt());%></td>


                <td><button class="viewbutton" id="idViewButtonp" onclick="window.location.href='${System.getenv("HOST_URL")}/organization-profile/'">View</button>

                    <button class="updatebutton" id="idUpdateButton" onclick="window.location.href='${System.getenv("HOST_URL")}/dashboard/organization/update/<% out.print(organization.getOrganizationId());%>'">Update</button>
                    <% if (session.getAttribute("role").toString().charAt(0) == 'A' ) {

                    %>
                    <button class="deletebutton" id="idDeleteButton" onclick="

                    idDeleteButton_onclick();">Delete</button>
                    <%}%>


                </td>
            </tr>
            <%}%>


            </tbody>
        </table>
    </div>


    <%}%>






</main>


<!-- javascipt -->
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


        // $('#example1 tbody').on( 'click', 'tr', function () {
        //
        //     alert(table.row( this ).data()[0]);
        //
        // } );
    });


    function deleteIt(){

        Swal.fire({
            title: 'Delete confirmation',
            input: 'text',
            inputLabel: 'Enter the Organization Name in the given box',
            inputPlaceholder: 'Organization-Name',
            iconColor: "#900",
            confirmButtonColor: "#900",
            showCancelButton: true,
        })

    }
</script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>
