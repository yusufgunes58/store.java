package com.project.store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Product;
import com.project.store.Repository.CategoryRepository;
import com.project.store.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRep;

	@Autowired
	CategoryRepository categoryRep;

	public List<Product> showAllProducts() {
		return productRep.findAll();
	}

	public List<Product> findByCategoryName(String name) {
	    return productRep.findByCategoryName(name);
	}

	public String addProduct(Product product) {
		productRep.save(product);
		return "Product saved!";
	}

	public String updateProduct(Long id, Product newProduct) {
	    Optional<Product> opt = productRep.findById(id);

	    if (opt.isEmpty()) {
	        return "Product not found";
	    }

	    Product p = opt.get();
	    p.setName(newProduct.getName());
	    p.setPrice(newProduct.getPrice());
	    p.setStock(newProduct.getStock());
	    p.setCategory(categoryRep.findById(
	        newProduct.getCategory().getId()).get()
	    );

	    productRep.save(p);
	    return "Product updated";
	}

	public String deleteProduct(Long id) {
		productRep.deleteById(id);
		return "Product deleted!";
	}

}
