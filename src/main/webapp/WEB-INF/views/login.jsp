<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
</head>
<body>
<form method = "get" name="login_form" action="/app/login" class="appForm">
            <fieldset>
                <legend>로그인폼</legend>
                <p class="info_pilsoo pilsoo_item">필수입력</p>
                <ul class="app_list">
                    <li class="clear">
                        <label for="id_lbl" class="tit_lbl pilsoo_item">아이디</label>
                        <div class="app_content"><input type="text" name="userid" class="w100p" id="userid" placeholder="아이디를 입력해주세요" required/></div>
                    </li>
                    <li class="clear">
                        <label for="password_lbl" class="tit_lbl pilsoo_item">암호</label>
                        <div class="app_content"><input type="password" name="userpw" class="w100p" id="userpw" placeholder="암호를 입력해주세요" required/></div>
                    </li>

                </ul>
                <p class="btn_line">
                <button class="btn_baseColor">로그인</button>
                </p>	
            </fieldset>
        </form>
</body>
</html>