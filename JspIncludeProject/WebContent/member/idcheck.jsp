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
   width:280px;
}
</style>
<script type="text/javascript">
$(function(){ // window.onload
	$('#checkBtn').click(function(){
		var id=$('#id').val();
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		
		$.ajax({
			type:'post',
			url:'idcheck_ok.jsp',
			data:{"id":id}, // idcheck_ok.jsp?id=aaa
		    success:function(res)
		    {
		    	var html="";
		    	if(res.trim()==0)
		    	{
		    		html="<tr><td>"+id+"는(은) 사용 가능한 아이디입니다</td></tr>"
		    		    +"<tr><td class='text-center'><input type='button' class='btn btn-sm btn-success' onclick=ok() value=확인></td></tr>";
		    	}
		    	else
		    	{
		    		html="<tr><td>"+id+"는(은) 사용중인 아이디입니다</td></tr>";
		    	}
		    	$('#result').html(html);
		    }
		});
	});
});
function ok()
{
	parent.frm.id.value=$('#id').val();
	parent.Shadowbox.close();
	}
</script>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
       <td>ID:<input type=text size=10 id=id>
           <input type=button value="중복체크" class="btn btn-sm btn-danger" id="checkBtn">
      </tr>
      <tr id="result" class="warning">
      <table class="table" id="result">
      </table>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>










