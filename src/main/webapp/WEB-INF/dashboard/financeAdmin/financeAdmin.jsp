<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Payment" %>
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

        <div class="overviewcard" style="background-color:white;color: rgb(3, 216, 21);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>payments</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${payment}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(255, 196, 0);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon" >
                <div>payouts</div>
                <div class="overviewcard__info"style="font-size: 36px;float: right">${payouts}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(255, 0, 76);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>refunds</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">${refunds}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(0, 110, 255);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Investors</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">${Investors}</div>
            </div>
        </div>



    </div>
    <!-- end of 4 data cards -->

    <div class="cbutton">
        <a href="http://localhost:8080/inventine_war/dashboard/financeAdmin/create">
            <button class="createbutton">Payout </button></a>
    </div>

    <div class="main-tables">
        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Project ID</th>
                <th>Investor ID</th>
                <th>Financial Details Id</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Payment ID</th>
                <th>Project ID</th>
                <th>Investor ID</th>
                <th>Financial Details Id</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
            </tfoot>

            <tbody>
            <%
                for (Payment payment: (ArrayList<Payment>)request.getAttribute("payments")){
            %>
            <tr>
                <th><% out.print(payment.getPaymentId());%></th>
                <td><% out.print(payment.getProjectId());%></td>
                <td><% out.print(payment.getInvestorId());%></td>
                <td><% out.print(payment.getFinancialDetailsId());%></td>
                <td><% out.print(payment.getAmount());%></td>
                <td>
                    <button class="updatebutton" id="idUpdateButton" onclick="refundIt()">Refund</button>
                </td>
            </tr>
            <%}%>


            </tbody>
        </table>
    </div>






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
            "columnDefs": [{
                className: "Name",
                "targets":[0],
                "visible": false,
                "searchable":false
            }]
        });//End of create main table


        // $('#example tbody').on( 'click', 'tr', function () {
        //
        //     alert(table.row( this ).data()[0]);
        //
        // } );



    });
    function refundIt() {

        Swal.fire({
            title: 'Refund confirmation',
            input: 'text',
            inputLabel: 'Enter the Transaction receipt id in the given box',
            inputPlaceholder: 'Transaction Id',
            iconColor: "#900",
            confirmButtonColor: "#900",
            showCancelButton: true,
        })
    }

</script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>