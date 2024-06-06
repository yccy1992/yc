<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet">
</head>
<body>
<form class="layui-form" action="${pageContext.request.contextPath }/modifyPwdServlet" method="post">

  <div class="layui-form-item">
    <label class="layui-form-label">旧密码</label>
    <div class="layui-input-inline">    
       <input type ="hidden" name = "admin_id" value ="${sessionScope.admin.admin_id }">  
      <input type="text" name="oldpwd"  required  lay-verify="required|pwd" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-inline">      
      <input type="text" name="newpwd" id="newpwd"  required  lay-verify="required|pwd" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">      
      <input type="text" name="confirmpwd"  required  lay-verify="required|pwd|confirm" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">修改密码</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>


<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script>
layui.use(['jquery','form','table','laydate','dropdown'], function(){
  var table = layui.table;
  var laydate = layui.laydate;
  var dropdown = layui.dropdown;
  var form = layui.form;
  var $ = layui.$;
  
  form.verify({
	 pwd:[/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/, '至少八个字符，至少一个字母，一个数字和一个特殊字符！'] 
  	,confirm:function(value,item){
  		var newpwd = $('#newpwd').val();
  		//console.log('confirm');
		 if(newpwd!=value){
			 return "两次输入的密码不一致！";
		 }  
	  }
  });
  form.on('submit(formDemo)', function(data){
	    //layer.msg(JSON.stringify(data.field));
	    return true;
	  });
});
</script>
</body>
</html>