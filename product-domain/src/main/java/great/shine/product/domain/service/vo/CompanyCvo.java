package great.shine.product.domain.service.vo;

import great.shine.common.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyCvo {
	private String code;
	private String name;
	
	public CompanyCvo(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
	
	public static CompanyCvo sample() {
		return new CompanyCvo("018260", "Samsung SDS");
	}
}
