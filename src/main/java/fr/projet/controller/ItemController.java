package fr.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.CategoryType;
import fr.projet.domain.Product;
import fr.projet.domain.ProductType;
import fr.projet.domain.criteria.ItemCriteria;
import fr.projet.domain.criteria.StockLevelType;
import fr.projet.exception.BadRequestException;
import fr.projet.services.ItemService;

@RestController
@RequestMapping("/products")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product user) throws BadRequestException {
		return itemService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return itemService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Product findOneByLogin(@PathVariable String login) {
		return itemService.findOneByLogin(login);
	}
	@RequestMapping(value = "/name/{login}", method = RequestMethod.GET)
	public List<Product>  findByName(@PathVariable String name) {
		return itemService.findByName(name);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return itemService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product update(@PathVariable Long id, 
			@RequestBody Product user) {
		user.setId(id);
		return itemService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Product delete(@PathVariable Long id) {
		return itemService.delete(id);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) String supplier,
			@RequestParam(required = false) String stockLevel,
			@RequestParam(required = false) Integer retailPriceMin,
			@RequestParam(required = false) Integer retailPriceMax,
			@RequestParam(required = false) String productType,
			@RequestParam(required = false) String categoryType

			) {
		
		StockLevelType stockLevelType = stockLevel != null ? StockLevelType.valueOf(stockLevel) : null;
		ProductType product = productType != null ? ProductType.valueOf(productType) : null;
		CategoryType category = categoryType != null ? CategoryType.valueOf(categoryType) : null;

		
		ItemCriteria criteria = new ItemCriteria(name, supplier, retailPriceMin, retailPriceMax, stockLevelType, product, category);
		
		return itemService.search(criteria);
	}

}
