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

    <div class="overviewcard" style="background-color:white;color: rgb(182, 0, 182);">
      <div><i class="fas fa-money-check-alt fa-2x"></i></i></div>
      <div class="overviewcard__icon">
        <div>Investors</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">569</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(255, 115, 0);">
      <div><i class="fas fa-chalkboard-teacher fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>Creators</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">236</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(3, 216, 21);">
      <div><i class="far fa-lightbulb fa-2x"></i></div>
      <div class="overviewcard__icon" >
        <div>Projects</div>
        <div class="overviewcard__info"style="font-size: 36px;float: right">999</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(0, 110, 255);">
      <div><i class="fas fa-trophy fa-2x"></i></i></div>
      <div class="overviewcard__icon">
        <div>Competitions</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">123</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(0, 182, 112);">
      <div><i class="fas fa-sitemap fa-2x"></i></i></i></div>
      <div class="overviewcard__icon">
        <div>Private.Orgs</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">569</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(255, 196, 0);">
      <div><i class="fas fa-school fa-2x"></i></i></div>
      <div class="overviewcard__icon">
        <div>Schools</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">236</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(64, 44, 179);">
      <div><i class="fas fa-university fa-2x"></i></div>
      <div class="overviewcard__icon" >
        <div>Universities</div>
        <div class="overviewcard__info"style="font-size: 36px;float: right">999</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(255, 0, 76);">
      <div><i class="fas fa-users fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>Org.Members</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">123</div>
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

  <div class="main-tables">
    <table id="example" class="table" cellspacing="0" width="100%">
      <thead>
      <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Project Name</th>
        <th>Creator</th>
        <th>Date Created</th>
        <th>Amount</th>
      </tr>
      </thead>

      <tfoot>
      <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Project Name</th>
        <th>Creator</th>
        <th>Date Created</th>
        <th>Amount</th>
      </tr>
      </tfoot>

      <tbody>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>
      <tr>
        <td>Tiger Nixon</td>
        <td>000102</td>
        <td>Mirror One | Your life at a glance</td>
        <td>Emily Wilson</td>
        <td>2021/04/25</td>
        <td>$400,00</td>
      </tr>

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


      $('#example tbody').on( 'click', 'tr', function () {

        alert(table.row( this ).data()[0]);

      } );
    });
  </script>
  <script src="static/js/dashboard/chart.js"></script>
  <script src="static/js/dashboard/dashboard.js"></script>
</body>
</html>
