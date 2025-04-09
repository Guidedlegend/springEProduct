package com.hello.amazon;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	
	public EProduct saveCreateProduct(EProduct product);
	
	public Optional<EProduct> getProductById(Long id);
	
	public List<EProduct> getAllProducts();
	
	public EProduct deleteProductById(Long id);
	
	public EProduct updateProductById(Long id, EProduct product);
	

}
