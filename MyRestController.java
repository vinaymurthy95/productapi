package com.agiliz.product.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agiliz.product.model.Product;
import com.agiliz.product.response.MyResponse;
import com.agiliz.product.service.MyService;

@RestController
public class MyRestController {
	@Autowired
	private MyService service;

	@Autowired
	private MyResponse response;

	@PostMapping("/add")
	public ResponseEntity<MyResponse> addProduct(@RequestBody Product pdto) {
		Product savePt = service.save(pdto);
		if (savePt != null) {
			response.setStatus(200);
			response.setMessage("product added successfully");
			response.setLiProducts(Arrays.asList(savePt));
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("failed to add may be duplicate");
			response.setLiProducts(null);
			return new ResponseEntity<MyResponse>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<MyResponse> getById(@PathVariable("id") int id) {
		Product getPt = service.getProduct(id);
		if (getPt != null) {
			response.setStatus(200);
			response.setMessage("product fetched successfully");
			response.setLiProducts(Arrays.asList(getPt));
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("not found");
			response.setLiProducts(null);
			return new ResponseEntity<MyResponse>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<MyResponse> UpdateProduct(@PathVariable("id") int id, @RequestBody Product pt) {
		Product updatePt = service.update(id, pt);
		if (updatePt != null) {
			response.setStatus(200);
			response.setMessage("product updated successfully");
			response.setLiProducts(Arrays.asList(updatePt));
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("not found");
			response.setLiProducts(null);
			return new ResponseEntity<MyResponse>(response, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MyResponse> deleteProduct(@PathVariable("id") int id) {
		Product getPt = service.delete(id);
		if (getPt != null) {
			response.setStatus(200);
			response.setMessage("product deleted successfully");
			response.setLiProducts(Arrays.asList(getPt));
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("not found");
			response.setLiProducts(null);
			return new ResponseEntity<MyResponse>(response, HttpStatus.NOT_FOUND);
		}
	}

}
