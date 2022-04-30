<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	async function uploadFile()
	{
		let formData = new FormData();
		formData.append("files", upload.files[0]);
		formData.append("title", title.value);
		
		const response = await fetch("/FileUploadServlet",{
			method : "POST",
			header : {
				"Content-Type" : "multipart/form-data"
			},
			body : formData,
		});
		
		const msg = await response.text();
	}
</script>

</head>
<body>

<form action="/FileUploadServlet" method="post" enctype="multipar/form-data">
	
	<input type="text" id="title" multiple requiered>
	<input type="file" id="upload" multiple requiered>
	<button id="button" onclick="uploadFile()">파일 업로드</button>
</form>

</body>
</html>