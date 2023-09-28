<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/contactus.css">

</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="reportissue">
    <button class="ribtn">Report an Issue</button>
</div>
<div class="container-cu">
    <div class="row">
        <h1>Contact Us</h1>
    </div>
    <div class="row">
        <h4 style="text-align:center">We'd love to hear from you!</h4>
    </div>
    <div class="row input-container">
        <div class="col-xs-12">
            <div class="styled-input wide">
                <label>Name</label>
                <input type="text" required />

            </div>
        </div>
        <div class="col-md-6 col-sm-12">
            <div class="styled-input">
                <label>Email</label>
                <input type="text" required />

            </div>
        </div>
        <div class="col-md-6 col-sm-12">
            <div class="styled-input" style="float:right;">
                <label>Phone Number</label>
                <input type="text" required />

            </div>
        </div>
        <div class="col-xs-12">
            <div class="styled-input wide">
                <label>Message</label>
                <textarea required></textarea>

            </div>
        </div>
        <div class="col-xs-12">
            <div class="btn-lrg submit-btn">Send Message</div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/components/footer.jsp" %>

</body>
</html>
