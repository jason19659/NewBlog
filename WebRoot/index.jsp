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
<title>Jason's blog</title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<link rel="stylesheet" type="text/css" href="style/css/media-queries.css" />
<link rel="stylesheet" type="text/css" href="style/js/player/mediaelementplayer.css" />
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="style/css/ie8.css" media="all" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="style/css/ie9.css" media="all" />
<![endif]-->
<!--[if IE 10]>
<link rel="stylesheet" type="text/css" href="style/css/ie9.css" media="all" />
<![endif]-->
<script type="text/javascript" src="style/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="style/js/scripts.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/retina.js"></script>
<script type="text/javascript" src="style/js/selectnav.js"></script>
<script type="text/javascript" src="style/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="style/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="style/js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="style/js/mediaelement.min.js"></script>
<script type="text/javascript" src="style/js/mediaelementplayer.min.js"></script>
<script type="text/javascript" src="style/js/jquery.dcflickr.1.0.js"></script>
<script type="text/javascript">
	$.backstretch("style/images/bg/1.jpg");
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
	var url = "interface/article";
	var d;
	$.getJSON(url, function(data) {
		d = data;
		var txt2;
		var cpy = "<div class=\"site-generator\" style=\"position: relative;\"> Copyright  &copy<a target=\"_blank\"href=\"http://weibo.com/yaburi\"> jason</a>  All rights reserved.</div>";
	//	var cb = "<div class=\"site-generator-wrapper\">";
	//	var ce = "</div>";
		
		for (var i = 0; i < data.obj.length; i++) {
			var divs = "<div class=\"post format-standard box\">\n";
			var title = "<h2 class='title'><a href='article/"+data.obj[i].id+"'>\n"
					+ data.obj[i].title + "</a></h2>\n";
			var t0 = "<p>" + data.obj[i].context + "</p>\n";
			var t1 = "<div class='details'>\n";
			var t2 = "<span class='icon-standard'><a href='article/"+data.obj[i].id+"'>"
					+ data.obj[i].date + "</a></span>\n";
			var t3 = "<span class='comments'><a href='article/"+data.obj[i].id+"'>\n"
					+ data.obj[i].replyCount + "</a></span>\n";
			var t4 = "</div>\n";
			var dive = "</div>\n";
			var txt = divs + title + t0 + t1 + t2 + t3 + t4 + dive;
			$("div.blog-grid").append(txt);
		}
		
		$('.site-generator-wrapper').append(cpy);
	});
</script>
</head>
<body onload="startTime()" >
<div class="scanlines"></div>

<!-- Begin Header -->
<div class="header-wrapper opacity">
	<div class="header">
		<!-- Begin Logo -->
		<div class="logo">
		    <a href="index">
				<img src="style/images/logo.png" alt="" />
			</a>
	    </div>
		<!-- End Logo -->
		<!-- Begin Menu -->
		<div id="menu-wrapper">
			<div id="menu" class="menu">
				<ul id="tiny">
					<li class="active"><a href="index">Blog</a>
						<ul>
							<li><a href="post.html">Blog Post</a></li>
						</ul>
					</li>
				
					<li><a href="contact.html">Contact</a></li>
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

<!-- Begin Blog Grid -->
<div class="blog-wrap">
	<!-- Begin Blog -->
	<div class="blog-grid">
 						
 	
 	</div>
 
 	
	<!-- End Blog -->
</div>
<!-- End Blog Grid -->

	<div class="clear"></div>
</div>
<!-- End Wrapper -->
<div class="footer-wrapper">
</div>

</body>
</html>