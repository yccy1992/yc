<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>示例演示</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 注意：项目正式环境请勿引用该地址 -->
  <link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet">
</head>
<body>
<h2 style="text-align:center;margin:10px">药品信息列表</h2>
<div class="layui-container" style="margin-left:-35px">
<div class="layui-form layui-form-pane">
 <div class="layui-inline">
    <label class="layui-form-label" for="medicinename">药品名称</label>
    <div class="layui-input-inline">
      <input type="text" name="medicinename" id="medicinename" style="width:100px" required  lay-verify="required" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
    </div>
  </div>
<%--  <div class="layui-inline">
    <label class="layui-form-label" for="address">地址</label>
    <div class="layui-input-inline">
      <input type="text" name="address" id="address" style="width:100px" required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-inline">
    <label class="layui-form-label" for="component">邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="email" id="component" style="width:100px" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
    </div>
    </div>--%>
    <button type="button"  id="myserach" class="layui-btn layui-btn-normal">查询</button>
 
</div>  
  
</div>
<div style="margin-top:-10px">          
<table class="layui-hide"  id="test" lay-filter="test"></table>
</div>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="delChosedMedicine">删除选中</button>
    <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="addMedicine">添加药品</button>
  </div>
</script>
 
<script type="text/html" id="cityTpl">
  <select id="demoCity1" class="layui-border" lay-ignore>
    <option value="浙江杭州">浙江杭州</option>
    <option value="江西南昌">江西南昌</option>
    <option value="湖北武汉">湖北武汉</option>
  </select>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>     
          
<!-- 注意：项目正式环境请勿引用该地址 -->
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>

<script>
layui.use(['jquery','table', 'dropdown'], function(){
  var table = layui.table;
  var dropdown = layui.dropdown;
  var $ = layui.$;
  
  // 创建渲染实例
  table.render({
    elem: '#test'
    //,url:'${pageContext.request.contextPath }/json/users.json' // 此处为静态模拟数据，实际使用时需换成真实接口
        ,url:'${pageContext.request.contextPath }/ListMedicineServlet'
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
      ,{field:'id', fixed: 'left', width:80, title: 'ID', sort: true, totalRowText: '合计：'}
      ,{field:'medicinename', width:120, title: '药品名称'}
      ,{field:'type', width:120, title: '药品类型', sort: true}
      ,{field:'dosage', width:150, title:'用量'}
      ,{field:'address', width:115, title: '厂家地址'}
      ,{field:'adverse_reactions', title: '不良反应',  Width: 160}
      ,{field:'component', title:'成分', hide: 0, edit: 'text'}
      ,{fixed: 'right', title:'操作', width: 125, minWidth: 125, toolbar: '#barDemo'}
    ]]
    ,done: function(){
      var id = this.id;

    }
    ,error: function(res, msg){
      console.log(res, msg)
    }
    ,id:"userTable"
  });
  $('#myserach').click(function(){
	  table.reload('userTable', {
		  where: { // 传递数据异步请求时携带的字段,url
			name: $('#medicinename').val()
		    /*address: $('#address').val(),
		    component:$('#component').val()*/
		  },
		  page: {
		    	curr:1
		    	,limit:15
		    	,limits:[15, 20, 30, 40, 500]
		    	
		    },
		  url:'${pageContext.request.contextPath }/ListMedicineServlet'
		});
  });
  
  
  // 工具栏事件
  table.on('toolbar(test)', function(obj){
    var id = obj.config.id;
    var checkStatus = table.checkStatus(id);
    var othis = lay(this);
    switch(obj.event){
      case 'delChosedMedicine':
    	  var data = checkStatus.data;
          //var users = JSON.stringify(data);
          //JSON.parse();
          //layer.alert(users);
          var selects = new Array();
          var count=0;
          layui.each(data,function(index,element){
          	selects[count]=element.id;
          	count++;
          });
          var ids = encodeURI(selects);
    	  if(selects.length!=0){
    		  layer.confirm('真的删除选中记录吗？', function(index){
    		       
    		        //layer.msg(ids);//异步提交给后端，进行删除操作  
    		        $.post("${pageContext.request.contextPath }/delChoseMedicineServlet",{"ids":ids},function(res){
    		        	//console.log("res："+res);
    		        	//layer.alert(res);
    		        	var data = JSON.parse(res);
    		        	//res
    		        	if(data.code == 0){
    		        		layer.alert(data.msg);
    		        		setTimeout("layui.table.reload('userTable')",200);  //刷新列表
    		        	}else{
    		        		layer.alert(data.msg);
    		        	}
    		        	
    		        });
    		        //setTimeout("layui.table.reload('userTable')",200);  //刷新列表
    		    	}); 
    	  }else{
    		  layer.alert("没选择任何要删除的记录！",{icon: 5});
    	  }
    	  
    	
      break;
            case 'addMedicine':
    	  //layer.msg("添加用户");//打开添加界面
    	   layer.open({
        		type: 2,
        		title: '添加用户',
        		shadeClose: true,
        		maxmin: true, //开启最大化最小化按钮
        		area: ['900px', '600px'],
        		content: '${pageContext.request.contextPath }/medicine/addMedicine.jsp',
        		end: function(){
        			setTimeout("layui.table.reload('userTable')",200);  //刷新列表
        		  }
      			});
      break;      
      
      case 'LAYTABLE_TIPS':
        layer.alert('Table for layui-v'+ layui.v);
      break;
    };
  });
 
  //触发单元格工具事件
  table.on('tool(test)', function(obj){ // 双击 toolDouble
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	  $.post("${pageContext.request.contextPath }/delMedicineServlet",{"id":data.id},function(res){
    	      console.log(res);
    		  var result = JSON.parse(res);	
    		  if(result.code==0){
    	      		obj.del();//前端的删除
    	            //console.log(data.id);
    	            layer.close(index);
    	            layer.alert(result.msg);
    	      	}else{
    	      		layui.alert(result.msg);
    	      		 layer.close(index);
    	      	}
    	  });
    	  
        obj.del();//前端的删除
        //console.log(data.id);
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      //显示被删除记录的主键
    	//var user = JSON.stringify(data);
        //layer.alert(data.id);
        //$.post("${pageContext.request.contextPath }/getMedicineServlet",{"id":data.id},function(res){
        //	
        //});
    	layer.open({
    		type: 2,
    		title: '编辑用户',
    		shadeClose: false,
    		maxmin: true, //开启最大化最小化按钮
    		area: ['900px', '600px'],
    		content: '${pageContext.request.contextPath }/getMedicineServlet?id='+data.id,
    		end: function(){
    			console.log("end");
    			 setTimeout("layui.table.reload('userTable')",200);  //刷新列表
    		  }
  			});
        
    }
  });
 
  //触发表格复选框选择
  table.on('checkbox(test)', function(obj){
    console.log(obj)
  });
 
  //触发表格单选框选择
  table.on('radio(test)', function(obj){
    console.log(obj)
  });
  
  // 行单击事件
  table.on('row(test)', function(obj){
    //console.log(obj);
    //layer.closeAll('tips');
  });
  // 行双击事件
  table.on('rowDouble(test)', function(obj){
    console.log(obj);
  });
 
  // 单元格编辑事件
  table.on('edit(test)', function(obj){
    var field = obj.field //得到字段
    ,value = obj.value //得到修改后的值
    ,data = obj.data; //得到所在行所有键值
 
    var update = {};
    update[field] = value;
    obj.update(update);
  });
});
</script>

</body>
</html>