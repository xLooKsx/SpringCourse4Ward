
package br.com.fiveward.xlooksx;

import java.io.Serializable;

import br.com.fiveward.xlooksx.enums.DocumentType;

public class DocumentCanonical implements Serializable {

	private static final long serialVersionUID = -1192126711895642155L;

	private Long id;

	private String value;

	private DocumentType type;

	public DocumentCanonical() {
		super();
	}

	public DocumentCanonical(Long id, String value, DocumentType type) {
		super();
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

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentCanonical other = (DocumentCanonical) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentCanonical [id=" + id + ", value=" + value + ", type=" + type + "]";
	}
}
