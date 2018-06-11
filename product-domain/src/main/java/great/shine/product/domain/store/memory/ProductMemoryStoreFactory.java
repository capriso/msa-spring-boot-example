package great.shine.product.domain.store.memory;

import great.shine.product.domain.store.CompanyStore;
import great.shine.product.domain.store.ProductStore;
import great.shine.product.domain.store.ProductStoreFactory;

public class ProductMemoryStoreFactory implements ProductStoreFactory {

	@Override
	public ProductStore requestProductStore() {
		return new ProductMemoryStore();
	}

	@Override
	public CompanyStore requestCompanyStore() {
		return new CompanyMemoryStore();
	}

}
