package Homework;

import java.util.Date;

public class Review {
	private int placeNum;
	private String title;
	private String content;
	private Date createdAt;
	private String author;
	
	public Review(int placeNum, String title, String content,  String author ) {
		this(placeNum, title, content, new Date(), author);
	}
	
	public Review(int placeNum, String title, String content, Date createdAt, String author) {
		this.placeNum = placeNum;
		this.title = title;
		this.content = content;
		this.createdAt = new Date();
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}
	
	
}
