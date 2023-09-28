<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <%@ include file="/WEB-INF/components/head-import.jsp" %>
  <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/aboutus.css">


</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="content">
  <!-- description and image start -->
  <div class="container">
    <div class="column-1">
      <h1>ABOUT US!</h1>
      <span class="paragraph">We are inventine, who makes tour Ideas get funded and mentoring to enhance the business process.<br><br> Our team consists of 4 main members who are all 2nd year students of Univesity of Colombo School of Computing.<br><br></span>

    </div>
    <div class="column-2">
      <img src="static/img/abus.jpg" style="width: 500px;height: 250px;">
    </div>
  </div>
  <!-- discription and image end -->


  <ul class="cards">
    <li class="cards_item">
      <div class="card">
        <div class="card_image"><img style="height: 402px; width: 272px;" src="static/img/m2.jpg"></div>
        <div class="card_content">
          <h2 class="card_title" style="text-align: center;">V.Vithiyasahar</h2><br>
          <div class="social">
            <i class="fa fa-facebook-square" aria-hidden="true"></i>
            <i class="fa fa-twitter-square" aria-hidden="true"></i>
            <i class="fa fa-tumblr-square" aria-hidden="true"></i>
          </div>
        </div>
      </div>
    </li>
    <li class="cards_item">
      <div class="card">
        <div class="card_image"><img style="height: 402px; width: 272px;" src="static/img/m3.jpg"></div>
        <div class="card_content">
          <h2 class="card_title" style="text-align: center;">V.Vignagajan</h2><br>
          <div class="social">
            <i class="fa fa-facebook-square" aria-hidden="true"></i>
            <i class="fa fa-twitter-square" aria-hidden="true"></i>
            <i class="fa fa-tumblr-square" aria-hidden="true"></i>
          </div>
        </div>
      </div>
    </li>
    <li class="cards_item">
      <div class="card">
        <div class="card_image"><img style="height: 402px; width: 272px;" src="static/img/m4.jpg"></div>
        <div class="card_content">
          <h2 class="card_title" style="text-align: center;">W.Amila</h2><br>
          <div class="social">
            <i class="fa fa-facebook-square" aria-hidden="true"></i>
            <i class="fa fa-twitter-square" aria-hidden="true"></i>
            <i class="fa fa-tumblr-square" aria-hidden="true"></i>
          </div>
        </div>
      </div>
    </li>
    <li class="cards_item">
      <div class="card">
        <div class="card_image"><img style="height: 402px; width: 272px;" src="static/img/m5.jpg"></div>
        <div class="card_content">
          <h2 class="card_title" style="text-align: center;">C.Ravisanka</h2><br>
          <div class="social">
            <i class="fa fa-facebook-square" aria-hidden="true"></i>
            <i class="fa fa-twitter-square" aria-hidden="true"></i>
            <i class="fa fa-tumblr-square" aria-hidden="true"></i>
          </div>
        </div>
      </div>
    </li>

  </ul>



</div>

<%@ include file="/WEB-INF/components/footer.jsp" %>

</body>
</html>
