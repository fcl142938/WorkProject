<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>北大青鸟办公自动化管理系统</title>
<style type="text/css">
.img {
	width: 40px;
	height: 40px;
	cursor: pointer;
}

.showImg {
	width: 16px;
	height: 16px;
	cursor: pointer;
}


.showBt>input {
	cursor: pointer;
}
</style>
<link href="../../css/style.css" rel="stylesheet" type="text/css">


</head>
<body>
	<form id="claimForm" name="claimForm" method="post" enctype="multipart/form-data" action="/projectFour/c/Tbreimburse/modifyAll">
		<div class="action  divaction">
			<div class="t">
				<c:if test="${Status!=1 }">
					修改报销
				</c:if>
				<c:if test="${Status==1 }">
					审核报销
				</c:if>
			</div>
			<div class="pages">
				<!--增加报销单 区域 开始-->
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>基本信息</caption>
					<tbody>
						<tr>
							<td>编&nbsp;&nbsp;号：${tbr.userVo.employeeid}</td>
							<td>填&nbsp;写&nbsp;人：${tbr.userVo.employeename}</td>
							<td>部&nbsp;&nbsp;门：${tbr.userVo.departmentName}</td>
							<td>职&nbsp;&nbsp;位：${tbr.userVo.positionName}</td>
						</tr>
						<tr>
							<td>总金额： <c:if test="${Status!=1 }">
									<input type="text" readonly="readonly" id="totalAccount" name="totalcount"
										value="${tbr.totalcount}" />
								</c:if> <c:if test="${Status==1 }">
									${tbr.totalcount}
								</c:if>
							</td>
							<td>填报时间：${tbr.createTimeStr}</td>
							<td>状态：${tbr.statusName}</td>
							<td>待处理人：${tbr.nextName}</td>
						</tr>
						<tr>
							<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
						</tr>
					</tbody>
				</table>
				<p>&nbsp;</p>
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<thead>
						<tr>
							<td>项目说明</td>
							<td>项目金额</td>
							<td>票据截图</td>
							<c:if test="${Status!=1 }">
								<td>操作</td>
							</c:if>
						</tr>
					</thead>
					<tbody>
					<!--主表id  -->
						<input type="hidden" name="reimburseid" id="reimburseid"
							value="${tbr.reimburseid }" />
						<c:forEach items="${tbr.reList }" var="re">
							<tr class='trNumber'>
								<td><span>${re.desc}</span></td>
								<td><span>${re.subtotal}</span></td>
								<td><img class="img" src="/img_server/${re.picturepath }"></td>
								<c:if test="${Status!=1 }">
									<td><img src="../../images/delete.gif" data-id='${re.id }'
										class="showImg" onclick='delRow(-1,this)'></td>
								</c:if>
							</tr>
						</c:forEach>
						<c:if test="${Status!=1 }">
							<tr id="myTableTr">
								<!--确认提交状态 -->
								<input type="hidden" name="statusid" id="statusId" value="1" />
								<td width="30%"><input type="text" id="desc"></td>
								<td width="30%"><input type="text" id="subTotal"></td>
								<td width="30%"><input type="file" name="imgFile" id="imgUrl0"></td>
								<td width="10%"><img src="../../images/add.gif"
									class="showImg" id="AddRow"></td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<p>&nbsp;</p>
				<p>-------------------------------------------------------------------------------</p>

				<table style="margin-top: 15px;" width="90%" border="0"
					cellspacing="0" cellpadding="0" class="addform-base">
					<thead>

						<tr>
							<td width="15%">审查人</td>
							<td width="40%">审查意见</td>
							<td width="30%">审查时间</td>
							<td width="15%">审查结果</td>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${tbr.tbList }" var="tb">
							<tr>
								<td><span>${tb.checkManName }</span></td>
								<td><span>${tb.checkComment }</span></td>
								<td><span>${tb.checkTimeStr }</span></td>
								<td><span class="weight">${tb.resultName }</span></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<table>
					<tbody>
						<c:if test="${Status!=1 }">
							<tr>
								<td>*事由：</td>
								<td><textarea name="event" cols="66" rows="5" id="event">${tbr.event }</textarea></td>
							</tr>
							<tr>
								<td colspan="2" style="padding-left: 100px;" class='showBt'><input
									type="button" id="1" value="保存"
									onclick="submitClaimVoucher('保存')" class="submit_01"> <input
									type="button" id="2" name="2" value="提交" class="submit_01"
									onclick="submitClaimVoucher('提交')"> <input
									type="button" value="返回" onclick="window.history.go(-1)"
									class="submit_01"></td>
							</tr>
							</tr>
						</c:if>
						<!-- 审核 -->
						<c:if test="${Status==1 }">
							<tr>
								<td>审批意见：</td>
							</tr>
							<tr>
								<td colspan="3"><textarea cols="66" rows="5" id="event"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" style="padding-left: 100px;" class='showBt'>
									<input type="button" value="通过" data-status="1" class="submit_01 addChe"> 
									<input type="button" value="拒绝" data-status="2" class="submit_01 addChe">
									<input type="button" value="打回" data-status="3" class="submit_01 addChe">
									<input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01">
								</td>
						</c:if>
					</tbody>
				</table>
				<p>&nbsp;</p>
				<!--增加报销单 区域 结束-->
			</div>
		</div>
	</form>
