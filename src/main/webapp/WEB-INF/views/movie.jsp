<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie</title>
<style>
table, tr, th, td {border: 1px solid black;}
table, tr, th, td {width: 100%; height: 100px;}

</style>
</head>
<body>
	<div class="col-md-12">
		<h1>영화 검색</h1>
		<div class="col-md-4">
			<form>
				<div class="form-group">
					<input type="text" class="form-control" id="keyword"
						placeholder="검색어를 입력하세요">
					<button type="button" class="btn btn-primary" id="btn-movies-find">검색</button>
				</div>
		</div>
		<br/><hr/>
		<h1>영화 검색 결과</h1>
		
		<div class="data_area">
			<div class="data_area_header"> <!-- 공통된 데이터들을 div에 출력. -->
				<div>lastBuildDate : </div>
				<div>total : </div>
				<div>start : </div>
				<div>display : </div>
			</div>
			<br/><br/>
			<table>
				<thead>
					<tr>
						<th>title</th>
						<th>link</th>
						<th>image</th>
						<th>subtitle</th>
						<th>pubDate</th>
						<th>director</th>
						<th>actor</th>
						<th>userRating</th>
					</tr>
				</thead>
				
				<tbody>	
				</tbody>
				
			</table>
		</div>
	</div>
	
	
</body>

<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
	var main = {
		init : function() {
			var _this = this;
			$('#btn-movies-find').on('click', function() {
				_this.find();
			});
		},
		find : function() {
			var keyword = $('#keyword').val();
			
			$.ajax({
				type : 'GET',
				url: '/app/movie/'+keyword ,
				dataType : 'json',
				contentType : 'application/json; charset=utf-8', //content-type이란 간단히 말해 보내는 자원의 형식을 명시하기 위해 헤더에 실리는 정보
			}).done(function(res) {
				
				var jsonData = JSON.stringify(res) //stringify 메소드는 json 객체를 String 객체로 변환시켜줌
				var str = [];	//JSON.parse()란? parse 메소드는 string 객체를 json 객체로 변환시켜줌.
				
				str.push("<div>lastBuildDate : "); // push 배열의 끝에 요소를 추가
				str.push(res.lastBuildDate); //res. 안에 데이터(lastBuildDate)를 생성
				str.push("</div>");
				str.push("<div>total : ");
				str.push(res.total);
				str.push("</div>");
				str.push("<div>start : ");
				str.push(res.start);
				str.push("</div>");
				str.push("<div>display : ");
				str.push(res.display);
				str.push("</div>");
				
				$(".data_area_header").html(str.join(''));//html은 append와 달리, 요청에 따라 새로운 화면을 출력.
											//append는, 기존의 데이터 뒤에 새로운 요청에 따른 결과를 생성.
				
				str = [];
				
				for(i=0; i<res.items.length; i++) { //res란 json 데이터 안에, items의 리스트 들의 길이만큼 for문.
					console.log("i:"+res.items[i].title);
					
					str.push("<tr>");
					str.push("	<td>");
					str.push(res.items[i].title); //items안에, [i]배열 길이만큼, for문.
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].link);
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].image);
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].subtitle);;
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].pubDate);
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].director);
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].actor);
					str.push("	</td>");
					str.push("	<td>");
					str.push(res.items[i].userRating);
					str.push("	</td>");
					str.push("</tr>");
					$(".data_area tbody").html(str.join('')); //join() 메서드는 배열의 모든 요소를 연결해 하나의 문자열로 만듬
				}
				
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
			
		}
	};
	main.init();
</script>

</html>