package com.adgile.controller;

import io.swagger.annotations.ApiOperation;
import com.adgile.util.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/excel")
public class ExcelController {

	@ApiOperation(value = "엑셀 업로드")
	@PostMapping("")
	public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		System.out.println("-------------- test");


		Workbook workbook = null;

		workbook = new XSSFWorkbook(file.getInputStream());

		Sheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			Row row = worksheet.getRow(i);
//			log.info("row == {}", row);
			Object data = new Object();

			log.info("row get 0 = {}", row.getCell(0));
			log.info("row get 1 = {}", row.getCell(1));
			log.info("row get 2 = {}", row.getCell(2));
			log.info("row get 3 = {}", row.getCell(3));

		}

		return "test";
	}
}
