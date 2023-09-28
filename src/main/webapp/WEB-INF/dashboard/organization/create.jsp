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

<%--                <div class="input-box">--%>
<%--                    <span class="details">Prize Amount</span>--%>
<%--                    <input type="text"--%>
<%--                           name="prizeMoney" id="prizeMoney" required pattern="^(?:0|[1-9]\d*)$">--%>
<%--                    <span class="error" aria-live="polite" style="display: none;">Enter an amount no decimals needed</span>--%>
<%--                </div>--%>

<%--                <div class="input-box">--%>
<%--                    <span class="details">Ending Date</span>--%>
<%--                    <input type="date"--%>
<%--                           name="endingAt" id="endingAt" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])">--%>
<%--                    <span class="error" aria-live="polite" style="display: none;" >Select the date of Competition expiry</span>--%>
<%--                </div>--%>


<%--                <div class="input-box">--%>
<%--                    <span class="details">Rules</span>--%>
<%--                    <input type="text"--%>
<%--                           name="rules" id="rules" required >--%>
<%--                    <span class="error" aria-live="polite" style="display: none;" >Input the description</span>--%>
<%--                </div>--%>
<%--                &lt;%&ndash;                <div class="input-box">&ndash;%&gt;--%>
                <%--                    <span class="details">Description</span>--%>
                <%--                    <textarea--%>
                <%--                            id="description" name="description" placeholder="" required>--%>
                <%--                    </textarea>--%>
                <%--                </div>--%>

<%--                <div class="input-box">--%>
<%--                    <span class="details">Competition Type</span>--%>
<%--                    <select class="category" name="cType" id="cType" required>--%>
<%--                        <option disabled selected value> -- select a category for Competition Type -- </option>--%>
<%--                        <option value="T">Target</option>--%>
<%--                        <option value="H">Hackathon</option>--%>

<%--                    </select>--%>
<%--                    <span class="error" aria-live="polite" style="display: none;" >Select a category</span>--%>
<%--                </div>--%>
                <!-- input boxes end -->
            </div>


            <%--            <div class="input-box">--%>
            <%--                <span class="details">Participate  Type</span>--%>
            <%--                <select class="category" name="pType" id="pType" required>--%>
            <%--                    <option disabled selected value> -- select a category for Participate Type -- </option>--%>
            <%--                    <option value="I">Internal</option>--%>
            <%--                    <option value="A">All</option>--%>

            <%--                </select>--%>
            <%--                <span class="error" aria-live="polite" style="display: none;" >Select a category</span>--%>
            <%--            </div>--%>
            <!-- input boxes end -->
        </div>

        <div style="display: flex">
            <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/organization';">Cancel</button>
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


        requestHandler(
            y,
            window.location.href,
            'Organization created successfully!',
            ''
        )
    }

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>




</body>
</html>
