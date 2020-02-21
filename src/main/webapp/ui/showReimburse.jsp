<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<!--<base href="/jboa/">-->
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet"
	type="text/css">
	<style type="text/css">
		td>a{
			cursor: pointer;
		}
		.page-bar>a{
			display: inline-block;
			margin: 0 5px;
		}
		.conOp>a>img{
			width: 16px;
			height: 16px;
		}
	</style>
</head>

<body>
	<div class="action  divaction">
		<div class="t">报销单列表</div>
		<div class="pages">
			<div class="forms">
				<form id="myForm" name="queryForm"
					action="../jboa/page/findList?pageNum=1&pageSize=10" method="get">
					<label>报销单状态</label> <select name="statusId" id="statusId">
						<option value="0">全部</option>
					</select> <label for="time">开始时间</label> <input type="text" name="StartTime"
						value="" id="startDate" class="nwinput"> <label
						for="end-time">结束时间</label> <input type="text" name="endTime"
						value="" id="endDate" class="nwinput">
					<label>查看</label>
					<select name="showId">
						<option value="0" selected="selected">全部</option>
						<option value="1">仅看本人</option>
					</select> 
					<input type="button" id="query"
						value="查询" class="submit_01">
				</form>
			</div>
			<!--增加报销单 区域 开始-->
			<form id="claimVoucher_searchClaimVoucher_action"
				name="claimVoucherForm"
				action="jsp/claim/claimVoucher_searchClaimVoucher.action"
				method="post">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="list items">
					<thead>
						<tr class="even">
							<td>编号</td>
							<td>填报日期</td>
							<td>填报人</td>
							<td>总金额</td>
							<td>状态</td>
							<td>待处理人</td>
							<td width=20%>操作</td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</form>
			<!--增加报销单 区域 结束-->
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script>
		/* $(function() {
			//日期选择控件
			$("#startDate").click(function() {
				WdatePicker({
					dateFmt: 'yyyy-MM-dd',
					maxDate: '#F{$dp.$D(\'endDate\')}',
					isShowClear: true,
					readOnly: true
				});
			});
			$("#endDate").click(function() {
				WdatePicker({
					dateFmt: 'yyyy-MM-dd',
					minDate: '#F{$dp.$D(\'startDate\')}',
					isShowClear: true,
					readOnly: true
				});
			});
		}); */
		var user =JSON.parse(window.sessionStorage.getItem("user"));
		
		if(user.positionid==2||user.positionid==4){
			$("[name=showId]").hide();
		}
		
		 LoadAll();
		/*页面初始化*/
		function LoadAll(){
			$.post("/projectFour/c/Tbstatus/queryAll",function(res){
				$.each(res,function(i,obj){
					$("#statusId").append($("<option value='"+obj.statusid+"'>"+obj.statusname+"</option>"));
				})
				var currentPage=window.sessionStorage.getItem("currentPage");
				//alert(currentPage);
				if(currentPage!=null){
					LoadTbData(currentPage)
				}else{
					LoadTbData(1)
				}	
			},"json")
		}

		function LoadTbData(currentPage){
			$(".TrShow").remove();
			var statusId=$("[name=statusId]").val();
			var StartTime=$("[name=StartTime]").val();
			var endTime=$("[name=endTime]").val();
			var showId=$("[name=showId]").val();
				$.post("/projectFour/c/Tbreimburse/queryPageByTerm",{"statusId":statusId,"StartTime":StartTime,"endTime":endTime,"currentPage":currentPage,"showId":showId},function(res){
					$.each(res.list,function(i,obj){
							var tr=$("<tr class='TrShow'><td><a href='javascript:void(0)''>"+obj.reimburseid+"</a></td>"+
									"<td>"+obj.createTimeStr+"</td><td>"+obj.createManName+"</td><td>"+obj.totalcount+"</td>"+
									"<td>"+obj.statusName+"</td><td>"+obj.nextName+"</td>"+
									"<td class='conOp'><a href='javascript:void(0)' class='aSub' data-id="+obj.reimburseid+"> <img src='../images/save.gif' title='提交'> </a>"+
									 "<a href='/projectFour/c/Tbreimburse/queryByTbId?pageName=updateReimburse&tbId="+obj.reimburseid+"' class='aModify' onclick=page('"+currentPage+"')> <img src='../images/edit.gif' title='编辑' ></a> "+
									"<a href='javascript:void(0)' class='aDelete' data-id="+obj.reimburseid+"> <img src='../images/delete.gif' title='删除'></a>  "+
									"<a href='/projectFour/c/Tbreimburse/queryByTbId?pageName=seeReimburse&tbId="+obj.reimburseid+"' onclick=page('"+currentPage+"') clas='aQuery'> <img src='../images/search.gif' title='查看详情' ></a></td></tr>");
							/* 状态 逻辑判断*/
							//console.log(obj.nextName+","+user.employeename)
							if(obj.nextName==user.employeename){
								//修改路徑
								tr.find(".conOp").find(".aModify").find("img").attr("title","审核");
								tr.find(".conOp").find(".aModify").find("img").attr("src","../images/sub.gif");
								tr.find(".conOp").find(".aModify").attr("href","/projectFour/c/Tbreimburse/queryByTbId?pageName=updateReimburse&Status=1&tbId="+obj.reimburseid);
							}
							/* 不是本人 */
							if(obj.createManName!=user.employeename){
								tr.find(".conOp").find(".aSub").remove();
								tr.find(".conOp").find(".aDelete").remove();
							}
							
							if(!(obj.statusid==1||obj.statusid==6)&&obj.statusid==8){
								tr.find(".conOp").find(".aSub").remove();
							}
							if(obj.statusid==8){
								tr.find(".conOp").find(".aSub").remove();
							}else if(!(obj.statusid==1||obj.statusid==6)){
								tr.find(".conOp").find(".aSub").remove();
								tr.find(".conOp").find(".aDelete").remove();
							}
							
							if(!(obj.statusid==1||obj.statusid==6)&&obj.nextName!=user.employeename){
								tr.find(".conOp").find(".aModify").remove();
							}
							if(obj.statusid==6&&obj.createManName!=user.employeename){
								tr.find(".conOp").find(".aModify").remove();
							}
							if(obj.statusid==6){
								tr.find(".conOp").find(".aDelete").remove();
							}

							if(obj.statusid==8){
								tr.find(".conOp").find(".aModify").remove();
							}

							
							$("tbody").append(tr);
					
						
					})
				

					/*  翻页*/
					var tr=$("<tr class='TrShow'><td colspan='7' align='center'> <div class='page-bar'>"+
						"<a href='javascript:void(0)' data-page="+res.firstPage+">首页</a>"+
						"<a href='javascript:void(0)' data-page="+res.prePage+">上一页</a>"+
					"<a href='javascript:void(0)' data-page="+res.nextPage+">下一页</a>"+
					"<a href='javascript:void(0)' data-page="+res.lastPage+">末页</a>"+
					"第 "+res.pageNum+"页/共"+res.pages+"页&nbsp;&nbsp;共"+res.total+"条记录 </div> </td></tr>");
					$("table").append(tr);

					
					//绑定事件
					$(".page-bar>a").on('click',function(){
							var currentPage=$(this).attr("data-page");
							if(currentPage==0){
								alert("没有"+$(this).text())
							}else{
								LoadTbData(currentPage);
							}		
					})

					/* 删除 */
					$(".aDelete").on('click',function(){
							var tbId=$(this).attr("data-id");
							$.post("/projectFour/c/Tbreimburse/removeById",{"tbId":tbId},function(res){
								if("yes"==res){
									alert("删除成功");
									LoadTbData(currentPage);
								}
							})
					})

					/*提交*/
					$(".aSub").on('click',function(){
						var tbId=$(this).attr("data-id");
						if(confirm("是否提交")){
							$.post("/projectFour/c/Tbreimburse/modifyStatus",{"reimburseid":tbId,"statusid":2},function(res){
								if("yes"==res){
									alert("提交成功");
									LoadTbData(currentPage);
								}
							})
						}		
					})
				},"json")
		}

		//表单查询
		$("#query").click(function(){
			LoadTbData(1);
		})
		
		//设置加载页面
		function page(currentPage){
			window.sessionStorage.setItem("currentPage",currentPage);
		}
	</script>
</html>