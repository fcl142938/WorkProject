package com.accp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.accp.biz.TbcountBiz;
import com.accp.pojo.Tbcount;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExPortExcelAction {

	private Integer year;
	private Integer month;
	private Integer departmentId;
	private Integer status;
	private String oftype;//确定部门公司
	private	List<Tbcount> pageDataList = new ArrayList<Tbcount>(0);


	public static void main(String[] args) {
		ExPortExcelAction exExcel = new ExPortExcelAction();
		// exExcel.setOrgType("orgType");
		// exExcel.setDateType("mothly");
		exExcel.reprotExcel();
		System.out.println("O.K.");
	}

	public void reprotExcel() {
		String fileName = "";
		// 年
		if (status != null) {
			if (oftype != null) {
				fileName = year+"年"+oftype+"年度报销统计";
			} else {
				fileName = year+"年公司年度报销统计";
			}
		} else {
			if (oftype != null) {
				fileName = month+"月"+oftype+"月度报销统计";
			} else {
				fileName = month+"月公司月度报销统计";
			}
		}
		
		try {
			WritableWorkbook wbook = Workbook.createWorkbook(new FileOutputStream("C:\\\\Users\\\\ASUS\\\\Desktop\\"+fileName + ".xls")); // 建立excel文件
			WritableSheet wsheet = wbook.createSheet("导出数据", 0); // sheet名称
			WritableCellFormat cellFormatNumber = new WritableCellFormat();
			cellFormatNumber.setAlignment(Alignment.RIGHT);

			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK); // 定义格式、字体、粗体、斜体、下划线、颜色
			WritableCellFormat wcf = new WritableCellFormat(wf); // title单元格定义
			WritableCellFormat wcfc = new WritableCellFormat(); // 一般单元格定义
			WritableCellFormat wcfe = new WritableCellFormat(); // 一般单元格定义
			wcf.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
			wcfc.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式

			wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcfc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcfe.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

			wsheet.setColumnView(0, 20);// 设置列宽
			wsheet.setColumnView(1, 10);
			wsheet.setColumnView(2, 20);

			int rowIndex = 0;
			int columnIndex = 0;
			if (null != pageDataList) {
				// rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 500);// 设置标题行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, fileName, wcf));
				wsheet.mergeCells(0, rowIndex,status == null ? 5 : 4, rowIndex);// 合并标题所占单元格
				rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 380);// 设置项目名行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, "编号", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销人", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销总额", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "年份", wcf));
				if (status == null) {
					wsheet.addCell(new Label(columnIndex++, rowIndex, "月份", wcf));
				}
				wsheet.addCell(new Label(columnIndex++, rowIndex, "部门", wcf));
				// 开始行循环
				for (Tbcount tbc : pageDataList) { // 循环列
					rowIndex++;
					columnIndex = 0;
					wsheet.addCell(new Label(columnIndex++, rowIndex,tbc.getCountid().toString(), wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, tbc.getEmployeename(), wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, tbc.getMoney().toString(), wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, tbc.getYear()+"年", wcfe));	
					if (status == null) {
						wsheet.addCell(new Label(columnIndex++, rowIndex, tbc.getMonth()+"月", wcfe));
					}
					wsheet.addCell(new Label(columnIndex++, rowIndex,tbc.getDepartmentname() , wcfe));
				}

				rowIndex++;
				columnIndex = 0;
			}

			// 文件写入
			wbook.write();
			if (wbook != null) {
				wbook.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ExPortExcelAction() {
		// TODO Auto-generated constructor stub
	}

	public ExPortExcelAction(Integer year, Integer month, Integer departmentId, Integer status,String oftype,List<Tbcount> pageDataList) {
		super();
		this.year = year;
		this.month = month;
		this.departmentId = departmentId;
		this.status = status;
		this.oftype=oftype;
		this.pageDataList=pageDataList;
	}

}
