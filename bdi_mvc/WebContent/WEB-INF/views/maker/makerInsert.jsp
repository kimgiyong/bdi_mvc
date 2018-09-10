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
	<form action="/maker/makerInsert" method="post">
		<table class="table table-bordered table-hover">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" name="cnt"></td>
			</tr>
			<tr>
				<th>메이커설명</th>
				<td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<td colspan="2"><button>메이커등록</button></td>
			</tr>
	</table>
	</form>
</div>
</body>
</html>