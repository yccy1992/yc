<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 管理系统大布局 - Layui</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">layout demo</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- 移动端显示 -->
      <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
        <i class="layui-icon layui-icon-spread-left"></i>
      </li>
      
      <li class="layui-nav-item layui-hide-xs"><a href="">nav 1</a></li>
      <li class="layui-nav-item layui-hide-xs"><a href="">nav 2</a></li>
      <li class="layui-nav-item layui-hide-xs"><a href="">nav 3</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">nav groups</a>
        <dl class="layui-nav-child">
          <dd><a href="">menu 11</a></dd>
          <dd><a href="">menu 22</a></dd>
          <dd><a href="">menu 33</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
          ${sessionScope.admin.username }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" id="selfInfo">查看个人信息</a></dd>
          <dd><a href="javascript:;" id ="modipwd">修改密码</a></dd>
          <dd><a href="${pageContext.request.contextPath }/logOutServlet" >退出</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">menu group 1</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/user/listUser.jsp">浏览用户信息</a></dd>
            <dd><a href="javascript:;">menu 2</a></dd>
            <dd><a href="javascript:;">menu 3</a></dd>
            <dd><a href="">the links</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">menu group 2</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">list 1</a></dd>
            <dd><a href="javascript:;">list 2</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>
        <li class="layui-nav-item"><a href="">the links</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    底部固定区域
  </div>
</div>
<script src="./layui/layui.js"></script>
<script>
//JS 
layui.use(['element', 'laydate','layer', 'util'], function(){
  var element = layui.element
  ,layer = layui.layer
  ,laydate = layui.laydate
  ,util = layui.util
  ,$ = layui.$;
  
  //头部事件
  util.event('lay-header-event', {
    //左侧菜单事件
    menuLeft: function(othis){
      layer.msg('展开左侧菜单的操作', {icon: 0});
    }
    ,menuRight: function(){
      layer.open({
        type: 1
        ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
        ,area: ['260px', '100%']
        ,offset: 'rt' //右上角
        ,anim: 5
        ,shadeClose: true
      });
    }
  });
  
  $('#selfInfo').click(function(){
	  layer.open({
  		type: 2,
  		title: '查看个人信息',
  		shadeClose: true,
  		maxmin: true, //开启最大化最小化按钮
  		area: ['900px', '600px'],
  		content: '${pageContext.request.contextPath }/admin/modifyAdmin.jsp',
  		});
  });
  $('#modipwd').click(function(){
	  layer.open({
  		type: 2,
  		title: '修改密码',
  		shadeClose: true,
  		maxmin: true, //开启最大化最小化按钮
  		area: ['900px', '600px'],
  		content: '${pageContext.request.contextPath }/admin/modifyPwd.jsp',
  		});
  });
  
});
</script>
</body>
</html>