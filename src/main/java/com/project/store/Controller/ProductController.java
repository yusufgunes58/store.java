package com.project.store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.Product;
import com.project.store.Service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productSer;

	@GetMapping
	public List<Product> showAllProducts() {
		return productSer.showAllProducts();
	}

	@GetMapping("/category/{name}")
	public List<Product> findByCategoryName(@PathVariable String name) {
		return productSer.findByCategoryName(name);
	}

	@PostMapping("/new")
	public String addProduct(@RequestBody Product product) {
		return productSer.addProduct(product);
	}

	@PostMapping("update/{id}")
	public String updateProduct(@PathVariable Long id,
	                            @RequestBody Product product) {
	    return productSer.updateProduct(id, product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
         return productSer.deleteProduct(id);
	}
}
