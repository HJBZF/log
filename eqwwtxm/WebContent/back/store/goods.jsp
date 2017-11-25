<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<script type="text/javascript" src="../../js/showpic.js"></script>
<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>
<table id="goods_data"></table>

<div  id="img-container">
	<img src="" id="imgBig" onclick="smallImg()"/>
</div>

<style>
	#img-container{
		width:100%;
		height:100%;
		position:absolute;
		left:0px;
		top:0px;
		background:rgba(255,255,255,0.7);
		display:none;
	}
	
	#img-container img{
		width:300px;
		height:300px;
		top:100px;
		left:450px;
		position:absolute;
		opacity:1;    <!-- 设置成不透明 -->
	}
.easyui-dialog p{
		margin-left: 50px;
		margin-top: 10px;
		width:290px;
		font-size:14px;
	}
	#licensediv{
		position: absolute;;
		left:500px;
	 	top:90px;	 	
	}
	/* .easyui-dialog .login_p1{
		margin-top: 40px;
	} */
	.easyui-dialog p input{
		width:200px;
		height:22px;
		font-size:14px;
	}
	#license_label{
		position: absolute;;
		left:400px;
	 	top:65px;
	 	width:200px;
	 	height:30px;
	 	font-size: 20px;
	 	line-height: 30px;
	}
	/* .easyui-dialog p select{
		width:205px;
		height:28px;
		font-size:14px;
	} */
</style>
<script type="text/javascript">
function bigImg(src){
	var img = new Image();
	$("#img-container").css("display","block");
	$("#imgBig").attr("src",src);
}

function smallImg(){
	$("#img-container").css("display","none");
}

var goods_status=["注销","上架","下架"];

var goodsEditRow=undefined;  //当前正在编辑的行
var goodsOp;  //操作
var goodsFlag;  //标识
var goodsObj=$('#goods_data').datagrid({   
    url:'../../goodsServlet',  
    queryParams:{op:"findByPage"},
    fitColumns:true,
    pagination:true,
    rownumbers:true,
    striped:true,
    fit:true,
    remoteSort:false,
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'gid',
    columns:[[   
  	        {checkbox:true},
  	        {field:'gid',title:'商品编号',width:100,align:'center',sortable:true},   
  	        {field:'gname',title:'商品名称',width:100,align:'center'},
  	        {field:'price',title:'商品原价',width:100,align:'center'}, 
  	        {field:'aprice',title:'活动价格',width:60,align:'center'},
  	        {field:'startDate',title:'开始时间',width:120,align:'center'},
  	        {field:'endDate',title:'结束时间',width:120,align:'center'},
  	        {field:'mark',title:'商品简介',width:100,align:'center'},
  	        {field:'descr',title:'订单详细',width:100,align:'center'},
  	        {field:'status',title:'状态',width:100,align:'center',formatter:function(val,row,index){
  	        	return goods_status[val];
  	        }},
  	      	{field:'pic',title:'商品图片',width:100,align:'center',formatter:function(val,row,index){
	  			license = "<img src='../../"+val+"' width='50px' height='50px' onclick='bigImg(this.src)'>";
	        	return license;
	        }},
	        
  	        {field:'_operate',title:'操作',width:100,align:'center',formatter:function(val,row,index){
  	        	var str="";
  	        	if(row.status==0){ //注销
  	        		str="";
  	        	}else if(row.status==1){ //上架
  	        		str+="<a href='javascript:store_changeStatus("+row.gid+",4)'>[下架]</a>";
  	        	}else if(row.status==4){ //下架
  	        		str+="<a href='javascript:store_changeStatus("+row.gid+",1)'>[上架]</a>";
  	        	}
  	        	return str;
  	        }}
  	    ]],
    toolbar: [{
    	text:"添加",
		iconCls: 'icon-add',
		handler: function(){
			goodsOp="addGoods";
			goodsFlag="添加";			
			$('#show_add_store').dialog({   
			    width: 1000,   
			    height: 300,   
			    buttons:[{
					text:'注册',
					handler:function(){
						var gid=$.trim( $("#gid").val() );
						var gname=$.trim( $("#gname").val() );
						var price=$.trim( $("#price").val() );
						var pic=$.trim( $("#pic").val() );
						var aprice=$.trim( $("#aprice").val() );
						var startDate=$.trim( $("#startDate").val() );
						var endDate=$.trim( $("#endDate").val() );
						var mark=$.trim( $("#mark").val() );
						var descr=$.trim( $("#descr").val() );
						
						if(gname=="" || price==""){
							$.messager.show({title:'温馨提示',msg:'您输入的信息不完整，请完善后再提交...',timeout:2000,showType:'slide'});
							return;
						}
						
						$.ajaxFileUpload({
							url:"../../goodsServlet?op=addGoods",
							secureuri:false,
							dataType:"text",
							data:{gname:gname,price:price,aprice:aprice,startDate:startDate,endDate:endDate,mark:mark,descr:descr},
							fileElementId:"pic",
							success:function(data,status){
								data=parseInt( $.trim(data) );
								if(data>0){
									$("#licensediv").html("");
									$('#show_add_store').dialog("close");
									$.messager.alert('成功提示','店铺信息注册成功，等待后台审核...','info');
									goodsObj.datagrid("reload");
								}else{
									$.messager.alert('失败提示','店铺信息注册失败，请稍后再试...','error');
								}
							},
							error:function(data,status,error){
								$.messager.alert('失败提示','店铺信息注册失败，请稍后再试...\n'+error,'error');
							}
						})
					}
				},{
					text:'关闭',
					handler:function(){
						$('#show_add_store').dialog('close');
					}
				}]
			}); 
			$('#show_add_store').dialog('open');  
		}
	},'-',{
		text:"修改",
		iconCls: 'icon-edit',
		handler: function(){
			goodsOp="editStoreType";
			goodsFlag="修改";
			
			if(goodsEditRow!=undefined){
				goodsObj.datagrid('endEdit',goodsEditRow);  //结束编辑
				goodsObj.datagrid('rejectChanges');
				goodsEditRow=undefined;
			}
			
			var row=goodsObj.datagrid('getChecked')[0];
			if(row==undefined){
				$.messager.show({title:'温馨提示',msg:'请选择您要修改的管理员信息...',timeout:2000,showType:'slide'});
			}else{
				var index=goodsObj.datagrid('getRowIndex',row);
				goodsObj.datagrid('beginEdit',index);
				goodsEditRow=index;
			}
		}
	},'-',{
		text:"删除",
		iconCls: 'icon-remove',
		handler: function(){
			var rows=goodsObj.datagrid('getChecked');
			if(rows.length<=0){
				$.messager.show({title:'温馨提示',msg:'请选择您要删除的商品信息...',timeout:2000,showType:'slide'});
			}else{
				$.messager.confirm('删除确认','数据一旦删除将不能恢复，您确定要删除吗?',function(r){   
				    if (r){   
				        var gid="";
				        for(var i=0,len=rows.length;i<len-1;i++){
				        	gid+=rows[i].gid+",";
				        }
				        gid+=rows[i].gid;
				        
				        $.post("../../goodsServlet",{op:"deleteGoods",gid:gid},function(data){
							if(data>0){
								$.messager.show({title:'成功提示',msg:'商品信息删除成功...',timeout:2000,showType:'slide'});
							}else{
								$.messager.alert('失败提示','商品信息删除失败...','error');   
							}
							goodsObj.datagrid("reload");
						},"text");
				    }   
				});  
			}
		}
	}]
});  

