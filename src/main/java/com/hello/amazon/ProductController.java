package com.hello.amazon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	/// this i will push to git lets see

	@GetMapping("/findProductById/{id}")
	public ResponseEntity<EProduct> findProductById(@PathVariable Long id) {
		EProduct product = productService.getProductById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
		return ResponseEntity.ok(product);
	}

	@PutMapping("/updateProductById/{id}")
	public ResponseEntity<EProduct> updateProductById(@PathVariable Long id, @Valid @RequestBody EProduct product) {
		if (product != null) {
			EProduct updateProductById = productService.updateProductById(id, product);
			return ResponseEntity.status(201).body(updateProductById);
		}
		return null;
	}

	@PostMapping("/addSaveProduct")
	public ResponseEntity<EProduct> addSaveProduct(@RequestBody EProduct product) {
		
		EProduct eproduct = productService.saveCreateProduct(product);
		return ResponseEntity.status(201).body(eproduct);
	}

	@DeleteMapping("/deleteProductByID/{id}")
	public ResponseEntity<DeleteProductResponseDTO> deleteProductByGivenID(@PathVariable Long id) {
		EProduct deletedProduct = productService.deleteProductById(id);
		DeleteProductResponseDTO response = new DeleteProductResponseDTO(
				"Successfully deleted product with the id: " + id, deletedProduct);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/allProductsInDB") // Use GET for fetching data, not POST
	public ResponseEntity<List<EProduct>> getAllProducts() {
		List<EProduct> allProducts = productService.getAllProducts();
		return ResponseEntity.ok(allProducts);
	}

}
