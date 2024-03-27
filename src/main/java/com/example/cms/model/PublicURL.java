package com.example.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PublicURL {
	@Id
	private int publicURL;

	public int getPublicURL() {
		return publicURL;
	}
	public void setPublicURL(int publicURL) {
		this.publicURL = publicURL;
	}
	
	@Override
	public String toString() {
		return "PublicURL [publicURL=" + publicURL + "]";
	}

}
