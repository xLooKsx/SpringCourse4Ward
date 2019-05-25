package br.com.fiveward.xlooksx.entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author xLooKsx
 *
 */
@Entity(name = "document")
public class DocumentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4292882048763361754L;
	private Long id;
	private String value;
	private String type;
	
	
	
	public DocumentEntity() {
		this(null, "", "");
	}



	public DocumentEntity(Long id, String value, String type) {
		this.id = id;
		this.value = value;
		this.type = type;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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
		return "DocumentEntity [id=" + id + ", value=" + value + ", type=" + type + "]";
	}
	
	
}
