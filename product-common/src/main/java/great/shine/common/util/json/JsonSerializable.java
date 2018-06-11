package great.shine.common.util.json;

public interface JsonSerializable {
	default String toJson() {
		return JsonUtil.toJson(this);
	}
}
