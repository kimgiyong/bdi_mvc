<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<th colspan="2"><button onclick="insertDel()">등록</button>
					<button onclick="goPage()">취소</button>
					</th>
				</tr>
			</thead>
		</table>
	</div>
	<script>
		function insertDel(){
			var val = document.querySelectorAll('input');
			var param = '?';
			for(var a=0;a<val.length;a++){
				param += val[a].name + "=" + val[a].value + '&';
			}
			location.href='/user/userInsert'+ param;
		}
		function goPage(){
			location.href='/user/userList';
		}
		
	</script>
</body>
</html>