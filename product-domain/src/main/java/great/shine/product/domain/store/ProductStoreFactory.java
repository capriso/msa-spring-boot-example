package great.shine.product.domain.store;

public interface ProductStoreFactory {
	ProductStore requestProductStore();
	CompanyStore requestCompanyStore();
}
