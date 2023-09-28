<header class="header">
  <nav class="navbar">
    <a href="#" class="nav-logo">inventine</a>
    <ul class="nav-menu">
      <li class="nav-item">
        <a href="#" class="nav-link">How It Works?</a>
      </li>
      <li class="nav-item">
        <a href="#" class="nav-link">About Us</a>
      </li>
      <li class="nav-item">
        <a href="#" class="nav-link">Contact Us</a>
      </li>
      <li class="nav-item">
        <a href="#" class="nav-link">Login</a>
      </li>
      <li class="nav-item">
        <a href="<%= request.getContextPath() %>/signup" class="nav-link">Signup</a>
      </li>
      <li class="nav-item">
        <a><div class="search-container">
          <form action="">
            <input type="text" placeholder="Start Project" class="searchTerm">
            <button type="submit" class="searchButton">
              <i class="fa fa-search"></i>
            </button>
          </form>
        </a></div>
      </li>
    </ul>


    <div class="hamburger">
      <span class="bar"></span>
      <span class="bar"></span>
      <span class="bar"></span>
    </div>
  </nav>
</header>
