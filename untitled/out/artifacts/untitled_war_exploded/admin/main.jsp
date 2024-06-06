<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<title>用户管理系统</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo"><a href="javascript:;" ><h2 style="color:red">郑州商学院</h2></a></div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left"  lay-filter="allmenu">    	
      <li class="layui-nav-item"><a href=""><a href="javascript:;" data-url="${pageContext.request.contextPath}/user/listUser.jsp" >控制台</a></a></li>
      <li class="layui-nav-item"><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/onlineAdmins.jsp">在线用户</a></li>
      <li class="layui-nav-item">
        	其它系统
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/user/addUser.jsp" >邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right" lay-filter="allmenu">
       
      <li class="layui-nav-item">        
          <img src="${pageContext.request.contextPath}/images/zbu_ico.png" class="layui-nav-img"> ${requestScope.admin.username }         
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/modifyAdmin.jsp" >基本资料</a></dd>
          <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/modifyPwd.jsp" >修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="javascript:;" data-url="${pageContext.request.contextPath}/logOutServlet">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="allmenu">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">用户管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/user/listUser.jsp" data-id="browseUser">浏览用户</a></dd>
            <dd><a href="javascript:;" data-url='${pageContext.request.contextPath}/user/addUser.jsp' data-id="addUser">添加用户</a></dd>
            <dd><a href="javascript:;">权限列表</a></dd>
            <dd><a href="javascript:;">权限分配</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">云市场</a></li>
        <li class="layui-nav-item"><a href="javascript:;">发布商品</a></li>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
				<div class="layui-tab" lay-allowClose="true" lay-filter="card">
					<ul class="layui-tab-title">
						<li class="layui-this"><span>首页</span></li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show"><iframe src="${pageContext.request.contextPath}/user/listUser.jsp" id="demoAdmin" style="width: 100%; height: 800px;" frameborder="0"></iframe>  </div>
					</div>
				</div>
				
	</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©2023 郑州商学院 信工学院 《Web编程技术》 20计科1班 张伟华
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在线人数：<font color="red">${fn:length(applicationScope.onLineAdmins) }</font>
  </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use(['element','layer','util'], function(){
	var element = layui.element,
		$ = layui.jquery,
		layer = layui.layer,
		util = layui.util;	
	
	element.on('nav(allmenu)', function(elem){
		var card = 'card'; // 选项卡对象
		var title = elem.text().substring(0,6); // 导航栏text	
		var src = elem.attr('data-url'); // 导航栏跳转URL		
		//console.log("src:"+src);
		id = new Date().getTime(); // ID		
		var flag = getTitleId(card, title); // 是否有该选项卡存在
		if(src==null || src=="" || src=='undefined'){
			flag=1;
		}
		// 大于0就是有该选项卡了
		if (flag > 0) {
			id = flag;
		} else {
			//新增tab
			element.tabAdd(card,{
								title : '<span>'
										+ title
										+ '</span>',
								content : '<iframe src="' + src + '" frameborder="0" style="width: 100%; height: 800px;"></iframe>',
								id : id
							}
			);
		}
		// 切换相应的ID tab
		element.tabChange(card, id);		
		
	});

	// 根据导航栏text获取lay-id
	function getTitleId(card, title) {
		var id = -1;
		$(document).find(".layui-tab[lay-filter=" + card + "] ul li").each(
						function() {
							if (title === $(this).find('span').text()) {
								id = $(this).attr('lay-id');
							}
						});
		
		return id;
	}
});
</script>
</body>
</html>