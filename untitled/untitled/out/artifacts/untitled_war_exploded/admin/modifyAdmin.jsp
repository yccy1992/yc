<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet">
</head>
<style>
 	 body {
		display: flex;
		justify-content: center;
		align-items: center;
	} 
	
</style>
<body>
<form class="layui-form" action="${pageContext.request.contextPath }/updateAdminServlet" method="post">

  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-inline">
      <input type ="hidden" name = "admin_id" value ="${sessionScope.admin.admin_id }">
      <input type="text" name="username" value="${sessionScope.admin.username }" required  lay-verify="required|name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
 
   <div class="layui-form-item">
    <label class="layui-form-label">Phone</label>
    <div class="layui-input-inline">
      <input type="text" name="phone" value="${sessionScope.admin.phone }" required  lay-verify="required|number" class="layui-input">      
    </div>
  </div>
 
  <div class="layui-form-item">
    <label class="layui-form-label">出生日期</label>
    <div class="layui-input-inline ">    	
       <input type="text" name="birthday" value="${sessionScope.admin.birthday }" id="ID-laydate-demo" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>


<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script>
layui.use(['jquery','table','laydate','dropdown'], function(){
  var table = layui.table;
  var laydate = layui.laydate;
  var dropdown = layui.dropdown;
  var $ = layui.$;
  // 渲染
  laydate.render({
    elem: '#ID-laydate-demo'
  });
});
</script>
</body>
</html>