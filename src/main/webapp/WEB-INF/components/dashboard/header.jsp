<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header start -->
<header id="header">
    <h1 id="title" >

       Dashboard

    </h1>
    <div class="user-wrapper">
        <h4 href="${System.getenv("HOST_URL")}/profile"> <%= (String)session.getAttribute("username")%></h4>
        <div class="dropdown">
            <img src="${System.getenv("HOST_URL")}/image/<%= (String)session.getAttribute("profileId")%>" width="50px" height="50px" alt="profile-pic">
            <div class="dropdown-content">
<%--                <a href="#">Generate Report</a>--%>
                <a href="${System.getenv("HOST_URL")}/profile/<%= (String)session.getAttribute("userId")%>?id=<%= (String)session.getAttribute("userId")%>">Profile</a>
                <a href="${System.getenv("HOST_URL")}">Homepage</a>
                <a href="${System.getenv("HOST_URL")}/logout">Logout</a>
            </div>
        </div>
    </div>

</header>
<!-- header end -->