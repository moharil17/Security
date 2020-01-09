package com.spring.excelreportgeneration;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.spring.entities.Users;

public class GenerateExcelReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Users> UserList = (List<Users>) model.get("userList");
		Sheet sheet = workbook.createSheet("user_data");
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("UserId");
		 header.createCell(1).setCellValue("User Name");
		 header.createCell(2).setCellValue("User Email");
		 
		 int rowNum = 1;
		 for(Users user:UserList){
		 Row row = sheet.createRow(rowNum++);
		 row.createCell(0).setCellValue(user.getUserId());
		 row.createCell(1).setCellValue(user.getUserName());
		 row.createCell(2).setCellValue(user.getUserEmail());
		
	}
}
}