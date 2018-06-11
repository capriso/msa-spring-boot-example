package great.shine.product.domain.store.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import great.shine.product.domain.store.jpa.jpo.ProductJpo;

@Repository
public interface ProductRepository extends CrudRepository<ProductJpo, String> {
	boolean existsByName(String name);
}
