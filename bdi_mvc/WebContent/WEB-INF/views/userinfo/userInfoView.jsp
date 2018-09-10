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
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${user.uiNo}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${user.uiName}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.uiId}</td>
			</tr>
			<tr>
				<th>사용자설명</th>
				<td>${user.uiDesc}</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${user.uiAge}</td>
			</tr>
			<tr>
				<th>소속(1~10)</th>
				<td>${user.diNo}</td>
			</tr>
			<tr>
				<td colspan="7">
				<button data-page="/userinfo/userInfoList">목록으로 돌아가기</button>
				<button data-page="/userinfo/userInfoUpdate?uiNo=${user.uiNo}">사용자 수정하기</button>
				<button data-page="/userinfo/userInfoDelete?uiNo=${user.uiNo}">사용자 삭제하기</button>
			</tr>
		</table>
</div>
</body>
</html>