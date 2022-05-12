<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SsookSsook - Log In</title>

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Roboto:wght@500;700;900&display=swap"
      rel="stylesheet"
    />
    <!-- Icon Font Stylesheet -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/login_join.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico" />
  </head>

  <body>
    <div class="container">
      <div class="input-form-backgroud row">
        <div class="input-form col-md-12">
          <a href="main">
            <img src="${pageContext.request.contextPath}/resources/img/core-img/SSSSlogo.png" class="logo" />
          </a>
          
          <!-- 폼에 method, action 채워야 함! -->
          <form
          	accept-charset="UTF-8"
            class="validation-form ScoreDream400"
            style="align-items: center"
            novalidate
            method='post'
            action='Login_Test'
          >
            <div class="col-md-8 mb-3 margin_center">
              <div class="invalid-feedback">이름을 입력해주세요.</div>
            </div>
            <div class="col-md-8 mb-3 margin_center">
              <label for="id">아이디</label>
              <input
                type="text"
                class="form-control"
                name="id"
                id="id"
                required
                maxlength="30"
              />
              <div class="invalid-feedback">아이디를 입력해주세요.</div>
            </div>
            <div class="col-md-8 mb-3 margin_center">
              <label for="pw">비밀번호</label>
              <input
                type="password"
                class="form-control"
                name="pw"
                id="pw"
                required
                maxlength="30"
              />
              <div class="invalid-feedback">비밀번호를 입력해주세요.</div>
            </div>

            <hr class="mb-4" style="margin-top: 50px" />
            <div class="custom-control custom-checkbox">
              <input
                type="checkbox"
                class="custom-control-input"
                id="aggrement"
                required
              />
            </div>
            <div class="btn-groups">
              <button
                class="login loginBtn, btn btn-warning btn-lg"
                style="font-family: Font Awesome 5 Free"
                ;
              >
                로그인
              </button>
              <button
              	type="button"
                onclick="location.href='JoinForm'";>가입하기</button>
            </div>
          </form>
        </div>
      </div>
      <footer class="my-3 text-center text-small"></footer>
    </div>
    
  </body>
</html>
