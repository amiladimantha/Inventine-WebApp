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
        <div class="search-bar">
            <table class="search-bar-element">
                <tr>
                    <td>
                        <input type="text" placeholder="Search" class="search" id="search" onkeyup="ajaxSearch()">
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
            <a href=""><button class="b">All</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/art"><button class="b">Art</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/design"><button class="b">Design</button></a>
            <a href="${System.getenv("HOST_URL")}/categories/publication"><button class="b">Publication</button></a>
        </div>
    </div>


    <div class="main">
        <ul class="cards" id="cards">
            <%
                List<User>  users= (ArrayList<User>)request.getAttribute("users");
                List<Creds> creds= (ArrayList<Creds>)request.getAttribute("creds");
                int i = 0;
                for ( Project project: (ArrayList<Project>)request.getAttribute("project")){
            %>
            <div class="card">

                <div class="card-header">
                    <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
                        <img src="${System.getenv("HOST_URL")}/image/<% out.print(project.getImageId());%>">
                    </a>
                </div>

                <div class="card-body">
                    <span class="tag tag-purple"><% out.print(project.getCategory());%></span>

                    <h4 class="card-title">
                        <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>?id=<% out.print(project.getProjectId());%>">
                            <% out.print(project.getProjectName()); %>
                        </a>
                    </h4>
                    <p>
                        <%--                        The future can be scary, but there are ways to--%>
                        <%--                        deal with that fear.--%>
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

<script>
    function ajaxSearch() {
        var input, filter, cards, cardContainer, title, i;
        input = document.getElementById("search");
        filter = input.value.toUpperCase();
        cardContainer = document.getElementById("cards");
        cards = cardContainer.getElementsByClassName("card");
        for (i = 0; i < cards.length; i++) {
            title = cards[i].querySelector(".card-title");
            if (title.innerText.toUpperCase().indexOf(filter) > -1) {
                cards[i].style.display = "";
            } else {
                cards[i].style.display = "none";
            }
        }
    }

</script>

</body>
<%@ include file="/WEB-INF/components/footer.jsp" %>
</html>