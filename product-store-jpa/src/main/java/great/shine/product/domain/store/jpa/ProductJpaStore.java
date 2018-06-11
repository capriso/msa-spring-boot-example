package great.shine.product.domain.store.jpa;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import great.shine.product.domain.entity.Product;
import great.shine.product.domain.store.ProductStore;
import great.shine.product.domain.store.jpa.jpo.ProductJpo;
import great.shine.product.domain.store.jpa.repository.ProductRepository;

@Component
public class ProductJpaStore implements ProductStore {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void create(Product entity) {
		String name = entity.getName();
		if(productRepository.existsByName(name)) {
			throw new IllegalArgumentException("Product name is duplicated: " + name);
		}
		ProductJpo jpo = new ProductJpo(entity);
		
		productRepository.save(jpo);
	}

	@Override
	public Product retrieve(String entityId) {
		Optional<ProductJpo> optionalJpo = productRepository.findById(entityId);
		ProductJpo jpo = optionalJpo.get();
		
		return jpo.toDomain();
	}

	@Override
	public void update(Product entity) {
		ProductJpo sourceJpo = new ProductJpo(entity);
		ProductJpo targetJpo = productRepository.findById(entity.getEntityId())
				.orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(sourceJpo, targetJpo, "entityId");
		productRepository.save(targetJpo);
	}

	@Override
	public void delete(Product entity) {
		productRepository.deleteById(entity.getEntityId());
	}

	@Override
	public boolean exists(String entityId) {
		return productRepository.existsById(entityId);
	}

	@Override
	public boolean existsByName(String name) {
		return productRepository.existsByName(name);
	}

}
