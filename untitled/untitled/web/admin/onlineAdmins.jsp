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
<div style="margin-top:-10px">          
<table class="layui-hide"  id="test" lay-filter="test"></table>
</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="logout">下线</a>
  <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>   

<!-- 注意：项目正式环境请勿引用该地址 -->
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>

<script>
layui.use(['jquery','table', 'dropdown'], function(){
  var table = layui.table;
  var dropdown = layui.dropdown;
  var $ = layui.$;
  
//创建渲染实例
  table.render({
    elem: '#test'
    //,url:'${pageContext.request.contextPath }/json/users.json' // 此处为静态模拟数据，实际使用时需换成真实接口
    ,url:'${pageContext.request.contextPath }/onLineAdminServlet'
    ,toolbar: '#toolbarDemo'
    ,defaultToolbar: ['filter', 'exports', 'print', {
      title: '帮助'
      ,layEvent: 'LAYTABLE_TIPS'
      ,icon: 'layui-icon-tips'
    }]
    ,height: 'full-200' // 最大高度减去其他容器已占有的高度差
    ,cellMinWidth: 80
    ,totalRow: false // 开启合计行
    ,page: {
    	curr:1
    	,limit:15
    	,limits:[15, 20, 30, 40, 500]
    	
    }
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'admin_id', fixed: 'left', width:180, title: 'ID', sort: true}
      ,{field:'username', width:180, title: '用户名'}
      ,{field:'phone', width:180, title: '电话', sort: true}
      ,{field:'birthday', title:'出生日期'}      
      ,{fixed: 'right', title:'操作', width: 125, minWidth: 125, toolbar: '#barDemo'}
    ]]
    ,done: function(){
      var id = this.id;

    }
    ,error: function(res, msg){
      console.log(res, msg)
    }
    ,id:"adminTable"
  });
  
  
//触发单元格工具事件
  table.on('tool(test)', function(obj){ // 双击 toolDouble
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'logout'){
      $.post("${pageContext.request.contextPath }/doOffLineServlet",{"username":data.username},function(res){
    	  var data =JSON.parse(res);
    	  if(data.code==0){
    		  layer.msg(data.msg);
    	  }else{
    		  layer.msg(data.msg);
    	  }
      });
    } else if(obj.event === 'del'){
      layer.msg(data.admin_id);
        
    }
  });
 
  
  
});
</script>
</body>
</html>