<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>통장 만들기</h2>
	<form id="accountForm" action="<%=request.getContextPath()%>/account.do">
		입금액	<input type="text" name="money"/> <br/>
		<input type="submit" id="btn" value="전송"/> 
	</form>
</div>	
<script>	<!-- 자바스크립트 -->
$('#accountForm').submit(function() {	
	alert('통장 테스트!');	
});
</script>
</body>
</html>