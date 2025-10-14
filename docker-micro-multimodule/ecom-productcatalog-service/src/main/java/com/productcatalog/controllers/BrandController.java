package com.productcatalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.exceptions.BrandNotFoundException;
import com.productcatalog.model.BrandDto;
import com.productcatalog.service.IBrandService;




@RestController
@RequestMapping("/catalog-service/v1")
@RefreshScope
public class BrandController {
	@Autowired
	private IBrandService brandService;
	


	//http://localhost:8084/catalog-service/v1/brands
	@PostMapping("/brands")
	ResponseEntity<Void> addBrand(@RequestBody BrandDto brandDto){
		brandService.addBrand(brandDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//http://localhost:8084/catalog-service/v1/brands
	@PutMapping("/brands")
	ResponseEntity<Void> updateBrand(@RequestBody BrandDto brandDto){
		brandService.updateBrand(brandDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "updating one Brand");
		headers.add("desc","update method called");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}
	
	
	
	//http://localhost:8084/catalog-service/v1/brands/brandId/2
	@DeleteMapping("/brands/brandId/{brandId}")
	ResponseEntity<Void> deleteBrand(@PathVariable int brandId){
		brandService.deleteBrand(brandId);
		HttpHeaders headers =new HttpHeaders();
		headers.add("info", "delete one Brand by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	}
	
	//http://localhost:8084/catalog-service/v1/brands/brandId/1
	@GetMapping("/brands/brandId/{brandId}")
	ResponseEntity<BrandDto> getById(@PathVariable int brandId) throws BrandNotFoundException{
		BrandDto brandDto=	brandService.getById(brandId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "getting one Brands by id ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(brandDto);
	}

}
