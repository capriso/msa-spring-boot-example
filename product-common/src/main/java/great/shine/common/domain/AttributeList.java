package great.shine.common.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import great.shine.common.util.json.JsonSerializable;
import great.shine.common.util.json.JsonUtil;

public class AttributeList implements JsonSerializable {
	private List<Attribute> attributes;
	
	public AttributeList() {
		this.attributes = new ArrayList<>();
	}
	
	public AttributeList(Attribute attribute) {
		this();
		this.attributes.add(attribute);
	}
	
	public AttributeList(String name, String value) {
		this(new Attribute(name, value));
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
	public static AttributeList fromJson(String json) {
		return JsonUtil.fromJson(json, AttributeList.class);
	}
	
	// add element
	public AttributeList add(Attribute attribute) {
		this.attributes.add(attribute);
		return this;
	}
	
	public AttributeList add(String name, String value) {
		return this.add(new Attribute(name, value));
	}
	
	public void addAll(List<Attribute> attributes) {
		this.attributes.addAll(attributes);
	}
	
	public List<Attribute> list() {
		return Collections.unmodifiableList(this.attributes);
	}
	
	// find attribute
	public String getValueOf(String name) {
		return getAttribute(name).getValue();
	}
	
	public Attribute getAttribute(String name) {
		if(name == null)	return null;
		for(Attribute attribute : this.attributes) {
			if(name.equals(attribute.getName())) {
				return attribute;
			}
		}
		return null;
	}
}
