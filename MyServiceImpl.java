package com.agiliz.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiliz.product.model.Product;
import com.agiliz.product.repository.MyRepository;

@Service
public class MyServiceImpl implements MyService {
	@Autowired
	private MyRepository repo;

	@Override
	public Product save(Product pt) {
		List<Product> list = repo.findAll();
		if (list.contains(pt)) {
			return null;
		} else {
			return repo.save(pt);
		}
	}

	@Override
	public Product getProduct(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Product update(int id, Product pt) {
		Product updatePt = repo.findById(id).orElse(null);
		if (updatePt != null) {
			updatePt.setName(pt.getName());
			updatePt.setCategory(pt.getCategory());
			updatePt.setCompany(pt.getCompany());
			updatePt.setQuantity(pt.getQuantity());
			updatePt.setPrice(pt.getPrice());
			return repo.save(updatePt);
		}
		return null;
	}

	@Override
	public Product delete(int id) {
		Product deletePt = repo.findById(id).orElse(null);
		if (deletePt != null) {
			repo.delete(deletePt);
			return deletePt;
		}
		return null;
	}

}
