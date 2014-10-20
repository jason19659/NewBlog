<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>jason's blog</title>
<link rel="stylesheet" type="text/css" media="all" href="../style.css" />
<link rel="stylesheet" type="text/css" href="../style/css/media-queries.css" />
<link rel="stylesheet" type="text/css" href="../style/js/player/mediaelementplayer.css" />
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="style/css/ie8.css" media="all" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="style/css/ie9.css" media="all" />
<![endif]-->
<script type="text/javascript" src="../style/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="../style/js/retina.js"></script>
<script type="text/javascript" src="../style/js/selectnav.js"></script>
<script type="text/javascript" src="../style/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="../style/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="../style/js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="../style/js/mediaelement.min.js"></script>
<script type="text/javascript" src="../style/js/mediaelementplayer.min.js"></script>
<script type="text/javascript" src="../style/js/jquery.dcflickr.1.0.js"></script>
<script type="text/javascript">
	$.backstretch("../style/images/bg/1.jpg");
</script>
<script type="text/javascript">
function startTime()  
{  
 var weekday = new Array(7)    
  weekday[0] = "星期日"  
  weekday[1] = "星期一"  
  weekday[2] = "星期二"  
  weekday[3] = "星期三"  
  weekday[4] = "星期四"  
  weekday[5] = "星期五"  
  weekday[6] = "星期六"  
  
var today=new Date()  
var year=today.getYear() + 1900 
var month=today.getMonth()+1  
var day=today.getDate()  
var week= weekday[today.getDay()]  
var h=today.getHours()  
  
var m=today.getMinutes()  
var s=today.getSeconds()  
// add a zero in front of numbers<10  
/*另一种写法  
month = month<10?"0"+month:month;//如果小于10即显示为09月          
day = day<10?"0"+day:day;//如果小于10即显示为09日    
……  
*/  
month=checkTime(month)  
day=checkTime(day)  
h=checkTime(h)  
m=checkTime(m)  
s=checkTime(s)  
document.getElementById('txt').innerHTML=year+"年"+month+"月"+day+"日 "+week+" "+h+":"+m+":"+s  
t=setTimeout('startTime()',500)  
}  
  
function checkTime(i)  
{  
if (i<10)   
  {i="0" + i}  
  return i  
}  
</script> 

<script type="text/javascript">
	var url = "../interface/article/"+${article_id};
	var d;
	var d2;
	var d3;
	var d4;
	$.getJSON(url, function(data) {
		d = data;
		var a = "<span class=\"icon-image\">"+ d.obj.date +"</span>";
		var b = "<span class=\"comments\">"+d.obj.replyCount+"</span>";
		$(a+b).appendTo(".details");
		$("h1:first").append(d.obj.title);
		$("p:first").append(d.obj.context);
		
		
	});
	var url2 = "../interface/reply/"+${article_id};
	$.getJSON(url2, function(data) {
		d2 = data;
		for (var i = 0; i < data.obj.length; i++) {
			var a1 =" <li class=\"comment\">";
			var a2 ="<div class=\"comment\">";
			var a3 ="	<div class=\"message\">";
			var a4 ="		<div class=\"info\">";
			var a5 ="			<h2>"+data.obj[i].title+"</h2>";
			var a6 ="			<span class=\"meta\">"+data.obj[i].date+" posted by "+data.obj[i].username+"</span>";
			var a7 ="		</div>";
			var a8 ="		<div class=\"comment-body\">";
			var a9 ="			<p>"+data.obj[i].context+"</p>";
			var a10 ="		</div>";
			var a11 ="		<span class=\"edit-link\"></span>";
			var a12 ="	</div>";
			var a13 ="	<div class=\"clear\"></div>";
			var a14 ="</div>";
			var a15 ="<div class=\"clear\"></div>";
			var a16 ="</li>";
			var text = a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16;
			$("#singlecomments").append(text);
		}
	});
	
	var url3 = "../interface/latestReply";
	$.getJSON(url3, function(data) {
	d3 =data;
	for (var i = 0; i < data.obj.length; i++) {
		var a1 = "<li>"; 
		var a2 = "	<div class=\"frame\">";
		var a3 = "		评论"+(i+1);
		var a4 = "	</div>";
		var a5 = "	<div class=\"meta\">";
		var a6 = "	     <h5><a href=\""+data.obj[i].articleId+"\">"+data.obj[i].title+"</a></h5>";
		var a61 ="	<h6><a href=\""+data.obj[i].articleId+"\">"+data.obj[i].context+"</a></h6>";
		var a7 = "	    <em>"+data.obj[i].date+"</em>";
		var a8 = "    </div>";
		var a9 = "</li>";
		var text = a1+a2+a3+a4+a5+a6+a61+a7+a8+a9;
		$(".post-list").append(text);
	}
	});
	
