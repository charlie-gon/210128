<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>

<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("진심이십니까?");
		if (yn) {
			location.href = "boardDelete.do?row=" + ${vo.bId};
		} else {

		}
	}

</script>
</head>
<body>

	<div align="center">
		<h1>게시글 상세 페이지</h1>
		
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
						required="required">${vo.bContent }</textarea></td>
			</tr>
		</table>

		<p />
		<div>
			<button type="button" onclick="location.href='/210128/boardEditForm.do?row='+${vo.bId}">글 수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteAlert()">글 삭제</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='/210128/boardList.do'">목록으로이동</button>
		</div>
		
		</div>

</body>
</html>