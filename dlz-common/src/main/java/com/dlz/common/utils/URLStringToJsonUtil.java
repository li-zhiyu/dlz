package com.dlz.common.utils;

import java.net.URLDecoder;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class URLStringToJsonUtil {
	
	public static JSONObject convertJson(String urlparam) {
		try {
			if (!urlparam.isEmpty()) {
				String[] params = URLDecoder.decode(urlparam, "UTF-8").split("&");
		    	JSONObject obj = new JSONObject();
		    	for (int i = 0; i < params.length; i++) {
		            String[] param = params[i].split("=");
		            if (param.length >= 2) {
		                String key = param[0];
		                String value = param[1];
		                for (int j = 2; j < param.length; j++) {
		                    value += "=" + param[j];
		                }
		                try {
		                	if (obj.containsKey(key)){
		                		obj.put(key,obj.get(key)+","+value);
							}else {
								obj.put(key,value);
							}
		                } catch (JSONException e) {
		                    e.printStackTrace();
		                    return null;
		                }
		            }
		        }
		    	return obj;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
