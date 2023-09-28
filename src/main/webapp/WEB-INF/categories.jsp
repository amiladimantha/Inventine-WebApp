<%@ page import="com.inventine.model.Post" %>
<%@ page import="com.inventine.model.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.ForumTopic" %>
<%@ page import="com.inventine.dao.PostDaoImplementation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/categories.css">

</head>
<div>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="content">
    <!-- description and image start -->
    <div class="container">
        <div class="column-1">
            <h1>Category</h1>

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



            <p margin-top: 40px;  style="color: #0097e6; font-size: large;">Success is not the key to happiness.<br> Happiness is the key to success.<br> If you love what you are doing, you will be successful. <br>– Herman Cain</p>

        </div>
        <div class="column-2">
            <div class="image-slider-cont">
                <div class="image-slider">
                    <div class="slideshow-container">

                        <!-- Full-width images with number and caption text -->
                        <div class="mySlides fade">
                            <div class="numbertext">1 / 6</div>
                            <img src="https://foodtank.com/wp-content/uploads/2017/01/Food-Tank-Restaurant-Innovators.jpg" style="width:650px;height: 300px">
                            <div class="text">Food</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 6</div>
                            <img src="http://godmachen.com.mx/wp-content/uploads/2019/07/Desarrollo-de-software-embebido.jpg" style="width:650px;height: 300px" >
                            <div class="text">Software</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 6</div>
                            <img src="https://www.aescampus.lk/wp-content/uploads/2019/09/Dip-in-Multimedia-Technology-1200x600.jpg" style="width:650px;height: 300px">
                            <div class="text">Technology</div>
                        </div>
                        <div class="mySlides fade">
                            <div class="numbertext">4 / 6</div>
                            <img src="https://m.media-amazon.com/images/I/819TEWajJAL._SL1253_.jpg" style="width:650px;height: 300px">
                            <div class="text">Art</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">5 / 6</div>
                            <img src="https://media.bitdegree.org/storage/media/images/online-graphic-design-courses.o.jpg" style="width:650px;height: 300px" >
                            <div class="text">Design</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">6 / 6</div>
                            <img src="https://img.jakpost.net/c/2016/07/27/2016_07_27_8941_1469611578._large.jpg" style="width:650px;height: 300px">
                            <div class="text">Publication</div>
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

    <div class="search-container">
        <div class="search-bar">
            <table class="search-bar-element">
                <tr>
                    <td>
                        <input type="text" placeholder="Search" class="search">
                    </td>
                    <td>
                        <a href="#"><i class="fas fa-search" style="color:#0e4a6c;text-align:right"></i></a>
                    </td>
                </tr>
            </table>
        </div>

    </div>

    <div class="main">
        <ul class="cards">
            <div class="card">
                <div class="card-header">
                    <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                </div>
                <div class="card-body">
                    <span class="tag tag-purple">Popular</span>
                    <h4>
                        How to Keep Going When You Don’t Know What’s Next
                    </h4>
                    <p>
                        The future can be scary, but there are ways to
                        deal with that fear.
                    </p>
                    <div class="user">
                        <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Eyup Ucmaz</h5>
                            <small>Yesterday</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                </div>
                <div class="card-body">
                    <span class="tag tag-pink">Design</span>
                    <h4>
                        10 Rules of Dashboard Design
                    </h4>
                    <p>
                        Dashboard Design Guidelines
                    </p>
                    <div class="user">
                        <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Carrie Brewer</h5>
                            <small>1w ago</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://c0.wallpaperflare.com/preview/483/210/436/car-green-4x4-jeep.jpg" alt="rover" />
                </div>
                <div class="card-body">
                    <span class="tag tag-teal">Technology</span>
                    <h4>
                        Why is the Tesla Cybertruck designed the way it
                        is?
                    </h4>
                    <p>
                        An exploration into the truck's polarising design
                    </p>
                    <div class="user">
                        <img src="https://cbsnews2.cbsistatic.com/hub/i/r/2014/11/15/028d7403-becc-414c-8e0a-96c69478c187/thumbnail/1200x630/956b9f22bd7910836f484686d8eac35b/mark-ruffalo-interview-promo.jpg" alt="user" />
                        <div class="user-info">
                            <h5>July Dec</h5>
                            <small>2h ago</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                </div>
                <div class="card-body">
                    <span class="tag tag-purple">Popular</span>
                    <h4>
                        How to Keep Going When You Don’t Know What’s Next
                    </h4>
                    <p>
                        The future can be scary, but there are ways to
                        deal with that fear.
                    </p>
                    <div class="user">
                        <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Eyup Ucmaz</h5>
                            <small>Yesterday</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                </div>
                <div class="card-body">
                    <span class="tag tag-pink">Design</span>
                    <h4>
                        10 Rules of Dashboard Design
                    </h4>
                    <p>
                        Dashboard Design Guidelines
                    </p>
                    <div class="user">
                        <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Carrie Brewer</h5>
                            <small>1w ago</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://c0.wallpaperflare.com/preview/483/210/436/car-green-4x4-jeep.jpg" alt="rover" />
                </div>
                <div class="card-body">
                    <span class="tag tag-teal">Technology</span>
                    <h4>
                        Why is the Tesla Cybertruck designed the way it
                        is?
                    </h4>
                    <p>
                        An exploration into the truck's polarising design
                    </p>
                    <div class="user">
                        <img src="https://cbsnews2.cbsistatic.com/hub/i/r/2014/11/15/028d7403-becc-414c-8e0a-96c69478c187/thumbnail/1200x630/956b9f22bd7910836f484686d8eac35b/mark-ruffalo-interview-promo.jpg" alt="user" />
                        <div class="user-info">
                            <h5>July Dec</h5>
                            <small>2h ago</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                </div>
                <div class="card-body">
                    <span class="tag tag-purple">Popular</span>
                    <h4>
                        How to Keep Going When You Don’t Know What’s Next
                    </h4>
                    <p>
                        The future can be scary, but there are ways to
                        deal with that fear.
                    </p>
                    <div class="user">
                        <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Eyup Ucmaz</h5>
                            <small>Yesterday</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                </div>
                <div class="card-body">
                    <span class="tag tag-pink">Design</span>
                    <h4>
                        10 Rules of Dashboard Design
                    </h4>
                    <p>
                        Dashboard Design Guidelines
                    </p>
                    <div class="user">
                        <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                        <div class="user-info">
                            <h5>Carrie Brewer</h5>
                            <small>1w ago</small>
                        </div>
                    </div>
                </div>
            </div>

        </ul>
    </div>
</div>




<%@ include file="/WEB-INF/components/footer.jsp" %>
<script src="${System.getenv("HOST_URL")}/static/js/forum.js"></script>
</body>
</html>

