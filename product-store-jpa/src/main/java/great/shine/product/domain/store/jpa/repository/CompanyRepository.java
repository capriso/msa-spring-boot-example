package great.shine.product.domain.store.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import great.shine.product.domain.store.jpa.jpo.CompanyJpo;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyJpo, String> {
	boolean existsByName(String name);
}
