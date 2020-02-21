<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大青鸟办公自动化管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.img{cursor:pointer;width: 40px;height:40px;}
</style>

</head>
<body>
	<div class="action  divaction">
		<div class="t">新增报销单</div>
		<div class="pages">
			<form id="claimVoucher_updateClaimVoucher_action" name="claimForm" enctype="multipart/form-data"
				action="/projectFour/c/Tbreimburse/addTb" method="post">
				<!-- 储存明细数量 -->
				<!-- <input type="hidden" id="rowNumber" name="rowNumber" value="0"> -->
				<!-- 储存提交状态 -->
				<input type="hidden" id="statusid" name="statusid" value="0">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>基本信息</caption>
					<tbody>
						<tr>
							<td>编&nbsp;&nbsp;号：${sessionScope.user.employeeid }</td>
							<td>填&nbsp;写&nbsp;人：${sessionScope.user.employeename }</td>
							<td>部&nbsp;&nbsp;门：${sessionScope.user.departmentName }</td>
							<td>职&nbsp;&nbsp;位：${sessionScope.user.positionName }</td>
						</tr>
						<tr>
							<td>总金额： <input type="text" name="totalcount"
								value="0" readonly="readonly" id="totalAccount"></td>
						</tr>
						<tr>
							<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
						</tr>
					</tbody>
				</table>
				<table id="myTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<thead>
						<tr>
							<td width="30%">项目说明</td>
							<td width="30%">项目金额</td>
							<td width="30%">凭据截图</td>
							<td width="10%">操作</td>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<table id="detailTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<tbody>
						<tr>
							<td width="30%">
								<input type="text" id="item">
							</td>
							<td width="30%"><input type="text" id="account">
							</td>
							<td width="30%">
								<input type="file" name="imgFile" id="imgUrl1">
							</td>
							<td width="10%">
								<img src="../images/add.gif" width="16" height="16" id="AddRow">
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td>*事由：</td>
							<td colspan="3"><textarea name="event"
									cols="66" rows="5" id="event"></textarea></td>
						</tr>
						<tr align="center" colspan="4">
							<td>&nbsp;</td>
							<td><input type="button" id="1" name="1" value="保存"
								onclick="submitClaimVoucher('保存')" class="submit_01"> <input
								type="button" id="2" name="2" value="提交" class="submit_01"
								onclick="submitClaimVoucher('提交')"> <input type="button"
								value="返回" onclick="window.history.go(-1)" class="submit_01">
							</td>
						</tr>
					</tbody>
				</table>
			</form>

		</div>
	</div>


</body>
  <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//data:base64数据       name:文件名(feng.jpg)
	var imgObj = {
		"data" : "",
		"name" : ""
	};//图片对象
	
	var i=parseInt(1);  
	//var rowNumber=parseInt(1);  
	/* 计算总价格 */
	var totalAccount = 0;
	
	
	
	$(function(){				
		//表单提交校验
		$("form[name='claimForm']").submit(function(){
			//判断是否加入了问题 
			/* if($("#rowNumber").val()<1){
				$("#notice").text("* 添加报销单的明细，至少一条 ！");
				return false;
			}	 */
			/* $("#notice").text("*");
			for(var s=0;s<$("#rowNumber").val();s++){
				$("#account"+s).next(".notice").text("*");
				$("#imgUrl"+s).next(".notice").text("*");
				if(isEmpty($("#account"+s).val())){
					$("#account"+s).next(".notice").text("* 金额不能为空  ！");
					return false;
				}		
				if(isEmpty($("#imgUrl"+s).val())){
					$("#imgUrl"+s).next(".notice").text("* 金额不能为空  ！");
					return false;
				}			
			}
			$(".buttons").hide(); */
			return true;
		});	
		
		
		$("#AddRow").click(function(){
			var tr=$("#myTable tr").eq(0).clone();
			++i;
			var j=i-1;
			
			var item = $("#item").val();
			var account = $("#account").val();
			var imgUrl = $("#imgUrl").val();
			var imgUrl1 = $("#imgUrl1").val();
			var file = $("#imgUrl"+j)[0].files[0];
			
			if(!file){
				alert("请选择文件");
				i--;
				return;
			}
			if(item == ""){
				alert("请输入项目说明");
				i--;
				return false;
			}
			if(account == ""){
				alert("请输入项目金额");
				i--;
				return false;
			}else{
				if(isNaN(account)){
					alert("请输入正确的数字");
					i--;
					return false;
				}else{
					if(account<=0){
						alert("请输入正确的数字");
						i--;
						return false;
					}
				}
			}
			
			totalAccount=parseFloat(totalAccount)+parseFloat(account);

			/*创建新节点  */
			tr.find("td").get(0).innerHTML="<input  id=item"+j+" name='desc' type=hidden value="+item+" />"+item;
			tr.find("td").get(1).innerHTML="<input  id=account"+j+" name='subTotal' type=hidden value="+account+" />"+account;
			tr.find("td").get(2).innerHTML="<img class='img' id=img"+j+" src=''>";		
			tr.find("td").get(3).innerHTML="<img src=../images/delete.gif width=16 height=16 id=DelRow"+j+" onclick=delRow("+j+",this) />";
			//图片操作
			var fr = new FileReader();
			var fileEle = "<input type='file' name='imgFile' id='imgUrl"+(j+1)+"'>";
			
			$("#imgUrl"+j).after(fileEle);
			fr.readAsDataURL(file);//读取文件
			//图片预览
			fr.onload = function() {
				var base64Data = this.result;//获得base编码字符串格式
				imgObj.name = file.name;//设置文件名
				imgObj.data = base64Data.substring(base64Data
						.indexOf(';base64,') + 8);//设置base64数据字符串
				$("#img"+j).attr("src", base64Data);//显示图片
			};
			tr.show();
			tr.appendTo("#myTable");
			//传递一共添加多少问题 
			$("#account").val("");
			$("#item").val("");
			/*隐藏上一个文件控件*/
			$("#imgUrl"+j).hide()
			$("#totalAccount").val(totalAccount);
	
		});	
		
	});
	
	function delRow(id,obj){	
		var account = $("#account"+id).val();
		$(obj).parent().parent().remove();
		$("#imgUrl"+id).remove();
		totalAccount=parseFloat(totalAccount)-parseFloat(account);
		$("#totalAccount").val(totalAccount);
	}
	
	
	function submitClaimVoucher(action){
		var desc = $("[name='desc']");
		if(desc.length == 0){
			alert("请输入至少一条明细");
			return false;
		}
		var event = $("#event").val();
		if(event == ""){
			alert("请输入报销事由");
			return false;
		}
		
  		
  		if (action == '保存'){
  			document.claimForm.statusid.value = 1;
  		}else{
  			document.claimForm.statusid.value = 2;
  		}
  		document.claimForm.submit();
	   		
	 }
	
	//图片检查
	$("[name='imgFile']").on("change", function(e) {
		var file = this.files[0];
		var _temp = file.name.match(/\.jpg|\.png|\.jpeg|\.gif|\.bmp/i);
		if (!_temp) {
			this.value = "";
			alert("目前只支持jpg,png,bmp,gif格式图片文件");
			return false;
		} else if (file.size > (1024 * 1024)) {
			this.value = "";
			alert("目前只支持小于1M大小图片文件");
			return false;
		}
	});
</script>
</html>