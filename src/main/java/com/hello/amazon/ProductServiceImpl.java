package com.hello.amazon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Optional<EProduct> getProductById(Long id) {
		return  Optional.of(productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found with the id: "+id))) ;
	}

	@Override
	public List<EProduct> getAllProducts() {
		return productRepo.findAll() ;
	}

	@Override
		public EProduct deleteProductById(Long id) {
		    EProduct product = productRepo.findById(id)
		            .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
		    
		    productRepo.deleteById(id);
		    return product;
	}
	
	@Override
	public EProduct updateProductById(Long id, EProduct product) {
	    return productRepo.findById(id)
	        .map(existingProduct -> {
	            existingProduct.setPname(product.getPname());
	            existingProduct.setPrice(product.getPrice());
	            existingProduct.setDescription(product.getDescription());
	            existingProduct.setCategory(product.getCategory());
	            existingProduct.setImageUrl(product.getImageUrl());
	            return productRepo.save(existingProduct);
	        })
	        .orElseThrow(() -> new ProductNotFoundException("Product not found with the ID: " + product.getId()));
	}

	@Override
	public EProduct saveCreateProduct(EProduct product) {
		return productRepo.save(product);
	}
	
	
	}


