<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
// id=admin&mode=1
String id =request.getParameter("id");
String mode =request.getParameter("mode");
int no = Integer.parseInt(mode);
if(no==1)
{
	//sendRedirect
	response.sendRedirect("result.jsp");
	//output.jsp는 메모리에 서 해제(request가 초기화)
}
else if(no==2)
{
	//forward
	
	//pageContext.forward("result.jsp");
	/*
	 pageContext : page와 page를 연결할 때
	 
	 ==include() => <jsp:include>
	 ==forward() => <jsp:forward>
	*/
%>
    <jsp:forward page="result.jsp"/>
<%	
	

}


%>