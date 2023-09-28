<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <!-- css  -->
    <link rel="stylesheet" href="static/css/form.css">
    <link rel="stylesheet" href="static/css/multi-step-form.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- javascript -->
    <script type="text/javascript" src="static/js/multi-step-form.js"></script>
</head>

<body>
<main>

    <!-- form start -->
    <div class="container">
        <!-- form title -->
        <div class="title">Registration</div>

        <div class="content">

            <form action="<%= request.getContextPath() %>/signup"  method="post" onsubmit="return validate()">

                <!-- input boxes start -->
                <div class="user-details">

                    <div class="tab">
                        <div class="input-box">
                            <span class="details">First Name</span>
                            <input type="text"
                                   name="firstName"  placeholder="Enter your first name" >
                        </div>

                        <div class="input-box">
                            <span class="details">Last Name</span>
                            <input type="text"
                                   name="lastName"  placeholder="Enter your last name" >
                        </div>

                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" name="phone" placeholder="Enter your phone number" >
                        </div>

                        <div class="input-box">
                            <span class="details">Address</span>
                            <input type="text" name="address" placeholder="Enter your address" >
                        </div>

                        <div class="input-box">
                            <span class="details">District</span>
                            <select class="district" name="district" id="district">
                                <option value="Ampara">Ampara</option>
                                <option value="Anuradhapura">Anuradhapura</option>
                                <option value="Badulla">Badulla</option>
                                <option value="Batticaloa">Batticaloa</option>
                                <option value="Colombo">Colombo</option>
                                <option value="Galle">Galle</option>
                                <option value="Gampaha">Gampaha</option>
                                <option value="Hambanthota">Hambanthota</option>
                                <option value="Jaffna">Jaffna</option>
                                <option value="Kaluthara">Kaluthara</option>
                                <option value="Kandy">Kandy</option>
                                <option value="Kegalle">Kegalle</option>
                                <option value="Kilinochchi">Kilinochchi</option>
                                <option value="Kurunegala">Kurunegala</option>
                                <option value="Mannar">Mannar</option>
                                <option value="Matale">Matale</option>
                                <option value="Matara">Matara</option>
                                <option value="Monaragala">Monaragala</option>
                                <option value="Mulativu">Mulativu</option>
                                <option value="Nuwara_Eliya">Nuwara Eliya</option>
                                <option value="Polonnaruwa">Polonnaruwa</option>
                                <option value="Puttalam">Kaluthara</option>
                                <option value="Ratanapura">Ratanapura</option>
                                <option value="Trincomalee">Trincomalee</option>
                                <option value="Vavuniya">Vavuniya</option>
                            </select>
                        </div>

                        <div class="input-box">
                            <span class="details">Date of Birth</span>
                            <input type="date" name="dob" >
                        </div>

                        <div class="input-box">
                            <span class="details">Gender</span>
                            <select class="gender" name="gender" id="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>

                        <div class="input-box">
                            <span class="details">Account Type</span>
                            <select class="atype" name="atype" id="atype">
                                <option value="creator">Creator</option>
                                <option value="investor">Investor</option>
                            </select>
                        </div>
                    </div>

                    <div class="tab">

                        <div class="input-box">
                            <span class="details">Username</span>
                            <input type="text"
                                   name="username"  placeholder="Enter your username" >
                        </div>

                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="text" name="email" placeholder="Enter your email" >
                        </div>

                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter your password"
                            >
                        </div>

                        <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <input type="text" name="confirm_password" placeholder="Confirm your password" >
                        </div>

                        <!-- input boxes end -->

                        <!-- checkbox -->
                        <div class="input_field_checkbox_option">
                            <input type="checkbox" name="terms">
                            <label>I agree with Terms of Service</label>
                        </div>

                        <!-- button -->
                        <div class="button">
                            <input type="submit"  value="Register">
                        </div>

                    </div>

                </div>

                <!-- Circles which indicates the steps of the form: -->
                <div style="text-align:center;margin-top:40px;">
                    <span class="step"></span>
                    <span class="step"></span>
                    <span class="step"></span>
                    <span class="step"></span>
                </div>

            </form>

        </div>

    </div>
    <!-- form end -->


</main>

<script>
    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab
</script>


</body>
</html>



