<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

	window.onload = function(){
		
		regBtn.addEventListener('click', function(){
			regForm.submit();
		})
		
	}

</script>
<div class="container-fluid">
	<!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">도서등록</h2>
        </div>
        <div class="card-body">
    		<!-- 등록폼 -->
    		<form action="/bookRegProcess" name="regForm" method="post">
    			
    			<div class="input-group mb-3">
				  <span class="w-20 input-group-text text-center" id="basic-addon1">도서명</span>
				  <!-- 서버에 값을 넘길 요소 -->
				  <input type="text" class="form-control radius-10" name="title" 
				  			aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
				  <span class="w-20 input-group-text" id="basic-addon1">작가명</span>
				  <input type="text" class="form-control" name="author"
				  			aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
				  <span class="w-20 input-group-text" id="basic-addon1">도서소개</span>
				  <input type="text" class="form-control" name="content" 
				  			aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
				  <span class="w-20 input-group-text" id="basic-addon1">표지이미지</span>
				  <input type="file" class="form-control" id="inputGroupFile01" name="imgFile" >
				</div>
    			<p><button type="button" class="btn btn-dark" id="regBtn">도서등록</button></p>
    		
    		</form>
    
        </div>
   	</div>

</div>
</body>
</html>