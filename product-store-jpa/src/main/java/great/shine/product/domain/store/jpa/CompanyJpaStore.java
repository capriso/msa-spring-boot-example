package great.shine.product.domain.store.jpa;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import great.shine.product.domain.entity.Company;
import great.shine.product.domain.store.CompanyStore;
import great.shine.product.domain.store.jpa.jpo.CompanyJpo;
import great.shine.product.domain.store.jpa.repository.CompanyRepository;

@Component
public class CompanyJpaStore implements CompanyStore {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public void create(Company entity) {
		String name = entity.getName();
		if(companyRepository.existsByName(name)) {
			throw new IllegalArgumentException("Company name is duplicated: " + name);
		}
		CompanyJpo jpo = new CompanyJpo(entity);
		
		companyRepository.save(jpo);
	}

	@Override
	public Company retrieve(String entityId) {
		Optional<CompanyJpo> optionalJpo = companyRepository.findById(entityId);
		CompanyJpo jpo = optionalJpo.get();
		
		return jpo.toDomain();
	}

	@Override
	public void update(Company entity) {
		CompanyJpo sourceJpo = new CompanyJpo(entity);
		CompanyJpo targetJpo = companyRepository.findById(entity.getEntityId())
				.orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(sourceJpo, targetJpo, "entityId");
		companyRepository.save(targetJpo);
	}

	@Override
	public void delete(Company entity) {
		companyRepository.deleteById(entity.getEntityId());
	}

	@Override
	public boolean exists(String entityId) {
		return companyRepository.existsById(entityId);
	}

	@Override
	public boolean existsByName(String name) {
		return companyRepository.existsByName(name);
	}

}
