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
    <title>SsookSsook - Purchase</title>

    <!-- Favicon -->
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico"
    />

    <!-- Core Stylesheet -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/style.css"
    />
  </head>

  <body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
      <div class="preloader-circle"></div>
      <div class="preloader-img">
        <img
          src="${pageContext.request.contextPath}/resources/img/core-img/leaf.png"
          alt=""
        />
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
                  
                </div>
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
                ><img
                  src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png"
                  alt=""
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
                    <li><a href="helpQnA">고객센터</a></li>
                    <li><a href="Contact">A/S</a></li>
                    <!--  관리자전용 회원관리 페이지 추가 -->
	                <c:if test='${LoginVo.admin_yn == "Y"}'>

                    <li>
                      <a href="#">회원 관리</a>
                      <ul class="dropdown">
                        <li><a href="member_Manage">회원 관리</a></li>
                        <li><a href="Sales_Manage">매출 관리</a></li>
                      </ul>
                    </li>
                  </ul>
                   </c:if>

                  <!-- Search Icon -->
                  <div id="searchIcon">
                    <i c
                    lass="fa fa-search" aria-hidden="true"></i>
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

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
      <!-- Top Breadcrumb Area -->
      <div
        class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
        style="
          background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/main3.png);
        "
      >
        <h2>제품 구매</h2>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-12">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="main"><i class="fa fa-home"></i> Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  제품 구매
                </li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area mb-50">
      <div class="produts-details--content mb-50">
        <div class="container">
          <div class="row justify-content-between">
            <div class="col-12 col-md-6 col-lg-5">
              <div class="single_product_thumb">
                <div
                  id="product_details_slider"
                  class="carousel slide"
                  data-ride="carousel"
                >
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <a
                        class="product-img"
                        href="${pageContext.request.contextPath}/resources/img/bg-img/pur1.png"
                        title="Product Image"
                      >
                        <img
                          class="d-block w-100"
                          src="${pageContext.request.contextPath}/resources/img/bg-img/pur1.png"
                          alt="1"
                        />
                      </a>
                    </div>
                    <div class="carousel-item">
                      <a
                        class="product-img"
                        href="${pageContext.request.contextPath}/resources/img/bg-img/pur2.png"
                        title="Product Image"
                      >
                        <img
                          class="d-block w-100"
                          src="${pageContext.request.contextPath}/resources/img/bg-img/pur2.png"
                          alt="1"
                        />
                      </a>
                    </div>
                    <div class="carousel-item">
                      <a
                        class="product-img"
                        href="${pageContext.request.contextPath}/resources/img/bg-img/pur3.png"
                        title="Product Image"
                      >
                        <img
                          class="d-block w-100"
                          src="${pageContext.request.contextPath}/resources/img/bg-img/pur3.png"
                          alt="1"
                        />
                      </a>
                    </div>
                  </div>
                  <ol class="carousel-indicators">
                    <li
                      class="active"
                      data-target="#product_details_slider"
                      data-slide-to="0"
                      style="
                        background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/pur1.png);
                      "
                    ></li>
                    <li
                      data-target="#product_details_slider"
                      data-slide-to="1"
                      style="
                        background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/pur2.png);
                      "
                    ></li>
                    <li
                      data-target="#product_details_slider"
                      data-slide-to="2"
                      style="
                        background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/pur3.png);
                      "
                    ></li>
                  </ol>
                </div>
              </div>
            </div>

            <div class="col-12 col-md-6">
              <div class="single_product_desc">
                <h4 class="title">가정용 스마트 화분</h4>
                <h4 class="price">35,000</h4>
                <div class="short_overview">
                  <p>
                    현대카드, 삼성카드, 국민카드
                    <span>5,000원 캐시백</span> 혜택<br />
                    오후 4시 이전 주문시 <span>당일 발송</span>
                  </p>
                </div>

                <div class="cart--area d-flex flex-wrap align-items-center">
                  <!-- Add to Cart Form -->
                  <form
                    class="cart clearfix d-flex align-items-center"
                    method="post"
                    action="PurchasePay"
                  >
                    <div class="quantity">
                      <span
                        class="qty-minus"
                        onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"
                        ><i class="fa fa-minus" aria-hidden="true"></i
                      ></span>
                      <input
                        type="number"
                        class="qty-text"
                        id="qty"
                        step="1"
                        min="1"
                        max="12"
                        name="quantity"
                        value="1"
                      />
                      <span
                        class="qty-plus"
                        onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"
                        ><i class="fa fa-plus" aria-hidden="true"></i
                      ></span>
                    </div>
                    <button
                      type="submit"
                      name="addtocart"
                      value="5"
                      class="btn alazea-btn ml-15"
                    >
                      결제하기
                    </button>
                  </form>
                  <!-- Wishlist & Compare -->
                  <div
                    class="wishlist-compare d-flex flex-wrap align-items-center"
                  >
                    <a href="#" class="wishlist-btn ml-15"
                      ><i class="icon_heart_alt"></i
                    ></a>
                  </div>
                </div>

                <div class="products--meta">
                  <p><span>제품명:</span> <span>SSSS20220801</span></p>
                  <p><span>종류:</span> <span>스마트 재배 화분</span></p>
                  <p><span>Tags:</span> <span>plants, green, cactus </span></p>
                  <p>
                    <span>Share on:</span>
                    <span>
                      <a href="#"><i class="fa fa-facebook"></i></a>
                      <a href="#"><i class="fa fa-twitter"></i></a>
                      <a href="#"><i class="fa fa-pinterest"></i></a>
                      <a href="#"><i class="fa fa-google-plus"></i></a>
                    </span>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="product_details_tab clearfix">
              <!-- Tabs -->
              <ul class="nav nav-tabs" role="tablist" id="product-details-tab">
                <li class="nav-item">
                  <a
                    href="#addi-info"
                    class="nav-link"
                    data-toggle="tab"
                    role="tab"
                    >배송/교환/반품 안내</a
                  >
                </li>
                <li class="nav-item">
                  <a
                    href="#reviews"
                    class="nav-link"
                    data-toggle="tab"
                    role="tab"
                    >리뷰<span class="text-muted">(342)</span></a
                  >
                </li>
              </ul>
              <!-- Tab Content -->
              <div class="tab-content">
                <div
                  role="tabpanel"
                  class="tab-pane fade show active"
                  id="addi-info"
                >
                  <div class="additional_info_area">
                    <p>
                      배송은 보통 얼마나 걸리나요? <br />
                      <span
                        >저희 쑥쑥은 고객님께 최대한 빠른 배송을 제공해드리기
                        위해 오후 네시 이전에 주문하시면 당일 배송을 원칙으로
                        하고 있습니다. <br />다만 택배사의 사정에 따라 1~2일
                        정도 더 소요가 될 수 있는 점은 양해 바랍니다.</span
                      >
                    </p>
                    <p>
                      모종과 함께 구매할 수 있나요?<br />
                      <span
                        >네! 모종과 함께 구매하시면 합배송으로
                        보내드립니다.</span
                      >
                    </p>
                    <p>
                      혹시 다른 색으로 교환도 가능한가요? <br />
                      <span
                        >제품 내 포장씰을 뜯지 않은 상황이라면 교환 가능합니다.
                        자세한 것은 고객센터로 문의 주세요.
                      </span>
                    </p>
                    <p>
                      구매를 취소 하고 싶어요.<br />
                      <span
                        >배송 후 환불은 제품 이상이 있는 경우에만 가능합니다.
                        자세한 것은 고객센터로 문의 주세요.</span
                      >
                    </p>
                  </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="reviews">
                  <div class="reviews_area">
                    <ul>
                      <li>
                        <div class="single_user_review mb-15">
                          <div class="review-rating">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <span>for Quality</span>
                          </div>
                          <div class="review-details">
                            <p>
                              by <a href="#">양정인</a> on
                              <span>20 Mar 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="single_user_review mb-15">
                          <div class="review-rating">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <span>for Design</span>
                          </div>
                          <div class="review-details">
                            <p>
                              by <a href="#">김승민</a> on
                              <span>11 Apr 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="single_user_review">
                          <div class="review-rating">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <span>for Value</span>
                          </div>
                          <div class="review-details">
                            <p>
                              by <a href="#">서창빈</a> on
                              <span>30 Apr 2022</span>
                            </p>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>

                  <div class="submit_a_review_area mt-50">
                    <h4>Submit A Review</h4>
                    <form action="#" method="post">
                      <div class="row">
                        <div class="col-12">
                          <div class="form-group d-flex align-items-center">
                            <span class="mr-15">평점:</span>
                            <div class="stars">
                              <input
                                type="radio"
                                name="star"
                                class="star-1"
                                id="star-1"
                              />
                              <label class="star-1" for="star-1">1</label>
                              <input
                                type="radio"
                                name="star"
                                class="star-2"
                                id="star-2"
                              />
                              <label class="star-2" for="star-2">2</label>
                              <input
                                type="radio"
                                name="star"
                                class="star-3"
                                id="star-3"
                              />
                              <label class="star-3" for="star-3">3</label>
                              <input
                                type="radio"
                                name="star"
                                class="star-4"
                                id="star-4"
                              />
                              <label class="star-4" for="star-4">4</label>
                              <input
                                type="radio"
                                name="star"
                                class="star-5"
                                id="star-5"
                              />
                              <label class="star-5" for="star-5">5</label>
                              <span></span>
                            </div>
                          </div>
                        </div>
                        <div class="col-12 col-md-6">
                          <div class="form-group">
                            <label for="name">이름</label>
                            <input
                              type="email"
                              class="form-control"
                              id="name"
                              placeholder="이름을 입력해주세요"
                            />
                          </div>
                        </div>
                        <div class="col-12 col-md-6">
                          <div class="form-group">
                            <label for="options">Reason for your rating</label>
                            <select class="form-control" id="options">
                              <option>Quality</option>
                              <option>Value</option>
                              <option>Design</option>
                              <option>Price</option>
                              <option>Others</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-12">
                          <div class="form-group">
                            <label for="comments">Comments</label>
                            <textarea
                              class="form-control"
                              id="comments"
                              rows="5"
                              data-max-length="150"
                            ></textarea>
                          </div>
                        </div>
                        <div class="col-12">
                          <button type="submit" class="btn alazea-btn">
                            리뷰 작성 하기
                          </button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ##### Single Product Details Area End ##### -->

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
                  <a href="main"><img
                      src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png"
                      alt=""
                  /></a>
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
                  <h5>STORE</h5>
                </div>

                <!-- Single Best Seller Products -->
                <div
                  class="single-best-seller-product d-flex align-items-center"
                >
                  <div class="product-thumbnail">
                    <a href="shop-details.html"
                      ><img src="${pageContext.request.contextPath}/resources/img/bg-img/apple1.png" alt=""
                    /></a>
                  </div>
                  <div class="product-info">
                    <a href="shop-details.html">가로수길 2호점</a>
                    <p>서울특별시 서울 강남구 <br />가로수길 43</p>
                  </div>
                </div>

                <!-- Single Best Seller Products -->
                <div
                  class="single-best-seller-product d-flex align-items-center"
                >
                  <div class="product-thumbnail">
                    <a href="shop-details.html"
                      ><img
                        src="${pageContext.request.contextPath}/resources/img/bg-img/apple.png"
                        alt=""
                    /></a>
                  </div>
                  <div class="product-info">
                    <a href="shop-details.html">명동 3호점</a>
                    <p>
                      서울 중구 남대문로 2가 9-1<br />
                      하이드파크
                    </p>
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
                  &copy; Copyright &copy;
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
                    <li><a href="main">Home</a></li>
                    <li><a href="About">About</a></li>
                    <li><a href="Purchase">Purchase</a></li>
                    <li><a href="#"> Service center</a></li>
                    <li><a href="Contact">A/S</a></li>
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
