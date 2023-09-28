<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/login.css">

</head>
<body>

<div class="alert" style="display: none">
    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    <strong>Login is Required!</strong> Please login to continue...
</div>


<div class="container">
    <div class="content">

        <!-- input boxes start -->
        <div class="details">

            <!-- form title -->
            <div class="title">Welcome Back!</div>

            <div class="input-box">
                <span class="details">Username or Email</span>
                <input type="text" id="username" name="username"  required>
                <span class="error" aria-live="polite" style="display: none;" >Username or Email is required!</span></span>
            </div>

            <div class="input-box">
                <span class="details">Password</span>
                <input type="password" id="password"  name="password" required>
                <span class="error" aria-live="polite" style="display: none;" >Password is required!</span></span>
            </div>

            <div class="forgot"><a href="">Forgot Password</a></div>

        </div>

        <div style="display: flex">
            <button type="button" id="prevBtn" onclick="history.back()">Back</button>
            <button type="button" id="nextBtn" onclick="loginValidation()">Login</button>
        </div>

        <hr style="margin-top: 20px; height: 10px;     border: none; border-top: medium double #0097e6;"/>
        <div class="desc" style="color: #0097e6; margin-top: 20px; text-align: center" >Don't have an account? <a href="${System.getenv("HOST_URL")}/signup">Signup</a></div>

    </div>

</div>

    <script src="${System.getenv("HOST_URL")}/static/js/dashboard/validate.js"></script>

<script>

    function loginValidation(){

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

        requestHandler(
            y,
            window.location.href,
            'Login is successfull!',
            '${System.getenv("HOST_URL")}/dashboard',

        )
    }

</script>

</body>
</html>
