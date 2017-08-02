<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<%@include file="header.jsp" %>

<title>品牌管理</title>
</head>
<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 品牌管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	<button type="button" class="btn btn-success" onclick="product_add('添加品牌','demoForm.jsp')"><i class="Hui-iconfont">&#xe600;</i> 添加</button>
	<button type="button" class="btn btn-danger radius" onclick="datadel()" ><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</button>
	</div>
	<div id="productChannel"  class="mt-20">
		<table class="table table-border table-bordered table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th ><input type="checkbox" name="" value=""></th>
					<th >ID</th>
					<th >年龄</th>
					<th >姓名</th>
					<th >总分</th>
					<th >平均分</th>
					<th >操作</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<%@include file="footer.jsp" %>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../lib/jquery.dataTables.js"></script>
<script type="text/javascript">
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

$(function(){
	$('.table-sort').dataTable( {
	"sPaginationType": "simple_numbers",      //翻页界面类型  
	"iDisplayLength": 5,                    //每页显示8条数据     
	"bAutoWidth": false,                    //不自动计算列宽度     
	"searching":false,
    "oLanguage": {
    	"sLengthMenu": "每页显示 _MENU_ 条记录",
    	"sZeroRecords": "抱歉， 没有找到",
    	"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
    	"sInfoEmpty": "没有数据",
    	"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
    	"oPaginate": {
    	"sFirst": "首页",
    	"sPrevious": "前一页",
    	"sNext": "后一页",	
    	"sLast": "尾页"
    	}},
    
    "bProcessing": true,                    //加载数据时显示正在加载信息     
    "bServerSide": true,                    //指定从服务器端获取数据     
    "sAjaxSource": "http://localhost:8080/productService",//获取数据的url    
    "aoColumns": [                          //设定各列宽度     
                                            {"mData": "",   "mRender": function ( data, type, full, meta )
                        	                  { return '<input type="checkbox">';
                        	                }  },     
                                            //{"mData": ''},   
                                            {"mData": 'id'},  
                                            {"mData": 'age'},    
                                            {"mData": 'name'},      
                                            {"mData": 'sumScore'},       
                                            {"mData": 'avgScore'},   
                                            //{"mData": 'avgScore'},
                                            {"mData": '',"mRender": function ( data, type, full, meta )
                 		                       { return "<a href='demoForm.jsp'  rel='demo_p11112' id=\'" +
                    	                        full["id"]+
                    	                        "\' style='color:blue;' onclick='edit(id,0)' > 修改</a>"+" &nbsp;" +
                    	                        		"&nbsp;<a  target='navTab' rel='demo_p11112' id=\'" +
                    	                        full["id"]+
                    	                        "\' style='color:blue;' onclick='remove(id)' >删除</a>"+" &nbsp;" +
                    	                        		"&nbsp;<a href='demoForm.jsp' target='navTab'   rel='demo_p11112' id=\'" +
                    	                        full["id"]+
                    	                        "\' style='color:blue;' onclick='detail(id,1)' >查看</a>";
                 		                       }  }
                                              
                                            
                                        ],     
    "fnServerData": function( sSource, aoData, fnCallback ) {
    	var pageNum;
    	var pageSize;
    	for(var i=0;i<aoData.length;i++){
    		if(aoData[i].name=="iDisplayStart"){
    			pageNum = aoData[i].value;
    		}else if(aoData[i].name=="iDisplayLength"){
    			pageSize = aoData[i].value;
    		}
    	}
    	pageNum = pageNum/pageSize+1;
        $.ajax( {     
            type: "POST",      
            url: sSource,      
            dataType: "json",  
            data: {_method:'PATCH',
        		"pageNum":pageNum,
        		"pageSize":pageSize},
    		  		//传入组装的参数
    		  		
            success: function(res) {     
            	console.log(res);
            	 var returnData = {};
                //returnData.sEcho = 1;//这里直接自行返回了draw计数器,应该由后台返回
                returnData.iTotalRecords = res.page.total;
                returnData.iTotalDisplayRecords  =res.page.total;//后台不实现过滤功能，每次查询均视作全部结果
                returnData.aaData = res.page.list;
                fnCallback(returnData);  //服务器端返回的对象的returnObject部分是要求的格式    
            }     
        });     
    }           //获取数据的处理函数     
    

}); 
})

function edit(id,flag){
	alert(id)
}
function remove(id){
	alert(id)
}

function detail(id,flag){
	if(flag){
		console.log(flag)
		
	}
}
</script>
</body>
</html>