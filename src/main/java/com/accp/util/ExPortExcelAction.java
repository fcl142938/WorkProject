package com.accp.util;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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
	private String startDate;
	private String endDate;
	private String dateType;
	private String orgType;

	public static void main(String[] args) {
		ExPortExcelAction exExcel = new ExPortExcelAction();
		exExcel.setDateType("orgType");
		exExcel.setDateType("mothly");
		exExcel.reprotExcel();
		System.out.println("O.K.");
	}

	public void reprotExcel() {
		List<String[]> pageDataList = null;

		String fileName = "报销统计";
		if ("dept".equals(orgType)) {
			if ("mothly".equals(dateType)) {
				fileName = "2013年08月业务一部月度报销统计";
				pageDataList = getDataListByDeptMothly();
			} else {
				fileName = "2013年业务一部年度报销统计";
				pageDataList = getDataListByDeptYear();
			}
		} else {
			if ("mothly".equals(dateType)) {
				fileName = "2013年08月公司月度";
				pageDataList = getDataListByCompanyMothly();
			} else {
				fileName = "2013年公司年度";
				pageDataList = getDataListByCompanyYear();
			}
		}
		/*
		 * if(null!= getLoginEmployee()){ fileName =
		 * getLoginEmployee().getDept().getName()+fileName; }
		 * if(Util.isNotEmpty(startDate)){ fileName = startDate+fileName; }
		 */
		try {
			WritableWorkbook wbook = Workbook
					.createWorkbook(new FileOutputStream(fileName + ".xls")); // 建立excel文件
			WritableSheet wsheet = wbook.createSheet("导出数据", 0); // sheet名称
			WritableCellFormat cellFormatNumber = new WritableCellFormat();
			cellFormatNumber.setAlignment(Alignment.RIGHT);

			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK); // 定义格式、字体、粗体、斜体、下划线、颜色
			WritableCellFormat wcf = new WritableCellFormat(wf); // title单元格定义
			WritableCellFormat wcfc = new WritableCellFormat(); // 一般单元格定义
			WritableCellFormat wcfe = new WritableCellFormat(); // 一般单元格定义
			wcf.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
			wcfc.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式

			wcf.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfc.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfe.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);

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
				wsheet.mergeCells(0, rowIndex, "mothly".equals(dateType) ? 5
						: 4, rowIndex);// 合并标题所占单元格
				rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 380);// 设置项目名行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, "编号", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销人", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销总额", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "年份", wcf));
				if ("mothly".equals(dateType)) {
					wsheet.addCell(new Label(columnIndex++, rowIndex, "月份", wcf));
				}
				wsheet.addCell(new Label(columnIndex++, rowIndex, "部门", wcf));
				// 开始行循环
				for (String[] array : pageDataList) { // 循环列
					rowIndex++;
					columnIndex = 0;
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[0],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[1],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[2],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[3],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[4],
							wcfe));
					if ("mothly".equals(dateType)) {
						wsheet.addCell(new Label(columnIndex++, rowIndex,
								array[5], wcfe));
					}
				}

				rowIndex++;
				columnIndex = 0;
			}
			
			//文件写入
			wbook.write();
			if (wbook != null) {
				wbook.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<String[]> getDataListByDeptMothly() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "1035", "董平", "10906.00", "2013年", "08月",
				"业务一部" });
		list.add(new String[] { "1024", "吕艳超", "5394.00", "2013年", "08月",
				"业务一部" });
		list.add(new String[] { "1013", "尚鸿运", "906.00", "2013年", "08月", "业务一部" });
		list.add(new String[] { "1005", "夏菲", "218.00", "2013年", "08月", "业务一部" });
		list.add(new String[] { "1002", "马克", "713.00", "2013年", "08月", "业务一部" });

		return list;
	}

	public List<String[]> getDataListByDeptYear() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "1035", "董平", "39860.00", "2013年", "业务一部" });
		list.add(new String[] { "1024", "吕艳超", "14593.00", "2013年", "业务一部" });
		list.add(new String[] { "1013", "尚鸿运", "19167.00", "2013年", "业务一部" });
		list.add(new String[] { "1005", "夏菲", "20841.00", "2013年", "业务一部" });
		list.add(new String[] { "1002", "马克", "17013.00", "2013年", "业务一部" });

		return list;
	}

	public List<String[]> getDataListByCompanyMothly() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "1035", "业务一部", "10906.00", "2013年", "08月",
				"业务一部" });
		list.add(new String[] { "1024", "业务二部", "5394.00", "2013年", "08月",
				"业务一部" });
		list.add(new String[] { "1013", "财务部", "906.00", "2013年", "08月", "业务一部" });
		list.add(new String[] { "1005", "平台研发部", "218.00", "2013年", "08月",
				"业务一部" });

		return list;
	}

	public List<String[]> getDataListByCompanyYear() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "1035", "业务一部", "10906.00", "2013年", "业务一部" });
		list.add(new String[] { "1024", "业务二部", "5394.00", "2013年", "业务一部" });
		list.add(new String[] { "1013", "财务部", "906.00", "2013年", "业务一部" });
		list.add(new String[] { "1005", "平台研发部", "218.00", "2013年", "业务一部" });

		return list;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}
