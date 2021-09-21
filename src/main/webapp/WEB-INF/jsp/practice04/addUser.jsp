<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원정보추가</h1>
		
		<form method="post" action="/practice04/ex01/add_user">
			<label for="name"><b>이름:</b><input type="text" id="name" name="name" class="form-control" placeholder="이름을 입력하세요"></label><br>
			<label for="yyyymmdd"><b>생년월일:</b><input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control" placeholder="예) 19990101"></label><br>
			<b>자기 소개:</b><br>
			<textarea name="introduce" rows="10" cols="5" class="form-control"></textarea><br>
			<label for="email" class="w-25"><b>이메일 주소:</b><input type="text" id="email" name="email" class="form-control" placeholder="이메일 주소를 입력하세요"></label><br>
			
			<p><input type="submit" class="btn btn-success" value="추가"></p>
		</form>
		
	</div>

</body>
</html>