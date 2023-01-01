package net.risingdev.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.risingdev.springboot.repo.ProductRepo;
import net.risingdev.springboot.entity.Product;
import net.risingdev.springboot.helper.Helper;

@Service
public class ExcelService {

	@Autowired
	private ProductRepo productRepo;
	
	public void save(MultipartFile file) {
	
		try {
		  List<Product> products = Helper.convertExcelToListOfProducts(file.getInputStream());
		  this.productRepo.saveAll(products);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	
	public List<Product> getAllProducts(){
		
		return this.productRepo.findAll();
		
	}
	
}
