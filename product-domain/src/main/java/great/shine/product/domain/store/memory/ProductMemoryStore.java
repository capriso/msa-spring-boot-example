package great.shine.product.domain.store.memory;

import java.util.HashMap;
import java.util.Map;

import great.shine.product.domain.entity.Product;
import great.shine.product.domain.store.ProductStore;

public class ProductMemoryStore implements ProductStore {
	private Map<String, Product> store;
	
	public ProductMemoryStore() {
		this.store = new HashMap<>();
	}

	@Override
	public void create(Product entity) {
		this.store.put(entity.getEntityId(), entity);
	}

	@Override
	public Product retrieve(String entityId) {
		return this.store.get(entityId);
	}

	@Override
	public void update(Product entity) {
		// nothing to do for memory store
	}

	@Override
	public void delete(Product entity) {
		this.store.remove(entity.getEntityId());
	}

	@Override
	public boolean exists(String entityId) {
		return this.store.get(entityId) != null;
	}

	@Override
	public boolean existsByName(String name) {
		if(name == null)	return false;
		
		for(Product entity : store.values()) {
			if(name.equals(entity.getName())) {
				return true;
			}
		}
		
		return false;
	}

}
