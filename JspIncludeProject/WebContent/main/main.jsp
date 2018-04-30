<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.change.*"%>
<%
   // 화면 변경  main.jsp?mode=1
   /*
        ~main.jsp
        => mode=null
           if(mode==null)
        ~main.jsp?mode=
        => mode=""
           if(mode=="")(X)
           if(mode.equals(""))(O)
   */
   String mode=request.getParameter("mode");
   if(mode==null)
      mode="0";
   int no=Integer.parseInt(mode);
   String jsp=JspChange.change(no);
%>
<!DOCTYPE HTML>
<html>
   <head>
      <title>서울 여행 코스</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
      
      <link rel="stylesheet" href="assets/css/main.css" />
      <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
      <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
       
   </head>
   <body>
      <div id="page-wrapper">

         <!-- Header -->
            <div id="header-wrapper">
               <!-- header첨부(메뉴) -->
               <jsp:include page="header.jsp"></jsp:include>     
            </div>

             <!-- content -->
             <jsp:include page="<%=jsp %>"></jsp:include>
             <!-- content end -->
         <!-- Footer -->
         <div id="footer-wrapper">
            <!-- footer 첨부 -->
            <%@ include file="footer.jsp" %>
          </div>

      <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/skel.min.js"></script>
         <script src="assets/js/skel-viewport.min.js"></script>
         <script src="assets/js/util.js"></script>
         <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
         <script src="assets/js/main.js"></script>

   </body>
</html>