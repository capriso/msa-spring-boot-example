package great.shine.common.domain;

import great.shine.common.util.json.JsonSerializable;
import great.shine.common.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Attribute implements JsonSerializable {
	private String name;
	private String value;
	
	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public static Attribute fromJson(String json) {
		return JsonUtil.fromJson(json, Attribute.class);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
}
