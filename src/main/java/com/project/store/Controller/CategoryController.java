package com.project.store.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Entity.Category;
import com.project.store.Service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("category")
public class CategoryController {

	@Autowired
	CategoryService categorySer;

	@GetMapping
	public List<Category> showAllCategories() {
		return categorySer.showAllCategories();
	}

	@GetMapping("/{id}")
	public Optional<Category> showCategoryById(@PathVariable Long id) {
		return categorySer.showCategoryById(id);
	}

	@PostMapping("/add")
	public String addCategory(@RequestBody Category category) {
		return categorySer.addCategory(category);
	}

	@PutMapping("/{id}")
	public String updateCategoryName(@PathVariable Long id, @RequestParam String name) {
		return categorySer.updateCategoryName(id, name);
	}

	@DeleteMapping("delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categorySer.deleteCategory(id);
		return "Category deleted";
	}

}
