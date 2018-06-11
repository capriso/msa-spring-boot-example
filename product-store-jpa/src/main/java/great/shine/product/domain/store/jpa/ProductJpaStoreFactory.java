package great.shine.product.domain.store.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import great.shine.product.domain.store.CompanyStore;
import great.shine.product.domain.store.ProductStore;
import great.shine.product.domain.store.ProductStoreFactory;

@Component
public class ProductJpaStoreFactory implements ProductStoreFactory {
	@Autowired
	private ProductStore productStore;
	
	@Autowired
	private CompanyStore companyStore;

	@Override
	public ProductStore requestProductStore() {
		return productStore;
	}

	@Override
	public CompanyStore requestCompanyStore() {
		return companyStore;
	}

}
