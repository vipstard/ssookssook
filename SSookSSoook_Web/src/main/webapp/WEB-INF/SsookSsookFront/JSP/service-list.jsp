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
        <h2>고객 문의</h2>
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
                  고객 문의
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
                placeholder="ㅤ검색어를 입력해주세요."
                value="${BoardPageMaker.cri.keyword }"
              />
              <button class="btn btn-success">검색</button>
            </div>
          </form>
        </div>
        <br /><br />
        <ul class="nav justify-content-end">
          <li class="nav-item">
            <a class="delivery nav-link active" aria-current="page" href="#"
              >배송 문의</a
            >
          </li>
          <li class="nav-item">
            <a class="fixed nav-link" href="#">고장 문의</a>
          </li>
          <li class="nav-item">
            <a class="another nav-link" href="#">기타 문의</a>
          </li>
        </ul>
        <br />
        <table class="table table-hover">
          <thead>
            <tr>
              <th>문의 유형</th>
              <th>글번호</th>
              <th>제목</th>
              <th>글쓴이</th>
              <th>작성일</th>
              <th>조회</th>
              
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="another">기타 문의</td>
              <td>1145</td>
              <td><a href="#">기술 제휴 문의 드립니다.</a></td>
              <td>최태원</td>
              <td>2022.05.11</td>
              <td>112</td>
            </tr>
            <tr>
              <td class="fixed">고장 문의</td>
              <td>1144</td>
              <td><a href="#">아 고장났자나여ㅡㅡ</a></td>
              <td>황현진</td>
              <td>2022.05.11</td>
              <td>87</td>
            </tr>
            <tr>
              <td class="delivery">배송 문의</td>
              <td>1143</td>
              <td><a href="#">배송 제발 빨리 보내주세요 제발</a></td>
              <td>이용복</td>
              <td>2022.05.11</td>
              <td>158</td>
            </tr>
            <tr>
              <td class="another">기타 문의</td>
              <td>1142</td>
              <td><a href="#">대량 구매 문의드립니다.</a></td>
              <td>이재용</td>
              <td>2022.05.10</td>
              <td>108</td>
            </tr>
            <tr>
              <td class="another">기타 문의</td>
              <td>1141</td>
              <td><a href="#">신고합니다</a></td>
              <td>유주영</td>
              <td>2022.05.11</td>
              <td>107</td>
            </tr>
            <tr>
              <td class="fixed">고장 문의</td>
              <td>1140</td>
              <td><a href="#">우리 고양이도 보고가세요</a></td>
              <td>수박조아</td>
              <td>2022.05.11</td>
              <td>87</td>
            </tr>
            <tr>
              <td class="delivery">배송 문의</td>
              <td>1139</td>
              <td><a href="#">집가고싶다</a></td>
              <td>김헌찬</td>
              <td>2022.05.11</td>
              <td>106</td>
            </tr>
            <tr>
              <td class="delivery">배송 문의</td>
              <td>1138</td>
              <td><a href="#">저는 튼튼하고 여러분을 좋아해여</a></td>
              <td>박지성</td>
              <td>2022.05.10</td>
              <td>105</td>
            </tr>
            
            <c:forEach var="vo" items="${QnaList}">
			   <tr>
			      <c:choose>
				      <c:when test="${vo.kinds eq '0' }">
				      <td class="another">기타 문의</td>
				      </c:when>
				      
				      <c:when test="${vo.kinds eq '1' }">
				      <td class="fixed">고장 문의</td>
				      </c:when>
				      
				      <c:when test="${vo.kinds eq '2' }">
				      <td class="delivery">배송 문의</td>
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
          글작성
        </button>
        <br /><br />
        
        <div class="pageInfo_wrap" >
        	<div class="pageInfo_area">
        
        <nav aria-label="Page navigation example">
          <ul class="pagination btn-movepage justify-content-center" id="pageInfo">
            
            <!-- 이전 페이지 -->
             <c:if test="${BoardPageMaker.cri.pageNum > 10}">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            </c:if>
            
            <!-- 각 번호 페이지 버튼 -->
            <c:forEach var="num" begin="${BoardPageMaker.startPage}" end="${BoardPageMaker.endPage}">
                   <li class="page-item ${BoardPageMaker.cri.pageNum == num ? "active":"" }"><a class="page-link" href="${num}">${num}</a></li>
            </c:forEach>
           
           <!-- 다음 페이지 -->
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
    
    <!-- 페이지수, 총개수, 검색키워드 전송 -->
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
                      ><img src="${pageContext.request.contextPath}/resources/img/bg-img/apple.png" alt=""
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

/* 페이지 넘기기 js */
let moveForm = $("#moveForm");

   $("#pageInfo a").on("click", function(e){
  
        e.preventDefault();
        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
        console.log('moveForm')
        moveForm.attr("action", "helpQnA");
        moveForm.submit();
        
    });
   
  
/* 검색 기능 */
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
