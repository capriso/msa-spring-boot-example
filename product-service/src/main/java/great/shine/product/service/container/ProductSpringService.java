package great.shine.product.service.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import great.shine.product.domain.service.logic.ProductServiceLogic;
import great.shine.product.domain.store.ProductStoreFactory;

@Component
public class ProductSpringService extends ProductServiceLogic {

	@Autowired
	public ProductSpringService(ProductStoreFactory storeFactory) {
		super(storeFactory);
	}

}
