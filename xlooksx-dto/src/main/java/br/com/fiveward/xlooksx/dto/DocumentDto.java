package br.com.fiveward.xlooksx.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author xLooKsx
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class DocumentDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8211824253144839199L;
	private String value;
	private String type;
	
	
	
	public DocumentDto() {
		this("", null);
	}



	public DocumentDto(String value, String type) {
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "DocumentDto [value=" + value + ", type=" + type + "]";
	}
	
	
}
