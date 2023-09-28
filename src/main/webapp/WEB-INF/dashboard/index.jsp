<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/modal.css">

</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<main id="main">

    <button class="show-modal">Log       In</button>

    <!-- the modal itself -->
    <div class="modal hidden">

        <!-- button to close the modal -->
        <button class="close-modal">&times;</button>

        <h3>Do you want to delete the project?</h3>
        <form action="">
            <p style="text-align: left;margin-top: 20px;">Type the project name to delete...</p>
            <input type="email" id="" placeholder="restored-cars">
            <button type="submit">Delete project</button>
        </form>
    </div>
    <div class="overlay hidden"></div>

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

        <div class="overviewcard" style="background-color:white;color: ${card5_color}">
            <div><i class="far ${card5_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card5_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card5_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card6_color}">
            <div><i class="far ${card6_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card6_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card6_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card7_color}">
            <div><i class="far ${card7_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${car7_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card7_count}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: ${card8_color}">
            <div><i class="far ${card8_icon} fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>${card8_label}</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${card8_count}</div>
            </div>
        </div>

    </div>
    <!-- end of 4 data cards -->


    <!-- the charts start -->
    <div class="main-cards">
        <div class="card">
            <canvas  id="chart1" ></canvas>
        </div>
        <div class="card">
            <canvas  id="chart2" ></canvas>
        </div>
    </div>
    <!-- the charts end -->

<%--    <div class="main-tables">--%>
<%--        <table id="example" class="table" cellspacing="0" width="100%">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <th>ID</th>--%>
<%--                <th>Project Name</th>--%>
<%--                <th>Creator</th>--%>
<%--                <th>Date Created</th>--%>
<%--                <th>Amount</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>

<%--            <tfoot>--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <th>ID</th>--%>
<%--                <th>Project Name</th>--%>
<%--                <th>Creator</th>--%>
<%--                <th>Date Created</th>--%>
<%--                <th>Amount</th>--%>
<%--            </tr>--%>
<%--            </tfoot>--%>

<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Tiger Nixon</td>--%>
<%--                <td>000102</td>--%>
<%--                <td>Mirror One | Your life at a glance</td>--%>
<%--                <td>Emily Wilson</td>--%>
<%--                <td>2021/04/25</td>--%>
<%--                <td>$400,00</td>--%>
<%--            </tr>--%>

<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>


</main>


<!-- javascript -->
<script>
<%--    $(document).ready(function() {--%>

<%--        const modal = document.querySelector(".modal"); //selects the modal--%>
<%--        const btnCloseModal = document.querySelector(".close-modal"); //selects the button to close the modal--%>
<%--        const btnOpenModal = document.querySelector(".show-modal"); //selects the button to show the modal--%>
<%--        const overlay = document.querySelector(".overlay"); //selects the overlay--%>

<%--        const toggleModal = function () {--%>
<%--            modal.classList.toggle("hidden");--%>
<%--            overlay.classList.toggle("hidden");--%>
<%--        };--%>

<%--        btnOpenModal.addEventListener("click", toggleModal);--%>

<%--        btnCloseModal.addEventListener("click", toggleModal);--%>

<%--        overlay.addEventListener("click", toggleModal);--%>

<%--        var table = $('#example').DataTable({--%>
<%--            select: false,--%>
<%--            "columnDefs": [{--%>
<%--                className: "Name",--%>
<%--                "targets":[0],--%>
<%--                "visible": false,--%>
<%--                "searchable":false--%>
<%--            }]--%>
<%--        });//End of create main table--%>


<%--        $('#example tbody').on( 'click', 'tr', function () {--%>

<%--            alert(table.row( this ).data()[0]);--%>

<%--        } );--%>
<%--    });--%>

    const labels =${graph_labels}

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/chart.js"></script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>
