<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!--<base href="/jboa/">-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大青鸟办公自动化管理系统</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
.showTr>td {
	text-align: center;
}
</style>
</head>

<body>
	<div class="action  divaction">
		<div class="t">查看请假</div>
		<div class="pages">
			<!--增加报销单 区域 开始-->
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base">
				<caption>基本信息</caption>
				<tbody>
					<tr>
						<td width="36%">姓名：${tb.imName }</td>
						<td width="64%">部门 :${tb.departmentName }</td>
					</tr>
					<tr>
						<td>开始时间：${tb.starttimeStr}</td>
						<td>结束时间：${tb.endtimeStr }</td>
					</tr>
					<tr>
						<td>请假天数：${tb.totalcount }</td>
						<td>请假事由：${tb.event }</td>
					</tr>
					<tr>
						<td>审批状态：${tb.statusName }</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<p>
				-------------------------------------------------------------------------------
			</p>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base" style="margin: 20px 0;">
				<thead>
					<tr>
						<th>审查人</th>
						<th>审查意见</th>
						<th>审查时间</th>
						<th>审查结果</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tb.list }" var="che">
						<tr class="showTr">
							<td>${che.checkManName }</td>
							<td>${che.checkComment }</td>
							<td>${che.checkTimeStr }</td>
							<td>${che.resultName }</td>
						</tr>
					</c:forEach>
				</tbody>
				<c:if test="${status==1 }">
					<tr>
						<td colspan="4">审批意见：<br /> <textarea rows="8" cols="50"
								name="event"></textarea><br /> <input type="button" value="审批拒绝"
							class="submit_01 modify" data-status="2" /> <input type="button" value="审批通过"
							class="submit_01 modify"   data-status="1"/>
						</td>
					</tr>
				</c:if>
				<!--表单提交行-->
				<tr>
					<td colspan="4" class="submit"><input type="button" value="返回"
						onclick="window.history.go(-1)" class="submit_01"></td>
				</tr>
			</table>
			<!--增加报销单 区域 结束-->
		</div>
	</div>
	<script type="text/javascript" src="../../js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">

		//提交
		$(".modify").click(function(){
			var  tbId="${tb.leaveid}";
			var status=$(this).attr("data-status");
			var event=$("[name=event]").val();
			if(event==""){
				alert("请填写意见");
				return ;
			}
			$.post("/projectFour/api/leave/modifyStatus",{"status":status,"tbId":tbId,"event":event},function(res){
				if("yes"==res){
					alert("审批成功");
					location.href="/projectFour/ui/showLeave.html";
				}
			})
		})
	</script>
</body>

</html>