</body>

<script type="text/javascript" src="../../js/jquery-1.8.0.min.js"></script>
<!-- <script type="text/javascript" src="../../js/common.js"></script> -->
<script type="text/javascript">
	//data:base64数据       name:文件名(feng.jpg)
	var imgObj = {
		"data" : "",
		"name" : ""
	};//图片对象

	var j = parseInt(0);
	
	/* 计算总价格 */
	var totalAccount =parseFloat("${tbr.totalcount}");
	
	$(function() {
		//表单提交校验
		/* $("form[name='claimForm']").submit(function() {
			return true;
		}); */

		$("#AddRow").click(function() {
							//复制
							var OldTr=$(this).parent().parent();
							var tr = $("#myTableTr").eq(0);
							var item = OldTr.find("#desc").val();
							var account = OldTr.find("#subTotal").val();
							var imgUrl = OldTr.find("#imgUrl").val();
							var imgUrl1 = OldTr.find("#imgUrl1").val();
							var file = $("#imgUrl" + j)[0].files[0];
							if (!file) {
								alert("请选择文件");
								return;
							}
							
							if (item == "") {
								alert("请输入项目说明");
								return false;
							}
							if (account == "") {
								alert("请输入项目金额");
								return false;
							} else {
								if (isNaN(account)) {
									alert("请输入正确的数字");
									return false;
								} else {
									if (account <= 0) {
										alert("请输入正确的数字");
										return false;
									}
								}
							}
							/*隐藏上一个文件控件*/
							$("#imgUrl" + j).hide();
							//设置总金额
							totalAccount = parseFloat(totalAccount)
									+ parseFloat(account);
							/*创建新节点  */
							var newTr=$("<tr class='trNumber'><td></td><td></td><td></td><td></td></tr>");
							newTr.find("td").get(0).innerHTML = "<input   name='desc' type=hidden value="+item+" />"+ item;
							newTr.find("td").get(1).innerHTML = "<input  name='subTotal' type=hidden value="+account+" />"+ account;
							
							newTr.find("td").get(3).innerHTML = "<img src=../../images/delete.gif width=16 height=16  onclick=delRow(" + j + ",this) />";
							//图片操作
							var fr = new FileReader();
							
							var fileEle = "<input type='file' name='imgFile' id='imgUrl"
									+ (j+1)  + "'>";
							$("#imgUrl" + j).after(fileEle);
							j++;
							fr.readAsDataURL(file);//读取文件
							//图片预览
							fr.onload = function() {
								var base64Data = this.result;//获得base编码字符串格式
								imgObj.name = file.name;//设置文件名
								imgObj.data = base64Data.substring(base64Data
										.indexOf(';base64,') + 8);//设置base64数据字符串
								newTr.find("td").get(2).innerHTML = "<img class='img'  src='"+base64Data+"'>";//显示图片
							};
							OldTr.before(newTr);
							//传递一共添加多少问题 
							$("#subTotal").val("");
							$("#desc").val("");
							$("#totalAccount").val(totalAccount);

						});

	});

	function delRow(id, obj) {
		var tr=$(obj).parent().parent();
		var account ;
		$(obj).parent().parent().remove();
		if(id!=-1){
			$("#imgUrl" + id).remove();
			account=tr.find("[name=subTotal]").val();			
		}else{
			account=tr.find("td").eq(1).find("span").text();
			var removeid= $(obj).attr("data-id");
			$("#statusId").after($("<input name='removeId' type='hidden' value="+removeid+">"));	
		}
		totalAccount = parseFloat(totalAccount) - parseFloat(account);
		$("#totalAccount").val(totalAccount);
	}

	function submitClaimVoucher(action) {
		var desc = $(".trNumber");
		if (desc.length == 0) {
			alert("请输入至少一条明细");
			return false;
		}
		var event = $("#event").val();
		if (event == "") {
			alert("请输入报销事由");
			return false;
		}

		if (action == '保存') {
			$("#statusId").val("");
		} else {
			$("#statusId").val(2);
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

	$(".addChe").click(function(){

		var checkresult=$(this).attr("data-status");
		var checkcomment=$("#event").val();
		if(checkcomment==""){
			alert("请填写意见");
			return;
		}	
		$.post("/projectFour/c/Tbreimburse/modifyStatusByNext",{"reimburseid":"${tbr.reimburseid }","checkresult":checkresult,"checkcomment":checkcomment},function(res){
				if("ok"==res){
					alert("审批成功");
					window.history.go(-1)
				}
		})

	})
</script>
</html>