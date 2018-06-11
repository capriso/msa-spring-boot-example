package great.shine.product.domain.service.logic;

import java.util.NoSuchElementException;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Product;
import great.shine.product.domain.service.ProductService;
import great.shine.product.domain.service.vo.ProductCvo;
import great.shine.product.domain.store.ProductStore;
import great.shine.product.domain.store.ProductStoreFactory;

public class ProductServiceLogic implements ProductService {
	private ProductStore store;
	
	public ProductServiceLogic(ProductStoreFactory storeFactory) {
		this.store = storeFactory.requestProductStore();
	}

	@Override
	public String register(ProductCvo vo) {
		String name = vo.getName();
		if(store.existsByName(name)) {
			throw new IllegalArgumentException("Product name is duplicated: " + name);
		}
		
		Product entity = new Product(vo.getId(), name, vo.getCompany());
		store.create(entity);
		
		return entity.getEntityId();
	}

	@Override
	public Product find(String entityId) {
		Product entity = store.retrieve(entityId);
		if(entity == null) {
			throw new NoSuchElementException("Product entity ID: " + entity);
		}
		
		return entity;
	}

	@Override
	public void modify(String entityId, AttributeList attributes) {
		Product entity = find(entityId);
		entity.setValues(attributes);
		
		store.update(entity);
	}

	@Override
	public void remove(String entityId) {
		Product entity = find(entityId);
		
		store.delete(entity);
	}

}
