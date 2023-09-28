<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- sidebar start -->
<div class="sidebar">

    <!--div for logo and hamburger button -->
    <div class="logo-details">
        <a href="${System.getenv("HOST_URL")}/" style="text-decoration: none;">
            <div class="logo_name">inventine </div>
        </a>
        <i class="bx bx-menu" id="btn" ></i>
    </div>

    <!-- sidebar list start -->


    <ul class="nav-list">

        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard">
                <i class="fab fa-dashcube"></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>

        <% if(session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/employee">
                <i class="fas fa-users-cog"></i>
                <span class="links_name">Employee</span>
            </a>
        </li>
        <%}%>

        <%--    <% if(session.getAttribute("role").toString().charAt(0) == 'C' ||--%>
        <%--            session.getAttribute("role").toString().charAt(0) == 'F' ||--%>
        <%--            session.getAttribute("role").toString().charAt(0) == 'S'){--%>
        <%--    %>--%>
        <%--    <li>--%>
        <%--      <a href="${System.getenv("HOST_URL")}/dashboard/investor">--%>
        <%--        <i class="fas fa-money-check-alt"></i>--%>
        <%--        <span class="links_name">Investors</span>--%>
        <%--      </a>--%>
        <%--    </li>--%>
        <%--    <%}%>--%>

        <%--    <% if(session.getAttribute("role").toString().charAt(0) == 'C' ||--%>
        <%--            session.getAttribute("role").toString().charAt(0) == 'F' ||--%>
        <%--            session.getAttribute("role").toString().charAt(0) == 'S'){--%>
        <%--    %>--%>
        <%--    <li>--%>
        <%--      <a href="${System.getenv("HOST_URL")}/dashboard/creator">--%>
        <%--        <i class="fas fa-chalkboard-teacher fa-2x"></i>--%>
        <%--        <span class="links_name">Creators</span>--%>
        <%--      </a>--%>
        <%--    </li>--%>
        <%--    <%}%>--%>


        <% if(
                session.getAttribute("role").toString().charAt(0) == 'A'||
                        session.getAttribute("role").toString().charAt(0) == 'S'||
                        session.getAttribute("role").toString().charAt(0) == 'F'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/employee">
                <i class="fas fa-user-alt"></i>
                <span class="links_name">Customer</span>
            </a>
        </li>
        <%}%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'S' ||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/project">
                <i class="far fa-lightbulb"></i>
                <span class="links_name">Projects</span>
            </a>
        </li>
        <%}%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'S' ||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/meeting">
                <i class="fas fa-people-carry"></i>
                <span class="links_name">Meetings</span>
            </a>
        </li>
        <%}%>

        <% if(
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'S' ||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/issue">
                <i class="fas fa-ticket-alt"></i>
                <span class="links_name">Issues</span>
            </a>
        </li>
        <%}%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'O'||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/payment">
                <i class="fas fa-funnel-dollar"></i>
                <span class="links_name">Transactions</span>
            </a>
        </li>
        <%}%>

        <% if(
                session.getAttribute("role").toString().charAt(0) == 'S'||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/validation">
                <i class="fas fa-check"></i>
                <span class="links_name">Validations</span>
            </a>
        </li>
        <%}%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'A'||
                session.getAttribute("role").toString().charAt(0) == 'S'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/organization">
                <i class="far fa-building"></i>
                <span class="links_name">Organization</span>
            </a>
        </li>
        <%}%>


        <% if(
                session.getAttribute("role").toString().charAt(0) == 'A'||
                session.getAttribute("role").toString().charAt(0) == 'S'||
                session.getAttribute("role").toString().charAt(0) == 'O'||
                session.getAttribute("role").toString().charAt(0) == 'F'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/dashboard/competition">
                <i class="fas fa-trophy"></i>
                <span class="links_name">Competition</span>
            </a>
        </li>
        <%}%>


                <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                        session.getAttribute("role").toString().charAt(0) == 'C' ||
                        session.getAttribute("role").toString().charAt(0) == 'F' ||
                        session.getAttribute("role").toString().charAt(0) == 'S' ||
                        session.getAttribute("role").toString().charAt(0) == 'O'||
                        session.getAttribute("role").toString().charAt(0) == 'A'){
                %>
                <li>
                    <a href="${System.getenv("HOST_URL")}/dashboard/chat">
                        <i class="fas fa-comments"></i>
                        <span class="links_name">Chat</span>
                    </a>
                </li>
                <%}%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'S' ||
                session.getAttribute("role").toString().charAt(0) == 'O'||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li>
            <a href="${System.getenv("HOST_URL")}/forum?type=0">
                <i class="far fa-comment-alt"></i>
                <span class="links_name">Forum</span>
            </a>
        </li>
        <%}%>

        <%--        <% if( session.getAttribute("role").toString().charAt(0) == 'A'){--%>
        <%--        %>--%>
        <%--        <li>--%>
        <%--            <a href="${System.getenv("HOST_URL")}/dashboard/supportTeam">--%>
        <%--                <i class="fas fa-hands-helping"></i>--%>
        <%--                <span class="links_name">Support Team</span>--%>
        <%--            </a>--%>
        <%--        </li>--%>
        <%--        <%}%>--%>

        <%--        <% if( session.getAttribute("role").toString().charAt(0) == 'A'){--%>
        <%--        %>--%>
        <%--        <li>--%>
        <%--            <a href="${System.getenv("HOST_URL")}/dashboard/financeAdmin">--%>
        <%--                <i class="fas fa-suitcase"></i>--%>
        <%--                <span class="links_name">Finance Admin</span>--%>
        <%--            </a>--%>
        <%--        </li>--%>
        <%--        <%}%>--%>

        <%--    <li>--%>
        <%--      <a href="sitesettings.html">--%>
        <%--        <i class="fas fa-cog"></i>--%>
        <%--        <span class="links_name">Site Settings</span>--%>
        <%--      </a>--%>
        <%--    </li>--%>

        <% if(session.getAttribute("role").toString().charAt(0) == 'I' ||
                session.getAttribute("role").toString().charAt(0) == 'C' ||
                session.getAttribute("role").toString().charAt(0) == 'F' ||
                session.getAttribute("role").toString().charAt(0) == 'S' ||
                session.getAttribute("role").toString().charAt(0) == 'A'){
        %>
        <li class="logout">
            <a href="${System.getenv("HOST_URL")}/logout">
                <i class="fas fa-sign-out-alt"></i>
                <span class="links_name">Logout</span>
            </a>
        </li>
        <%}%>
    </ul>
    <!-- sidebar list end -->

</div>
<!-- sidebar end -->