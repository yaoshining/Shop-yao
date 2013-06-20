package com.yao.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 * 
 * @author yaoshining
 *
 */
public class StringObjectMapAdapter extends XmlAdapter<StringObjectMapConvertor, Map<String, Object>>{

	@Override
	public StringObjectMapConvertor marshal(Map<String, Object> map)
			throws Exception {
		StringObjectMapConvertor convertor = new StringObjectMapConvertor();
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			StringObjectMapConvertor.MapEntry e = new StringObjectMapConvertor.MapEntry(entry);
			convertor.addEntry(e);
		}
		return convertor;
	}

	@Override
	public Map<String, Object> unmarshal(StringObjectMapConvertor convertor)
			throws Exception {
		Map<String, Object> results = new HashMap<String, Object>();
		for(StringObjectMapConvertor.MapEntry e : convertor.getEntries()) {
			results.put(e.getKey(), e.getValue());
		}
		return results;
	}
	
}
