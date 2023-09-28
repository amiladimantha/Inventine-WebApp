<%@ page import="com.inventine.model.Competition" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/form.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>
<% Competition competition = (Competition)request.getAttribute("competition");%>

<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">


                <div class="input-box">
                    <span class="details">Competition Id</span>
                    <input type="text" name="competitionid" id="competitionid"  required pattern="[0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(competition.getCompetitionId());%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>


                <div class="input-box">
                    <span class="details">Competition Name</span>
                    <input type="text" name="competitionName" id="competitionName"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(competition.getCompetitionName());%>">
                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>




                <div class="input-box">
                    <span class="details">Starting Date</span>
                    <input type="date"
                           name="startingAt" id="startingAt" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])" value="<%out.print(competition.getStartingAt());%>">
                    <span class="error" aria-live="polite" style="display: none;" >Select the date of Competition </span>
                </div>


                <div class="input-box">
                    <span class="details">Ending Date</span>
                    <input type="date"
                           name="endingAt" id="endingAt" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])" value="<%out.print(competition.getEndingAt().getTime());%>">
                    <span class="error" aria-live="polite" style="display: none;" >Select the date of Competition expiry</span>
                </div>

                <div class="input-box">
                    <span class="details">Prize Amount</span>
                    <input type="text"
                           name="prizeMoney" id="prizeMoney" required pattern="^(?:0|[1-9]\d*)$" value="<%out.print(competition.getPrizeMoney());%>">
                    <span class="error" aria-live="polite" style="display: none;">Enter an amount no decimals needed</span>
                </div>


                <div class="input-box">
                    <span class="details">Rules</span>
                    <input type="text"
                           name="rules" id="rules" required value="<%out.print(competition.getRules());%>">
                    <span class="error" aria-live="polite" style="display: none;" >Input the description</span>
                </div>

                <div class="input-box">
                    <span class="details">OverView</span>
                    <input type="text"
                           name="overView" id="overView" required value="<%out.print(competition.getOverView());%>">
                    <span class="error" aria-live="polite" style="display: none;" >Input the OverviewofCompetition</span>
                </div>
                <%--                <div class="input-box">--%>
                <%--                    <span class="details">Description</span>--%>
                <%--                    <textarea--%>
                <%--                            id="description" name="description" placeholder="" required>--%>
                <%--                    </textarea>--%>
                <%--                </div>--%>

                <div class="input-box">
                    <span class="details">Competition Type</span>
                    <select class="category" name="cType" id="cType" required value="<%out.print(competition.getCType());%>">
                        <option disabled selected value> -- select a category for Competition Type -- </option>
                        <option value="T">Target</option>
                        <option value="H">Hackathon</option>

                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Select a category</span>
                </div>







        <div style="display: flex">
            <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/competition';">Cancel</button>
            <button onclick="signupValidation()">Update</button>
        </div>

    </div>
</div>
</div>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/validate.js"></script>

<script>

    function signupValidation(){

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

            if(!y[i].checkValidity()){

                Swal.fire({
                    icon: 'error',
                    title: 'Form fields should be valid!',
                    iconColor: "#0097e6",
                    confirmButtonColor: "#0097e6",
                });

                return false;
            }

        }


        requestHandler(
            y,
            window.location.href,
            'Competition updated successfully!',
            ''
        )
    }

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>




</body>
</html>
