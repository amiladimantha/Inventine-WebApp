<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/home.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-details.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/contactus.css">
<%--    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">--%>



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<%
    Project project = (Project) request.getAttribute("project");
    User user = (User) request.getAttribute("user");
    Creds creds= (Creds) request.getAttribute("creds");
    RateProject rateProject=(RateProject) request.getAttribute("rateProject");

%>

<div class = "card-wrapper">
    <div class = "project-card">
        <!-- card left -->
        <div class = "project-imgs">
            <div class = "img-display">
                <div class = "img-showcase">
                    <img src = "${System.getenv("HOST_URL")}/image/<% out.print(project.getImageId());%>">
                </div>
            </div>
<%--            <div class = "img-select">--%>
<%--                <div class = "img-item">--%>
<%--                    <a href = "#" data-id = "1">--%>
<%--                        <img src = "https://picsum.photos/640/640/?image=1071" alt = "shoe image">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class = "img-item">--%>
<%--                    <a href = "#" data-id = "2">--%>
<%--                        <img src = "https://picsum.photos/640/640/?image=1070" alt = "shoe image">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class = "img-item">--%>
<%--                    <a href = "#" data-id = "3">--%>
<%--                        <img src = "https://picsum.photos/640/640/?image=1072" alt = "shoe image">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class = "img-item">--%>
<%--                    <a href = "#" data-id = "4">--%>
<%--                        <img src = "https://picsum.photos/640/640/?image=183" alt = "shoe image">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <!-- card right -->
        <div class = "project-content">

            <div class="cat-rate">
                <a href = "${System.getenv("HOST_URL")}/categories/<% out.print(project.getCategory());%>" class = "project-link"><% out.print(project.getCategory());%></a>
                <div class = "project-rating">
                    <i class = "fas fa-star"></i>
                    <i class = "fas fa-star"></i>
                    <i class = "fas fa-star"></i>
                    <i class = "fas fa-star"></i>
                    <i class = "fas fa-star-half-alt"></i>
                    <span>4.7(21)</span>
                </div>

            </div>

            <h2 class = "project-title"><% out.print(project.getProjectName());%></h2>

            <div class = "project-detail">
                <div class="row">
                    <div class="column">
                        <div class="card">
                            <div class="title">Pledged</div>
                            <div class="count"><% out.print(request.getAttribute("pledge"));%></div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="card">
                            <div class="title">Investors</div>
                            <div class="count"><% out.print(request.getAttribute("investors"));%></div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="card">
                            <div class="title">Days Left</div>
                            <div class="count"><% out.print(request.getAttribute("projectsdate"));%></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="progress-info">
                <div>
                    <p><b>Goal</b>: <b style="color: #0097E6;">Rs. <% out.print(project.getRequestedAmount());%></b></p>
                </div>
                <div style="margin-left: auto;">
                    <p><b>0%</b></p>
                </div>
            </div>

            <progress class="progress-bar" max="100" value="0"></progress>

            <div class = "invest-info">
                Rs.

                <form action="${System.getenv("HOST_URL")}/invest" method="post" id="invest">
                <input id ="investmentAmount" name="investmentAmount" min = "1000" value = "1000">
                <input type="hidden" id="projectId" name="projectId" value=" <% out.print(project.getProjectId());%>">
                </form>
                <button type="submit" onclick="window.location.href='${System.getenv("HOST_URL")}/invest?projectId=<% out.print(project.getProjectId());%>'" class="btn">
                    <b>Invest</b>
                </button>

            </div>

            <div class="creator-info">
                <div class="creator-img">
                    <img src = "${System.getenv("HOST_URL")}/image/<%out.print(creds.getProfileId());%>">
                </div>
                <div class="creator-link">
                    <p>By: <a href="${System.getenv("HOST_URL")}/profile/<% out.print(creds.getUserId());%>"><b style="text-transform: capitalize"><% out.print(user.getFirstName());%> <% out.print(user.getLastName());%></b></a></p>
                </div>
            </div>

            <hr style="height:5px ;background-color:#0097E6; border: none; margin-bottom: 20px;" />

            <div class="share">
                <p style="color: #0097E6;"><b>Social Share: </b></p>
                <div class = "social-links">
                    <i class = "fab fa-facebook-f" onclick="shareProject()"></i>
                    <a href = "#">
                        <i class = "fab fa-twitter"></i>
                    </a>
                    <a href = "#">
                        <i class = "fab fa-instagram"></i>
                    </a>
                    <a href = "#">
                        <i class = "fab fa-whatsapp"></i>
                    </a>
                    <a href = "https://www.linkedin.com/sharing/share-offsite/?url=https://app.diagrams.net/" target="_blank">
                        <i class = "fab fa-linkedin"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="right">
    <div class="tabs">
        <button class="tablink" onclick="openPage('Projects', this, '#0097e6','#fff')" id="defaultOpen">Proposal</button>
