<%@ include file="../template/dashboard/base.jsp" %>
<%--Side Bar--%>
<div class="sidebar-menu">
        <ul>
            <li>
                <a href="../dashboard/dashboard.html" ><span><i class="fab fa-dashcube"></i></span>
                    <span>Dashboard</span></a>
            </li>
            <li>
                <a href="../users/users.html" class="active"><span><i class="fas fa-users-cog"></i></span>
                    <span>Users</span></a>
            </li>
            <li>
                <a href="../projects/projects.html"><span><i class="far fa-lightbulb"></i></span>
                    <span>Projects</span></a>
            </li>
            <li>
                <a href="../meetings/meetings.html"><span><i class="fas fa-people-carry"></i></span>
                    <span>Meetings</span></a>
            </li>
            <li>
                <a href="../issues/issues.html" ><span><i class="fas fa-ticket-alt"></i></span>
                    <span>Issues</span></a>
            </li>
            <li>
                <a href="../transactions/transactions.html"><span><i class="fas fa-funnel-dollar"></i></span>
                    <span>Transactions</span></a>
            </li>
            <li>
                <a href="../support team/support team.html"><span><i class="fas fa-hands-helping"></i></span>
                    <span>Support T.</span></a>
            </li>
            <li>
                <a href="../finance admin/finance admin.html" ><span><i class="fas fa-suitcase"></i></span>
                    <span>Finance A.</span></a>
            </li>
            <li>
                <a href=""><span><i class="fas fa-cog"></i></span>
                    <span>Site Settings</span></a>
            </li>
        </ul>
    </div>
    <div class="sidebar-logout">
        <ul>
            <li>
                <a href="../homepage/homepage.html"><span><i class="fas fa-sign-out-alt"></i></span>
                    <span>Logout</span></a>
            </li>
        </ul>
    </div>
</div>

<div class="main-content">

    <%@ include file="../template/dashboard/nav.jsp" %>

    <main>

        <div class="cards">
            <div class="cards-singlefirst">
                <div>
                    <span>Creators</span>
                    <h1>120</h1>
                </div>
            </div>
            <div class="cards-singlesecond">
                <div>
                    <span>Projects</span>
                    <h1>56</h1>
                </div>
            </div><div class="cards-singlethird">
            <div>
                <span>Meetings</span>
                <h1>383</h1>
            </div>
        </div>

            <div class="cards-singlefourth">
            <div>
                <span>Investors</span>
                <h1>127</h1>
            </div>
        </div>


        </div>

            <div class="container">
                <div>
                    <canvas id="canvas"></canvas>
                </div>
            </div>

    </main>


</div>

<script >

    var dData = function() {
        return Math.round(Math.random() * 90) + 10
    };

    var barChartData = {
        labels: ["dD 1", "dD 2", "dD 3", "dD 4", "dD 5", "dD 6", "dD 7", "dD 8", "dD 9", "dD 10"],
        datasets: [{
            fillColor: "rgba(0,60,100,1)",
            strokeColor: "black",
            data: [dData(), dData(), dData(), dData(), dData(), dData(), dData(), dData(), dData(), dData()]
        }]
    }

    var index = 11;
    var ctx = document.getElementById("canvas").getContext("2d");
    var barChartDemo = new Chart(ctx).Bar(barChartData, {
        responsive: true,
        barValueSpacing: 2
    });
    setInterval(function() {
        barChartDemo.removeData();
        barChartDemo.addData([dData()], "dD " + index);
        index++;
    }, 3000);


</script>


</body>

</html>