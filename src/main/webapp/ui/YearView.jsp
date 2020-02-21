<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="action  divaction">
		<div class="t">年度统计详情</div>
		<div class="pages">
			<form id="compYearStatistics_getDetailExcel_action" name="queryForm"
				action="../jboa/statistics/yearExcel"
				method="get">
				<label for="time">年份:</label> ${year }  <input type="hidden"
					name="currYear" value="${year }"
					id="compYearStatistics_getDetailExcel_action_currYear"> <input
					type="submit" id="compYearStatistics_getDetailExcel_action_0"
					value="导出报表" class="submit_01">
			</form>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					
						<tr class="even">
							<td>员工编号</td>
							<td>姓名</td>
							<td>报销总额</td>
							<td>年份</td>
						</tr>					
				</thead>
				<tbody>
					
						<c:forEach items="${List }" var="tb">
						<tr>
							<td>${tb.employeeid }</td>
							<td>${tb.employeename}</td>
							<td>￥${tb.money }</td>
							<td>${tb.year }年</td>
						</tr>
					</c:forEach>	
					<tr>
						<td></td>
						<td bgcolor="yellow">总计</td>
						<td bgcolor="yellow">￥224.0</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>


				</tbody>
			</table>
		</div>
	</div>
		<div id="echartsDom" style='width:702px;heigth:400px;background:#fff;clear: both;padding-top: 20px;padding-left: 40px;'>
		
	</div>
	<div style="width:542px;background:#fff;padding-left: 200px;">
		<input type="button" class="submit_01" value="查看柱状图" onclick="initEcharts('bar')"/>
		<input type="button" class="submit_01" value="查看饼图" onclick="initEcharts('pie')"/>
		<input type="button" class="submit_01" value="查看曲线图" onclick="initEcharts('line')"/>
	</div>

</body>
<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/echarts.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function(){
		initEcharts('pie');
	});
	
	function initEcharts(type){
		var data = [];
		var departmentName = '';
		$.each(${data},function(i,obj){
			var arr={"name":obj.employeename,"money":obj.money,};
			departmentName=obj.departmentname;
			data.push(arr);
		})
		var xAxis = new Array();
		var legend = new Array(); 
		for(var i=0;i<data.length;i++){
			xAxis[i] = data[i].name;
			legend[i] = data[i].money;
		}
		var year = ${year};
		var option = null;
		if(type=='bar'){
			option = {
			    title: {
			    	text: year+'年'+departmentName+'月度报销统计图'
			    },
			    tooltip: {},
			    legend: {
			        data:['报销金额']
			    },
			    xAxis: {
			        data: xAxis
			    },
			    yAxis: {},
			    series: [{
			        name: '报销金额',
			        type: 'bar',
			        barWidth : 30,
			        data: legend
			    }]
			};
		}else if(type=="pie"){
			option = {
			    title: {
			    	text: year+'年'+departmentName+'月度报销统计图'
			    },
			    tooltip: {},
			    series: [{
			        name: '报销金额',
			        type: 'pie',
			        radius:'60%',
			        label : {
			        	normal : {
			        		formatter: '{b}: ({d}%)',
			        		textStyle : {
				        		fontWeight : 'normal',
				        		fontSize : 15
			        		}
			        	}
			        }
			    }],
			    dataset:{
			    	source:data
			    }
			};
		}else{
			option = {
			    title: {
			    	text: year+'年'+departmentName+'月度报销统计图'
			    },
			    tooltip: {},
			    legend: {
			        data:['报销金额']
			    },
			    xAxis: {
			        data: xAxis
			    },
			    yAxis: {},
			    series: [{
			        name: '报销金额',
			        type: 'line',
			        barWidth : 30,
			        data: legend
			    }]
			};
		}
		var dom = document.getElementById('echartsDom');
		$("#echartsDom").height('400px');
		var myChart = echarts.init(dom);
		if (myChart != null && myChart != "" && myChart != undefined) {//关键
	        myChart.dispose();
	    }
		var myChart = echarts.init(dom);
		myChart.setOption(option);
	}
</script>
</html>