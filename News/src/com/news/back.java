package com.news;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class back {
	private String Country;
	private String Category;
	private String title;
	private String Description;
	private String Url;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String Category) {
		this.Category = Category;
	}
	public String getTitle() {
		return title;
	}
	public String getURL() {
		return Url;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setURL(String URL) {
		this.Url = URL;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	
	

	

	public back(String Country, String Category, String URL, String title, String description) {
		super();
		this.Country = Country;
		this.Category = Category;
		this.Url=URL;
		this.title=title;
		this.Description=description;
		
	}

	public back() {
		super();
	}
}




