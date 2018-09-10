<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test='${!empty msg}'>
	<script>
		alert('${msg}');
		if(confirm("다시 수정하시겠습니까?")){
			location.href="/views/gamechart/gamechartUpdate";
		}else if(confirm("게임정보로 돌아가시겠습니까?")){
			location.href="/gamechart/gamechartView";
		}else{
			location.href="/gamechart/gamechartList";
		}
	</script>
</c:if>
<div class="container">
	<form action="/gamechart/gamechartUpdate" method="post">
		<table class="table table-bordered">
			<tr>
				<th>게임이름</th>
				<td><input type="text" name="게임이름" value="${gamechart.gcName}"></td>
			</tr>
			<tr>
				<th>게임가격</th>
				<td><input type="number" name="게임가격" value="${gamechart.gcPrice}"></td>
			</tr>
			<tr>
				<th>게임제작사</th>
				<td><input type="text" name="게임제작사" value="${gamechart.gcVendor}"></td>
			</tr>
			<tr>
				<th>게임수량</th>
				<td><input type="number" name="게임수량" value="${gamechart.gcOrder}"></td>
			</tr>
			<tr>
				<th>게임설명</th>
				<td><textarea name="게임설명">${gamechart.gcDesc}</textarea></td>
			</tr>
			<tr>
				<th>게임로고</th>
				<td><input type="text" name="게임로고" value="${gamechart.gcImg}"></td>
			</tr>
			<tr>
				<td colspan="2"><button data-page="/gamechart/gamechartList">리스트돌아가기</button>
				<button data-page="/gamechart/gamechartView?gcNum=${gamechart.gcNum}">게임정보로 돌아가기</button>
				<button>게임수정</button></td>
			</tr>
		</table>
		<input type="hidden" name="게임숫자" value="${gamechart.gcNum}">
	</form>
</div>
</body>
</html>