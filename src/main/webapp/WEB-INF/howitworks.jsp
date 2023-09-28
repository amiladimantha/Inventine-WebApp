<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/home.css">




</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <div class="content">
    <div class="container">
        <div class="column-1">
            <h1>How it works?</h1>
            <span class="paragraph">The main target of Inventine is to bring everyone together to make a massive network where people who are looking to guide, invest in new ideas, projects and people who are looking for funds to realize their ideas and projects.<br> Investors and Creators have the following abilities,<br><br>

        <li style="font-weight: 800;">The investors provide financial support for those projects that they think are interesting and promising.</li>
        <li style="font-weight: 800; margin-bottom: 30px;">The innovators/creators can request for funds from the people who invest by putting their projects  in the inventine platform. </li>


        </span>
        </div>
        <div class="column-2">
            <img src="static/img/hws.jpg" style="width: 100%;height: 300px;">
        </div>
    </div>
    </div>

</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="static/js/profile.js"></script>
</body>
</html>
