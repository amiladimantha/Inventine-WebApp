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
<script src="${host_url}/static/js/forum.js"></script>

<div class="content" id="content">
    <!-- description and image start -->
    <div class="container">
        <div class="column-1">
            <h1>MAKE YOUR IDEAS WORKABLE!</h1>
            <span class="paragraph">We are inventine, who makes tour Ideas get funded and mentoring to enhance the business process.</span>
            <div class="search-bar">
                <table class="search-bar-element">
                    <tr>
                        <td>
                            <input type="text" placeholder="Search" class="search">
                        </td>
                        <td>
                            <a href="#"><i class="fas fa-search" style="color:#424242"></i></a>
                        </td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="column-2">
            <div class="image-slider-cont">
                <div class="image-slider">
                    <div class="slideshow-container">

                        <!-- Full-width images with number and caption text -->
                        <div class="mySlides fade">
                            <div class="numbertext">1 / 3</div>
                            <img src="https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg" style="width:100%">
                            <div class="text">Caption Text</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 3</div>
                            <img src="https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg" style="width:100%" >
                            <div class="text">Caption Two</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 3</div>
                            <img src="https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg" style="width:100%">
                            <div class="text">Caption Three</div>
                        </div>

                        <!-- Next and previous buttons -->
                        <!-- <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a> -->
                    </div>
                    <br>

                    <!-- The dots/circles -->
                    <!-- <div style="text-align:center">
                      <span class="dot" onclick="currentSlide(1)"></span>
                      <span class="dot" onclick="currentSlide(2)"></span>
                      <span class="dot" onclick="currentSlide(3)"></span>
                    </div> -->
                </div>

            </div>
        </div>
    </div>
    <!-- discription and image end -->

</div>

<div class="forum">
    <div class="forum-cont-main">
        <div class="forum-cont" id="forum-cont">
            <div class="container-2">
                <div class="grid-container">
                    <div class="item1">Community Activity</div>
                    <div class="item23">
                        <div class="item2"><label>Sorted by: </label></div>
                        <div class="item3">
                            <select class="dropbox" name="" id="">
                                <option value="">Most Recent</option>
                                <option value="">Most Viewed</option>
                                <option value="">Most Commented</option>
                                <option value="">Most Helpful</option>
                            </select>
                        </div>
                    </div>
                    <div class="item4"><button onclick="document.getElementById('cont').style.display='block';make_blur('content'); ;make_blur('main');make_blur('forum-cont');make_blur('menu');make_blur('post');" class="button2">Start Conversation</button></div>
                </div>
            </div>
            <div class="posts" id="post">
                <%
                    for ( ForumTopic forumTopic: (ArrayList<ForumTopic>)request.getAttribute("forumTopic")){
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
<%--                                Latest reply by <label>User</label> on <% dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");--%>
<%--                                out.print(dtf.format(forumTopic.getLatest_reply().toLocalDateTime()));%> <label>--%>
<%--                                &lt;%&ndash;                                <%out.print(dtf.format(forumTopic.getDateStr().toLocalDateTime()));%>>&ndash;%&gt;--%>
<%--                            </label>--%>
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
                        <div class="like-btn" id="like-btn">
                            <button id="like-btn-1" onclick=" postID = <%out.print(forumTopic.getPostId());%>;document.getElementById('like-btn-1').style.display='none';document.getElementById('like-btn-2').style.display='block';Like_function();">Like</button>
                            <button id="like-btn-2" style="display:none;" onclick="postID = <%out.print(forumTopic.getPostId());%>;document.getElementById('like-btn-1').style.display='block';document.getElementById('like-btn-2').style.display='none';">Unlike</button>
                        </div>
                        <div class="unlike-btn" style="display: none">
                            <button>Dislike</button>
                        </div>
                        <div class="reply-btn">
                            <button onclick="forumTopicID=<%out.print(forumTopic.getForumTopicId());%>;document.getElementById('forumTopicID').value=<%out.print(forumTopic.getForumTopicId());%>;document.getElementById('cont-reply').style.display='block';make_blur('content');make_blur('main');make_blur('forum-cont');make_blur('menu')">Reply</button>
                        </div>
                        <div class="view-post">
                            <button onclick="window.location.href='<%=System.getenv("HOST_URL")%>/forum/view?id=<%out.print(forumTopic.getForumTopicId());%>&sc=1';">View</button>
                        </div>
                    </div>

                </div>

                <%}%>
            </div>


        </div>
        <div class="forum-cont-category">
            <div class="container-2">
            </div>
        </div>
    </div>
    <div class="forum-categories">
        <div class="grid-container-3">
            <div class="category-title">
                <div class="cat-icon">

                </div>
            </div>
            <div class="categories">

            </div>
        </div>
    </div>
