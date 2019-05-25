package br.com.fiveward.xlooksx;

import java.io.Serializable;
import java.time.LocalDate;


 /**
 * @author xLooKsx
 *
 */
public class MerchantCanonical implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269465780419020390L;
	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	private LocalDate foundation;
	private DocumentCanonical document;
	private Boolean isActive;
	
	
	
	public MerchantCanonical() {
		this(null, "", "", false, null, null, false);
	}



	public MerchantCanonical(Long id, String legalName, String socialName, Boolean allowedToTransact, LocalDate foundation,
			DocumentCanonical document, Boolean isActive) {		
		this.id = id;
		this.legalName = legalName;
		this.socialName = socialName;
		this.allowedToTransact = allowedToTransact;
		this.foundation = foundation;
		this.document = document;
		this.isActive = isActive;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLegalName() {
		return legalName;
	}



	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}



	public String getSocialName() {
		return socialName;
	}



	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}



	public Boolean getAllowedToTransact() {
		return allowedToTransact;
	}



	public void setAllowedToTransact(Boolean allowedToTransact) {
		this.allowedToTransact = allowedToTransact;
	}



	public LocalDate getFoundation() {
		return foundation;
	}



	public void setFoundation(LocalDate foundation) {
		this.foundation = foundation;
	}


	public DocumentCanonical getDocument() {
		return document;
	}



	public void setDocument(DocumentCanonical document) {
		this.document = document;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "MerchantCanonical [id=" + id + ", legalName=" + legalName + ", socialName=" + socialName
				+ ", allowedToTransact=" + allowedToTransact + ", foundation=" + foundation + ", document=" + document
				+ ", isActive=" + isActive + "]";
	}
	
	
	
	
}
