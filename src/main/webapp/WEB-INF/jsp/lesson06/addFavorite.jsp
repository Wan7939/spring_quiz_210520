<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
  <%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> --%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control col-3">
		</div>
		<div class="form-group">
			<label for="url">제목</label>
			
			<div class="form-inline">
				<input type="text" id="url" class="form-control col-3">
				<button type="button" id="ckeckDuplicateBtn" class="btn btn-info ml-3">중복확인</button>
			</div>
			<small id="isDuplicationText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableUrlText" class="text-success d-none">저장 가능한 url 입니다.</small>
			
		</div>
		
		<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button>
	</div>
	<script>
		$(dovument).ready(function(){
			// quiz02) url 중복 확인
			$('availableUrlText').on('click',function(){
				//	alert("클릭")
				let url = $('#url').val().trim();
				if (url == ''){
					alert("검사할 url을 입력해주세요.");
					return;
				}
			
				$.ajax({
					type:'post'
					, url'/lesson06/quiz01/check_duplication_url'
					, data: {'url':url}
					, success: function(data) {
						id (data.isDuplication == true) {
							// 중복
							$('isDuplicationText').removeClass=('d-none')
							$('availableUrlText').addClass=('d-none')
						} else {
							$('isDuplicationText').addClass=('d-none')
							$('availableUrlText').removeClass=('d-none')
							// 사용가능
						}
						
					}, error :function(e) {
						alert("error" + e);
					}
				})
				
			});
			
			$('#addBtn').on('click', function(){
				let name = $('name').val().trim();
				let url = $('#url').val().trim();
				
				if(name == ''){
					alret("제목을 입력해주세요.")
					return;
				}
				
				if(url == ''){
					alret("URL을 입력해주세요.")
					return;
				}
				
				if(url.startsWith('http') == false && url.startsWith('https') == false){
					alret("주소 형식이 잘못되었습니다.")
					return;
				}
				
				// 서버에 보내기 AJAX 통신
				$.ajax({
					type:'POST'
					, url: '/lesson06/quiz01/add_favorite'
					, data: {'name': name, 'url' : url, url}
				
					 , dataType: 'json'  // response body
					, success: function(data){
						// AJAX 통신후 response body로 String 또는 JSON이 리턴되어야 한다.
						// alert(data.result);
						if (data.result == 'success'){
							location.href = "/lesson06/quiz01/favorite_list"
						} else {
							alert("실패했습니다.");
						}
					}, error: function(e) {
						alert("에러: " + e);
					}
				})
			});
		});
		
	</script>
</body>
</html>