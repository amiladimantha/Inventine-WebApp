<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${host_url}/static/css/dashboard/form.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">



                <div class="input-box">
                    <span class="details">Date and time of Meeting</span>
                    <input type="datetime-local"
                           id="datetime" name="datetime" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])">
                    <span class="error" aria-live="polite" style="display: none;" >Select the date of the meeting</span>
                </div>

                <div class="input-box">
                    <span class="details">Link</span>
                    <input type="text"
                           name="link" id="link" required >
                    <span class="error" aria-live="polite" style="display: none;" >Input the meeting link</span>
                </div>

                <div class="input-box">
                    <span class="details">Description</span>
                    <textarea class="description-textarea" style="width: 100%;min-height: 150px;border-color: #0097e6;border-radius: 10px;"  name="description" id="description"  required ></textarea>

                    <span class="error" aria-live="polite" style="display: none;">Input the meeting description</span>
                </div>



            <div style="display: flex">
                <button type="button" id="cancelBtn" onclick="location.href='${host_url}/project';">Cancel</button>
                <button onclick="signupValidation()">Create</button>

            </div>

        </div>
        </div>
    </div>
</div>
<script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/validate.js"></script>

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
            'Project created successfully!',
            ''
        )
    }

</script>

<script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/dashboard.js"></script>




</body>
</html>
