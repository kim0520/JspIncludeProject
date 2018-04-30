<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.foodhouse.dao.*,java.util.*"%>
<jsp:useBean id="dao" class="com.sist.foodhouse.dao.FoodDAO"/>
<%
    ArrayList<CategoryVO> list=dao.categoryAllData();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	//Custom settings
	var style_in = 'easeOutBounce';
	var style_out = 'jswing';
	var speed_in = 1000;
	var speed_out = 300;


	//Calculation for corners
	var neg = Math.round($('.qitem').width() / 2) * (-1);
	var pos = neg * (-1);
	var out = pos * 2;
	
	var wneg = Math.round($('.qitem').width() / 2) * (-1);
	var wpos = wneg * (-1);
	
	var hneg = Math.round($('.qitem').height() / 2) * (-1);
	var hpos = hneg * (-1);
	
	$('.qitem').each(function () {
	
		url = $(this).find('a').attr('href');
		img = $(this).find('img').attr('src');
		alt = $(this).find('img').attr('img');
		
		$('img', this).remove();
		$(this).append('<div class="topLeft"></div><div class="topRight"></div><div class="bottomLeft"></div><div class="bottomRight"></div>');
		$(this).children('div').css('background-image','url('+ img + ')');
		$(this).children('div').css('background-size','180px 120px');

		$(this).find('div.topLeft').css({top:0, left:0, width:wpos , height:hpos});	
		$(this).find('div.topRight').css({top:0, left:wpos, width:wpos , height:hpos});	
		$(this).find('div.bottomLeft').css({bottom:0, left:0, width:wpos , height:hpos});	
		$(this).find('div.bottomRight').css({bottom:0, left:wpos, width:wpos , height:hpos});	

	}).hover(function () {
	
		$(this).find('div.topLeft').stop(false, true).animate({top:wneg, left:hneg}, {duration:speed_out, easing:style_out});	
		$(this).find('div.topRight').stop(false, true).animate({top:wneg, left:out}, {duration:speed_out, easing:style_out});	
		$(this).find('div.bottomLeft').stop(false, true).animate({bottom:wneg, left:hneg}, {duration:speed_out, easing:style_out});	
		$(this).find('div.bottomRight').stop(false, true).animate({bottom:wneg, left:out}, {duration:speed_out, easing:style_out});	
				
	},
	
	function () {

		$(this).find('div.topLeft').stop(false, true).animate({top:0, left:0}, {duration:speed_in, easing:style_in});	
		$(this).find('div.topRight').stop(false, true).animate({top:0, left:wpos}, {duration:speed_in, easing:style_in});	
		$(this).find('div.bottomLeft').stop(false, true).animate({bottom:0, left:0}, {duration:speed_in, easing:style_in});	
		$(this).find('div.bottomRight').stop(false, true).animate({bottom:0, left:wpos}, {duration:speed_in, easing:style_in});	
	
	}).click (function () {
		window.location = $(this).find('a').attr('href');	
	});	

});
</script>

<style>
	.qitem {
		width:180px;
		height:120px;	
		border:2px solid #222;	
		margin:5px 5px 5px 0;
		background: url('../foodhouse/bg.gif') no-repeat; 
		
		
		/* required to hide the image after resized */
		overflow:hidden;
		
		/* for child absolute position */
		position:relative;
		
		/* display div in line */
		float:left;
		cursor:hand; cursor:pointer;
	}

	.qitem img {
		border:0;
	
		/* allow javascript moves the img position*/
		position:absolute;
		z-index:200;
	}

	.qitem .caption {
		position:absolute;
		z-index:0;	
		color:#ccc;
		display:block;
		height: 100%;
		line-height: 22px;
		width: 100%;
		text-align: center;
		vertical-align: middle;
	}

	.qitem .caption h4 {
		font-size:15px;
		padding:10px 5px 0 8px;
		margin:0;
		color:#369ead;
	}

	.qitem .caption p {
		font-size:12px;	
		padding:3px 5px 0 8px;
		margin:0;
	}


	/* Setting for corners */

	.topLeft, .topRight, .bottomLeft, .bottomRight {
		position:absolute;
		background-repeat: no-repeat; 
		float:left;
	}
	
	.topLeft {
		background-position: top left; 	
	} 
	
	.topRight {
		background-position: top right; 
	} 
	
	.bottomLeft {
		background-position: bottom left; 
	} 
	
	.bottomRight {
		background-position: bottom right; 
	}
	
	.clear {
		clear:both;	
	}
</style>
</head>
<body>
<section>
   <%
      int i=1;
      for(CategoryVO vo:list)
      {
   %>
         <div class="qitem">
		   <img src="<%=vo.getPoster() %>" width="180" height="120"/>
		   <span class="caption">
			<h4><%=vo.getTitle() %></h4>
			<p><%=vo.getSubject() %></p>
		  </span>
	     </div>
	
	      <%
	        if(i%3==0)
	        {
	      %>
	           <div class="clear"></div>
	      <%
	        }
	      %>  
   <%
        i++;
      }
   %>				
</section>
</body>
</html>






