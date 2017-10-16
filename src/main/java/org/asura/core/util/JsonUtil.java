package org.asura.core.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {

	public static String fromObject(Object obj) {
		return JSONObject.toJSONString(obj);
	}

	public static <T> T json2Object(String json, Class<T> clazz) {
		return JSONObject.parseObject(json, clazz);
	}

	public static <T> T json2Object(String json, T type) {
		return JSONObject.parseObject(json, new TypeReference<T>() {
		});
	}
}
