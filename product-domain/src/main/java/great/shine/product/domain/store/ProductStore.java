package great.shine.product.domain.store;

import great.shine.common.domain.store.BaseStore;
import great.shine.product.domain.entity.Product;

public interface ProductStore extends BaseStore<Product> {
	boolean existsByName(String name);
}
