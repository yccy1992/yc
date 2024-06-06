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
    <label class="layui-form-label">药品名称</label>
    <div class="layui-input-inline">
      <input type="hidden" name="id" value="${medicine.id }">
      <input type="text" name="name" value="${medicine.medicinename }" required  lay-verify="required|medicinename" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">药品类型</label>
    <div class="layui-input-block">    
      <input type="radio" name="gender" value="1" title="处方药" ${medicine.type=='1'?'checked':'' }>
      <input type="radio" name="gender" value="2" title="非处方药" ${medicine.type=='2'?'checked':'' }>
    </div>   
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">用量</label>
    <div class="layui-input-block">
      <input type="text" name="age" value="${medicine.dosage }" required  lay-verify="required|number" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">生产厂商地址</label>
    <div class="layui-input-inline">
      <input type="text" name="name" value="${medicine.address }" required  lay-verify="required|address" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">不良反应</label>
    <div class="layui-input-inline">
      <input type="text" name="qq" value="${medicine.adverse_reactions }" required  lay-verify="required|adverse_reactions" placeholder="请输入QQ" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">成分</label>
    <div class="layui-input-inline">
      <input type="text" name="email" value="${medicine.component }" required  lay-verify="required|component" placeholder="请输入Email" autocomplete="off" class="layui-input">
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
/*layui.use('form', function(){
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
});*/
</script>
</body>
</html>