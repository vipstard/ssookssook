<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <!-- 아임포트 결제모듈 연동 -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<!-- 아래 제이쿼리는 1.0이상이면 원하는 버전을 사용하셔도 무방합니다. -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  
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
                  
                  </div>
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

    <div class="breadcrumb-area">
      <!-- Top Breadcrumb Area -->
      <div
        class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
        style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/main4.png)"
      >
        <h2>제품 결제</h2>
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
                  제품 구매
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  제품 결제
                </li>
                
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    <div class="container" style="margin-bottom: 50px;">
      <div class="row ">
        <div class="col-md-8 mb-4 ">
          <div class="card mb-4">
            <div class="card-header py-3">
              <h5 class="mb-0">제품 결제</h5>
            </div>
            <div class="card-body">
            
              <form id="frm" class="pay_info" action="Order" method="post">
                <!-- 2 column grid layout with text inputs for the first and last names -->
                <div class="row col-md-12 mb-4">
                  <div class="col">
                    <div class="form-outline">
                      <label class="form-label" for="form7Example2">이름</label>
                      <input type="text" name="receiver_name" id="form7Example2" class="form-control" value="${LoginVo.name }"/>
                      <input type="hidden" name="user_id" id="id" value="${LoginVo.id }"/>
                    </div>
                  </div>
                </div>

                <!-- Number input -->
                <div class="form-outline col-md-8 mb-3">
                  <label class="form-label" for="form7Example6">연락처</label>
                  <input type="number" name="receiver_phone" id="form7Example6" class="form-control" value="${LoginVo.phone }" />
                  
                </div>
      
                <!-- address input -->
                <div class="col-md-12 mb-3 margin_center">
                  <label for="address">주소</label>
                  <div class="col-12 row">
                    <input
                    type="text"
                    class="form-control col-8"
                    id="sample6_postcode"
                    placeholder="우편번호"
                    style="margin-bottom: 10px"
                    value="${LoginVo.getPostalcode()}"
                    name="Postalcode"
                    readonly
                  />
                  <div class="addr__container col-2">
                    <input
                      type="button"
                      class="daumBtn , btn btn-success btn-sm"
                      value="우편번호 찾기"
                      onclick="openDaumPostCode()"
                    />
                  </div> 
                  </div>
                  <input
                    type="text"
                    class="form-control , col-10"
                    name="addr1"
                    id="sample6_address"
                    placeholder="주소"
                    value="${LoginVo.addr1 }"
                    readonly
                    style="margin-bottom: 10px"
                  />
                  <input
                    type="text"
                    class="form-control , col-10"
                    name="addr2"
                    id="sample6_detailAddress"
                    placeholder="상세주소"
                    value="${LoginVo.addr2 }"
                    style="margin-bottom: 10px"
                  />
                  
                </div>
      
                <!-- Email input -->
                <div class="form-outline col-md-10 mb-3">
                  <label class="form-label" for="form7Example5">이메일</label>
                  <input type="email" name="email" id="email" class="form-control" value="${LoginVo.email }" />
                  
                </div>
                         
                <!-- Message input -->
                <div class="form-outline col-md-10 mb-3">
                  <label class="form-label" for="form7Example7">배송 메모</label>
                  <textarea name="memo" class="form-control" placeholder="배송 메모를 입력해주세요." id="form7Example7" rows="4"></textarea>
                </div>
      
                <!-- Checkbox -->
                <div class="form-check d-flex justify-content-center mb-2 align-items-center">
                  <input class="" type="checkbox" value="" id="form7Example8"
                    checked />
                  <label class="form-check-label" for="form7Example8" style="font-family: S-CoreDream-4Regular; font-size: 14px; padding-left: 5px;">
                    개인정보 제 3자 제공 및 위탁에 동의합니다.
                  </label>
                </div>
              
            </div>
          </div>
        </div>
      
        <div class="col-md-4 mb-4">
          <div class="card mb-4">
            <div class="card-header py-3">
              <h5 class="mb-0">합계</h5>
            </div>
            <div class="card-body">
              <ul class="list-group list-group-flush">
                <li
                  class="pay_title list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                  가정용 스마트 화분
                  <span>35,000</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                  배송비
                  <span>3,000</span>
                </li>
                <li
                  class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                  <div>
                    <strong>총 결제 금액</strong>
                  </div>
                  <span><strong>38,000</strong></span>
                </li>
              </ul>
              <div class="paycheck">
                <div class="credit form-check">
                  <input class="form-check-input" type="radio" name="pay_method" id="flexRadio" value="card">
                  <label class="form-check-label" for="flexRadioDefault1">
                    신용카드로 결제
                  </label>
                </div>
                <div class="kakaopay form-check">
                  <input class="form-check-input"  type="radio" name="pay_method" id="flexRadio" value="kakao" checked>
                  <label class="form-check-label" for="flexRadioDefault2">
                    카카오페이로 결제
                  </label>
                </div>
                <div class="cash form-check">
                  <input class="form-check-input" type="radio" name="pay_method" id="flexRadio" value="nobankbook" checked>
                  <label class="form-check-label" for="flexRadioDefault2">
                    무통장 입급으로 결제
                  </label>
                </div>
              </div>
              <button type='button' onclick="iamport()" class="btn btn-success btn-lg btn-block" style="font-family: S-CoreDream-5Medium; font-size: 16px;">
                결제 하기
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
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
                  <a href="main"
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

    <script>
      window.addEventListener(
        "load",
        () => {
          const forms = document.getElementsByClassName("validation-form");

          Array.prototype.filter.call(forms, (form) => {
            form.addEventListener(
              "submit",
              function (event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }

                form.classList.add("was-validated");
              },
              false
            );
          });
        },
        false
      );
    </script>
    <script>
      function openDaumPostCode() {
        new daum.Postcode({
          oncomplete: function (data) {
            var addr = "";
            var extraAddr = "";
            if (data.userSelectedType === "R") {
              addr = data.roadAddress;
            } else {
              addr = data.jibunAddress;
            }
            if (data.userSelectedType === "R") {
              if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                extraAddr += data.bname;
              }
              if (data.buildingName !== "" && data.apartment === "Y") {
                extraAddr +=
                  extraAddr !== ""
                    ? ", " + data.buildingName
                    : data.buildingName;
              }
              if (extraAddr !== "") {
                extraAddr = " (" + extraAddr + ")";
              }
              document.getElementById("sample6_detailAddress").value =
                extraAddr;
            } else {
              document.getElementById("sample6_detailAddress").value = "";
            }
            document.getElementById("sample6_postcode").value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            document.getElementById("sample6_detailAddress").focus();
          },
        }).open();
      }
      
      <!-- 신욧카드로 결제 선택시 아임포트 신용카드 결제모듈 실행 -->
      function iamport(){
    	  
    	  <!-- 체크 값 불러와서 각각 지불수단 별로 창 띄우기 -->
    	  
    	  var payMethod=$("input[name='pay_method']:checked").val() //JQuery 라디오 값 가져오기
    	  console.log(payMethod);
    	  
    	  if(payMethod=='card'){
  		//가맹점 식별코드
  		IMP.init('imp09311302');
  		
  		IMP.request_pay({
  		    pg : 'kcp',
  		    pay_method : 'card',
  		    merchant_uid : 'merchant_' + new Date().getTime(),
  		    name : '쑥쑥 스마트화분', //결제창에서 보여질 이름
  		    amount : 38000, //실제 결제되는 가격
  		    buyer_email : '${LoginVo.email}',
  		    buyer_name : '${LoginVo.name}',
  		    buyer_tel : '${LoginVo.phone}',
  		    buyer_addr : '${LoginVo.addr}',
  		    buyer_postcode : '123-456'
  		}, function(rsp) {
  			console.log(rsp);
  		    if ( rsp.success ) {
  		    	var msg = '결제가 완료되었습니다.';
  		       /*  msg += '고유ID : ' + rsp.imp_uid;
  		        msg += '상점 거래ID : ' + rsp.merchant_uid;
  		        msg += '결제 금액 : ' + rsp.paid_amount;
  		        msg += '카드 승인번호 : ' + rsp.apply_num; */
  		        document.getElementById('frm').submit();
  		    } else {
  		    	 var msg = '결제에 실패하였습니다.';
  		         msg += '에러내용 : ' + rsp.error_msg;
  		    }
  		    alert(msg);
  		});
  		
    }		else if(payMethod=='kakao'){
    		  IMP.init('imp09311302'); 
    			// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    			// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
    			IMP.request_pay({
    				pg: 'kakaopay',
    				pay_method: 'card',
    				merchant_uid: 'merchant_' + new Date().getTime(),
    				/* 
    				 *  merchant_uid에 경우 
    				 *  https://docs.iamport.kr/implementation/payment
    				 *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
    				 */
    				name: '주문명 : 아메리카노',
    				// 결제창에서 보여질 이름
    				// name: '주문명 : ${auction.a_title}',
    				// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
    				amount: 2000,
    				// amount: ${bid.b_bid},
    				// 가격 
    				buyer_name: '이름',
    				// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
    				// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
    				buyer_postcode: '123-456',
    				}, function (rsp) {
    					console.log(rsp);
    				if (rsp.success) {
    					var msg = '결제가 완료되었습니다.';
    					msg += '결제 금액 : ' + rsp.paid_amount;
    					// success.submit();
    					// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
    					// 자세한 설명은 구글링으로 보시는게 좋습니다.
    					
    					<!--폼태그 Controller로 전송 -->
    					document.getElementById('frm').submit();
    					
    				} else {
    					var msg = '결제에 실패하였습니다.';
    					msg += '에러내용 : ' + rsp.error_msg;
    				}
    				alert(msg);
    			});
    	  }else{
    		  document.getElementById('frm').submit();
    	  }
  	}
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  </body>
</html>
