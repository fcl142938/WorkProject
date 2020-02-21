<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>北大青鸟办公自动化管理系统
</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<style>
.img {
	width: 40px;     
	height: 40px;
	cursor: pointer;
}

.weight {
	font-weight: bold;
}
</style>
</head>
<body>
	<form id="myForm" name="myForm" method="post">
		<div class="action  divaction">
			<div class="t">查看报销单</div>
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
							<td>总金额：${tbr.totalcount}</td>
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
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tbr.reList }" var="re">
							<tr>
								<td><span>${re.desc}</span></td>
								<td><span>${re.subtotal}</span></td>
								<td><img class="img" src="/img_server/${re.picturepath }"></td>
							</tr>
						</c:forEach>
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
						<tr>
							<td>*事由：</td>
							<td colspan="3"><textarea name="event" cols="66" rows="5"
									id="event" readonly="readonly">${tbr.event }</textarea></td>
						</tr>
					</tbody>
				</table>
				<p>&nbsp;</p>

				<p>&nbsp;</p>
				<p>
					<input type="button" value="返回" onclick="window.history.go(-1)"
						class="submit_01">
				</p>
				<!--增加报销单 区域 结束-->
			</div>
		</div>
	</form>
</body>
</html>