package great.shine.product.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Product;
import great.shine.product.domain.service.ProductService;
import great.shine.product.domain.service.vo.ProductCvo;
import great.shine.product.service.container.ProductSpringService;

@RestController
@RequestMapping("/product")
public class ProductResource implements ProductService {

	@Autowired
	private ProductSpringService productSpringService;
	
	public ProductResource() {
		
	}
	
	@PostMapping("/")
	@Override
	public String register(@RequestBody ProductCvo vo) {
		return productSpringService.register(vo);
	}

	@GetMapping("/{entityId}")
	@Override
	public Product find(@PathVariable String entityId) {
		return productSpringService.find(entityId);
	}

	@PutMapping("/{entityId}")
	@Override
	public void modify(@PathVariable String entityId, @RequestBody AttributeList attributes) {
		productSpringService.modify(entityId, attributes);
	}

	@DeleteMapping("/{entityId}")
	@Override
	public void remove(@PathVariable String entityId) {
		productSpringService.remove(entityId);
	}

}
