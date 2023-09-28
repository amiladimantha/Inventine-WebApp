<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${host_url}/static/css/dashboard/forum_form.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>

<button onclick="document.getElementById('cont').style.display='block';document.getElementsByClassName('sidebar')[0].style.filter='blur(10px)'" style="position: fixed;top: 100px;right:100px;">123</button>
<button onclick="document.getElementById('cont').style.display='none';document.getElementsByClassName('sidebar')[0].style.filter='blur(0px)'" style="position: fixed;top: 200px;right:100px;">456</button>
<div class="container" style="display: none" id="cont">
    <div class="content">

        <div class="form">

            <!-- input boxes start -->
            <div class="details">

                <div class="input-box">
                    <span class="details">Title</span>
                    <input type="text"
                           name="title" id="title"  required >
                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>



                <div class="input-box">
                    <span class="details">Description</span>
                    <textarea class="description-textarea" type="text"  name="description" id="description"  required ></textarea>

                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>

                <!-- input boxes end -->

                <div style="display: flex">
                    <button type="button" id="cancelBtn" onclick="location.href='${host_url}/forum';">Cancel</button>
                    <button onclick="signupValidation()">Create</button>
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
                'Forum post is created successfully!',
                '${host_url}/forum'


            )
        }

    </script>

    <script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/dashboard.js"></script>

</div>
</body>
</html>