</div>

<div class="container-form" style="display:none;z-index:100;" id="cont">
    <div class="content_forum">
        <div class="form">

            <!-- input boxes start -->
            <div class="details">

                <div class="input-box">
                    <span class="details">Title</span>
                    <input type="text"
                           name="title" id="title"  required >
                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>



                <div class="input-box">
                    <span class="details">Description</span>
                    <textarea rows="4" class="description-textarea" type="text"  name="description" id="description"  required ></textarea>

                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>

                <!-- input boxes end -->
                <div class="form_btn">
                    <button class="btn-cancel" type="button" id="cancelBtn" onclick="document.getElementById('cont').style.display='none';cancel_blur('content');cancel_blur('main');cancel_blur('forum-cont');cancel_blur('menu')">Cancel</button>
                    <button class="btn-create" onclick="signupValidation();document.getElementById('cont').style.display='none';cancel_blur('content');cancel_blur('main');cancel_blur('forum-cont');cancel_blur('menu')">Create</button>
                </div>

            </div>
        </div>
    </div>


    <script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/validate.js"></script>

    <script>

        function signupValidation(){
            y = new Array;
            y.push(document.getElementById("title"));
            y.push(document.getElementById("description"));
            // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
            // y = y.concat(z);

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
                window.location.href+"?type=0",
                'Forum post is created successfully!',
                '${host_url}forum?type=0'


            )
        }


        function replyValidation(){
            y = new Array;
            // let st = window.location.href.toString();
            // st = st.split("?")[0]}
            // y.push(document.getElementById("postID"));
            // y.push(postID);
            y.push(document.getElementById("forumTopicID"));
            y.push(document.getElementById("description-reply"));
            // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
            // y = y.concat(z);

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

                // if(!y[i].checkValidity()){
                //
                //     Swal.fire({
                //         icon: 'error',
                //         title: 'Form fields should be valid!',
                //         iconColor: "#0097e6",
                //         confirmButtonColor: "#0097e6",
                //     });
                //
                //     return false;
                // }

            }



            requestHandler(
                y,
                "${host_url}forum/forumreply",
                'Forum reply is created successfully!',
                '${host_url}forum?type=0'
            )
        }

        function Like_function(){
            y = new Array;
            // y.push(document.getElementById("postID"));
            y.push(document.getElementById("postID"));
            // y.push(document.getElementById("forumTopicID"));
            // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
            // y = y.concat(z);

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

                // if(!y[i].checkValidity()){
                //
                //     Swal.fire({
                //         icon: 'error',
                //         title: 'Form fields should be valid!',
                //         iconColor: "#0097e6",
                //         confirmButtonColor: "#0097e6",
                //     });
                //
                //     return false;
                // }

            }



            requestHandler(
                y,
                window.location.href+"/forum/postLike",
                'Liked!',
                '${host_url}/forum?type=0'


            )
        }

        function Unlike_function(){
            y = new Array;
            // y.push(document.getElementById("postID"));
            y.push(postID);
            // y.push(document.getElementById("forumTopicID"));
            // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
            // y = y.concat(z);

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

                // if(!y[i].checkValidity()){
                //
                //     Swal.fire({
                //         icon: 'error',
                //         title: 'Form fields should be valid!',
                //         iconColor: "#0097e6",
                //         confirmButtonColor: "#0097e6",
                //     });
                //
                //     return false;
                // }

            }



            requestHandler(
                y,
                window.location.href+"/forumreply",
                'UnLiked!',
                '${host_url}/forum'


            )
        }

        function Views_function(){
            y = new Array;
            // y.push(document.getElementById("postID"));
            y.push(forumTopicID);
            // y.push(document.getElementById("forumTopicID"));
            // z = Array.prototype.slice.call(document.getElementsByTagName("select"));
            // y = y.concat(z);

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

                // if(!y[i].checkValidity()){
                //
                //     Swal.fire({
                //         icon: 'error',
                //         title: 'Form fields should be valid!',
                //         iconColor: "#0097e6",
                //         confirmButtonColor: "#0097e6",
                //     });
                //
                //     return false;
                // }

            }



            requestHandler(
                y,
                window.location.href,
                'Forum Post Loading...',
                '${host_url}/forum/view?id='+forumTopicID+'&sc=1',


            )
        }



    </script>

    <script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/dashboard.js"></script>
    <script src="${host_url}/static/js/forum.js"></script>
</div>
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




<%@ include file="/WEB-INF/components/footer.jsp" %>
</body>
</html>