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
	<form action="/userinfo/userInfoInsert" onsubmit="return check()" method="post">
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pwd" name="uiPwd"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" id="pwdOK" name="uiPwdOK"></td>
			</tr>
			<tr>
				<th>사용자설명</th>
				<td><textarea name="uiDesc"></textarea></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="uiAge"></td>
			</tr>
			<tr>
				<th>소속(1~10)</th>
				<td><input type="number" name="diNo" min="1" max="10"></td>
			</tr>
			<tr>
				<td colspan="2"><button>등록</button>
				<button type="button" data-page="/userinfo/userInfoList">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<script>
	function check(){
		var ch = document.querySelectorAll('input');
		var pwd = document.getElementById('pwd');
		var pwdOK = document.getElementById('pwdOK');
		for(a=0;a<ch.length;a++){
			var value = ch[a].value.trim();
			if(value==''){
				alert(ch[a].name + "를 채워주세요");
				ch[a].focus();
				return false;
			}
		}if(pwd.value!=pwdOK.value){
			alert("비밀번호를 확인해주세요");
			pwdOK.focus();
			return false;
		}
		return true;
	}
</script>
</body>
</html>