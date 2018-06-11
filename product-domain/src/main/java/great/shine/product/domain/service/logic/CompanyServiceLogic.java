package great.shine.product.domain.service.logic;

import java.util.NoSuchElementException;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Company;
import great.shine.product.domain.service.CompanyService;
import great.shine.product.domain.service.vo.CompanyCvo;
import great.shine.product.domain.store.CompanyStore;
import great.shine.product.domain.store.ProductStoreFactory;

public class CompanyServiceLogic implements CompanyService {
	private CompanyStore store;
	
	public CompanyServiceLogic(ProductStoreFactory storeFactory) {
		this.store = storeFactory.requestCompanyStore();
	}

	@Override
	public String register(CompanyCvo vo) {
		String name = vo.getName();
		if(store.existsByName(name)) {
			throw new IllegalArgumentException("Company name is duplicated: " + name);
		}
		
		Company entity = new Company(vo.getCode(), name);
		store.create(entity);
		
		return entity.getEntityId();
	}

	@Override
	public Company find(String entityId) {
		Company entity = store.retrieve(entityId);
		if(entity == null) {
			throw new NoSuchElementException("Company entity ID: " + entity);
		}
		
		return entity;
	}

	@Override
	public void modify(String entityId, AttributeList attributes) {
		Company entity = find(entityId);
		entity.setValues(attributes);
		
		store.update(entity);
	}

	@Override
	public void remove(String entityId) {
		Company entity = find(entityId);
		
		store.delete(entity);
	}

}