</script>
</head>
<body class="single" onload="startTime()">
<div class="scanlines"></div>

<!-- Begin Header -->
<div class="header-wrapper opacity">
	<div class="header">
		<!-- Begin Logo -->
		<div class="logo">
		    <a href="../index">
				<img src="../style/images/logo.png" alt="" />
			</a>
	    </div>
		<!-- End Logo -->
		<!-- Begin Menu -->
		<div id="menu-wrapper">
			<div id="menu" class="menu">
				<ul id="tiny">
					<li class="active"><a href="../index">Blog</a>
						<ul>
							<li><a href="post.html">Blog Post</a></li>
						</ul>
					</li>
					<li><a href="../contact.html">Contact</a></li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<!-- End Menu -->
	</div>
</div>
<!-- End Header -->

<!-- Begin Wrapper -->
<div class="wrapper"><!-- Begin Intro -->
<div class="intro">你好旅行者,欢迎来到jason的博客,现在时间是<div id="txt"></div>温馨提示:IE内核可能无法正常显示本站 </div>
<ul class="social">
<li><a class="rss" href="#"></a></li><li><a class="facebook" href="#"></a></li><li><a class="twitter" href="#"></a></li><li><a class="pinterest" href="#"></a></li><li><a class="dribbble" href="#"></a></li><li><a class="flickr" href="#"></a></li><li><a class="linkedin" href="#"></a></li></ul><!-- End Intro --> 

	

<!-- Begin Container -->
<div class="content">

		<!-- Begin Post -->
		<div class="post format-image box"> 

			<div class="details">
				
			</div>
		
			<h1 class="title"></h1>
			<p></p>
		
			
			<div class="post-nav">
				<span class="nav-prev"><a href="../index">← back home</a></span>
				<div class="clear"></div>
			</div>

		</div>
		<!-- End Post --> 	
	
		<!-- Begin Comment Wrapper -->
		<div id="comment-wrapper" class="box">
		  
		  <!-- Begin Comments -->
		  <div id="comments">
	            
	    
	        <ol id="singlecomments" class="commentlist">
	      	
		
					
			</ol>
		</div>
		<!-- End Comments -->
	
		<!-- Begin Form -->
		<div id="comment-form" class="comment-form">
		
			<div id="respond">
						<h3 id="reply-title">回复本文</h3>
						
						<form action="../reply/submit" method="post" id="commentform">
							<p class="comment-notes">最长不超过255个字节<span class="required">*</span></p>
							
							<p class="comment-form-author">
								<label for="author">昵称</label> <span class="required">*</span>
								<input id="author" name="username" type="text" value="" size="30" aria-required='true' />
							</p>
							
							<p class="comment-form-author">
								<label for="author">标题</label> <span class="required">*</span>
								<input id="author" name="title" type="text" value="" size="30" aria-required='true' />
							</p>
							<p class="comment-form-comment">
								<label for="comment">内容</label>
								<textarea id="comment" name="context" cols="45" rows="8" aria-required="true"></textarea>
							</p>
							<input  type="hidden" name="articleId" value="${article_id}" />
							<p class="form-submit">
								<input name="submit" type="submit" id="submit" value="Post Comment" />
							</p>
						</form>
			</div><!-- #respond -->	
	  	
		</div>
		<!-- End Form -->	
		
		
		</div>	
		<!-- End Comment Wrapper -->

</div>
<!-- End Container -->

<!-- Begin Sidebar -->
<div class="sidebar box">
  <div class="sidebox widget">
			<h3 class="widget-title">Popular replies</h3>
			<ul class="post-list">
			<!-- begin -->
			  
				<!-- end -->
				
			</ul>
			
	</div>
	
	
	
	<div class="sidebox widget">
		<h3 class="widget-title">啊啊哈哈哈哈哈哈</h3>
		<div>哈哈哈哈哈哈哈哈</div>
	</div>
	
	</div>
<!--End Sidebar -->
<div class="clear"></div>

</div>
<!-- End Wrapper -->

<!-- Begin Footer -->
<div class="footer-wrapper">
</div>
<div class="site-generator-wrapper">
	<div class="site-generator">Copyright jason 2014. Design by <a target="_blank" href="http://weibo.com/yaburi">jason</a>. All rights reserved.</div>
</div>
<!-- End Footer --> 
<script type="text/javascript" src="../style/js/scripts.js"></script>
</body>
</html>