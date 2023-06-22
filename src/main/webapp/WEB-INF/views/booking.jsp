<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 예약</title>
</head>
<body>
	<form>
		<%-- <%
   String loginid=(String)session.getAttribute("loginid");
   out.println(loginid);
   if(!loginid.equals("jyw")){
     response.sendRedirect("http://localhost:8080/app/login");
   }
   %> --%>
		<a href="/app/logout"><h4 style="margin: 0px 15px;">로그아웃</h4></a>

		<h3 style="margin: 0px 150px;">
			<a style="cursor: pointer;" href="/app/room">객실관리</a> <a>예약관리</a>
		</h3>

		<!-- <div class="abc"> -->
		<div class="table3">
			<p style="background-color: white;">숙박기간</p>
			<input type="date" name=sday id=sday> ~ <input type="date"
				name=eday id=eday> <br>

			<p style="background-color: white;">객실분류</p>
			<select>
				<option value="-">전체</option>
				<c:forEach items="${list}" var="room">
					<option value='${room.typecode}'>
						${room.roomname},${room.typename}</option>
			</select>
			</c:forEach>
			<input type="button" name="search" style="margin: 0px 10px;"
				id=search value="조회">
		</div>


		<div class="table4">
			<br>
			<p>객실이름</p>
			<td><input type="search" name="roomSearch" id="roomSearch">
				<input type=hidden id=roomcode> <input type=hidden
				id=bookcode></td>
			<p>객실종류</p>
			<input type=text name=roomtype id=roomtype>
			<p>숙박인원</p>
			<input type="text" name="humans" id="humans" min=1>명
			<p>예약기간</p>
			<input type="date" name="checkin" id="checkin">~<input
				type="date" name=checkout id=checkout>
			<p>총 숙박비</p>
			<td><input type="number" name="gunMoney" id="gunMoney" min=1>원
				<input type=hidden name=price id=price>
			<td>
				<p>예약자명</p> <input type=text name=name id=name>님
				<p>모바일</p> <input type="text" name="mobile" id="mobile"> <br>
				<br> <input type="button" name="upDate" id="upDate"
				value="예약완료"> <input type="button" name="no" id="no"
				value="비우기"> <input type="button" name="noBooking"
				id="noBooking" value="예약취소">
		</div>
		<br> <br>
		<div class=wow>
			<h3>예약된 객실</h3>
			<div class="def">
				<select id="okRoom" style="width: 200px; height: 400px;" size="10">
					<c:forEach items="${list}" var="roomss">
						<option value="${roomss.roomcode}">
							${roomss.roomname},${roomss.typename},${roomss.howmany},${roomss.howmuch}
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<br>
		<div class="bb">
			<h3 style="text-align: left;">예약가능</h3>
			<div class="Go">
				<select size="20" style="width: 200px;" id="pickRoom">
					<c:forEach items="${PickListBooking}" var="pickRoom">
						<option value="${pickRoom.roomcode}">
							${pickRoom.roomname},${pickRoom.typename},${pickRoom.howmany},${pickRoom.howmuch}
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
</body>

<style>
h4 {
	text-align: right;
}

li {
	list-style: none;
	margin: 20px 20px;
	text-align: left;
}

.li2 {
	padding: 30px;
}

.li3 {
	text-align: center;
	padding: 20px;
}

.Go {
	border: 1px solid;
}

.bor {
	border: 1px solid;
	box-sizing: border-box;
	padding: 20px;
	margin: 0px 300px 0px 0px;
}

.btn {
	margin: 10px 10px 10px 520px;
}

.bb {
	float: left;
	padding: 60px;
	margin: -450px -2px 0px 97px;
	width: 100%;
	max-width: 200px;
}

.def {
	display: flow-root;
	max-width: 200px;
	width: 100%;
	margin: 0px;
}

.table {
	float: left;
}

.table3 {
	box-sizing: border-box;
	padding: 15px;
	margin: 100px 0px 130px 100px;
	float: left;
}

.table4 {
	margin: 0px 70px 131px 100px;
	float: left;
}

.wow {
	width: 100%;
}

body { /* background-color: #dee8ff; */
	background-image:
		url('https://cdn.pixabay.com/photo/2019/04/10/12/40/watercolour-4117017_960_720.png');
	width: 100%;
	height: 100vh;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}
</style>

