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

<%--<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>--%>
<%--<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>--%>


<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">

                <div class="input-box">
                    <span class="details">Organization Name</span>
                    <input type="text" name="name" id="name"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}">
                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization Address</span>
                    <input type="text" name="address" id="address"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}">
                    <span class="error" aria-live="polite" style="display: none;">A address of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization district</span>
                    <input type="text" name="district" id="district"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}">
                    <span class="error" aria-live="polite" style="display: none;">A district of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Contact Number</span>
                    <input type="text"
                           id="contactnumber" type="tel" name="contactnumber" placeholder="" required pattern="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$">
                    <span class="error" aria-live="polite" style="display: none;" >Enter phone number in international code</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization Type</span>
                    <select class="orgtype" name="orgtype" id="orgtype">
                        <option disabled selected value> -- select a type -- </option>
                        <option value="U">University</option>
                        <option value="S">School</option>
                        <option value="P">privateOrganization</option>
                    </select>
                </div>

                <div class="input-box">
                    <span class="details">Username</span>
                    <input type="text"
                           name="username" id="username"  placeholder="" required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;" >Small letters of length 4-50 is allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="email"
                           id="email" name="email" placeholder="" required>
                    <span class="error" aria-live="polite" style="display: none;" >Enter valid email address</span>
                </div>

                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="password" name="password"
                           id="password" placeholder="" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}">
                    <span class="error" aria-live="polite" style="display: none;">
                          <div style="padding:5px;">
                            <p>Should contain: </p>
                            <ul>
                              <li>* At least one upper case English letter</li>
                              <li>* At least one lower case English letter</li>
                              <li>* At least one digit</li>
                              <li>* At least one special character</li>
                              <li>* Minimum eight characters</li>
                            </ul>
                          </div>
                        </span>
                </div>

                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="password" name="confirm_password"
                           id="confirm_password" placeholder="" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}">
                    <span class="error" aria-live="polite" style="display: none;" >Password doesn't match the policy!</span>
                </div>
            </div>







        </div>

        <div style="display: flex">
            <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/login';">Cancel</button>
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
            window.location.href,
            'Organization is created successfully!',
            ''
        )
    }

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>




</body>
</html>
