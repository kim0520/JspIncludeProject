<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.row{
   width:450px;
}
</style>
<script type="text/javascript">
$(function(){
	$('#postBtn').click(function(){
		var dong=$('#dong').val();
		if(dong.trim()=="")
		{
			$('#dong').focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'../member/postfind_ok.jsp',
			data:{"dong":dong},
			success:function(res)
			{
				$('#result').html(res);
			}
		});
	});
});

</script>
</head>
<body>
  <div class="container">
  <div class="row">
  <table class="table">
  <tr>
  <td> 입력: <input type="text" id="dong" size=12>
  <input type="button" class="btn btn-sm btn-success"  value="검색" id="postBtn">
  </td>
  </tr>
  </table>
  <div id="result">
  
  </div>
  </div>
  </div>
  
</body>
</html>