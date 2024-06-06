<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
 	 body {
		display: flex;
		justify-content: center;
		align-items: center;
	} 
	
</style>
</head>

<body>

<form class="layui-form" action="${pageContext.request.contextPath }/editUserServlet" method="post">

  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input type="hidden" name="id" value="${user.id }">
      <input type="text" name="name" value="${user.name }" required  lay-verify="required|name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">    
      <input type="radio" name="gender" value="男" title="男" ${user.gender=='男'?'checked':'' }>
      <input type="radio" name="gender" value="女" title="女" ${user.gender=='女'?'checked':'' }>   
    </div>   
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">年龄</label>
    <div class="layui-input-block">
      <input type="text" name="age" value="${user.age }" required  lay-verify="required|number" class="layui-input">      
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-inline">
      <select name="address" lay-verify="required">
        <option value=""></option>
        <option value="北京" ${user.address=='北京'?'selected':'' }>北京</option>
        <option value="上海" ${user.address=='上海'?'selected':'' }>上海</option>
        <option value="广州" ${user.address=='广州'?'selected':'' }>广州</option>
        <option value="深圳" ${user.address=='深圳'?'selected':'' }>深圳</option>
        <option value="杭州" ${user.address=='杭州'?'selected':'' }>杭州</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-inline">
      <input type="text" name="qq" value="${user.qq }" required  lay-verify="required|qq" placeholder="请输入QQ" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">Email</label>
    <div class="layui-input-inline">
      <input type="text" name="email" value="${user.email }" required  lay-verify="required|email" placeholder="请输入Email" autocomplete="off" class="layui-input">
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>



<!-- 注意：项目正式环境请勿引用该地址 -->
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  form.verify({
	  name:function(value,item){
		  if(!new RegExp("^([\u4e00-\u9fa5\·]{2,4})$").test(value)){
		        return '中文用户名错误！';
		  }		  
	  }
  	 ,qq:[/^[1-9][0-9]{4,15}$/, 'qq长度错误！'] 
  });
  //提交
  form.on('submit(formDemo)', function(data){
    //layer.msg(JSON.stringify(data.field));
    return true;
  });
});
</script>
</body>
</html>