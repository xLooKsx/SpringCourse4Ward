package br.com.fiveward.xlooksx.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


 /**
 * @author xLooKsx
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class MerchantDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 808544786941115485L;
	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate foundation;
	private DocumentDto document;
	private Boolean isActive;
	
	
	
	public MerchantDto() {
		this(null, "", "", false, null, null, false);
	}



	public MerchantDto(Long id, String legalName, String socialName, Boolean allowedToTransact, LocalDate foundation,
			DocumentDto document, Boolean isActive) {		
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



	public DocumentDto getDocument() {
		return document;
	}



	public void setDocument(DocumentDto document) {
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
		return "MerchantDto [id=" + id + ", legalName=" + legalName + ", socialName=" + socialName
				+ ", allowedToTransact=" + allowedToTransact + ", foundation=" + foundation + ", document=" + document
				+ ", isActive=" + isActive + "]";
	}
	
	
	
	
}