<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
	$(document)
			.ready(function() {/* 
				$.post("http://localhost:8080/app/getRoomList",{},function(result){
					console.log(result);
					$.each(result,function(ndx,value){
						str='<option value="'+value['roomcode']+'">'+value['roomname']+','+
						value['typename']+','+value['howmany']+','+value['howmuch']+'</option>';
					$('#pickRoom').append(str);
					// <option value="2">백두산,Suite Room,8,500000</option>
					});
				},'json');
				return false; */
			})

			.on('click', '#pickRoom option', function() {
				let str = $(this).text();
				let ar = str.split(',');
				$('#roomSearch').val(ar[0]);
				$('#roomtype').val(ar[1]);
				$('#humans').val(ar[2]);
				$('#gunMoney').val(ar[3]);
				let code = $(this).val();
				$('#roomcode').val(code);
				//$('#day').val($('#checkin').val());
				//	$('#checkin').val($('#checkout').val());
				//$('#day,#checkin').trigger('change');
				return false;
			})

			.on(
					'click',
					'#upDate',
					function() {
						let roomname = $('#roomSearch').val();
						let roomtype = $('#roomtype').val();
						let howmany = $('#humans').val();
						let checkin = $('#checkin').val();
						let checkout = $('#checkout').val();
						let gunMoney = $('#gunMoney').val();
						let name = $('#name').val();
						let mobile = $('#mobile').val();

						//validation(유효성 검사)
						if (roomname == '' || roomtype == '' || howmany == ''
								|| checkin == '' || checkout == ''
								|| gunMoney == '' || name == '' || mobile == '') {
							alert("누락된 값이 있습니다.");
							return false;
						}
						let bookcode = $('#bookcode').val();
						if (bookcode == '') { //insert
							$.post('http://localhost:8080/app/addBooking', {
								roomcode : $('#roomcode').val(),
								howmany : $('#humans').val(),
								checkin : $('#checkin').val(),
								checkout : $('#checkout').val(),
								total : $('#gunMoney').val(),
								booker : $('#name').val(),
								mobile : $('#mobile').val()
							}, function(result) {
								if (result == 'ok') {
									txt = '<option value="'
											+ $('#roomcode').val() + '">'
											+ $('#roomSearch').val() + ','
											+ $('#roomtype').val() + ','
											+ $('#humans').val() + ','
											+ $('#gunMoney').val() + ','
											+ $('#checkin').val() + '~'
											+ $('#checkout').val() + ','
											+ $('#name').val() + ','
											+ $('#mobile').val() + '</option>';
									$('#okRoom').append(txt);
									$('#no').trigger('click');
									//$("#pickRoom option:selected").remove();
								}
							}, 'text');
						} else {
							$.post('http://localhost:8080/app/updateBooking', {
								bookcode : $('#bookcode').val(),
								howmany : $('#humans').val(),
								booker : $('#name').val(),
								mobile : $('#mobile').val()
							}, function(result) {
								if (result == "ok") {
									$('#search').trigger('click');
								}
							}, 'text');
						}
					})

			.on(
					'click',
					'#no',
					function() {
						$(
								'#roomSearch,#roomtype,#humans,#gunMoney,#checkin,#checkout,#name,#mobile')
								.val('');
						return false;
					})

			.on(
					'change',
					'#checkin,#checkout',
					function() {
						let checkin = $('#checkin').val();
						let checkout = $('#checkout').val();
						console.log('checkin [' + checkin + '] checkout ['
								+ checkout + ']');
						if (checkin == '' || checkout == '')
							return false;
						checkin = new Date(checkin);
						checkout = new Date(checkout);
						if (checkin > checkout) {
							alert("날짜를 다시 설정하세요.");
							return false;
						}
						let ms = Math.abs(checkout - checkin);
						console.log(ms);
						let days = Math.ceil(ms / (1000 * 60 * 60 * 24));
						console.log(days);
						let total = days * parseInt($('#price').val());
						console.log(total);
						$('#gunMoney').val(total);
						return false;
					})

			.on(
					'click',
					'#search',
					function() {
						$.post('http://localhost:8080/app/findBooked', {
							checkin : $('#sday').val(),
							checkout : $('#eday').val()
						}, function(result) {
							$('#okRoom').empty();
							$.each(result.arBooked, function(ndx,value) {
							//(result-변수명(배열,리스트) ndx==시작위치를 처음부터, value==사용할 변수명)
								str = '<option value="'+value.roomcode+'">'
										+ value.roomname + ','
										+ value.typename + ','
										+ value.howmany + '</option>';
								$('#okRoom').append(str);
								//$("#pickRoom option:selected").remove();
							});
							$('#checkin').val($('#sday').val());
							$('#checkout').val($('#eday').val());
							//$('#day,#checkin').trigger('change');
							$('#no').trigger('click');
						}, 'json')

						$.post('http://localhost:8080/app/goBooking', {
							checkin : $('#sday').val(),
							checkout : $('#eday').val()
						}, function(result) {
							$('#pickRoom').empty();
							$.each(result, function(ndx, value) {
								str = '<option value="'+value['roomcode']+'">'
										+ value['roomname'] + ','
										+ value['typename'] + ','
										+ value['howmany'] + ','
										+ value['howmuch'] + '</option>';
								$('#pickRoom').append(str);
							})
							$('#no').trigger('click');
						}, 'json');
						return false;
					})

			.on('click', '#okRoom option', function() {
				let str = $(this).text();
				let ar = str.split(',');
				$('#roomSearch').val(ar[0]);
				$('#roomtype').val(ar[1]);
				$('#humans').val(ar[3]);
				$('#checkin').val(ar[4]);
				$('#checkout').val(ar[5]);
				$('#gunMoney').val(ar[6]);
				$('#name').val(ar[7]);
				$('#mobile').val(ar[8]);
				let code = $(this).val();
				ar = code.split(',');
				$('#bookcode').val(ar[0]);
				$('#roomcode').val(ar[1]);
				return false;
			})

			.on('click', '#noBooking', function() {
				$.post('http://localhost:8080/app/deleteBooking', {
					bookcode : $('#bookcode').val()
				}, function(result) {
					console.log(result);
					if (result == "ok") {
						$('#no').trigger('click'); //입력란 비우기
						$('#okRoom option:selected').remove(); //room리스트에서 제거.
					}
				}, 'text');
				return false;
			})

	var message = '${message}';
	console.log("message: " + message);
	if (message != null && message != undefined && $.trim(message) != '') {
		//message값이 널이 아니고, undefined(어떠한 값으로도 할당되지 않아 자료형이 정해지지(undefined) 않은 상태)
		//도 아니고, message가 trim(공백)이 아닐때 if문 안으로 들어와 Controller에서 전하는 message 출력.
		alert(message);
	}
</script>
</html>