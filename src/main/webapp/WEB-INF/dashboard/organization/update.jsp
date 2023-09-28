<%@ page import="com.inventine.model.Organization" %>
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
<%   Organization organization = (Organization)request.getAttribute("organization");%>

<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">

                <div class="input-box">
                    <span class="details">Organization Id</span>
                    <input type="text" name="organizationid" id="competitionid"  required pattern="[0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(organization.getOrganizationId());%>" disabled>
                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization Name</span>
                    <input type="text" name="name" id="name"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(organization.getName());%>">
                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization Address</span>
                    <input type="text" name="address" id="address"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(organization.getAddress());%>">
                    <span class="error" aria-live="polite" style="display: none;">A address of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Organization district</span>
                    <input type="text" name="district" id="district"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(organization.getDistrict());%>" >
                    <span class="error" aria-live="polite" style="display: none;">A district of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Contact Number</span>
                    <input type="text"
                           id="contactnumber" type="tel" name="contactnumber" placeholder="" required pattern="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$" value="<%out.print(organization.getContactNumber());%>">
                    <span class="error" aria-live="polite" style="display: none;" >Enter phone number in international code</span>
                </div>






            </div>




        </div>

        <div style="display: flex">
            <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/organization';">Cancel</button>
            <button onclick="signupValidation()">Update</button>
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
