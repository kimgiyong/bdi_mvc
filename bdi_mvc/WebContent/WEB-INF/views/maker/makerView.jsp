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
	<table class="table table-bordered table-hover">
		<tr>
			<th>번호</th>
			<td>${maker.mnum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${maker.mname}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${maker.mprice}</td>
		</tr>
		<tr>
			<th>수량</th>
			<td>${maker.mcnt}</td>
		</tr>
		<tr>
			<th>총액</th>
			<td>${maker.mtotal}</td>
		</tr>
		<tr>
			<th>메이커설명</th>
			<td>${maker.mdesc}</td>
		</tr>
		<tr style="text-align:center">
			<td colspan="2">
	<!--
				<button onclick="location='/maker/makerList'">리스트로</button>
				<button onclick="location='/maker/makerUpdate?mNum=${maker.mnum}'">수정</button>
				<button onclick="location='/maker/makerDelete?mNum=${maker.mnum}'">메이커삭제</button>	-->
				<button data-page='/maker/makerList'>리스트로</button>
				<button data-page='/maker/makerUpdate?mNum=${maker.mnum}'>수정</button>
				<button data-page='/maker/makerDelete?mNum=${maker.mnum}'>메이커삭제</button>
			</td>
		</tr>
	</table>
</div>

</body>
</html>