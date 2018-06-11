package great.shine.product.domain.store.jpa.jpo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import great.shine.common.util.json.JsonSerializable;
import great.shine.product.domain.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CompanyJpo implements JsonSerializable {
	@Id
	private String entityId;
	private String code;
	private String name;
	private long created;
	
	public CompanyJpo(Company entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
	public Company toDomain() {
		Company entity = new Company(this.entityId);
		BeanUtils.copyProperties(this, entity, "entityId");
		return entity;
	}
	
	public static CompanyJpo sample() {
		return new CompanyJpo(Company.sample());
	}
}
