<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<style>
	tr div{float:right;}
</style>
<div class="container">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="7">사용자목록
					<div><button data-page="/views/userinfo/userInfoInsert">사용자등록</button></div></th>
				</tr>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>사용자설명</th>
					<th>나이</th>
					<th>소속번호(1~10)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="a">
					<tr>
						<td>${a.uiNo}</td>
						<td><a href="/userinfo/userInfoView?uiNo=${a.uiNo}">${a.uiName}</a></td>
						<td>${a.uiId}</td>
						<td>${a.uiDesc}</td>
						<td>${a.uiAge}</td>
						<td>${a.diNo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>