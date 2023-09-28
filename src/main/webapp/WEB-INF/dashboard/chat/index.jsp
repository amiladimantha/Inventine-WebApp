<%@ page import="com.inventine.model.Chat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/chat.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>



<main id="main">

    <div class="main-container">
        <div class="container">
            <div class="side-nav">
                <div class="profile">
                    <img style="width: 50px;height: 50px;" src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80">
                </div>
                <div class="icon-container">
                    <i class="fa fa-home"></i>
                </div>
                <div class="icon-container">
                    <i class="fas fa-calendar"></i>
                </div>
                <div class="icon-container active">
                    <i class="fa fa-comment-alt"></i>
                </div>
                <div class="icon-container">
                    <i class="fa fa-list"></i>
                </div>
                <div class="icon-container">
                    <i class="fa fa-sticky-note"></i>
                </div>
            </div>
            <div class="main-veiw">
                <div class="top-nav">
                    <div class="logo">CHAT</div>
                </div>
                <div class="content">
                    <div class="message-list">
                        <div class="list-top">
                            <input type="text">
                            <button class="search">
                                <i class="fa fa-search"></i>
                            </button>
                            <button class="add">
                                +
                            </button>
                            <button class="close-list">
                                <i class="fa fa-chevron-left"></i>
                            </button>
                        </div>
                        <div class="list">
                            <div class="contact unread">
                                <div class="icon">
                                    <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="kitten-image">
                                </div>
                                <div class="blurb">
                                    <h2 class="name">
                                        Emily Wilson
                                    </h2>
                                </div>
                            </div>
                            <div class="contact unread active">
                                <div class="icon">
                                    <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="kitten-image">
                                </div>
                                <div class="blurb">
                                    <h2 class="name">
                                        Jane Doe
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chat">
                        <div class="top">
                            <div class="open-message">
                                <i class="fa fa-chevron-left"></i>
                            </div>
                            <div class="name" id="open">
                                Jane Doe
                            </div>
                            <div class="button-container">
                                <button>
                                    <i class="fa fa-phone"></i>
                                </button>
                                <button>
                                    <i class="fa fa-camera"></i>
                                </button>
                                <button>
                                    <i class="fa fa-folder"></i>
                                </button>
                            </div>
                        </div>
                        <div class="message-container">
                            <%
                                String me = (String)request.getSession().getAttribute("userid");
                                List<Chat> chats = (ArrayList<Chat>)request.getAttribute("chats");
                                for(Chat chat: chats) {  %>
                            <div class="comment <% if (me == (String)chat.getSenderId()){
                                out.print("me");
                                }else{
                                out.print("other");}%>">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    <%out.print(chat.getMessage());%>
                                </div>
                            </div>
                            <% }%>
                        </div>
                        <div class="input-container">
                            <button class="attach">
                                <i class="fa fa-paper-plane"></i>
                            </button>
                            <div class="textarea-container">
                                <textarea type="text" placeholder="message"></textarea>
                            </div>
                            <button class="send">
                                <i class="fa fa-paper-plane"></i>
                            </button>
                        </div>
                    </div>
                    <div class="contact-detail">
                        <button class="close">
                            x
                        </button>
                        <img src="https://placekitten.com/200/200?image=2" alt="">
                        <h3>Jane Doe</h3>
                        <div class="bio">
                            A bunch of great weirdos
                        </div>
                        <ul class="contact-list">
                            <li>
                                <img class="contact-img" src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <span class="name">
                    Maria Hugges
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <span class="name">
                    Lucy Farrel
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://placekitten.com/540/540" alt="">
                                <span class="name">
                    Your Neighbor
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://placekitten.com/550/555" alt="">
                                <span class="name">
                    Sam Willis
                  </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>





</main>





<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>