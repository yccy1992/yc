<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加药品</title>
<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet">
<style>
 	 body {
		display: flex;
		justify-content: center;
		align-items: center;
	} 
	
</style>
</head>

<body>

<form class="layui-form" action="${pageContext.request.contextPath }/addMedicineServlet" method="post">

  <div class="layui-form-item">
    <label class="layui-form-label">药品名称</label>
    <div class="layui-input-inline">
      <input type="text" name="medicinename" value="药品名称" required  lay-verify="required|name" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">药品类型</label>
    <div class="layui-input-block">
      <input type="radio" name="type" value="1" title="处方药">
      <input type="radio" name="type" value="2" title="非处方药" checked>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">用量</label>
    <div class="layui-input-block">
      <input type="text" name="dosage" value="3" required  lay-verify="required|number" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">生产厂商地址</label>
    <div class="layui-input-inline">
      <input type="text" name="address" value="生产厂商地址" required  lay-verify="required|name" placeholder="请输入生产厂商地址" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">不良反应</label>
    <div class="layui-input-inline">
      <input type="text" name="adverse_reactions" value="不良反应" required  lay-verify="required|name" placeholder="请输入不良反应" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">成分</label>
    <div class="layui-input-inline">
      <input type="text" name="component" value="成分" required  lay-verify="required|name" placeholder="请输入成分" autocomplete="off" class="layui-input">
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
  
/!*  form.verify({
	  name:function(value,item){
		  if(!new RegExp("^([\u4e00-\u9fa5\·]{2,4})$").test(value)){
		        return '中文用户名错误！';
		  }		  
	  }
  	 ,qq:[/^[1-9][0-9]{4,15}$/, 'qq长度错误！'] 
  });*!/
  //提交
  form.on('submit(formDemo)', function(data){
    //layer.msg(JSON.stringify(data.field));
    return true;
  });
});*/
</script>
</body>
</html>