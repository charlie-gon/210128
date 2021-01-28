<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

<style>
	tr.row:hover{
		background: turquoise;
		cursor: pointer;
	}
</style>

<script>
	function formSubmit(str){
		frm.bId.value = str;
		frm.submit();
		
	}
</script>

</head>
<body>

	<div align="center">
		<h1>게시글 목록</h1>
		<div>
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
	</div>
	<div align="center">
		<table border="1">
			<tr>
				<th width="50">글번호</th>
				<th width="100">제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일자</th>
				<th width="50">조회수</th>
			</tr>

			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">게시글이 없습니다.</td>
				</tr>
			</c:if>

			<c:if test="${not empty list }">
				<c:forEach var="vo" items="${list }">
					<tr align="center" class="row" onclick="formSubmit(${vo.bId })">
						<td>${vo.bId }</td>
						<td>${vo.bTitle }</td>
						<td>${vo.bName }</td>
						<td>${vo.bDate }</td>
						<td>${vo.bHit }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<p />
		<div>
			<button type="button" onclick="location.href='boardForm.do'">글쓰기</button>&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="location.href='/210128/main.do'" value="홈으로 이동">
		</div>
		
	</div>

</body>
</html>