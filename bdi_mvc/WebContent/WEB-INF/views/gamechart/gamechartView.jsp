<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test='${!empty msg}'>
	<script>
		alert('${msg}');
		location.href="/gamechart/gamechartList";
	</script>
</c:if>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>게임이름</th>
			<td>${gamechart.gcName}</td>
		</tr>
		<tr>
			<th>게임가격</th>
			<td>${gamechart.gcPrice}</td>
		</tr>
		<tr>
			<th>게임제작사</th>
			<td>${gamechart.gcVendor}</td>
		</tr>
		<tr>
			<th>게임수량</th>
			<td>${gamechart.gcOrder}</td>
		</tr>
		<tr>
			<th>게임설명</th>
			<td>${gamechart.gcDesc}</td>
		</tr>
		<tr>
			<th>게임로고</th>
			<td>${gamechart.gcImg}</td>
		</tr>
		<tr>
			<td colspan="2"><button data-page="/gamechart/gamechartList">돌아가기</button>
			<button data-page="/gamechart/gamechartUpdate?gcNum=${gamechart.gcNum}">수정하기</button>
			<button data-page="/gamechart/gamechartDelete?gcNum=${gamechart.gcNum}">삭제하기</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>