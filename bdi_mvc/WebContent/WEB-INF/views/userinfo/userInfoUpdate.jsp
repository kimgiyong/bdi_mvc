<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test="${!empty success}">
	<script>
		alert("${success}");
		location.href="/userinfo/userInfoList";
	</script>
</c:if>
<div class="container">
	<form action="/userinfo/userInfoUpdate" method="post" onsubmit="return check()">
		<table class="table table-bordered table-hover">
			<tr>
				<th>번호</th>
				<td>${user.uiNo}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName" value="${user.uiName}"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId" value="${user.uiId}"></td>
			</tr>
			<tr>
				<th>기존 비밀번호</th>
				<td><input type="password" id="pwd" name="Pwd"></td>
			</tr>
			<tr>
				<th>바꿀 비밀번호</th>
				<td><input type="password" id="pwdOK" name="uiPwd"></td>
			</tr>
			<tr>
				<th>바꿀 비밀번호 확인</th>
				<td><input type="password" id="pwdOK2" name="uiPwdOK"></td>
			</tr>
			<tr>
				<th>사용자설명</th>
				<td><textarea name="uiDesc">${user.uiDesc}</textarea></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="uiAge" value="${user.uiAge}"></td>
			</tr>
			<tr>
				<th>소속(1~10)</th>
				<td><input type="number" name="diNo" value="${user.diNo}" min="1" max="10"></td>
			</tr>
			<tr>
				<td colspan="2"><button>수정</button></td>
			</tr>
		</table>
		<input type="hidden" name="uiNo" value="${user.uiNo}">
	</form>
</div>
<script>
	function check(){
		var ch = document.querySelectorAll('input[type=text],input[type=number]');
		var pwd = document.getElementById('pwd');
		var pwdOK = document.getElementById('pwdOK');
		var pwdOK2 = document.getElementById('pwdOK2');
		for(a=0;a<ch.length;a++){
			var value = ch[a].value.trim();
			if(value==''){
				alert(ch[a].name + "를 채워주세요");
				ch[a].focus();
				return false;
			}
		}if(pwd.value!="${user.uiPwd}"){
			alert("기존 비밀번호를 확인해주세요");
			pwd.focus();
			return false;
		}else if(pwdOK.value==""&&pwdOK2.value==""){
			pwdOK.value = pwd.value;
			return true;
		}
		else if(pwdOK.value!=pwdOK2.value){
			alert("바꿀 비밀번호를 확인해주세요");
			pwdOK2.focus();
			return false;
		}
		
		return true;
	}
</script>
</body>
</html>