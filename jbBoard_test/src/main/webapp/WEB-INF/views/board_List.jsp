<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JB 게시판 목록</title>

<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>

<script type="text/javascript">
	function move(url) {
		/* alert("페이지이동"); */
		location.href = url;
	}
</script>

</head>
<body>
	<h1>${message}</h1>
	<marquee behavior="alternate" scrolldelay="100" direction="right">
		게시판 리스트 테스트 입니다. </marquee>
	<table class="board" width="1000" height="200" border="2" bgcolor="d8d8d8">
		<colgroup>
			<col width="100" />
			<col width="250" />
			<col width="100" />
			<col width="400" />
			<col width="100" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<th>번    호</th>
				<th>제    목</th>
				<th>작 성 자</th>
				<th>내    용</th>
				<th>작 성 일</th>
				<th>조 회 수</th>
			</tr>
		</thead>
		
		<!-- 디비에 저장된 게시판이 반복됨 -->
		<tbody>
			<c:forEach var = "item" items="${list}" varStatus="status">
			<tr>
				<td align="center">${item.seq }</td>
				<td><a href="./${item.seq}">${item.title}</a></td>
				<td align="center">${item.user_name }</td>
				<td align="center">${item.content }</td>
				<td align="center">${item.reg_datetime }</td>
				<td align="center">${item.cnt }</td>
			</tr>
			</c:forEach>
		</tbody>
	<tfoot>
		<tr>
		<td align="center" colspan="5" width="50">1</td>
	</table>
		<!-- <input type="button" value="처음으로(index)" onclick="move('index.jsp')"> -->
		<input type="button" value="글쓰기" onclick="move('./write_move')"/>
		
</body>
</html>