function store_changeStatus(sid,status){
	if(status==4){
		store_change(sid,status);
	}else{
		store_change(sid,status);
	}
}
function store_change(gid,status){
	$.post("../../goodsServlet",{op:"changeStatus",gid:gid,status:status},function(data){
		data=parseInt($.trim(data));
		if(data>0){
			$.messager.show({title:'成功提示',msg:'商品信息操作成功...',timeout:2000,showType:'slide'});
			$('#goods_data').datagrid("reload");
		}else{
			$.messager.alert('失败提示','商品操作失败...','error');   
		}
	},"text");
}

</script>
<div id="show_add_store" class="easyui-dialog" title="商品添加" data-options="iconCls:'icon-user-add',resizable:true,modal:true,closed:true">
	<form id="store_reg">
		<!-- <p class="login_p1">商品名称：
			<select id="gname"></select>
		</p> -->
		<p>商品名称：
			<input type="text" id="gname"/>
		</p>
		<p>商品原价：
			<input type="text" id="price"/>
		</p>
		<p>商品图片：
			<input type="file" id="pic" name="pic" onchange="setImagePreviews(this,'licensediv')"/>
		</p>
		<div id="licensediv"></div>
		<p>活动价格：
			<input type="text" id="aprice"/>
		</p>
		<p>开始时间：
			<input type="text" id="startDate"/>
		</p>
		<p>结束时间：
			<input type="text" id="endDate"/>
		</p>
		<p>商品简介：
			<textarea rows="3" cols="30" id="mark"></textarea>
		</p>
		<p>订单详细：
			<!-- <input type="text" id="descr"/> -->
			<textarea rows="10" cols="50" id="descr"></textarea>
		</p>
		
	</form>	
	<div id="license_label">商品图片</div>
</div>