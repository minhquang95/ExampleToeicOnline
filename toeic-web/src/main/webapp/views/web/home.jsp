<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
</head>
<body>
<div class="container">

    <!--Carousel
==================================================-->

    <div id="myCarousel" class="carousel slide">
        <div class="carousel-inner">

            <div class="active item">
                <div class="container">
                    <div class="row">

                        <div class="span6">

                            <div class="carousel-caption">
                                <h1>Hướng dẫn phần nghe, đọc toeic</h1>
                                <p class="lead">Chúng tôi cung cấp cho các bạn những kiến
                                    thức tốt nhất</p>
                                <a class="btn btn-large btn-primary" href="#">Hãy tham gia
                                    ngay</a>
                            </div>

                        </div>

                        <div class="span6">
                            <img src="template/web/img/slide/slide1.jpg" height="350px"
                                 width="350px">
                        </div>

                    </div>
                </div>




            </div>

            <c:forEach items="${listslidebanner}" var="list">
                <div class="item">

                    <div class="container">
                        <div class="row">

                            <div class="span6">

                                <div class="carousel-caption">
                                    <h1>${list.slidename}</h1>
                                    <p class="lead">${list.slidecontent}</p>
                                    <a class="btn btn-large btn-primary" href="#">Hãy tham gia</a>
                                </div>

                            </div>

                            <div class="span6">
                                <img src="template/web/img/slide/${list.slideimage}"
                                     height="350px" width="350px">
                            </div>

                        </div>
                    </div>

                </div>
            </c:forEach>




        </div>
        <!-- Carousel nav -->
        <a class="carousel-control left " href="#myCarousel"
           data-slide="prev"><i class="icon-chevron-left"></i></a> <a
            class="carousel-control right" href="#myCarousel" data-slide="next"><i
            class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

    </div>
    <!-- /Carousel -->



    <!-- Feature
==============================================-->


    <div class="row feature-box">
        <div class="span12 cnt-title">
            <h1>At vero eos et accusamus et iusto odio dignissimos</h1>
            <span>Contrary to popular belief, Lorem Ipsum is not simply
					random text.</span>
        </div>

        <div class="span4">
            <img src="/template/web/img/icon3.png">
            <h2>Feature A</h2>
            <p>Pellentesque habitant morbi tristique senectus et netus et
                malesuada fames ac turpis egestas.</p>

            <a href="#">Read More &rarr;</a>

        </div>

        <div class="span4">
            <img src="/template/web/img/icon2.png">
            <h2>Feature B</h2>
            <p>Consectetur adipisicing elit, sed do eiusmod tempor
                incididunt ut labore et dolore magna aliqua.</p>
            <a href="#">Read More &rarr;</a>
        </div>

        <div class="span4">
            <img src="/template/web/img/icon1.png">
            <h2>Feature C</h2>
            <p>Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor
                sit amet, ante.</p>
            <a href="#">Read More &rarr;</a>
        </div>
    </div>


    <!-- /.Feature -->

    <div class="hr-divider"></div>

    <!-- Row View -->


    <div class="row">
        <div class="span6">
            <img src="/template/web/img/responsive.png">
        </div>

        <div class="span6">
            <img class="hidden-phone" src="/template/web/img/icon4.png"
                 alt="">
            <h1>Fully Responsive</h1>
            <p>Pellentesque habitant morbi tristique senectus et netus et
                malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat
                vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit
                amet quam egestas semper. Aenean ultricies mi vitae est. Mauris
                placerat eleifend leo.</p>
            <a href="#">Read More &rarr;</a>
        </div>
    </div>


</div>
</body>
</html>