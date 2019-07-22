<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tea and Meal - Free CSS Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>

<%	
	//Customer update message print
	String CustomerUpdateSuccess =(String) request.getAttribute("CustomerUpdateSuccess");
	String CustomertUpdateFailed =(String) request.getAttribute("CustomertUpdateFailed");
	
	if(CustomerUpdateSuccess != null)
	{
		out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + CustomerUpdateSuccess + "</p>");
	}
	else if(CustomertUpdateFailed != null)
	{
		out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + CustomertUpdateFailed + "</p>");
	}
	
	//Order place message print
	String OrderPlaceSuccess =(String) request.getAttribute("OrderPlaceSuccess");
	String OrderPlaceFailed =(String) request.getAttribute("OrderPlaceFailed");
	
	if(OrderPlaceSuccess != null)
	{
		out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + OrderPlaceSuccess + "</p>");
	}
	else if(OrderPlaceFailed != null)
	{
		out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + OrderPlaceFailed + "</p>");
	}
%>

    <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to our website</h1>
                <img src="images/templatemo_image_05.jpg" alt="image" />
                    <p>This <a href="#">Free CSS Template</a> is provided by TemplateMo.com. You may apply this template layout for your websites. Credit goes to <a href="http://www.photovaco.com" target="_blank">Photovaco.com</a> for photos. </p>
                    <p>Donec malesuada elit vel enim. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id velit elementum mi egestas ullamcorper. Vivamus nec dui.</p>
                  <p>Suspendisse vitae nibh ac nunc mattis blandit. Morbi consectetur ullamcorper felis. Nulla nec elit. Aliquam et mauris. Ut euismod congue diam.</p>
                    <a href="#">Read more...</a>
                    
                    <div style="clear: both; padding: 30px 0 20px 0;">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
					</div>
                    
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    <h1>What's new?</h1>
                    <div class="right_column_section">
	                    <h2>Special meal for you</h2>
                        <img src="images/templatemo_image_06.jpg" alt="image" />
                        <p>Curabitur turpis. Nulla a risus. Aliquam lectus dui, euismod id, volutpat ac, fringilla eu, ipsum.</p>
                        <a href="#">Read more...</a>
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>