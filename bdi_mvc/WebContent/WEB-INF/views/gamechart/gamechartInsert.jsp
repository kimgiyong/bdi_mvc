<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test='${!empty msg}'>
	<script>
		alert('${msg}');
		if(confirm("다시 등록하시겠습니까?")){
			location.href="/views/gamechart/gamechartInsert";
		}else{
			location.href="/gamechart/gamechartList";
		}
	</script>
</c:if>
<div class="container">
	<form action="/gamechart/gamechartInsert" method="post">
		<table class="table table-bordered">
			<tr>
				<th>게임이름</th>
				<td><input type="text" name="게임이름"></td>
			</tr>
			<tr>
				<th>게임가격</th>
				<td><input type="number" name="게임가격"></td>
			</tr>
			<tr>
				<th>게임제작사</th>
				<td><input type="text" name="게임제작사"></td>
			</tr>
			<tr>
				<th>게임수량</th>
				<td><input type="number" name="게임수량"></td>
			</tr>
			<tr>
				<th>게임설명</th>
				<td><textarea name="게임설명"></textarea></td>
			</tr>
			<tr>
				<th>게임로고</th>
				<td><input type="text" name="게임로고"></td>
			</tr>
			<tr>
				<td colspan="2"><button>게임등록</button></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>