<%--
  Created by IntelliJ IDEA.
  User: amila
  Date: 27/03/2022
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="https://source.zoom.us/1.9.5/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="https://source.zoom.us/1.9.5/css/react-select.css" />
    <link type="text/css" rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/zoom.css">

    <title>Create Meeting</title>
</head>

<body>

<nav id="nav-tool" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Inventine Meeting Creation</a>
        </div>
        <div id="navbar" class="websdktest">
            <form class="navbar-form navbar-right" id="meeting_form">
                <div class="form-group">
                    <input type="text" name="userName" id="userName" value="1.9.5#CDN" maxLength="100"
                           placeholder="Name" class="form-control" required>
                </div>
                <div class="form-group">
                    <input type="text" name="meetingNumber" id="meetingNumber" value="" maxLength="200"
                           style="width:150px" placeholder="Meeting Number" class="form-control" required>
                </div>
                <div class="form-group">
                    <input type="text" name="meetingPassword" id="meetingPassword" value="" style="width:150px"
                           maxLength="32" placeholder="Meeting Password" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" name="userEmail" id="userEmail" value="" style="width:150px"
                           maxLength="32" placeholder="Email option" class="form-control">
                </div>

                <div class="form-group">
                    <select id="meetingRole" class="sdk-select">
                        <option value=0>Attendee</option>
                        <option value=1>Host</option>
                        <option value=5>Assistant</option>
                    </select>
                </div>

                <input type="hidden" id="meeting_lang" value="en-US" />
                <input type="hidden" id="meeting_china" value="0" /> <!-- Global-->

                <input type="hidden" value="" id="copy_link_value" />
                <button type="submit" class="btn btn-primary" id="join_meeting">Join</button>

            </form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</nav>

<script src="https://source.zoom.us/1.9.5/lib/vendor/react.min.js"></script>
<script src="https://source.zoom.us/1.9.5/lib/vendor/react-dom.min.js"></script>
<script src="https://source.zoom.us/1.9.5/lib/vendor/redux.min.js"></script>
<script src="https://source.zoom.us/1.9.5/lib/vendor/redux-thunk.min.js"></script>
<script src="https://source.zoom.us/1.9.5/lib/vendor/lodash.min.js"></script>
<script src="https://source.zoom.us/zoom-meeting-1.9.5.min.js"></script>
<script src="${System.getenv("HOST_URL")}/static/js/zoom.js"></script>

</body>

</html>
