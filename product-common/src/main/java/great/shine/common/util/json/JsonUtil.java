package great.shine.common.util.json;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	private static Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).setPrettyPrinting().create();
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json,  clazz);
	}
}
