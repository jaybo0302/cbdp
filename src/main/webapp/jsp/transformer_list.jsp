<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<%@include file="static.jsp" %>
<link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/highlight.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" />
<title>空白页</title>
<%
	String contextPath = request.getContextPath();
%>
</head>

<body>
<div class="page-container">
	<div>
		<form id="searchForm">
			<div class="text-c">
				<input type="text" name="name" id="name" placeholder="名称 " style="width:200px" class="input-text">
			</div>
			<div class="text-c">
				<input type="text" name="address" id="address" placeholder="地址" style="width:200px" class="input-text">
			</div>
			&nbsp;
			<button name="" id="searchButton" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
			&nbsp;
			<button name="" id="resetButton" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe6e2;</i> 清空</button>
		</form>
	</div>
	<br/>
	<table class="table table-border table-bordered table-hover table-bg table-sort" id ="transformerTable">
	</table>
	<br/>
	
	<div class="m-style M-box1" style="float:right;"></div>
	<input type="hidden" id = "pageNo"/> 
</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cd-table.js"></script>
<script type="text/javascript">
	var pageSize = 10;
	var contextPath = "<%=contextPath%>";
    var tableParam = [{"field":"名称",
    				   "name":"name"}
    				 ,{"field":"部门",
      				   "name":"department"}
    				 ,{"field":"类型",
        			   "name":"type"}
    				 ,{"field":"地址",
      				   "name":"address"}
    				 ,{"field":"操作",
    				   "name":"operate",
    				   "operates":[
    					   {"title":"删除",
    						"icon":"&#xe6e2;",
    						"function":"deleteTransformer"},
    					   {"title":"编辑",
    						"icon":"&#xe6df;",
    						"function":"editTransformer"}
    				   ]}];
	var moduleName = "transformer";
	
	function deleteTransformer(id) {
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '${pageContext.request.contextPath}/transformer/deleteTransformer.do',
				data:{"id":id},
				dataType: 'json',
				success: function(data){
					if(data.success) {
						refresh(currentNo);
						layer.msg('已删除!',{icon:1,time:1000});
					} else {
						layer.msg(data.message,{icon:1,time:1000});
					}
				},
				error:function(data) {
					layer.msg(data,{icon:1,time:1000});
				},
			});
		});
	}
	
	function editTransformer(id) {
		layer_show("编辑变压器","${pageContext.request.contextPath}/transformer/getEditPage.do?id="+id,500,500);
	}
</script>
</html>