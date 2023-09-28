<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <%@ include file="/WEB-INF/components/head-import.jsp" %>

  <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/home.css">

</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="content">
  <!-- description and image start -->
  <div class="container">
    <div class="column-1">
      <h1>MAKE YOUR IDEAS WORKABLE!</h1>
      <span class="paragraph">We are inventine, who makes tour Ideas get funded and mentoring to enhance the business process.</span>
      <div class="hostbutton">
        <a href="">
          <button class="button1" >
            <span class="host">Browse</span>
          </button>
        </a>
        <a href="">
          <button class="button2">
            <span class="host">Start Project</span>
          </button>
        </a>
      </div>
    </div>
    <div class="column-2">
      <img src="static/img/img.png" style="width: 500px;height: 250px;">
    </div>
  </div>
  <!-- discription and image end -->

  <div class="search-container">
    <div class="wrap">
      <div class="search">
        <input type="text" class="searchTerm" placeholder="What are you looking for?">
        <button type="submit" class="searchButton">
          <i class="fa fa-search"></i>
        </button>
      </div>
    </div>
    <div class="rowbutton">
      <a href=""><button class="b">Food</button></a>
      <a href=""><button class="b">Software</button></a>
      <a href=""><button class="b">Tech</button></a>
      <a href=""><button class="b">All</button></a>
      <a href=""><button class="b">Art</button></a>
      <a href=""><button class="b">Film</button></a>
      <a href=""><button class="b">Punlication</button></a>
    </div>
  </div>


  <div class="main">
    <ul class="cards">
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-4-180x180.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">Mirror One | Your life at a glance</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://i.etsystatic.com/6563235/r/il/328096/2585488407/il_570xN.2585488407_3gpt.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">Wildlife Illustrated GiftWrap</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-5-180x180.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">VR Ears | Hear Off-World Listen Off-Ear</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://ae01.alicdn.com/kf/HTB1YA5RedqUQKJjSZFIq6AOkFXaW/Creative-Notebook-Cactus-Leaves-PU-Leather-Cover-Planner-Diary-Book-Exercise-Composition-Binding-Notepad-Gift-Stationery.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">Notebook for your creative observation</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.ofdesign.net/wp-content/uploads/images/100-interior-design-ideas-for-kids-room-with-bright-colors-for-girls-and-boys-0-2061936751.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">Beautiful colors for all the designers & students</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>
      <li class="cards_item">
        <div class="card">
          <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-2-180x180.jpg"></div>
          <div class="card_content">
            <h2 class="card_title">SelfDriving Robot for Target Shooting Game</h2>
            <button class="btn card_btn">View</button>
          </div>
        </div>
      </li>

    </ul>
  </div>
</div>

<%@ include file="/WEB-INF/components/footer.jsp" %>

</body>
</html>
