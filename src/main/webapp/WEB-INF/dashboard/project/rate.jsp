<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.inventine.dao.RateProjectDaoImplementation" %>
<%@ page import="com.inventine.model.RateProject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/form.css">
    <script src="${System.getenv("HOST_URL")}/static/js/img_upload.js"></script>


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>

<%Project project = (Project)request.getAttribute("project"); %>

<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">
                <div class="input-box">
                    <span class="details">Project Id</span>
                    <input type="text"
                           name="projectId" id="projectId"  value="<%out.print(project.getProjectId());%>" disabled>
                </div>

                <div class="input-box">
                    <span class="details">Project Name</span>
                    <input type="text"
                           name="projectName" id="projectName"  value="<%out.print(project.getProjectName());%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;">letters,numbers and special characters allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Requested Amount</span>
                    <input type="text"
                           name="requestedAmount" id="requestedAmount" required pattern="^(?:0|[1-9]\d*)$" value="<%out.print(project.getRequestedAmount());%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;"></span>
                </div>

                <div class="input-box">
                    <span class="details">Date of Expiry</span>
                    <input type="date"
                           id="dateOfExpiry" name="dateOfExpiry" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])" value="<%out.print(new Date(project.getDateOfExpiry().getTime()));%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;" >Select the date of funding expiry</span>
                </div>

                <div class="input-box">
                    <span class="details">Description</span>
                    <input type="text"
                           id="description" name="description" style="border-color:#0097E6;border-radius: 10px;width: 100%;min-height: 150px;" value="<%out.print(project.getDescription());%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;">Enter the description</span>
                </div>



                <%--                <div class="input-box">--%>
                <%--                    <span class="details">Project Name</span>--%>
                <%--                    <input type="text"--%>
                <%--                           name="projectName" id="projectName">--%>
                <%--                    <span class="error" aria-live="polite" style="display: none;">letters,numbers and special characters allowed</span>--%>
                <%--                </div>--%>

                <div class="input-box">
                    <span class="details">Category</span>
                    <select class="category" name="category" id="category" required disabled>
                        <option > <%out.print(project.getCategory());%></option>
                        <option value="Art">art</option>
                        <option value="Design">design</option>
                        <option value="Food">food</option>
                        <option value="Publication">publication</option>
                        <option value="Software">software</option>
                        <option value="Technology">technology</option>
                        <option value="Other">other</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Select a category</span>
                </div>

                <%--                <div class="input-box">--%>
                <%--                    <span class="details">Financial Status (Complete/Incomplete)</span>--%>
                <%--                    <select class="financialStatus" name="financialStatus" id="financialStatus" required>--%>
                <%--                        <option hidden> <%out.print(project.getFinancialStatus());%></option>--%>
                <%--                        <option value="Complete">C</option>--%>
                <%--                        <option value="Incomplete">I</option>--%>
                <%--                    </select>--%>
                <%--                    <span class="error" aria-live="polite" style="display: none;" >Select a status</span>--%>
                <%--                </div>--%>

                <div class="input-box">
                    <span class="details">Rating</span>
                    <select class="rating" name="rating" id="rating" required>
                        <option > -- Select a value from (1-5) --</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Rate</span>
                </div>

                <!-- input boxes end -->


            </div>
            <div style="display: flex">
                <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/project';">Cancel</button>
                <button onclick="signupValidation()">Confirm</button>
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
            'Rated successfully!',
            ''
        )
    }

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>




</body>
</html>
