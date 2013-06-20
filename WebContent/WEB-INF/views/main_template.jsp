<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/resources/css/yaml/core/base.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath() %>/resources/css/yaml/forms/gray-theme.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath() %>/resources/css/yaml/screen/typography.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath() %>/resources/css/jquery/component/lightbox.css" rel="stylesheet" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/utils/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/component/lightbox-evolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/utils/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/utils/JSUtils.js"></script>
<script type="text/javascript">
$(function(){
});
</script>
</head>
<body>
	<tiles:insertAttribute name="main" />
</body>
</html>