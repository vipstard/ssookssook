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
    <title>SsookSsook - Customer Service</title>

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico" />

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>

  <body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
      <div class="preloader-circle"></div>
      <div class="preloader-img">
        <img src="${pageContext.request.contextPath}/resources/img/core-img/leaf.png" alt="" />
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
                        <a class="dropdown-item" href="#">?????????</a>
                        <a class="dropdown-item" href="#">?????????</a>
                        <a class="dropdown-item" href="#">?????????</a>
                      </div>
                    </div>
                  </div>
                 <c:if test="${!empty LoginVo}">
                <label style='color : white'>${LoginVo.name }??? ???????????????.</label>&nbsp&nbsp
                 <!-- ???????????? ??????  -->
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
                    <li><a href="About">?????? ??????</a></li>
                    <li><a href="Purchase">?????? ??????</a></li>
                    <li><a href="helpQnA">????????????</a></li>
                    <li><a href="Contact">A/S</a></li>
                    <!--  ??????????????? ???????????? ????????? ?????? -->
	                <c:if test='${LoginVo.admin_yn == "Y"}'>

                    <li>
                      <a href="#">?????? ??????</a>
                      <ul class="dropdown">
                        <li><a href="member_Manage">?????? ??????</a></li>
                        <li><a href="Sales_Manage">?????? ??????</a></li>
                      </ul>
                    </li>
                  </ul>
                   </c:if>

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

    <div class="breadcrumb-area">
      <!-- Top Breadcrumb Area -->
      <div
        class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
        style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/main4.png)"
      >
        <h2>?????? ??????</h2>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-12">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="#"><i class="fa fa-home"></i> Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  ?????? ??????
                </li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Breadcrumb Area Start ##### -->

    <div id="main">
      <br /><br />
      <div class="container ScoreDream400" id="board-list">
        <div class="search-window">
          <form action="">
            <div class="search-wrap">
              <input
                id="search"
                type="text"
                name="keyword"
                placeholder="??????????????? ??????????????????."
                value="${BoardPageMaker.cri.keyword }"
              />
              <button class="btn btn-success">??????</button>
            </div>
          </form>
        </div>
        <br /><br />
        <ul class="nav justify-content-end">
          <li class="nav-item">
            <a class="delivery nav-link active" aria-current="page" href="#"
              >?????? ??????</a
            >
          </li>
          <li class="nav-item">
            <a class="fixed nav-link" href="#">?????? ??????</a>
          </li>
          <li class="nav-item">
            <a class="another nav-link" href="#">?????? ??????</a>
          </li>
        </ul>
        <br />
        <table class="table table-hover">
          <thead>
            <tr>
              <th>?????? ??????</th>
              <th>?????????</th>
              <th>??????</th>
              <th>?????????</th>
              <th>?????????</th>
              <th>??????</th>
              
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="another">?????? ??????</td>
              <td>1145</td>
              <td><a href="#">?????? ?????? ?????? ????????????.</a></td>
              <td>?????????</td>
              <td>2022.05.11</td>
              <td>112</td>
            </tr>
            <tr>
              <td class="fixed">?????? ??????</td>
              <td>1144</td>
              <td><a href="#">??? ????????????????????????</a></td>
              <td>?????????</td>
              <td>2022.05.11</td>
              <td>87</td>
            </tr>
            <tr>
              <td class="delivery">?????? ??????</td>
              <td>1143</td>
              <td><a href="#">?????? ?????? ?????? ??????????????? ??????</a></td>
              <td>?????????</td>
              <td>2022.05.11</td>
              <td>158</td>
            </tr>
            <tr>
              <td class="another">?????? ??????</td>
              <td>1142</td>
              <td><a href="#">?????? ?????? ??????????????????.</a></td>
              <td>?????????</td>
              <td>2022.05.10</td>
              <td>108</td>
            </tr>
            <tr>
              <td class="another">?????? ??????</td>
              <td>1141</td>
              <td><a href="#">???????????????</a></td>
              <td>?????????</td>
              <td>2022.05.11</td>
              <td>107</td>
            </tr>
            <tr>
              <td class="fixed">?????? ??????</td>
              <td>1140</td>
              <td><a href="#">?????? ???????????? ???????????????</a></td>
              <td>????????????</td>
              <td>2022.05.11</td>
              <td>87</td>
            </tr>
            <tr>
              <td class="delivery">?????? ??????</td>
              <td>1139</td>
              <td><a href="#">???????????????</a></td>
              <td>?????????</td>
              <td>2022.05.11</td>
              <td>106</td>
            </tr>
            <tr>
              <td class="delivery">?????? ??????</td>
              <td>1138</td>
              <td><a href="#">?????? ???????????? ???????????? ????????????</a></td>
              <td>?????????</td>
              <td>2022.05.10</td>
              <td>105</td>
            </tr>
            
            <c:forEach var="vo" items="${QnaList}">
			   <tr>
			      <c:choose>
				      <c:when test="${vo.kinds eq '0' }">
				      <td class="another">?????? ??????</td>
				      </c:when>
				      
				      <c:when test="${vo.kinds eq '1' }">
				      <td class="fixed">?????? ??????</td>
				      </c:when>
				      
				      <c:when test="${vo.kinds eq '2' }">
				      <td class="delivery">?????? ??????</td>
				      </c:when>
			      </c:choose>
			   	  <td>${vo.idx}</td>
			      <td><a href="/SS/QnaContent?idx=${vo.idx}">${vo.title}</a>
			      <c:if test=""> </c:if></td>
			      <td>${vo.writer}</td>
			      <td>${vo.indate}</td>
			      <td>${vo.count}</td>
			   </tr>
			   </c:forEach>
          </tbody>
        </table>
        <button
          type="button"
          class="btn btn-write"
          onclick="location.href='QnaForm?writer=${id}'"
        >
          ?????????
        </button>
        <br /><br />
        
        <div class="pageInfo_wrap" >
        	<div class="pageInfo_area">
        
        <nav aria-label="Page navigation example">
          <ul class="pagination btn-movepage justify-content-center" id="pageInfo">
            
            <!-- ?????? ????????? -->
             <c:if test="${BoardPageMaker.cri.pageNum > 10}">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            </c:if>
            
            <!-- ??? ?????? ????????? ?????? -->
            <c:forEach var="num" begin="${BoardPageMaker.startPage}" end="${BoardPageMaker.endPage}">
                   <li class="page-item ${BoardPageMaker.cri.pageNum == num ? "active":"" }"><a class="page-link" href="${num}">${num}</a></li>
            </c:forEach>
           
           <!-- ?????? ????????? -->
           <c:if test="${pageMaker.cri.pageNum < pageMaker.realEnd}">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
            </c:if>
          
            
          </ul>
        </nav>
         </div>
    	</div>
      </div>
    </div>
    
    <!-- ????????????, ?????????, ??????????????? ?????? -->
    <form id="moveForm" method="get">
   	<input type="hidden" name="pageNum" value="${BoardPageMaker.cri.pageNum }">
   	<input type="hidden" name="amount"  value="${BoardPageMaker.cri.amount }">
   	<input type="hidden" name="keyword" value="${BoardPageMaker.cri.keyword }">
  	</form> 

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
                  <a href="#"
                    ><img src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png" alt=""
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
                    <a href="shop-details.html">???????????? 2??????</a>
                    <p>??????????????? ?????? ????????? <br />???????????? 43</p>
                  </div>
                </div>

                <!-- Single Best Seller Products -->
                <div
                  class="single-best-seller-product d-flex align-items-center"
                >
                  <div class="product-thumbnail">
                    <a href="shop-details.html"
                      ><img src="${pageContext.request.contextPath}/resources/img/bg-img/apple.png" alt=""
                    /></a>
                  </div>
                  <div class="product-info">
                    <a href="shop-details.html">?????? 3??????</a>
                    <p>
                      ?????? ?????? ???????????? 2??? 9-1<br />
                      ???????????????
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
                  <p><span>Address:</span> ??????????????? ?????? ????????? 31-15 4???</p>
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
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Purchase</a></li>
                    <li><a href="#"> Service center</a></li>
                    <li><a href="#">A/S</a></li>
                  </ul>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>

<script>

/* ????????? ????????? js */
let moveForm = $("#moveForm");

   $("#pageInfo a").on("click", function(e){
  
        e.preventDefault();
        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
        console.log('moveForm')
        moveForm.attr("action", "helpQnA");
        moveForm.submit();
        
    });
   
  
/* ?????? ?????? */
   $(".search_wrap button").on("click", function(e){
       e.preventDefault();
       let val = $("input[name='keyword']").val();
       moveForm.find("input[name='keyword']").val(val);
       moveForm.find("input[name='pageNum']").val(1);
       moveForm.submit();
   });


 
</script>
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
