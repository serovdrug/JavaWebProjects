<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Notes | List</title>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<style>
		.bs-example {
			margin: 0.5em 0;
			padding: 0.5em;
			border: 1px solid #DDD;
			border-radius: 10px 0px 10px 0px;
			box-shadow: none;
		}
		
		.additional {
			padding-left: 10px;
			padding-right: 10px;
		}
		
		body {
			padding-left:  (@grid-gutter-width / 2);
			padding-right: (@grid-gutter-width / 2);
		}
	</style>
</head>
<body>
<div class="container">
<form id="addform" method="post">
  	<div class="input-group">
		<textarea id="newnote" class="form-control custom-control" name="newnote" rows="3" 
					autofocus placeholder="What's on your mind, ${username}?" style="resize:none" 
					onkeypress="if(event.keyCode==10||(event.ctrlKey && event.keyCode==13))add.click();"></textarea>
		<span id="add" class="btn btn-primary input-group-addon" onclick="addform.submit();">Add Note</span>
		</div>
	<input name="username" type="hidden" value="${username}">
</form>
<hr>

<div class="row">
  <c:forEach items="${notesList}" var="item">
    <div class="col-md-3 ">
    <div class="bs-example">
      <span class="close" aria-label="Close"><span aria-hidden="true">&times;</span></span>
          ${item}
      </div>
    </div>
  </c:forEach>
</div>
</div>
</body>
</html>