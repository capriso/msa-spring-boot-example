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
public class Company extends BaseEntity implements BaseAggregate {
	private String code;
	private String name;
	private long created;
	
	public Company(String uuid) {
		super(uuid);
	}
	
	public Company(String code, String name) {
		super();
		this.code = code;
		this.name = name;
		this.created = System.currentTimeMillis();
	}
	
	public static Company fromJson(String json) {
		return JsonUtil.fromJson(json, Company.class);
	}
	
	public void setValues(AttributeList attributes) {
		for(Attribute attribute : attributes.list()) {
			String value = attribute.getValue();
			switch(attribute.getName()) {
			case "code":
				this.code = value;
				break;
			case "name":
				this.name = value;
				break;
			}
		}
	}
	
	public static Company sample() {
		return new Company("018260", "Samsung SDS");
	}
}
