package br.com.fiveward.xlooksx.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;


 /**
 * @author xLooKsx
 *
 */
@Entity(name = "merchant")
public class MerchantEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6550618873261080954L;
	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	private LocalDate foundation;
	private String document;
	private Boolean isActive;
	
	
	
	public MerchantEntity() {
		this(null, "", "", false, null, null, false);
	}



	public MerchantEntity(Long id, String legalName, String socialName, Boolean allowedToTransact, LocalDate foundation,
			String document, Boolean isActive) {		
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



	public String getDocument() {
		return document;
	}



	public void setDocument(String document) {
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
		return "MerchantEntity [id=" + id + ", legalName=" + legalName + ", socialName=" + socialName
				+ ", allowedToTransact=" + allowedToTransact + ", foundation=" + foundation + ", document=" + document
				+ ", isActive=" + isActive + "]";
	}
	
	
	
	
}
