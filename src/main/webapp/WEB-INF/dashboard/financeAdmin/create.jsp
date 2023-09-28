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


<div class="container">
    <div class="content">

        <div class="form">

            <!-- input boxes start -->
            <div class="details">

                <div class="input-box">
                    <span class="details">TransactionId</span>
                    <input type="text"
                           name="transactionId" id="transactionId"  required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;">Invalid Transaction ID</span>
                </div>



                <!-- input boxes end -->

                <div style="display: flex">
                    <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/financeAdmin';">Cancel</button>
                    <button onclick="signupValidation()">Create</button>
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

            // Password Validation

            const password = document.getElementById("password");
            const cpassword = document.getElementById("confirm_password");

            if( password.value != cpassword.value){
                Swal.fire({
                    icon: 'error',
                    title: 'Passwords should be same!',
                })
                return false;
            }

            requestHandler(
                y,
                'https://ptsv2.com/t/78q0w-1634957884/post',
                'User created successfully!',
                ''
            )
        }

    </script>

    <script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>

</div>
</body>
</html>

