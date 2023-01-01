package net.risingdev.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.risingdev.springboot.entity.Product;
import net.risingdev.springboot.helper.Helper;
import net.risingdev.springboot.service.ExcelService;
@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload 
	(@RequestParam("file") MultipartFile file) {
		
		if(Helper.checkExcelContentType(file)) {
			this.excelService.save(file);
			return ResponseEntity.ok(
					Map.of("message", 
							"File is uploaded and data is saved"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel format only");
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return this.excelService.getAllProducts();
	}
}
