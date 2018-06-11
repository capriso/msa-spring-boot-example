package great.shine.product.domain.store.memory;

import java.util.HashMap;
import java.util.Map;

import great.shine.product.domain.entity.Company;
import great.shine.product.domain.store.CompanyStore;

public class CompanyMemoryStore implements CompanyStore {
	private Map<String, Company> store;
	
	public CompanyMemoryStore() {
		this.store = new HashMap<>();
	}

	@Override
	public void create(Company entity) {
		this.store.put(entity.getEntityId(), entity);
	}

	@Override
	public Company retrieve(String entityId) {
		return this.store.get(entityId);
	}

	@Override
	public void update(Company entity) {
		// nothing to do for memory store
	}

	@Override
	public void delete(Company entity) {
		this.store.remove(entity.getEntityId());
	}

	@Override
	public boolean exists(String entityId) {
		return this.store.get(entityId) != null;
	}

	@Override
	public boolean existsByName(String name) {
		if(name == null)	return false;
		
		for(Company entity : store.values()) {
			if(name.equals(entity.getName())) {
				return true;
			}
		}
		
		return false;
	}

}
