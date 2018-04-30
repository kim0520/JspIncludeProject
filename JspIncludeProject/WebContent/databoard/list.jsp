<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.sist.databoard.dao.*" %>
    <jsp:useBean id="dao" class="com.sist.databoard.dao.DataBoardDAO"></jsp:useBean>
    
    <%
       String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage =Integer.parseInt(strPage);
    ArrayList<DataBoardVO> list= dao.boardListData(curpage);
    int totalPage= dao.dataBoardTotalPage();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
  	<section>
		<header>
			<h2>자료실</h2>
		</header>
			<table class="table table-striped">
		<tr>
		<td class="text-left">
		<a href="main.jsp?mode=4&dno=2" class="btn btn-sm btn-success" style="color:black">새글</a>
		</td>
		</tr>
		</table>
		<table class="table table-striped">
		<tr class="danger">
		<th width="10%" class="text-center">번호</th>
			<th width="45%" class="text-center">제목</th>
				<th width="15%" class="text-center">이름</th>
					<th width="20%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
		</tr>
		<%
		
		  int i=0;
		  String color="";
		  for(DataBoardVO vo:list)
		  {
			  i=i%2;
			  if(i==0)
				  color="";
			  else	 
				  color="warning";
			%>
			<tr class="<%=color %>">
			<td width="10%" class="text-center"><%=vo.getNo() %></th>
			
			<td width="45%" class="text-left">
			<a href="main.jsp?mode=4&dno=1&no=<%= vo.getNo()%>&page=<%=curpage%>"><%=vo.getSubject() %></th><!-- 제목 누르면 상세페이지로 넘어감 -->
				<td width="15%" class="text-center"><%=vo.getName() %></th>
					<td width="20%" class="text-center"><%=vo.getRegdate() %></th>
						<td width="10%" class="text-center"><%=vo.getHit() %></th>
			<% 	
			  i++;
		  }
		%>
		
		</table>
		<table class="table table-striped">
		<tr>
		<td class="text-right">
		<a href="main.jsp?mode=4&page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-info" style="color: white">이전</a>
		<a href="main.jsp?mode=4&page=<%=curpage<totalPage?curpage+1:curpage%>" class="btn btn-sm btn-success" style="color: white">다음</a>
		&nbsp;&nbsp;
		<%= curpage %> page/ <%= totalPage %> page
		</td>
		</tr>
		</table>
	</section>
</body>
</html>