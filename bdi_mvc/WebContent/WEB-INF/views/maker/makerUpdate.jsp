<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test="${!empty map}">
<script>
	alert('${map.msg}');
	if('${map.success}'== 'true'){
		location.href="/maker/makerList";
	}
</script>
</c:if>
<div class="container">
	<form action="/maker/makerUpdate" method="post">
	<table class="table table-bordered table-bover">
		<tr>
			<th>번호</th>
			<td>${maker.mnum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${maker.mname}"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="price" value="${maker.mprice}"></td>
		</tr>
		<tr>
			<th>수량</th>
			<td><input type="text" name="cnt" value="${maker.mcnt}"></td>
		</tr>
		<tr>
			<th>메이커설명</th>
			<td><input type="text" name="desc" value="${maker.mdesc}"></td>
		</tr>
		<tr>
			<td colspan="2"><button>데이터 수정</button></td>
		</tr>
	</table>
	<input type="hidden" type="number" name="mNum" value="${maker.mnum}">
	</form>
</div>
</body>
</html>