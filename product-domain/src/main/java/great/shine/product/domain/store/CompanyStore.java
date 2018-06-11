package great.shine.product.domain.store;

import great.shine.common.domain.store.BaseStore;
import great.shine.product.domain.entity.Company;

public interface CompanyStore extends BaseStore<Company> {
	boolean existsByName(String name);
}
