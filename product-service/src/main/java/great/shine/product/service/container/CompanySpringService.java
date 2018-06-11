package great.shine.product.service.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import great.shine.product.domain.service.logic.CompanyServiceLogic;
import great.shine.product.domain.store.ProductStoreFactory;

@Component
public class CompanySpringService extends CompanyServiceLogic {

	@Autowired
	public CompanySpringService(ProductStoreFactory storeFactory) {
		super(storeFactory);
	}

}
