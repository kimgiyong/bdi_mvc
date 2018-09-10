<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<div style="margin:10px">게임리스트<button style="float:right" data-page="/views/gamechart/gamechartInsert">게임등록</button></div>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>게임번호</th>
				<th>게임이름</th>
				<th>게임가격</th>
				<th>게임제작사</th>
				<th>게임수량</th>
				<th>게임설명</th>
				<th>게임로고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gamechart}" var="gc">
				<tr>
					<td>${gc.gcNum}</td>
					<td><a href="/gamechart/gamechartView?gcNum=${gc.gcNum}">${gc.gcName}</a></td>
					<td>${gc.gcPrice}</td>
					<td>${gc.gcVendor}</td>
					<td>${gc.gcOrder}</td>
					<td>${gc.gcDesc}</td>
					<td>${gc.gcImg}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>