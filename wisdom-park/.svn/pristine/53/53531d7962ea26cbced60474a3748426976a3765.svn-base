<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<style>
	.form .row{
		width:50%;
		float:left;
	}
</style>
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>

<![endif]-->
<%@include file="header.jsp" %>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<link href="../lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title></title>
</head>
<body>
    <div class="page-container">
	<form action="office" method="post" class="form form-horizontal" >
		
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>父级id：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="parentId" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所有id：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="parentIds" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="name" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>排序：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="sort" type="number" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>归属区域：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="areaId" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>区域编码：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="code" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机构类型：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="type" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机构等级：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="grade" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>联系地址：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="address" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮政编码：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="zipCode" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>负责人：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="master" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>电话：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="phone" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>传真：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="fax" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮箱：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="email" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否启用：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="useable" type="number" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>主负责人：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="primaryPerson" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>副负责人：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="deputyPerson" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>创建时间：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input id="createDate" name="createDate" class="Wdate" type="text" onfocus="WdatePicker({readOnly:true,isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>创建人id：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="createBy" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>更改人id：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="updateBy" type="text" class="input-text">	
				</div>
			</div>
			<div class="row cl">	
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>更改时间：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input id="updateDate" name="updateDate" class="Wdate" type="text" onfocus="WdatePicker({readOnly:true,isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />	
				</div>
			</div>
			<div class="row cl">	
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>删除标记：</label>	
				<div class="formControls col-xs-8 col-sm-9">		
					<input name="delFlag" type="number" class="input-text">	
				</div>
			</div>
		<div >
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i>保存</button>
			</div>
		</div>
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<%@include file="footer.jsp" %>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="../lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="../lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="../lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="../lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
/* $(function(){
	var ue = UE.getEditor('editor');
}); */

</script>
</body>
</html>
