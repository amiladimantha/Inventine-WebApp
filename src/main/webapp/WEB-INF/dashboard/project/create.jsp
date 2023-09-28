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


<div class="container">
    <div class="content">

        <div class="form">

            <!-- input boxes start -->
            <div class="details">



                <div class="input-box">
                    <span class="details">Project Name</span>
                    <input type="text"
                           name="projectName" id="projectName">
                    <span class="error" aria-live="polite" style="display: none;">letters,numbers and special characters allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Requested Amount</span>
                    <input type="text"
                           name="requestedAmount" id="requestedAmount" required pattern="^(?:0|[1-9]\d*)$">
                    <span class="error" aria-live="polite" style="display: none;">Enter an amount no decimals needed</span>
                </div>

                <div class="input-box">
                    <span class="details">Date of Expiry</span>
                    <input type="date"
                           id="dateOfExpiry" name="dateOfExpiry" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])">
                    <span class="error" aria-live="polite" style="display: none;" >Select the date of funding expiry</span>
                </div>

                <div class="input-box">
                    <span class="details">Description</span>
                    <input type="text"
                            id="description" name="description" style="border-color:#0097E6;border-radius: 10px;width: 100%;min-height: 150px;" >
                    <span class="error" aria-live="polite" style="display: none;">Enter the description</span>
                </div>

                <div class="input-box">
                    <span class="details">Cover Image</span>
                    <button onclick="img_upload('<%=System.getenv("HOST_URL")%>',640,640,'cover_id')" style="margin-top: 10px;"> Upload Image and enter given id in the box</button>
                    <input type="text" name="imageId" id="imageId">
                    <span class="error" aria-live="polite" style="display: none;">Enter the imageid</span>
                </div>



<%--                <div class="input-box">--%>
<%--                    <span class="details">Project Name</span>--%>
<%--                    <input type="text"--%>
<%--                           name="projectName" id="projectName">--%>
<%--                    <span class="error" aria-live="polite" style="display: none;">letters,numbers and special characters allowed</span>--%>
<%--                </div>--%>

                <div class="input-box">
                    <span class="details">Category</span>
                    <select class="category" name="category" id="category" required>
                        <option disabled selected value> -- select a category for the Project -- </option>
                        <option value="art">art</option>
                        <option value="design">design</option>
                        <option value="food">food</option>
                        <option value="publication">publication</option>
                        <option value="software">software</option>
                        <option value="technology">technology</option>
                        <option value="other">other</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Select a category</span>
                </div>

                <!-- input boxes end -->

                <div style="display: flex">
                    <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/project';">Cancel</button>
                    <button onclick="signupValidation()">Create</button>
                </div>

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
            y.push(document.getElementsByTagName("textarea"))

            requestHandler(
                y,
                window.location.href,
                'Project created successfully!',
                ''
            )
        }

    </script>

    <script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>

</body>
</html>
