<%@ page import="com.inventine.model.Post" %>
<%@ page import="com.inventine.model.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.ForumTopic" %>
<%@ page import="com.inventine.dao.PostDaoImplementation" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.inventine.model.ForumReply" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${host_url}/static/css/home.css">
    <link rel="stylesheet" href="${host_url}/static/css/dashboard/forum_form.css">
    <link rel="stylesheet" href="${host_url}/static/css/forum.css">


</head>
<body>
<script>
    let postID;
    let forumTopicID;
</script>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>


<div class="container-form" style="display:none;z-index:100;" id="cont-reply">
    <div class="content_forum" >

        <div class="form">

            <!-- input boxes start -->
            <div class="details">


                <div class="input-box">
                    <span class="details">Reply</span>
                    <input type="hidden" name="forumTopicID" id="forumTopicID">
                    <textarea rows="4" class="description-textarea" type="text"  name="description-reply" id="description-reply"  required ></textarea>

                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>

                <!-- input boxes end -->

                <div class="form_btn">
                    <button class="btn-cancel" type="button" id="cancelBtn-reply" onclick="document.getElementById('cont-reply').style.display='none';cancel_blur('content');cancel_blur('main');cancel_blur('forum-cont');cancel_blur('menu')">Cancel</button>
                    <button class="btn-create" onclick="replyValidation();document.getElementById('cont-reply').style.display='none';cancel_blur('content');cancel_blur('main');cancel_blur('forum-cont');cancel_blur('menu')">Create</button>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="forumReply"  id="reply-posts">
    <div class="content_forum">
        <div class="posts" style="background: #a6cbff">
            <%
                ForumTopic forumTopic= (ForumTopic)request.getAttribute("forumTopic");
            %>

            <div class="grid-container-2">

                <div class="post-header">
                    <div class="post-header-container-1">
                        <div class="profile-pic">
                            <img style="width: 120px; height: 120px; vertical-align:super;" src="${System.getenv("HOST_URL")}/image/<%out.print(forumTopic.getImage());%>">
                        </div>
                        <div class="post-title">
                            <% out.print(forumTopic.getTitle());%>
                        </div>
                        <div class="time">
                            <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
                                out.print(dtf.format(forumTopic.getCreatedAt().toLocalDateTime()));%>
                        </div>
                        <div class="profile-owner">
                            <% out.print("Author " + forumTopic.getFirstName() + " " + forumTopic.getLastName());%>
                        </div>
                        <div class="latest-reply" >
                            Latest reply by <label>User</label> on <label>
                            <%--                                <%out.print(dtf.format(forumTopic.getDateStr().toLocalDateTime()));%>>--%>
                        </label>
                        </div>
                        <div class="catogory">
                            Posted in <label>Catogory</label>
                        </div>
                    </div>
                    <div class="post-header-container-2">
                        <div class="like-amount">
                            <div class="like">
                                <i class="fas fa-thumbs-up "></i>
                            </div>
                            <div class="amount">
                                <% out.print(forumTopic.getLikeAmount()); %>
                            </div>
                        </div>
                        <div class="views-amount">
                            <div class="views">
                                <i class="fas fa-eye"></i>
                            </div>
                            <div class="amount">
                                <%out.print(forumTopic.getViews());%>
                            </div>
                        </div>
                        <div class="comment-amount">
                            <div class="comments">
                                <i class="fas fa-comment"></i>
                            </div>
                            <div class="amount">
                                <%out.print(forumTopic.getReplyAmount());%>
                            </div>
                        </div>
                    </div>
                </div>
                <%--                <div class="post-title">--%>
                <%--                    <% out.print(forumTopic.getTitle());%>--%>
                <%--                </div>--%>
                <div class="post-cont">
                    <% out.print(forumTopic.getDescription());%>
                </div>

                <div class="post-footer">
                    <%--                    <div class="time">--%>
                    <%--                        <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");--%>
                    <%--                            out.print(dtf.format(forumTopic.getCreatedAt().toLocalDateTime()));%>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="catogory">--%>
                    <%--                        Posted in <label>Catogory</label>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="latest-reply">--%>
                    <%--                        Latest reply by <label>User</label> on <label>30/05/2021 05:30:21 PM</label>--%>
                    <%--                    </div>--%>
                    <div class="like-btn">
                        <button >Like</button>
                    </div>
                    <div class="reply-btn">
                        <button id=<%out.print(forumTopic.getPostId());%> onclick="document.getElementById('forumTopicID').value=<%out.print(forumTopic.getForumTopicId());%>;document.getElementById('cont-reply').style.display='block';make_blur('content');make_blur('main');make_blur('forum-cont');make_blur('menu')">Reply</button>
                    </div>
                    <div class="view-post">
                        <button onclick="window.location.href='/inventine_war/forum?type=0'">Back</button>
                    </div>
                </div>

            </div>


        </div>
        <div class="posts">
            <%
                for ( ForumReply forumReply: (ArrayList<ForumReply>)request.getAttribute("forumReply")){
            %>

            <div class="grid-container-2">

                <div class="post-header" style="grid-template-areas: 'post-header-container-1  post-header-container-2';">
                    <div class="post-header-container-1" style="grid-template-areas:
                                                                                    'profile-pic profile-owner time1'
                                                                                    'profile-pic . .';">
                        <div class="profile-pic" >
                            <img style="width: 120px; height: 120px; vertical-align:super;top: 50%" src="${System.getenv("HOST_URL")}/image/<%out.print(forumReply.getImage());%>">
                        </div>

                        <div class="time" style="top: 0%">
                            <% DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm");
                                out.print("Posted on " + dtf2.format(forumReply.getCreatedAt().toLocalDateTime()));%>
                        </div>
                        <div class="profile-owner" style="top: 0%">
                            <% out.print(forumReply.getFirstName() + " " + forumReply.getLastName());%>
                        </div>

                    </div>
                    <div class="post-header-container-2" style="grid-template-areas: '. like-amount';">
                        <div class="like-amount" style="grid-template-areas: '. like amount';">
                            <div class="like">
                                <i class="fas fa-thumbs-up "></i>
                            </div>
                            <div class="amount">
                                <% out.print(forumReply.getAmount()); %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="post-cont">
                    <% out.print(forumReply.getDescription());%>
                </div>

                <div class="post-footer" style="grid-template-areas: 'like-btn';">
                    <%--                    <div class="time">--%>
                    <%--                        <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");--%>
                    <%--                            out.print(dtf.format(forumTopic.getCreatedAt().toLocalDateTime()));%>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="catogory">--%>
                    <%--                        Posted in <label>Catogory</label>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="latest-reply">--%>
                    <%--                        Latest reply by <label>User</label> on <label>30/05/2021 05:30:21 PM</label>--%>
                    <%--                    </div>--%>
                    <div class="like-btn" style="padding-left: 60%;">
                        <button >Like</button>
                    </div>
                    <%--                        <div class="reply-btn">--%>
                    <%--                            <button id=<%out.print(forumTopic.getPostId());%> onclick="document.getElementById('forumTopicID').value=<%out.print(forumTopic.getForumTopicId());%>;console.log(this.id);document.getElementById('cont-reply').style.display='block';make_blur('content');make_blur('main');make_blur('forum-cont');make_blur('menu')">Reply</button>--%>
                    <%--                        </div>--%>
                    <%--                        <div class="view-post">--%>
                    <%--                            <button onclick="console.log(document.getElementById('reply-posts').value);document.getElementById('reply-posts').style.display='block';make_blur('content');/make_blur('main');make_blur('forum-cont');make_blur('menu')/;">Back</button>--%>
                    <%--                        </div>--%>
                </div>


            </div>

            <%}%>
        </div>
    </div>
</div>



<%@ include file="/WEB-INF/components/footer.jsp" %>
</body>
</html>