<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스프링 게시판 리스트</title>
</head>
<body>
	<h1>${message }</h1>
	<table border="1">
		<colgroup>
			<col width="60">
			<col>
			<col width="115">
			<col width="85">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">내용</th>
				<th scope="col">등록일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>

		<!-- 몽록이 반복될 영역 -->
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td>${item.seq}</td>
					<td><a href="./${item.seq}">${item.title}</a></td>
					<td><a href="./${item.seq}">${item.user_name}</td>
					<td><a href="./${item.seq}">${item.content}</td>
					<td>${item.reg_datetime}</td>
					<td>${item.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <input type="button" value="글쓰기" onclick="location.href='./move_write' "> -->
	<input type="button" value="글쓰기" onclick="location.href='./write' ">
</body>
</html>