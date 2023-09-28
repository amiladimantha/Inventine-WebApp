<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Creds" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/home.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">

</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="content">
    <!-- description and image start -->
    <div class="container">
        <div class="column-1">
            <h1>Art</h1>
            <span class="paragraph">"Creativity takes courage." <br>"Art should be something that liberates your soul." <br> "Action is the foundational key to all success."</span>

        </div>
        <div class="column-2">
            <img src="https://m.media-amazon.com/images/I/819TEWajJAL._SL1253_.jpg" style="width:650px;height: 300px">
        </div>
    </div>
    <!-- discription and image end -->

    <div class="search-container">
        <div class="search-bar">
            <table class="search-bar-element">
                <tr>
                    <td>
                        <input type="text" placeholder="Search" class="search">
                    </td>
                    <td>
                        <a href="#"><i class="fas fa-search" style="color:#0e4a6c;text-align:right"></i></a>
                    </td>
                </tr>
            </table>
        </div>
        <%--        <div class="wrap">--%>
        <%--            <div class="search">--%>
        <%--                <input type="text" class="searchTerm" placeholder="What are you looking for?">--%>
        <%--                <button type="submit" class="searchButton">--%>
        <%--                    <i class="fa fa-search"></i>--%>
        <%--                </button>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="rowbutton">
            <a href="${System.getenv("HOST_URL")}/categories/food"><button class="b">Food</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/software"><button class="b">Software</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/technology"><button class="b">Tech</button></a>
            <a href="${System.getenv("HOST_URL")}"><button class="b">All</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/art"><button class="b">Art</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/design"><button class="b">Design</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/publication"><button class="b">Publication</button></a>
        </div>
    </div>


    <div class="main">
        <ul class="cards">
            <%
                List<User>  users= (ArrayList<User>)request.getAttribute("users");
                List<Creds> creds= (ArrayList<Creds>)request.getAttribute("creds");
                int i = 0;
                for ( Project project: (ArrayList<Project>)request.getAttribute("project")){
            %>
            <div class="card">
                <div class="card-header">
                    <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
                        <img src="${System.getenv("HOST_URL")}/image/<%out.print(creds.get(i).getProfileId());%>" />
                    </a>
                </div>
                <div class="card-body">
                    <span class="tag tag-purple"><% out.print(project.getCategory());%></span>
                    <h4>
                        <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
                            <% out.print(project.getProjectName()); %>
                        </a>
                    </h4>
                    <p>

                    </p>
                    <div class="user">
                        <img src="${System.getenv("HOST_URL")}/image/<%out.print(creds.get(i).getProfileId());%>" />
                        <div class="user-info">
                            <h5>
                                <%out.print(users.get(i).getFirstName());%> <%out.print(users.get(i).getLastName());%></h5>
                        </div>
                    </div>
                </div>
            </div>
            <%i++;}%>

        </ul>
    </div>
</div>


</body>
<%@ include file="/WEB-INF/components/footer.jsp" %>
</html>
