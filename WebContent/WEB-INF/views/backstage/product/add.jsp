<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<form action="backstage/notebook" method="post">
		<input type="text" value="型号" name="notebook" />
		<input type="text" value="品牌"/>
		<input type="text" value="尺寸" />
		<input type="text" value="颜色" />
		<input type="text" value="上市时间" />
		<input type="text" value="价格" />
		<input type="submit" value="save" />
	</form>
</body>
</html>