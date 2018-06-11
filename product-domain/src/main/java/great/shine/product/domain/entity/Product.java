package great.shine.product.domain.entity;

import great.shine.common.domain.Attribute;
import great.shine.common.domain.AttributeList;
import great.shine.common.domain.entity.BaseAggregate;
import great.shine.common.domain.entity.BaseEntity;
import great.shine.common.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity implements BaseAggregate {
	private String id;
	private String name;
	private Company company;
	private long created;
	
	public Product(String uuid) {
		super(uuid);
	}
	
	public Product(String id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.created = System.currentTimeMillis();
	}
	
	public static Product fromJson(String json) {
		return JsonUtil.fromJson(json, Product.class);
	}
	
	public void setValues(AttributeList attributes) {
		for(Attribute attribute : attributes.list()) {
			String value = attribute.getValue();
			switch(attribute.getName()) {
			case "name":
				this.name = value;
				break;
			}
		}
	}
	
	public static Product sample() {
		return new Product("2017-003", "CMP", Company.sample());
	}
}
