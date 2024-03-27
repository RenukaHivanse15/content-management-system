package com.example.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BlogPost {
	@Id
	private int postId;
	private String title;
	private String subTitle;
	private String summary;
	private String seo;
	private String seoDescription;
	private String seoTags;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	public String getSeoTags() {
		return seoTags;
	}
	public void setSeoTags(String seoTags) {
		this.seoTags = seoTags;
	}
	@Override
	public String toString() {
		return "BlogPost [postId=" + postId + ", title=" + title + ", subTitle=" + subTitle + ", summary=" + summary
				+ ", seo=" + seo + ", seoDescription=" + seoDescription + ", seoTags=" + seoTags + "]";
	}

}
