<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>

<style type="text/css">
.pointer{
	cursor:pointer;
}
input[name="pageNo"],[name="amount"] {
    display: none;
}
body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 20px #a39485 solid;
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  
  
  }

</style>

<script type="text/javascript">

window.onload = function(){
	// 요소선택
	let regBtn = document.querySelector("#regBtn");
	
	// 이벤트 부여
	regBtn.addEventListener('click', function(){
		location.href = "/book/reg.jsp";
	});
	
	searchBtn.addEventListener('click', function(){
		searchForm2.action = "/bookList";
		searchForm2.submit();
	})
	
	
}

function view(no){
	location.href = "/view?no=" + no;
}



</script>

</head>
<body>

<h2><a href="/bookList"> 도서 목록 </a></h2>
		<form name="searchForm2" action="/bookList">
		<br>
			<div class="input-group">
				<select class="form-select" name="searchField"
					id="inputGroupSelect04"
					aria-label="Example select with button addon">
					<!-- 선택된 요소의 value값이 서버로 넘어갑니다. -->
					<option value="title"
						${pageDto.cri.searchField eq 'title' ? 'selected' : ''}>도서명</option>
					<option value="author"
						${pageDto.cri.searchField eq 'author' ? 'selected' : ''}>작가</option>
				</select> <input type="text" name="searchWord"
					value="${pageDto.cri.searchWord }" class="form-control"
					aria-label="Text input with dropdown button">
				<button class="btn btn-outline-secondary" type="button"
					id="searchBtn">검색</button>
			</div>
			<br>
		</form>
		<p><button type="button" class="btn btn-dark" id="regBtn">도서등록</button></p>
	<form action="" name="searchForm">
	<input name="pageNo">
	<input name="amount" value="10">
</form>
<table>
    <thead>
    <tr>
        <th>도서 번호</th>
        <th>도서명</th>
        <th>작가명</th>
        <th>대여 여부</th>
    </tr>
    </thead>
    <tbody>
	   <c:if test="${empty list}">
			<tr>
				<td colspan="4" align="center">
					도서 목록이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.no}</td>
					<td class="pointer" onclick="view(${dto.no})">${dto.title }</td>
					<td>${dto.author }</td>
					<td>${dto.rentynStr }</td>
				</tr>
			</c:forEach>
		</c:if>
    </tbody>
</table>

<div style="position: fixed; bottom: 2%; left: 0; width: 100%;">
    <%@ include file="/book/pageNavi.jsp" %>
</div>

</body>
</html>