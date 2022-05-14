<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="description" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>SsookSsook</title>

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico" />

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />
  </head>

  <body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
      <div class="preloader-circle"></div>
      <div class="preloader-img">
        <img src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png" alt="" />
      </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
      <!-- ***** Top Header Area ***** -->
      <div class="top-header-area">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div
                class="top-header-content d-flex align-items-center justify-content-end"
              >
                <!-- Top Header Content -->
                <div class="top-header-meta d-flex" style="float: left">
                  <!-- Language Dropdown -->
                  <div class="language-dropdown">
                    <div class="dropdown">
                      <button
                        class="btn btn-secondary dropdown-toggle mr-30"
                        type="button"
                        id="dropdownMenuButton"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                      >
                        Language
                      </button>
                      <div
                        class="dropdown-menu"
                        aria-labelledby="dropdownMenuButton"
                      >
                        <a class="dropdown-item" href="#">한국어</a>
                        <a class="dropdown-item" href="#">日本語</a>
                        <a class="dropdown-item" href="#">中国語</a>
                      </div>
                    </div>
                  </div>
                  
                <c:if test="${!empty LoginVo}">
                <label style='color : white'>${LoginVo.name }님 환영합니다.</label>&nbsp&nbsp
                 <!-- 회원정보 수정  -->
                  <div class="Sign Up">
                    <a href="EditProfile?id=${LoginVo.id }"
                      ><i class="fa fa-sign-in" aria-hidden="true"></i>
                      <span>Edit Profile</span></a
                    >
                  </div>
                  
                  	<!--  관리자전용 회원관리 페이지 추가 -->
	                  <c:if test='${LoginVo.admin_yn == "Y"}'>
						 <!-- 회원정보 수정  -->
	                  	  <div class="Sign Up">
		                    <a href="EditProfile?id=${LoginVo.id }"
		                      ><i class="fa fa-sign-in" aria-hidden="true"></i>
		                      <span>Management</span></a
		                    >
		                  </div>
					  </c:if>
					  
					  <div class="Sign Up">
		                    <a href="https://kauth.kakao.com/oauth/logout?client_id=e3eced6c366d05e611468e218fc8f42d&logout_redirect_uri=http://211.227.224.199:8081/SS/LogOut"
		                      ><i class="fa fa-sign-in" aria-hidden="true"></i>
		                      <span>Log out</span></a>
		               </div>
                 
                 </c:if>
                 
                 <c:if test="${empty LoginVo}">
  					 <!-- Login -->
                  <div class="login">
                    <a href="LoginForm"
                      ><i class="fa fa-user" aria-hidden="true"></i>
                      <span>Log in</span></a
                    >
                  </div>
                  <!-- Sign Up -->
                  <div class="Sign Up">
                    <a href="JoinForm"
                      ><i class="fa fa-sign-in" aria-hidden="true"></i>
                      <span>Sign Up</span></a
                    >
                  </div>
                  
				 </c:if>

                 
                </div> <!-- TOP -->
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- ***** Navbar Area ***** -->
      <div class="alazea-main-menu">
        <div class="classy-nav-container breakpoint-off">
          <div class="container">
            <!-- Menu -->
            <nav class="classy-navbar justify-content-between" id="alazeaNav">
              <!-- Nav Brand -->
              <a href="main" class="nav-brand"
                ><img src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png" alt=""
              /></a>

              <!-- Navbar Toggler -->
              <div class="classy-navbar-toggler">
                <span class="navbarToggler"
                  ><span></span><span></span><span></span
                ></span>
              </div>

              <!-- Menu -->
              <div class="classy-menu">
                <!-- Close Button -->
                <div class="classycloseIcon">
                  <div class="cross-wrap">
                    <span class="top"></span><span class="bottom"></span>
                  </div>
                </div>

                <!-- Navbar Start -->
                <div class="classynav">
                  <ul style="font-family: SBAggroL">
                    <li><a href="main">Home</a></li>
                    <li><a href="About">회사 소개</a></li>
                    <li><a href="Purchase">제품 구매</a></li>
                    <li><a href="helpQnA?id=${LoginVo.id }">고객센터</a></li>
                    <li><a href="Contact">A/S</a></li>
                  </ul>

                  <!-- Search Icon -->
                  <div id="searchIcon">
                    <i class="fa fa-search" aria-hidden="true"></i>
                  </div>
                </div>
                <!-- Navbar End -->
              </div>
            </nav>

            <!-- Search Form -->
            <div class="search-form">
              <form action="#" method="get">
                <input
                  type="search"
                  name="search"
                  id="search"
                  placeholder="Type keywords &amp; press enter..."
                />
                <button type="submit" class="d-none"></button>
              </form>
              <!-- Close Icon -->
              <div class="closeIcon">
                <i class="fa fa-times" aria-hidden="true"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Hero Area Start ##### -->
    <section class="hero-area">
      <div class="hero-post-slides owl-carousel">
        <!-- Single Hero Post -->
        <div class="single-hero-post bg-overlay">
          <!-- Post Image -->
          <div
            class="slide-img bg-img"
            style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/img1.png)"
          ></div>
          <div class="container h-100">
            <div class="row h-100 align-items-center">
              <div class="col-12">
                <!-- Post Content -->
                <div class="hero-slides-content text-center">
                  <h1 id="title" style="font-size: 55px; text-align: left;">
                    혼자서도 쑥쑥 자라는<br>
                    쑥쑥에 대해 알고 계시나요? 
                  </h1>
                  <p class="sub_title" style="font-size: 17px;">
                    꽃이나 식물은 더 이상 집안의 인테리어 용도로만 쓰이는게 아니라 반려 식물로써 여러분의 가족이 되었습니다. <br>
                    하지만 이런 반려 식물들마저 케어하기엔 너무 바쁘고 서툰 당신에게 쑥쑥을 소개합니다. 
                  </p>
                  <div class="more welcome-btn-group">
                    <a href="#" class="btn alazea-btn active">더 알아보기</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="sub-carousel">
              <ul>
                <li class="active"></li>
                <li class=""></li>
                <li class=""></li>
              </ul>
            </div>
          </div>
        </div>

        <!-- Single Hero Post -->
        <div class="single-hero-post bg-overlay">
          <!-- Post Image -->
          <div
            class="slide-img bg-img"
            style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/img2.png)"
          ></div>
          <div class="container h-100">
            <div class="row h-100 align-items-center">
              <div class="col-12">
                <!-- Post Content -->
                <div class="hero-slides-content text-center">
                  <h1 id="title" style="font-size: 55px; text-align: left;">
                    쑥쑥 유저들은 과연<br>
                    어떤 식물들을 키울까요?
                  </h1>
                  <p class="sub_title" style="font-size: 17px;">
                    가끔 잠이 안오는 날이 있다면 쑥쑥 앱의 가장 깊숙한 곳에 있는 유저들의 비밀공간에 놀러오세요. <br> 다양한 식물 재배 정보를 나눌수도 있고 즐거운 이야기를 할 수도 있답니다.<br> 당신이 생각하지도 못한 다양한 식물을 키우는 쑥쑥 유저들과 함께 소통하는 재미를 느껴보세요.
                  </p>
                  <div class="more welcome-btn-group">
                    <a href="#" class="btn alazea-btn active">더 알아보기</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="sub-carousel">
              <ul>
                <li class=""></li>
                <li class="active"></li>
                <li class=""></li>
              </ul>
            </div>
          </div>
        </div>

        <!-- Single Hero Post -->
        <div class="single-hero-post bg-overlay">
          <!-- Post Image -->
          <div
            class="slide-img bg-img"
            style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/img3.png)"
          ></div>
          <div class="container h-100">
            <div class="row h-100 align-items-center">
              <div class="col-12">
                <!-- Post Content -->
                <div class="hero-slides-content text-center">
                  <h2 id="title" style="font-size: 55px; text-align: left;">
                    자꾸 깜빡깜빡 잊어버리면, <br>
                    식물은 점점 시들어가요
                  </h2>
                  <p class="sub_title" style="font-size: 17px;">
                    사실 모든 식물은 꾸준한 물과 햇빛만 있어도 잘 자랍니다. <br> 하지만 너무나 바쁜 우리는 가끔 그런 사소한 법칙도 자주 잊어먹죠.<br>
                    쑥쑥은 그런 당신을 위해 자동 급수 시스템과 실시간 모니터링 시스템을 제공합니다.
                  </p>
                  <div class="more welcome-btn-group">
                    <a href="#" class="btn alazea-btn active">더 알아보기</a>
                  </div>
                </div>
              </div>
              <div class="multiple-items"></div>
            </div>
          </div>
          <div class="sub-carousel">
            <ul>
              <li class=""></li>
              <li class=""></li>
              <li class="active"></li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Hero Area End ##### -->

    <!-- ##### Service Area Start ##### -->
    <section class="our-services-area bg-gray section-padding-100-0">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <!-- Section Heading -->
            <div class="section-heading text-center">
              <h2>
                쑥쑥과 함께 쑥쑥
              </h2>
              <p style="font-size: small">당신이 바쁜 사이에도 쑥쑥 자라게 해드려요</p>
            </div>
          </div>
        </div>

        <div class="row justify-content-between">
          <div class="col-12 col-lg-5">
            <div class="alazea-service-area mb-100">
              <!-- Single Service Area -->
              <div
                class="single-service-area d-flex align-items-center wow fadeInUp"
                data-wow-delay="100ms"
              >
                <!-- Icon -->
                <div class="service-icon mr-30">
                  <img src="${pageContext.request.contextPath}/resources/img/core-img/waterdrop.png" alt="" />
                </div>
                <!-- Content -->
                <div class="service-content">
                  <h5 class="explain_title">Automatic Watering</h5>
                  <p style="font-family: S-CoreDream-3Light;
                  font-size: 14px;">
                    쑥쑥은 자동 급수 시스템 뿐만 아니라 물통의 수위를 체크하여 급수 시 물이 부족한 일이 없게 도와줍니다. 또한 물통의 수위는 어플로 실시간 확인이 가능합니다.
                  </p>
                </div>
              </div>

              <!-- Single Service Area -->
              <div
                class="single-service-area d-flex align-items-center wow fadeInUp"
                data-wow-delay="300ms"
              >
                <!-- Icon -->
                <div class="service-icon mr-30">
                  <img src="${pageContext.request.contextPath}/resources/img/core-img/check.png" alt="" />
                </div>
                <!-- Content -->
                <div class="service-content">
                  <h5 class="explain_title">Check Status</h5>
                  <p style="font-family: S-CoreDream-3Light;
                  font-size: 14px;">
                    멀리 있어도 가까이 느낄 수 있게! 당신이 어디에 있어도 어플 하나면 쑥쑥이 돌보고 있는 화분들의 상태를 한번에 알게됩니다.
                  </p>
                </div>
              </div>

              <!-- Single Service Area -->
              <div
                class="single-service-area d-flex align-items-center wow fadeInUp"
                data-wow-delay="500ms"
              >
                <!-- Icon -->
                <div class="service-icon mr-30">
                  <img src="${pageContext.request.contextPath}/resources/img/core-img/talk.png" alt="" />
                </div>
                <!-- Content -->
                <div class="service-content">
                  <h5 class="explain_title">Communicate with other users</h5>
                  <p style="font-family: S-CoreDream-3Light;
                  font-size: 14px;">
                    쑥쑥은 '식물덕후'들이 모여있습니다. 당신이 치열하게 고민하던 고민이 쑥쑥 유저 게시판에서 5분만에 해결 될 수도 있습니다! 정말 놀랍지 않나요? 
                  </p>
                </div>
              </div>
            </div>
          </div>

          <div class="col-12 col-lg-6">
            <div class="alazea-video-area bg-overlay mb-100">
              <img src="${pageContext.request.contextPath}/resources/img/bg-img/video.jpeg" alt="" >
              <a
                href="https://www.youtube.com/watch?v=OvioeS1ZZ7o"
                class="video-icon"
              >
                <i class="fa fa-play" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Service Area End ##### -->

    <!-- ##### About Area Start ##### -->
    <section class="about-us-area section-padding-100-0">
      <div class="container">
        <div class="row justify-content-between">
          <div class="col-12 col-lg-5">
            <!-- Section Heading -->
            <div class="section-heading">
              <h2 style="margin-top: 40px;">ABOUT SsookSsook</h2>
              <p>놀라운 성장을 이루고 있는 쑥쑥의 원동력은 <br>바로 고객 여러분입니다.</p>
            </div>

            <!-- Progress Bar Content Area -->
            <div class="alazea-progress-bar mb-50" style="padding-top: 40px;">
              <!-- Single Progress Bar -->
              <div class="single_progress_bar">
                <p>재구매율</p>
                <div id="bar1" class="barfiller">
                  <div class="tipWrap">
                    <span class="tip"></span>
                  </div>
                  <span class="fill" data-percentage="92"></span>
                </div>
              </div>

              <!-- Single Progress Bar -->
             
              <div class="single_progress_bar">
                <p>식물 성장률</p>
                <div id="bar2" class="barfiller">
                  <div class="tipWrap">
                    <span class="tip"></span>
                  </div>
                  <span class="fill" data-percentage="78"></span>
                </div>
              </div>

              <!-- Single Progress Bar -->
              <div class="single_progress_bar">
                <p>암튼 대단함</p>
                <div id="bar3" class="barfiller">
                  <div class="tipWrap">
                    <span class="tip"></span>
                  </div>
                  <span class="fill" data-percentage="85"></span>
                </div>
              </div>

              <!-- Single Progress Bar -->
              <div class="single_progress_bar">
                <p>작년 대비 매출 증가율</p>
                <div id="bar4" class="barfiller">
                  <div class="tipWrap">
                    <span class="tip"></span>
                  </div>
                  <span class="fill" data-percentage="96"></span>
                </div>
              </div>
            </div>
          </div>

          <div class="col-12 col-lg-6">
            <div class="alazea-benefits-area">
              <div class="row">
                <!-- Single Benefits Area -->
                <div class="col-12 col-sm-6">
                  <div class="single-benefits-area">
                    <img src="${pageContext.request.contextPath}/resources/img/core-img/deli.png" alt="" />
                    <h5 class="merit">당일 발송</h5>
                    <p style="font-size: 13px;">
                      오후 4시 이전에 주문하시면 모든 제품을 당일 발송해 드리며 보다 빠른 배송을 위해 우체국 택배로 배송해 드립니다.
                    </p>
                  </div>
                </div>

                <!-- Single Benefits Area -->
                <div class="col-12 col-sm-6">
                  <div class="single-benefits-area">
                    <img src=" ${pageContext.request.contextPath}/resources/img/core-img/qna.png" alt="" />
                    <h5 class="merit">365일 전화 상담</h5>
                    <p style="font-size: 13px;">
                      쑥쑥은 쉬지 않습니다. 연중무휴 오전 10시부터 오후 6시까지 고객님들의 불편을 도와드리기 위해 준비하고 있습니다.
                    </p>
                  </div>
                </div>

                <!-- Single Benefits Area -->
                <div class="col-12 col-sm-6">
                  <div class="single-benefits-area">
                    <img src=" ${pageContext.request.contextPath}/resources/img/core-img/product.png" alt="" />
                    <h5 class="merit">100% 국내 제작</h5>
                    <p style="font-size: 13px;">
                      광주광역시 동구에 있는 제조시설에서 모든 제품을 생산합니다. 고객님이 걱정 없이 쓰실 수 있게 최선을 다 하겠습니다.
                    </p>
                  </div>
                </div>

                <!-- Single Benefits Area -->
                <div class="col-12 col-sm-6">
                  <div class="single-benefits-area">
                    <img src=" ${pageContext.request.contextPath}/resources/img/core-img/repair.png" alt="" />
                    <h5 class="merit">1년 이내 무상 A/S</h5>
                    <p style="font-size: 13px;">
                      제품 구매 후 1년 이내 고장 발생 시 무조건 무상 A/S 해드립니다. 
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="border-line"></div>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### About Area End ##### -->



    <!-- ##### Product Area Start ##### --> 
    <section class="new-arrivals-products-area bg-gray section-padding-100">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <!-- Section Heading -->
            <div class="section-heading text-center">
              <h2>박람회 정보</h2>
              <p style="font-size: 14px;">쑥쑥을 체험해보시고 저렴한 가격에 구매하실 수 있는 진행 예정 박람회입니다.<br>
                (일정은 언제든지 변경 될 수 있습니다.)
              </p>
            </div>
          </div>
        </div>

        <div class="row">
          <!-- Single Product Area -->
          <div class="col-12 col-sm-6 col-lg-3">
            <div
              class="single-product-area mb-50 wow fadeInUp"
              data-wow-delay="100ms"
            >
              <!-- Product Image -->
              <div class="product-img">
                <a href="shop-details.html"
                  ><img src=" ${pageContext.request.contextPath}/resources/img/core-img/poster1.png" alt=""
                /></a>
                <!-- Product Tag -->
                <div class="product-tag">
                  <a href="#">Hot</a>
                </div>
                <div class="product-meta d-flex">
                  <a href="#" class="wishlist-btn"
                    ><i class="icon_heart_alt"></i
                  ></a>
                </div>
              </div>
              <!-- Product Info -->
              <div class="product-info mt-15 text-center">
                <a href="shop-details.html">
                  <p>2022.03.20 ~ 2022.03.22</p>
                </a>
                <h6>전주 정원문화 박람회</h6>
              </div>
            </div>
          </div>

          <!-- Single Product Area -->
          <div class="col-12 col-sm-6 col-lg-3">
            <div
              class="single-product-area mb-50 wow fadeInUp"
              data-wow-delay="200ms"
            >
              <!-- Product Image -->
              <div class="product-img">
                <a href="shop-details.html"
                  ><img src=" ${pageContext.request.contextPath}/resources/img/core-img/poster2.png" alt=""
                /></a>
                <div class="product-meta d-flex">
                  <a href="#" class="wishlist-btn"
                    ><i class="icon_heart_alt"></i
                  ></a>
                </div>
              </div>
              <!-- Product Info -->
              <div class="product-info mt-15 text-center">
                <a href="shop-details.html">
                  <p>2022.03.25 ~ 2022.03.27</p>
                </a>
                <h6>한국도로공사 정원 박람회</h6>
              </div>
            </div>
          </div>

          <!-- Single Product Area -->
          <div class="col-12 col-sm-6 col-lg-3">
            <div
              class="single-product-area mb-50 wow fadeInUp"
              data-wow-delay="300ms"
            >
              <!-- Product Image -->
              <div class="product-img">
                <a href="shop-details.html"
                  ><img src=" ${pageContext.request.contextPath}/resources/img/core-img/poster3.png" alt=""
                /></a>
                <div class="product-meta d-flex">
                  <a href="#" class="wishlist-btn"
                    ><i class="icon_heart_alt"></i
                  ></a>
                </div>
              </div>
              <!-- Product Info -->
              <div class="product-info mt-15 text-center">
                <a href="shop-details.html">
                  <p>2022.04.29 ~ 2022.05.01</p>
                </a>
                <h6>서울 도시농업 박람회</h6>
              </div>
            </div>
          </div>

          <!-- Single Product Area -->
          <div class="col-12 col-sm-6 col-lg-3">
            <div
              class="single-product-area mb-50 wow fadeInUp"
              data-wow-delay="400ms"
            >
              <!-- Product Image -->
              <div class="product-img">
                <a href="shop-details.html"
                  ><img src=" ${pageContext.request.contextPath}/resources/img/core-img/poster4.png" alt=""
                /></a>
                <!-- Product Tag -->
                <div class="product-tag sale-tag">
                  <a href="#">Hot</a>
                </div>
                <div class="product-meta d-flex">
                  <a href="#" class="wishlist-btn"
                    ><i class="icon_heart_alt"></i
                  ></a>
              
                </div>
              </div>
              <!-- Product Info -->
              <div class="product-info mt-15 text-center">
                <a href="shop-details.html">
                  <p>2022.06.04 ~ 2022.06.07</p>
                </a>
                <h6>대구 꽃 박람회</h6>
              </div>
            </div>
          </div>

          <div class="col-12 text-center">
            <a href="#" class="btn alazea-btn">View All</a>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Product Area End ##### -->

    <!-- ##### Blog Area Start ##### -->
    <section class="alazea-blog-area section-padding-100-0">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <!-- Section Heading -->
            <div class="section-heading text-center">
              <h2>BEST REVIEW</h2>
              <p style="font-size: 14px;">고객님들의 생생한 리뷰를 바로 확인하세요.</p>
            </div>
          </div>
        </div>

        <div class="row justify-content-center">
          <!-- Single Blog Post Area -->
          <div class="col-12 col-md-6 col-lg-4">
            <div class="single-blog-post mb-100">
              <div class="post-thumbnail mb-30">
                <a href="single-post.html"
                  ><img src=" ${pageContext.request.contextPath}/resources/img/bg-img/review1.png" alt=""
                /></a>
              </div>
              <div class="post-content">
                <a href="single-post.html" class="post-title">
                  <h6>
                    아이랑 같이 식물을 키워보려고 구매했어요~ 정말 좋네요.
                  </h6>
                </a>
                <div class="post-meta">
                  <a href="#"
                    ><i class="fa fa-clock-o" aria-hidden="true"></i> 25 Oct
                    2022</a
                  >
                  <a href="#"
                    ><i class="fa fa-user" aria-hidden="true"></i> 이민호</a
                  >
                </div>
                <p class="post-excerpt">
                  자동으로 물주고 어플로 상태 확인도 가능하니 정말 편하고 아이 교육에도 훨씬 좋은것 같네요! 이번에는 허브를 키워보려고 두개 더 구매했어요~
                </p>
              </div>
            </div>
          </div>

          <!-- Single Blog Post Area -->
          <div class="col-12 col-md-6 col-lg-4">
            <div class="single-blog-post mb-100">
              <div class="post-thumbnail mb-30">
                <a href="single-post.html"
                  ><img src="${pageContext.request.contextPath}/resources/img/bg-img/review2.png" alt=""
                /></a>
              </div>
              <div class="post-content">
                <a href="single-post.html" class="post-title">
                  <h6>
                    친구 생일 선물로 줬는데 너무 좋아해서 뿌듯해용!!!!!!
                  </h6>
                </a>
                <div class="post-meta">
                  <a href="#"
                    ><i class="fa fa-clock-o" aria-hidden="true"></i> 22 Sep
                    2022</a
                  >
                  <a href="#"
                    ><i class="fa fa-user" aria-hidden="true"></i> 김승민</a
                  >
                </div>
                <p class="post-excerpt">
                  제품도 제품이지만 배송이 너무 빨라서 두번 놀랬답니다! 그리고 사이즈 문제로 상담도 했는데 주말이지만 친절하게 상담해주셔서 너무 감사했어요!! 
                </p>
              </div>
            </div>
          </div>

          <!-- Single Blog Post Area -->
          <div class="col-12 col-md-6 col-lg-4">
            <div class="single-blog-post mb-100">
              <div class="post-thumbnail mb-30">
                <a href="single-post.html"
                  ><img src="${pageContext.request.contextPath}/resources/img/bg-img/review3.png" alt=""
                /></a>
              </div>
              <div class="post-content">
                <a href="single-post.html" class="post-title">
                  <h6>
                    플랜테리어가 유행인데 제가 주기적으로 챙기는건 자신이 없어서 구매해봤어요
                  </h6>
                </a>
                <div class="post-meta">
                  <a href="#"
                    ><i class="fa fa-clock-o" aria-hidden="true"></i> 20 Mar
                    2022</a
                  >
                  <a href="#"
                    ><i class="fa fa-user" aria-hidden="true"></i> 황현진</a
                  >
                </div>
                <p class="post-excerpt">
                  외관이 예뻐서 인테리어 용으로도 좋고 재배조명 기능이 있어서 훨씬 더 건강하게 자라는 것 같아서 사길 잘했다는 생각이 들어요. 예쁘게 잘 키워보겠습니다.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Blog Area End ##### -->

    <!-- ##### Subscribe Area Start ##### -->
    <section
      class="subscribe-newsletter-area"
    >
      <div class="container">
        <div class="row align-items-center justify-content-between">
          <div class="col-12 col-lg-5">
            <!-- Section Heading -->
            <div class="section-heading mb-0">
              <h2>주간식물을 무료 구독하세요!</h2>
              <p style="font-size: 12px;">
                쑥쑥 홈페이지에서 신청 시 식물정보지 '주간식물'을 무료로 구독하실 수 있습니다.
              </p>
            </div>
          </div>
          <div class="col-12 col-lg-6">
            <div class="subscribe-form">
              <form action="#" method="get">
                <input
                  type="email"
                  name="subscribe-email"
                  id="subscribeEmail"
                  placeholder="Enter your email"
                />
                <button type="submit" class="btn alazea-btn">SUBSCRIBE</button>
              </form>
            </div>
          </div>

        </div>       
      </div>

      <!-- Subscribe Side Thumbnail -->
     
    </section>
    <!-- ##### Subscribe Area End ##### -->

    <!-- ##### Contact Area Start ##### -->
    <section class="contact-area section-padding-100-0">
      <div class="container">
        <div class="row align-items-center justify-content-between">
          <div class="col-12 col-lg-5">
            <!-- Section Heading -->
            <div class="section-heading">
              <h2>A/S Service</h2>
              <p style="font-size: 14px;">문의를 남겨주시면 24시간 이내에 전문 상담사가 연락 드리겠습니다.</p>
            </div>
            <!-- Contact Form Area -->
            <div class="contact-form-area mb-100">
              <form action="#" method="post">
                <div class="row">
                  <div class="col-12 col-sm-6">
                    <div class="form-group">
                      <input
                        type="text"
                        class="form-control"
                        id="contact-name"
                        placeholder="Your Name"
                      />
                    </div>
                  </div>
                  <div class="col-12 col-sm-6">
                    <div class="form-group">
                      <input
                        type="email"
                        class="form-control"
                        id="contact-email"
                        placeholder="Your Email"
                      />
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-group">
                      <input
                        type="text"
                        class="form-control"
                        id="contact-subject"
                        placeholder="Subject"
                      />
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-group">
                      <textarea
                        class="form-control"
                        name="message"
                        id="message"
                        cols="30"
                        rows="10"
                        placeholder="Message"
                      ></textarea>
                    </div>
                  </div>
                  <div class="col-12">
                    <button type="submit" class="btn alazea-btn mt-15">
                      Send Message
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>

          <div id="map" class="col-12 col-lg-6" style="height:400px;"></div>
          
          <!-- KAKAO MAPS-->
          <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=efe0b188069dca1c9271e0360dd0501f"></script>
          <script>
            var container = document.getElementById("map");
            var options = {
              center: new kakao.maps.LatLng(33.450701, 126.570667),
              level: 3,
            };

            var map = new kakao.maps.Map(container, options);
          </script>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Contact Area End ##### -->

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area bg-img" style="background-color: #313b2b">
      <!-- Main Footer Area -->
      <div class="main-footer-area">
        <div class="container">
          <div class="row">
            <!-- Single Footer Widget -->
            <div class="col-12 col-sm-6 col-lg-3">
              <div class="single-footer-widget">
                <div class="footer-logo mb-30">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png" alt="" /></a>
                </div>
                <p>
                  Lorem ipsum dolor sit samet, consectetur adipiscing elit.
                  India situs atione mantor
                </p>
                <div class="social-info">
                  <a href="#"
                    ><i class="fa fa-facebook" aria-hidden="true"></i
                  ></a>
                  <a href="#"
                    ><i class="fa fa-twitter" aria-hidden="true"></i
                  ></a>
                  <a href="#"
                    ><i class="fa fa-google-plus" aria-hidden="true"></i
                  ></a>
                  <a href="#"
                    ><i class="fa fa-instagram" aria-hidden="true"></i
                  ></a>
                  <a href="#"
                    ><i class="fa fa-linkedin" aria-hidden="true"></i
                  ></a>
                </div>
              </div>
            </div>

            <!-- Single Footer Widget -->
            <div class="col-12 col-sm-6 col-lg-3">
              <div class="single-footer-widget">
                <div class="widget-title">
                  <h5>QUICK LINK</h5>
                </div>
                <nav class="widget-nav">
                  <ul>
                    <li><a href="#">Purchase</a></li>
                    <li><a href="#">FAQs</a></li>
                    <li><a href="#">Payment</a></li>
                    <li><a href="#">Review</a></li>
                    <li><a href="#">Return</a></li>
                    <li><a href="#">Advertise</a></li>
                    <li><a href="#">BulkOrder</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Application</a></li>
                    <li><a href="#">Contact</a></li>
                  </ul>
                </nav>
              </div>
            </div>

           

            <!-- Single Footer Widget -->
            <div class="col-12 col-sm-6 col-lg-3">
              <div class="single-footer-widget">
                  <div class="widget-title">
                      <h5>BEST SELLER</h5>
                  </div>

                  <!-- Single Best Seller Products -->
                  <div class="single-best-seller-product d-flex align-items-center">
                      <div class="product-thumbnail">
                          <a href="shop-details.html"><img src="${pageContext.request.contextPath}/resources/img/bg-img/4.jpg" alt=""></a>
                      </div>
                      <div class="product-info">
                          <a href="shop-details.html">애플민트 Set</a>
                          <p>16,000원</p>
                      </div>
                  </div>

                  <!-- Single Best Seller Products -->
                  <div class="single-best-seller-product d-flex align-items-center">
                      <div class="product-thumbnail">
                          <a href="shop-details.html"><img src="${pageContext.request.contextPath}/resources/img/bg-img/5.jpg" alt=""></a>
                      </div>
                      <div class="product-info">
                          <a href="shop-details.html">바질 Set</a>
                          <p>12,000</p>
                      </div>
                  </div>
              </div>
          </div>

          <!-- Single Footer Widget -->
          <div class="col-12 col-sm-6 col-lg-3">
              <div class="single-footer-widget">
                  <div class="widget-title">
                      <h5>CONTACT</h5>
                  </div>

                  <div class="contact-information">
                      <p><span>Address:</span> 광주광역시 동구 예술길 31-15 4층</p>
                      <p><span>tel:</span> 062-655-3510</p>
                      <p><span>fax:</span> 062-655-3511</p>
                      <p><span>Email:</span> info.ssookssook@gmail.com</p>
                      <p><span>Open hours:</span> Mon - Sun: 8 AM to 9 PM</p>
                      
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>

      <!-- Footer Bottom Area -->
      <div class="footer-bottom-area">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="border-line"></div>
            </div>
            <!-- Copywrite Text -->
            <div class="col-12 col-md-6">
              <div class="copywrite-text">
                <p>
                  &copy;
                  Copyright &copy;
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  All rights reserved |
                  <i class="fa fa-heart-o" aria-hidden="true"></i> by
                  <a href="#" target="_blank">SsookSsook</a>
                  
                </p>
              </div>
            </div>
            <!-- Footer Nav -->
            <div class="col-12 col-md-6">
              <div class="footer-nav">
                <nav>
                  <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Purchase</a></li>
                    <li><a href="#">
                      Service center</a></li>
                    <li><a href="#">A/S</a></li>
                  </ul>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### All Javascript Files ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath}/resources/js/active.js"></script>
    
    
  </body>
</html>
