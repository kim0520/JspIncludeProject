<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.member.dao.*"%>
<%
   request.setCharacterEncoding("EUC-KR");

%>
<jsp:useBean id="dao" class="com.sist.member.dao.MemberDAO"></jsp:useBean>
<jsp:useBean id="vo" class="com.sist.member.dao.MemberVO">
<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>
<%
  dao.memberJoin(vo);
  response.sendRedirect("../member/welcome.jsp");
%>