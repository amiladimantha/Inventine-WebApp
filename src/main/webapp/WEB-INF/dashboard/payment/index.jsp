<%@ page import="com.inventine.model.Payment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.AcceptMeeting" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/form.css">

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
    <% if (session.getAttribute("role").toString().charAt(0) == 'S' ||  session.getAttribute("role").toString().charAt(0) == 'F' || session.getAttribute("role").toString().charAt(0) == 'A' ) {

    %>

    <div class="main-tables">
        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>
                <th>Actions</th>

            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>
                <th>Actions</th>

            </tr>
            </tfoot>

            <tbody>
            <%
                List<Project> projects = (ArrayList<Project>)request.getAttribute("projects");
                List<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");
                Hashtable<Character, String> role_values = new Hashtable<Character, String>();

                role_values.put('A',"Admin");
                role_values.put('F',"Finance Admin");
                role_values.put('S',"Support Team");
                role_values.put('C',"Creator");
                role_values.put('I',"Investor");

                Hashtable<Character, String> status_values = new Hashtable<Character, String>();

                status_values.put('A',"Active");
                status_values.put('B',"Blocked");
                status_values.put('D',"Deleted");

                Hashtable<Character, String> financialstatus_values = new Hashtable<Character, String>();

                financialstatus_values.put('C',"Complete");
                financialstatus_values.put('I',"Incomplete");


                for (int i=0; i< payments.size();i++){
                %>
                  <tr>
                    <td><% out.print(payments.get(i).getPaymentId());%></td>
                    <td><% out.print(payments.get(i).getInvestorId());%></td>
                    <td><% out.print(payments.get(i).getProjectId());%></td>
                    <td><% out.print(projects.get(i).getProjectName());%></td>
                    <td><% out.print(payments.get(i).getAmount());%></td>
                    <td><% out.print(payments.get(i).getCreatedAt());%></td>
                    <td><% if (session.getAttribute("role").toString().charAt(0) == 'F' || session.getAttribute("role").toString().charAt(0) == 'A' ) {

                    %>
                        <button class="updatebutton" id="idUpdateButton" onclick="window.location.href='${System.getenv("HOST_URL")}/dashboard/payment/update/<% out.print(payments.get(i).getPaymentId());%>'">Update</button>
                        <button class="refundbutton" id="idRefundButton" onclick="">Refund</button>
                        <%}%></td>
                  </tr>
                 <%}%>


            </tbody>
        </table>
    </div>

    <%} else if(session.getAttribute("role").toString().charAt(0) == 'C') {%>

    <div class="main-tables">
        <table id="example1" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>


            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>


            </tr>
            </tfoot>

            <tbody>
            <%
                List<Project> projects = (ArrayList<Project>)request.getAttribute("projects");
                List<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");
                Hashtable<Character, String> role_values = new Hashtable<Character, String>();

                role_values.put('A',"Admin");
                role_values.put('F',"Finance Admin");
                role_values.put('S',"Support Team");
                role_values.put('C',"Creator");
                role_values.put('I',"Investor");

                Hashtable<Character, String> status_values = new Hashtable<Character, String>();

                status_values.put('A',"Active");
                status_values.put('B',"Blocked");
                status_values.put('D',"Deleted");

                Hashtable<Character, String> financialstatus_values = new Hashtable<Character, String>();

                financialstatus_values.put('C',"Complete");
                financialstatus_values.put('I',"Incomplete");


                for (int i=0; i< payments.size();i++){
            %>
            <tr>
                <td><% out.print(payments.get(i).getPaymentId());%></td>
                <td><% out.print(payments.get(i).getInvestorId());%></td>
                <td><% out.print(payments.get(i).getProjectId());%></td>
                <td><% out.print(projects.get(i).getProjectName());%></td>
                <td><% out.print(payments.get(i).getAmount());%></td>
                <td><% out.print(payments.get(i).getCreatedAt());%></td>

            </tr>
            <%}%>


            </tbody>
        </table>
    </div>

    <%} else{%>

    <div class="main-tables">
        <table id="example2" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>

            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Payment ID</th>
                <th>Investor ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>

            </tr>
            </tfoot>

            <tbody>
            <%
                List<Project> projects = (ArrayList<Project>)request.getAttribute("projects");
                List<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");
                Hashtable<Character, String> role_values = new Hashtable<Character, String>();

                role_values.put('A',"Admin");
                role_values.put('F',"Finance Admin");
                role_values.put('S',"Support Team");
                role_values.put('C',"Creator");
                role_values.put('I',"Investor");

                Hashtable<Character, String> status_values = new Hashtable<Character, String>();

                status_values.put('A',"Active");
                status_values.put('B',"Blocked");
                status_values.put('D',"Deleted");

                Hashtable<Character, String> financialstatus_values = new Hashtable<Character, String>();

                financialstatus_values.put('C',"Complete");
                financialstatus_values.put('I',"Incomplete");


                for (int i=0; i< payments.size();i++){
            %>
            <tr>
                <td><% out.print(payments.get(i).getPaymentId());%></td>
                <td><% out.print(payments.get(i).getInvestorId());%></td>
                <td><% out.print(payments.get(i).getProjectId());%></td>
                <td><% out.print(projects.get(i).getProjectName());%></td>
                <td><% out.print(payments.get(i).getAmount());%></td>
                <td><% out.print(payments.get(i).getCreatedAt());%></td>

            </tr>
            <%}%>


            </tbody>
        </table>
    </div>

    <%}%>

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

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/chart.js"></script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>

