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
import fr.projet.domain.criteria.ProductCriteria;
import fr.projet.domain.criteria.StockLevelType;
import fr.projet.exception.BadRequestException;
import fr.projet.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService itemService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product user) {//throws BadRequestException {
		try {
			return itemService.save(user);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return itemService.find(id);
	}


	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public List<Product> findByName(@PathVariable String name) {
		return itemService.findByName(name);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return itemService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		return itemService.update(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Product delete(@PathVariable Long id) {
		return itemService.delete(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String supplier, @RequestParam(required = false) String stockLevelType,
			@RequestParam(required = false) Integer retailPriceMin,
			@RequestParam(required = false) Integer retailPriceMax, @RequestParam(required = false) String productType,
			@RequestParam(required = false) String categoryType, @RequestParam(required = false) String reference

	) {

			StockLevelType stockLevel = stockLevelType != null ? StockLevelType.valueOf(stockLevelType) : null;
			ProductType product = productType != null ? ProductType.valueOf(productType) : null;
			CategoryType category = categoryType != null ? CategoryType.valueOf(categoryType) : null;

			ProductCriteria criteria = new ProductCriteria(id, name, supplier, retailPriceMin, retailPriceMax, stockLevel,
					product, category, reference);

			return itemService.search(criteria);
			

	}
}
