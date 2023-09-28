<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Creds" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<main id="main">

  <!-- the 4 cards containing data at top -->
  <div class="main-overview">

    <div class="overviewcard" style="background-color:white;color: ${card1_color}">
      <div><i class="far ${card1_icon} fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>${card1_label}</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">${card1_count}</div>
      </div>
    </div>

      <div class="overviewcard" style="background-color:white;color: ${card2_color}">
      <div><i class="far ${card2_icon} fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>${card2_label}</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">${card2_count}</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: ${card3_color}">
      <div><i class="far ${card3_icon} fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>${card3_label}</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">${card3_count}</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: ${card4_color}">
      <div><i class="far ${card4_icon} fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>${card4_label}</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">${card4_count}</div>
      </div>
    </div>

  </div>
  <!-- end of 4 data cards -->

  <div class="cbutton">
    <a href="${System.getenv("HOST_URL")}/dashboard/employee/create">
      <button class="createbutton">Create </button></a>
  </div>

  <div class="main-tables">
    <table id="example" class="table" cellspacing="0" width="100%">
      <thead>
      <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>District</th>
        <th>Role</th>
        <th>Status</th>
        <th>Created At</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tfoot>
      <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>District</th>
        <th>Role</th>
        <th>Status</th>
        <th>Created At</th>
        <th>Actions</th>
      </tr>
      </tfoot>

      <tbody>
      <%
        
        List<User> users = (ArrayList<User>)request.getAttribute("users");
        List<Creds> creds = (ArrayList<Creds>)request.getAttribute("creds");

        Hashtable<Character, String> role_values = new Hashtable<Character, String>();
        
        role_values.put('A',"Admin");
        role_values.put('F',"Finance Admin");
        role_values.put('S',"Support Team");
        role_values.put('C',"Creator");
        role_values.put('I',"Investor");

        Hashtable<Character, String> status_values = new Hashtable<Character, String>();

        status_values.put('A',"Active");
        status_values.put('B',"Blocked");
        status_values.put('D',"Deleted");
        
        for (int i=0; i<users.size();i++){
      %>
      <tr>
        <th><% out.print(users.get(i).getUserId());%></th>
        <td><% out.print(users.get(i).getFirstName());%></td>
        <td><% out.print(users.get(i).getLastName());%></td>
        <td><% out.print(creds.get(i).getEmail());%></td>
        <td><% out.print(users.get(i).getPhone());%></td>
        <td><% out.print(users.get(i).getAddress());%></td>
        <td><% out.print(users.get(i).getDistrict());%></td>
        <td><% out.print(role_values.get(creds.get(i).getRole()));%></td>
        <td><% out.print(status_values.get(creds.get(i).getStatus()));%></td>
        <td><% out.print(new Date(users.get(i).getCreatedAt().getTime()));%></td>
        <td>

        <button class="updatebutton" id="idUpdateButton" style=":hover{cursor: pointer;}" onclick="window.location.href='${System.getenv("HOST_URL")}/dashboard/employee/update/<% out.print(users.get(i).getUserId());%>'">Update</button>

        <button class="deletebutton" id="idDeleteButton" onclick="deleteIt()">Delete</button>
        </td>
      </tr>
      <%}%>


      </tbody>
    </table>
  </div>






</main>


<!-- javascipt -->
<script>

  $(document).ready(function() {

    var table = $('#example').DataTable({
      select: false,
      "columnDefs": [{
        className: "Name",
        "targets":[0],
        "visible": false,
        "searchable":false
      }]
    });

    //End of create main table

  });

  function deleteIt(confirm_value){

    Swal.fire({
      title: 'Delete confirmation',
      input: 'text',
      inputLabel: 'Enter the employee username in the given box',
      inputPlaceholder: 'some-username',
      iconColor: "#900",
      confirmButtonColor: "#900",
      showCancelButton: true,
      preConfirm: (confirm) => {
        console.log(${request.getPathInfo()});
        return fetch(`${request.getPathInfo()}`)
                .then(response => {
                  if (!response.ok) {
                    throw new Error(response.statusText)
                  }
                  return response.json()
                })
                .catch(error => {
                  Swal.showValidationMessage(
                          `Request failed: ${error}`
                  )
                })
      },
      allowOutsideClick: () => !Swal.isLoading()
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          title: `${result.value.login}'s avatar`,
          imageUrl: result.value.avatar_url
        })
      }
    })

  }

</script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>