<%--        <button class="tablink" onclick="openPage('Organization', this, '#0097e6','#fff')" >Investors</button>--%>
<%--        <button class="tablink" onclick="openPage('Contact', this, '#0097e6','#fff')">Ratings</button>--%>

    </div>

    <div class="details">
        <div id="Projects" class="tabcontent">
            <% out.print(project.getDescription());%>
<%--            <h3>Introduction</h3>--%>
<%--            <p>--%>
<%--                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent venenatis lacus ultricies nisi scelerisque laoreet. Phasellus ac molestie ligula. Cras euismod interdum libero. Proin vitae rhoncus massa, id fermentum erat. Vestibulum ultricies, odio at ultricies consequat, libero nibh pharetra purus, eget convallis eros leo eget ligula. Integer tempor laoreet mauris, vel scelerisque urna cursus ut. Nunc commodo est sit amet est accumsan, sit amet ultricies eros venenatis. Vestibulum ac eros a metus bibendum tristique in quis tellus. Maecenas vehicula feugiat porta. Cras gravida nulla augue, eget convallis ipsum maximus ut. Phasellus tempus feugiat tellus pharetra convallis. Vivamus volutpat ante quam, in imperdiet purus tincidunt non. Suspendisse potenti. Donec non justo nisi.--%>
<%--            </p>--%>
<%--            <img class="dt-img" src = "https://picsum.photos/400/400/?image=1071" alt = "shoe image">--%>
        </div>

        <div id="Organization" class="tabcontent">
            <h3>Organization</h3>
            <p>Some news this fine day!</p>
        </div>

        <div id="Contact" class="tabcontent">
            <h3>Contacts</h3>
            <p>Numbers!</p>
        </div>
    </div>
</div>

<%--<div class="main">--%>
<%--    <ul class="cards" id="cards">--%>
<%--        <%--%>
<%--            List<User> users= (ArrayList<User>)request.getAttribute("users");--%>
<%--            List<Creds> cred= (ArrayList<Creds>)request.getAttribute("cred");--%>
<%--            int i = 0;--%>
<%--            for ( Project projects: (ArrayList<Project>)request.getAttribute("projects")){--%>
<%--        %>--%>
<%--        <div class="card">--%>

<%--            <div class="card-header">--%>
<%--                <a href="${System.getenv("HOST_URL")}/project/<% out.print(projects.getProjectId());%>">--%>
<%--                    <img src="${System.getenv("HOST_URL")}/image/<% out.print(projects.getImageId());%>">--%>
<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="card-body">--%>
<%--                <span class="tag tag-purple"><% out.print(projects.getCategory());%></span>--%>

<%--                <h4 class="card-title">--%>
<%--                    <a href="${System.getenv("HOST_URL")}/project/<% out.print(projects.getProjectId());%>">--%>
<%--                        <% out.print(projects.getProjectName()); %>--%>
<%--                    </a>--%>
<%--                </h4>--%>
<%--                <p>--%>
<%--                    &lt;%&ndash;                        The future can be scary, but there are ways to&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        deal with that fear.&ndash;%&gt;--%>
<%--                </p>--%>
<%--                <div class="user">--%>
<%--                    <img src="${System.getenv("HOST_URL")}/image/<%out.print(cred.get(i).getProfileId());%>" />--%>
<%--                    <div class="user-info">--%>
<%--                        <h5>--%>
<%--                            <%out.print(users.get(i).getFirstName());%> <%out.print(users.get(i).getLastName());%></h5>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <%i++;}%>--%>

<%--    </ul>--%>
<%--</div>--%>

<script>
    function investValidation(){
        y = new Array;
        // let st = window.location.href.toString();
        // st = st.split("?")[0]}
        // y.push(document.getElementById("postID"));
        // y.push(postID);
        y.push(document.getElementById("investmentAmount"));
        y.push(document.getElementById("projectId"));
        // y.push(document.getElementById("description-reply"));
        // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
        // y = y.concat(z);

        for (i = 0; i < y.length; i++) {

            if(y[i].value == ""){

                Swal.fire({
                    icon: 'warning',
                    title: 'Form fields cannot be empty!',
                    iconColor: "#0097e6",
                    confirmButtonColor: "#0097e6",
                });

                return false;
            }

            // if(!y[i].checkValidity()){
            //
            //     Swal.fire({
            //         icon: 'error',
            //         title: 'Form fields should be valid!',
            //         iconColor: "#0097e6",
            //         confirmButtonColor: "#0097e6",
            //     });
            //
            //     return false;
            // }

        }



        requestHandler(
            y,
            "${host_url}invest",
            'Investment is processing...',
            '${host_url}invest'
        )
    }
</script>
<script src="${System.getenv("HOST_URL")}/static/js/project-details.js"></script>
<%@ include file="/WEB-INF/components/footer.jsp" %>

</body>
</html>
