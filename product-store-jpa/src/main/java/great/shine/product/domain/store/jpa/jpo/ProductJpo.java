package great.shine.product.domain.store.jpa.jpo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import great.shine.common.util.json.JsonSerializable;
import great.shine.product.domain.entity.Company;
import great.shine.product.domain.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductJpo implements JsonSerializable {
	@Id
	private String entityId;
	private String id;
	private String name;
	private String companyJson;
	
	public ProductJpo(Product product) {
		BeanUtils.copyProperties(product, this);
		this.companyJson = product.getCompany().toJson();
	}
	
	public Product toDomain() {
		Product product = new Product(this.entityId);
		BeanUtils.copyProperties(this, product, "entityId");
		product.setCompany(Company.fromJson(this.companyJson));
		
		return product;
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
	public static ProductJpo sample() {
		return new ProductJpo(Product.sample());
	}
}
