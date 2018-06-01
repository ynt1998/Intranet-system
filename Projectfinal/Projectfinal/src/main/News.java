package main;

import java.io.Serializable;
import java.util.*;

public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 708995177131084864L;
	private String title;
	private String content;
	private String from;
	Vector<String> comment = new Vector<String>();
	public News(String title, String content, String from){
		this.title = title;
		this.content = content;
		this.from = from;
	}
	public String getTitle(){
		return title;
	}
	public String getContent(){
		return content;
	}
	public String getAuthor(){
		return from;
	}
}
