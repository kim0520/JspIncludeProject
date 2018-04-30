<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.row{
   margin: 0px auto;
   width: 600px;
}
h2,h3{
  text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="../member/shadow/css/shadowbox.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="../member/shadow/js/shadowbox.js"></script>
<script type="text/javascript">
Shadowbox.init({players:["iframe"]});
function idcheck()
{
	Shadowbox.open({
		content:'../member/idcheck.jsp',
		title:'아이디중복체크',
		player:'iframe',
		width:250,
		height:200
	});
}


function postfind()
{
	Shadowbox.open({
		content:'../member/postfind.jsp',
		title:'우편번호 검색',
		player:'iframe',
		width:450,
		height:350
	});
}
</script>
</head>
<body>
 <div id="content-wrapper">
					<div id="content">
						<div class="container">
							<div class="row">
								<div class="12u">

									<!-- Main Content -->
										<section>
											<header>
												<h2>회원가입</h2>
												<h3><font color=red>*</font>은 필수 입력사항</h3>
											</header>
											<!-- 입력폼 -->
											<form name="frm" method="post" action="../member/join_ok.jsp">
											<table class="table">
											 <tr>
											  <th width=20% class="text-right success">ID</th>
											  <td width=80% class="text-left">
											    <input type=text name=id size=12 readonly>
											    <input type=button class="btn btn-sm btn-danger" value="중복체크"
											     onclick="idcheck()"
											    >
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">비밀번호</th>
											  <td width=80% class="text-left">
											    <input type="password" name=pwd size=12>
											    <input type="password" name=pwd1 size=12 placeholder="재입력">
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">이름</th>
											  <td width=80% class="text-left">
											    <input type="text" name=name size=12>
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">성별</th>
											  <td width=80% class="text-left">
											    <input type=radio name=sex value="남자">남자
											    <input type=radio name=sex value="여자">여자
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">생년월일</th>
											  <td width=80% class="text-left">
											    <input type=date name=birthday size=30>
											  </td>
											 </tr>
											 <!-- 이메일 보내기 : javaMail -->
											 <tr>
											  <th width=20% class="text-right success">이메일</th>
											  <td width=80% class="text-left">
											    <input type=text name=email size=40>
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">우편번호</th>
											  <td width=80% class="text-left">
											    <input type=text name=post1 size=5 readonly> -
											    <input type=text name=post2 size=5 readonly>
											    <input type=button value="우편번호검색" class="btn btn-sm btn-danger" onclick="postfind()">
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">주소</th>
											  <td width=80% class="text-left">
											    <input type=text name=addr1 size=40 readonly>
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">상세주소</th>
											  <td width=80% class="text-left">
											    <input type=text name=addr2 size=40>
											  </td>
											 </tr>
											 
											 <tr>
											  <th width=20% class="text-right success">전화번호</th>
											  <td width=80% class="text-left">
											    <select name=tel1>
											     <option>02</option>
											     <option>031</option>
											     <option>032</option>
											     <option>053</option>
											     <option>041</option>
											    </select>
											    <input type=text name=tel2 size=7> -
											    <input type=text name=tel3 size=10>
											  </td>
											 </tr>
											 
											 <tr>
											  <td colspan="2" class="text-center">
											    <input type=submit class="btn btn-sm btn-info" value="가입">
											    <input type=button class="btn btn-sm btn-warning" value="취소">
											  </td>
											 </tr>
											</table>
											</form>
										</section>

								</div>
							</div>
						</div>
					</div>
				</div>
 
</body>
</html>