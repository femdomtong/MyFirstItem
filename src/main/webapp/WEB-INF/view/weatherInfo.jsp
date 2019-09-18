<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript" src= /js/jquery-1.8.3.js></script>
<script>
	$(function(){
		$.post(
		  "/wc/getWeather",
		  {"cityCode":"101280601"},
		 function(data){
			  
			  $("#s1").text(data.time);
			  $("#s2").text(data.cityInfo.city);
			  var forarr = data.data.forecast;
			  $.each(forarr,function (index,domEle){
				 console.log(domEle);
				 if(index==0){
					 $("#s3").text(domEle.high);
					 if("多云" == domEle.type)
					 
						$("#tianqi").attr("src","/images/weatherImg/日间多云.png");
					 	$("#s4 span").text("多云" );
					 
				 }
				  });
		  },
		  'json'
		
		);
		
		
		
	});
	
	
</script>
</head>
<body>
		日期:<span id="s1"></span><br/>
		城市:<span id="s2"></span><br/>
		高温:<span id="s3"></span><br/>
		天气:<span id="s4">
			<img src=""  id="tianqi"/>
			<span></span>
		</span><br/>
		
		
		
		
		
		
		
		
		
		
		
		
		
</body>
</html>
