<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>开始使用 layui</title>
  <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
    }

  </style>
  <script type="text/javascript">
    if (top.location !== self.location) {
      //点击退出按钮时，是login.jsp跳出iframe框架
      top.location=self.location;
    }
  </script>
</head>
<body>

<%
  List<String> list = new ArrayList<String>();
  Cookie[] cookies = request.getCookies();
  String username = "";
  if(cookies!=null){
    for(Cookie cookie:cookies){
      if("username".equals(cookie.getName())){
        username = cookie.getValue();
      }
    }
  }
%>

<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/login" method ="post">
  <h1 style="text-align: center;margin:0px 0px 20px 0px">用户登录</h1>
  <div class="layui-form-item">
    <label class="layui-form-label">用户名：</label>
    <div class="layui-input-inline">
      <input type="text" name="username" value="<%=username %>" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码:</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"> </label>
    <div class="layui-input-inline">
      <img alt="验证码" id="checkCode" src="${pageContext.request.contextPath }/checkCodeServlet">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">验证码:</label>
    <div class="layui-input-inline">
      <input type="text" name="veryfyCode" required lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">记住密码</label>
    <div class="layui-input-block">
      <input type="checkbox" name="remberUsername" title="记住用户名">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">登录</button>
      <button type="reset" class="layui-btn layui-btn-warm">重置</button>
    </div>
  </div>
  <div><font color="red">${msg }</font></div>
</form>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
  layui.use(['layer', 'form','laypage'], function(){
    var layer = layui.layer;
    var form = layui.form;
    var laypage = layui.laypage;

    window.onload = function () {
      //1.获取图片对象
      var img = document.getElementById("checkCode");
      //2.绑定单击事件
      img.onclick = function () {
        //加时间戳
        var date = new Date().getTime();
        img.src="${pageContext.request.contextPath}/checkCodeServlet?date="+date;
      }
    }
  });
</script>
</body>
</html>