<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 Form</title>

<script type="text/javascript">
	function editAlert() {
		frm.action = "boardEditComplete.do";
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>게시글 수정 페이지</h1>
		<div>
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="bId" name="bId" value="${vo.bId }">


				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td align="center">${vo.bName }</td>
						<th width="100">작성일자</th>
						<td align="center">${vo.bDate }</td>
						<th width="100">조회수</th>
						<td align="center">${vo.bHit }</td>
					</tr>
					<tr>
						<th width="100">제목</th>
						<td align="center">${vo.bTitle }</td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="7"><textarea rows="10" cols="100"
								required="required" id="bContent" name="bContent">${vo.bContent }</textarea></td>
					</tr>
				</table>

				<p />
				<div>
					<button type="button" onclick="editAlert()">수정완료</button>
					&nbsp;&nbsp;
					<button type="reset">취소</button>
					&nbsp;&nbsp;
					<button type="button"
						onclick="location.href='/210128/boardList.do'">목록으로 이동</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>