<%@ page import="com.inventine.model.Competition" %>
<%@ page import="com.inventine.model.Organization" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/competition.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/leaderboard.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/organization.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/profile.css">



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <%
        Competition competition = (Competition) request.getAttribute("competition");
        Organization organization = (Organization) request.getAttribute("organization");

    %>

    <div class="container">
        <div class="top-image">
            <img style="height: 100%; width: 100%;" src="https://osr.statisticsauthority.gov.uk/wp-content/uploads/2017/12/Possible-number-swirl.jpg">
        </div>
        <div class="row">
            <div class="left">
                <img class="photo" src="https://digitaltimes-media.s3.amazonaws.com/original_images/ai.jpeg">
                <h4 class="name"><% out.print(competition.getCompetitionName());%></h4>
                <p class="number-stat"> Type:<% out.print(competition.getPType());%>  </p>
                <p class="desc-stat"> By <%  out.print(organization.getName());%></p>
                <div class="desc">
                    <p >You have some experience with R or Python and machine learning basics, but you’re new to computer vision. This competition is the perfect introduction to techniques like neural networks using a classic dataset including pre-extracted features.</p>
                </div>
                <div class="social">
                    <i class="fa fa-facebook-square" aria-hidden="true"></i>
                    <i class="fa fa-twitter-square" aria-hidden="true"></i>
                    <i class="fa fa-tumblr-square" aria-hidden="true"></i>
                </div>
            </div>

            <div class="right">
                <div class="tabs">
                    <button class="tablink" onclick="openPage('Overview', this, '#0097e6','#fff')"id="defaultOpen">Overview</button>
                    <button class="tablink" onclick="openPage('Rules', this, '#0097e6','#fff')" >Rules</button>
                    <button class="tablink" onclick="openPage('Leaderboard', this, '#0097e6','#fff')">Leaderboard </button>
                    <a href=""><button class="tablink" >Join Competition</button></a>
                </div>

                <div class="details">
                    <div id="Overview" class="tabcontent">
                        <div class="tabs-container">
                            <div class="tabs-title">
                                <h4 class="titles">Competition Description</h4>
                            </div>
                            <p>MNIST ("Modified National Institute of Standards and Technology") is the de facto “hello world” dataset of computer vision. Since its release in 1999, this classic dataset of handwritten images has served as the basis for benchmarking classification algorithms. As new machine learning techniques emerge, MNIST remains a reliable resource for researchers and learners alike.

                                In this competition, your goal is to correctly identify digits from a dataset of tens of thousands of handwritten images. We’ve curated a set of tutorial-style kernels which cover everything from regression to neural networks. We encourage you to experiment with different algorithms to learn first-hand what works well and how techniques compare.</p>

                            <div class="tabs-title">
                                <h4 class="titles">Prctice Skills</h4>
                            </div>
                            <li>Computer vision fundamentals including simple neural networks</li>
                            <li>Classification methods such as SVM and K-nearest neighbors</li>


                            <div class="tabs-title">
                                <h4 class="titles">Goal</h4>
                            </div>
                            <p>The goal in this competition is to take an image of a handwritten single digit, and determine what that digit is.
                                For every in the test set, you should predict the correct label.</p>

                            <div class="tabs-title">
                                <h4 class="titles">Metric</h4>
                            </div>
                            <p>This competition is evaluated on the categorization accuracy of your predictions (the percentage of images you get correct).</p>

                            <div class="tabs-title">
                                <h4 class="titles">Submission File Format</h4>
                            </div>
                            <p>The file should contain a header and have the following format:</p>
                            <img class="submission" src="static/img/submission.png">
                        </div>
                    </div>
                </div>

                <div id="Rules" class="tabcontent">
                    <div class="tabs-container">

                        <div class="tabs-title">
                            <h4 class="titles">One account per participant</h4>
                        </div>
                        <p>You cannot sign up to inventine from multiple accounts and therefore you cannot submit from multiple accounts.</p>
                        <div class="tabs-title">
                            <h4 class="titles">No private sharing outside teams</h4>
                        </div>
                        <p>Privately sharing code or data outside of teams is not permitted. It's okay to share code if made available to all participants on the forums.</p>
                        <div class="tabs-title">
                            <h4 class="titles">Team Mergers</h4>
                        </div>
                        <p>Team mergers are not allowed in this competition.</p>
                        <div class="tabs-title">
                            <h4 class="titles">Team Limits</h4>
                        </div>
                        <p>Max participant limit is 100</p>
                        <div class="tabs-title">
                            <h4 class="titles">Submission Limits</h4>
                        </div>
                        <p>You may submit a maximum of 5 entries per day.You may select up to 6 final submissions for judging.</p>
                        <div class="tabs-title">
                            <h4 class="titles">Competition Timeline</h4>
                        </div>
                        <li>Start Date: 7/25/2021 8:43 PM UTC</li>
                        <li>Merger Deadline: None</li>
                        <li>Entry Deadline: None</li>
                        <li>End Date: 1 year from start</li>
                    </div>
                </div>

                <div id="Leaderboard" class="tabcontent">
                    <div class="lead-container">
                        <section id="scrims-ladder--container" class="scrims-ladder">
                            <div class="ladder-nav">
                                <div class="ladder-nav--col ladder-title">
                                    <h1>Standings</h1>
                                </div>
                                <div class="ladder-nav--col">
                                    <input type="text" class="ladder-search" placeholder="Search Team, Player..." />
                                </div>
                            </div>
                            <div class="ladder-nav--results">
                                <div class="ladder-nav--results-col">
                                    <label>Rank</label>
                                </div>
                                <div class="ladder-nav--results-col">
                                    <label>Creator Id</label>
                                </div>
                                <div class="ladder-nav--results-col">
                                    <label>Collected Money</label>
                                </div>
<%--                                <div class="ladder-nav--results-col">--%>
<%--                                    <label>P2</label>--%>
<%--                                </div>--%>
<%--                                <div class="ladder-nav--results-col">--%>
<%--                                    <label>GP</label>--%>
<%--                                </div>--%>
<%--                                <div class="ladder-nav--results-col">--%>
<%--                                    <label>PTS</label>--%>
<%--                                </div>--%>
                            </div>
                            <div class="ladder-nav--results-players">
                                <div class="results-col">
                                    <span class="results-rank"><span class="positions">1</span></span>
                                </div>
                                <div class="results-col">
                                    <span class="results-team">12</span>
                                </div>
                                <div class="results-col">
                                    <span class="results-p1">10000</span>
                                </div>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
                            </div>
                            <!-- JS Loop -->
                            <div class="ladder-nav--results-players">
                                <div class="results-col">
                                    <span class="results-rank"><span class="positions">2</span></span>
                                </div>
                                <div class="results-col">
                                    <span class="results-team">11</span>
                                </div>
                                <div class="results-col">
                                    <span class="results-p1">20000</span>
                                </div>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
                            </div>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">3</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">4</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">5</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">6</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">7</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">8</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">9</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="ladder-nav--results-players">--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-rank"><span class="positions">10</span></span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-team">Nihilum</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p1">Hydramist</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-p2">Reckful</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-gp">7</span>--%>
<%--                                </div>--%>
<%--                                <div class="results-col">--%>
<%--                                    <span class="results-pts">512</span>--%>
<%--                                </div>--%>
                            </div>
                        </section>
                    </div>
                </div>


                <div id="Join" class="tabcontent">
                </div>
            </div>
        </div>
    </div>



</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="${System.getenv("HOST_URL")}/static/js/profile.js"></script>
</body>
</html>
