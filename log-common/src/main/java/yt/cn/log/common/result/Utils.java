package yt.cn.log.common.result;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class Utils {
	 public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
	        @SuppressWarnings("unchecked")
	        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
	        return ts;
	    }

}
