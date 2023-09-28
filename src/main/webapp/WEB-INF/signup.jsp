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

        <div id="signupForm">

            <!-- input boxes start -->
            <div class="details">

                <div class="tab" style="display: none">

                    <!-- form title -->
                    <div class="title">Personal Details</div>

                    <div class="input-box">
                        <span class="details">First Name</span>
                        <input type="text"
                               name="firstName" id="firstName"  required pattern="[a-zA-Z]{2,50}">
                        <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
                    </div>

                    <div class="input-box">
                      <span class="details">Last Name</span>
                      <input type="text"
                             name="lastName" id="lastName" required pattern="[a-zA-Z]{2,50}">
                      <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
                    </div>

                    <div class="input-box">
                      <span class="details">Date of Birth</span>
                      <input type="date"
                             id="dob" name="dob" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])">
                      <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
                    </div>

                    <div class="input-box">
                      <span class="details">Gender</span>
                      <select class="gender"
                              id="gender" name="gender" required pattern=[A-Z]>
                        <option disabled selected value> -- select a gender -- </option>
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                      </select>
                      <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
                    </div>

                </div>

                <div class="tab" style="display: none">

                    <!-- form title -->
                    <div class="title">Contact Details</div>

                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="email"
                               id="email" name="email" placeholder="" required>
                        <span class="error" aria-live="polite" style="display: none;" >Enter valid email address</span>
                    </div>

                    <div class="input-box">
                      <span class="details">Phone Number</span>
                      <input type="text"
                             id="phone" type="tel" name="phone" placeholder="" required pattern="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$">
                      <span class="error" aria-live="polite" style="display: none;" >Enter phone number in international code</span>
                    </div>

                    <div class="input-box">
                      <span class="details">Address</span>
                      <input type="text"
                             id="address"name="address" placeholder="">
                      <span class="error" aria-live="polite" style="display: none;" >Enter valid postal address</span>
                    </div>

                    <div class="input-box">
                      <span class="details">District</span>
                      <select class="district" name="district" id="district" required>
                        <option disabled selected value> -- select a district -- </option>
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
                      <span class="error" aria-live="polite" style="display: none;" ></span>
                    </div>

                </div>

                <div class="tab" style="display: none">

                    <!-- form title -->
                    <div class="title">inventine Details</div>
                    <div class="input-box">
                        <span class="details">Username</span>
                        <input type="text"
                               name="username" id="username"  placeholder="" required pattern="[a-zA-Z]{2,50}">
                        <span class="error" aria-live="polite" style="display: none;" >Small letters of length 4-50 is allowed</span>
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

                    <div class="input-box">
                        <span class="details">Who you are</span>
                        <select class="role" name="role"
                                id="role" required pattern="[A-Z]">
                            <option disabled selected value> -- select a your type -- </option>
                            <option value="C">Creator</option>
                            <option value="I">Investor</option>
                        </select>
                        <span class="error" aria-live="polite" style="display: none;" >Select account type</span>
                        </span>

                    </div>

                    <!-- input boxes end -->

                    <!-- checkbox -->
                    <!-- <div class="input_field_checkbox_option">
                      <input type="checkbox" id="terms" name="terms" required>
                      <label for="cb1">I agree with Terms of Service</label>
                    </div> -->

                </div>
            </div>

            <div style="display: flex">
                <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
            </div>

            <hr style="margin-top: 20px; height: 10px;     border: none; border-top: medium double #0097e6;"/>
            <div class="desc" style="color: #0097e6; margin-top: 20px; text-align: center" >Already have an account? <a href="${System.getenv("HOST_URL")}/login">Login</a></div>
            <!-- Circles which indicates the steps of the form: -->
            <div style="text-align:center;margin-top:20px;">
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
            </div>

        </div>
    </div>
</div>

<!-- css style sheets -->
<script src="static/js/signup-form.js"></script>
<script src="static/js/dashboard/validate.js"></script>

<script>

    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab

    function signupValidation(){

        var x = document.getElementsByClassName("tab");

        tab_elements = Array.prototype.slice.call(x[currentTab].getElementsByTagName("input"));

        tab_elements = tab_elements.concat(Array.prototype.slice.call(x[currentTab].getElementsByTagName("select")));

        for (i = 0; i < tab_elements.length; i++) {

            if(tab_elements[i].value == ""){

                Swal.fire({
                    icon: 'warning',
                    title: 'Form fields cannot be empty!',
                    iconColor: "#0097e6",
                    confirmButtonColor: "#0097e6",
                });

                return false;
            }

            if(!tab_elements[i].checkValidity()){

                Swal.fire({
                    icon: 'error',
                    title: 'Signuo is successfull!',
                    iconColor: "#0097e6",
                    confirmButtonColor: "#0097e6",
                });

                return false;
            }

        }

        // Password Validation

        if( currentTab == 2){

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
                'Employee is created successfully!',
                '${pageContext.request.contextPath}/login'
            )

        }

        return true;

    }


</script>

</body>
</html>
