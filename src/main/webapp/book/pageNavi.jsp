<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<style type="text/css">
.page-link{
	cursor:pointer;
}
.nav{
        justify-content: center; /* 가로 가운데 정렬 (flex 방식) */
}
</style>
<script type="text/javascript">
	function goPage(pageNo) {
		searchForm.pageNo.value = pageNo
		searchForm.submit();
	}
</script>
</head>
<body>
<nav aria-label="Page navigation example" class="nav">
	<ul class="pagination">
		<li class="page-item${pageDto.prev ? '' : 'disabled' }">
			<a class="page-link" onclick="if (${pageDto.cri.pageNo} > 1) goPage(${pageDto.cri.pageNo - 1})">
				Previous
			</a>
		</li>
	<c:forEach begin="${pageDto.startNo }" end="${pageDto.endNo }" var="i">
		<li class="page-item">
			<a class="page-link ${pageDto.cri.pageNo eq i ? 'active' : ''}" onclick="goPage(${i})" >
				${ i }
			</a>
		</li>
	</c:forEach>
		<li class="page-item">
			<a class="page-link" onclick="if (${pageDto.cri.pageNo} < ${pageDto.realEnd }) goPage(${pageDto.cri.pageNo + 1})">
				Next
			</a>
		</li>
	</ul>
</nav>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>