<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.io.*,com.sist.databoard.dao.*"%>
    <jsp:useBean id="dao" class="com.sist.databoard.dao.DataBoardDAO"></jsp:useBean>
    
  <%
   String strNo=request.getParameter("no");
   String strPage=request.getParameter("page");
  String pwd=request.getParameter("pwd");
  
  //������ ���� ����  ==> �����ͺ��̽� ���� 
		  
  DataBoardVO vo =dao.databoardFileinfo(Integer.parseInt(strNo));
  boolean bCheck=dao.databoardDelete(Integer.parseInt(strNo), pwd);
  
  if(bCheck==true)
  {
	  if(vo.getFilesize()>0) //������ ������ ���
	  {
	  //���ϻ���
	  File f =new File("c:\\download\\"+vo.getFilename());
	  f.delete();
	  }
	  
	  response.sendRedirect("../main/main.jsp?mode=4&page="+strPage);
  }
  else
  {
	  //back
	  %>
	  <script >
	  alert("��й�ȣ�� Ʋ���ϴ�.");
	  history.back();
</script>
	  <%
  }
%>