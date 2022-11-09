package com.example.demo.utils;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	private static final JsonParser PARSER = new JsonParser();
	protected static final Map<Type, JsonDeserializer<?>> adapterMap;
	static {
		adapterMap = new HashMap<>();
		
		
	}
	
	private GsonUtil()
	{
		throw new IllegalStateException("Utility class");	
	}
	
	protected static final Map<Type, JsonSerializer<?>> serializerMap;
	static {
		serializerMap = new HashMap<>();
	
		
	}

	private static final ThreadLocal<Gson> gsonInstance = new ThreadLocal<Gson>() {
		@Override
		protected Gson initialValue() {
			if (adapterMap == null) {
				return new GsonBuilder().create();
			} else {
				GsonBuilder gsonBuilder = new GsonBuilder();
				adapterMap.entrySet().forEach(adapter -> 
					gsonBuilder.registerTypeAdapter(adapter.getKey(), adapter.getValue()));
				
				
				serializerMap.entrySet().forEach(serializer -> 
					gsonBuilder.registerTypeAdapter(serializer.getKey(), serializer.getValue()));
				return gsonBuilder.create();
			}
		}
	};


	private static Gson getSharedInstance() {
		synchronized (gsonInstance) {
			if (gsonInstance.get() == null) {
				if (adapterMap == null) {
					gsonInstance.set(new GsonBuilder().create());
				} else {
					GsonBuilder gsonBuilder = new GsonBuilder();
					adapterMap.entrySet().forEach(adapter -> gsonBuilder.registerTypeAdapter(adapter.getKey(), adapter.getValue()));
					
					return gsonBuilder.create();
				}

			}
		}
		return gsonInstance.get();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String val, Class<?> classOfObj) {
		
		return (T) getSharedInstance().fromJson(val, classOfObj);
		
	}
	
	public static <T> T fromJson(String val, Type typeOfT) {
		return getSharedInstance().fromJson(val, typeOfT);
	}
	
	public static <T> T fromJson(JsonElement element, Type typeOfT) {
		return getSharedInstance().fromJson(element, typeOfT);
	}

	public static String toJson(Object obj) {
		return getSharedInstance().toJson(obj);
	}
	
	public static String toJson(Object obj, Class<?> classOfObj) {
		return getSharedInstance().toJson(obj, classOfObj);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T fromJson(Reader reader, Class<?> classOfObj) {
		return (T) getSharedInstance().fromJson(reader, classOfObj);
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJson(JsonElement element, Class<?> classOfObj) {
		return (T) getSharedInstance().fromJson(element, classOfObj);
	}

	public static boolean isEmpty(Object object) {
		JsonElement jsonElement = PARSER.parse(toJson(object));
		
		if(jsonElement instanceof JsonArray) {
			return jsonElement.getAsJsonArray().size() == 0;
		} else
			return jsonElement.getAsJsonObject().entrySet().size() == 0;
	}

	public static JsonObject toJsonObject(Object object) {
		JsonObject jsonObject = null;
		if(object instanceof String) {
			jsonObject = PARSER.parse((String) object).getAsJsonObject();
		} else {
			jsonObject = PARSER.parse(toJson(object)).getAsJsonObject();
		}
		return jsonObject;
	}
	
	public static JsonArray toJsonArray(Object object) {
		return PARSER.parse(toJson(object)).getAsJsonArray();
	}

	public static <T> T deepCopy(T object, Class<T> type) {
	    try {
	        return fromJson(toJson(object, type), type);
	    } catch (Exception e) {
	        return null;
	    }
	}
	
	public static String chkNull(JsonPrimitive data) {
		if (data != null) {
			return data.getAsString();
		} else {
			return "";
		}
	}
	public static String chkNull(JsonElement data) {
		if (data != null) {
			return data.getAsJsonPrimitive().getAsString();
		} else {
			return "";
		}
	}
	
	public static boolean isEqual(Object object1, Object object2) {
		JsonElement jsonElement1 = PARSER.parse(toJson(object1));
		JsonElement jsonElement2 = PARSER.parse(toJson(object2));
		
		return jsonElement1.equals(jsonElement2);
	}
	
	@SuppressWarnings("unchecked")
	public static String toJsonStringValue(Object object) {
		
		java.lang.reflect.Type t = new TypeToken<Map<String,String>>() {}.getType();
		Map<String,String> map = (Map<String,String>) fromJson(toJson(object), t);
		
		return getSharedInstance().toJson(map);
	}

}
