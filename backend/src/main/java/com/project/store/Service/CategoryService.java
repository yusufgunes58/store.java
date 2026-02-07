package com.project.store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.Entity.Category;
import com.project.store.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRep;

	public List<Category> showAllCategories() {
		return categoryRep.findAll();
	}

	public Optional<Category> showCategoryById(Long id) {
		return categoryRep.findById(id);
	}

	public String addCategory(Category category) {
		categoryRep.save(category);
		return "Category saved!";
	}

	public String updateCategoryName(Long id, String name) {
		Category cat = categoryRep.findById(id).get();
		String tempName = cat.getName();
		cat.setName(name);

		categoryRep.save(cat);
		return "Category saved!" + tempName + "New name: " + name;
	}
	
	public String deleteCategory(Long id) {
	    categoryRep.deleteById(id);
	    return "Category deleted!";
	}

}
