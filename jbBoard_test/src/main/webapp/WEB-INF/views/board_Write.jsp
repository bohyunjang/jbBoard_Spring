<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>${message}</h1>
	<form id="form" method="post" action="./write_ok">
		<input type="hidden" name="seq" id="seq" value="${baord.seq }">
		<div>
			<span>번호</span>
			<textarea id="seq" name="seq" rows="10" cols="20">
			</textarea>
		</div>

		<div>
			<sapn>제목</sapn>
			<input type="text" id="title" name="title"
				value="${boards.subject }" />
		</div>
		<div>
			<spn>작성자</spn>
			<input type="text" id="user_name" name="user_name"
				value="${boards.user_name}" />
		</div>
		<div>
			<span>내용</span>
			<textarea id="content" name="content" rows="10" cols="20">
                ${boards.content}
            </textarea>
		</div>
		<div>
			<span>작성시간</span>
			<textarea id="reg_datetime" name=" content" rows="10" cols="20">
			</textarea>
		</div>
		<div>
			<span>조회수</span>
			<textarea id="cnt" name=" cnt" rows="10" cols="20">
			</textarea>
		</div>


		<div>
			<!-- <input type="button" value="저장" onclick="location.href='./write' "> -->
			<input type="submit" value="저장" /> 
			<input type="button" value="목록" onclick="location.href='./'">
		</div>
	</form>
</body>
</html>