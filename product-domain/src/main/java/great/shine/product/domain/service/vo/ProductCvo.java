package great.shine.product.domain.service.vo;

import great.shine.common.util.json.JsonUtil;
import great.shine.product.domain.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCvo {
	private String id;
	private String name;
	private Company company;

	public ProductCvo(String id, String name, Company company) {
		this.id = id;
		this.name = name;
		this.company = company;
	}
	
	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
	
	public static ProductCvo sample() {
		return new ProductCvo("2017-003", "CMP", Company.sample());
	}
}
