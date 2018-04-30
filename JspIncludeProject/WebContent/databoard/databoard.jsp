<%@page import="com.sist.change.JspChange"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.* ,com.sist.databoard.dao.*"%>
<jsp:useBean id="dao" class="com.sist.databoard.dao.DataBoardDAO"></jsp:useBean>
<%--
    useBean : 객체 생성 ---> 자동으로 메모리 해제  -----> 싱글톤
    DataBoard dao = new DataBoardDaO();
 --%> 
 <%
    ArrayList<DataBoardVO> list =dao.boardTopData();
    String no = request.getParameter("dno");
    if(no==null)
     no="0";
    int n= Integer.parseInt(no);
    String jsp=JspChange.databoard_change(n);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <div id="content-wrapper">
					<div id="content">
						<div class="container">
							<div class="row">
								<div class="9u 12u(mobile)">

									<!-- Main Content -->
									<jsp:include page="<%=jsp %>"></jsp:include>

								</div>
								<div class="3u 12u(mobile)">

									<!-- Sidebar -->
										<section>
											<header>
												<h2>인기 게시물</h2>
											</header>
											<ul class="link-list">
												<%
												for(DataBoardVO vo:list)
												{
												%>
												
												<li><a href="#"><%=vo.getSubject() %></a></li>
												
												<%
												}
												%>
											</ul>
										</section>
										<section>
											<header>
												<h2>실시간 단어 검색</h2>
											</header>
											<p>
												<img src="images/wc.png" width=100%>
											</p>
											
										</section>

								</div>
							</div>
						</div>
					</div>
				</div>
</body>
</html>