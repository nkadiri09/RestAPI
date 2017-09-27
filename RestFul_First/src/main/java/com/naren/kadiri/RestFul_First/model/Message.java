package com.naren.kadiri.RestFul_First.model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private int id;
	private String message;
	private Date created;
	private String author;
	private List<Link> links = new ArrayList<Link>();

	private Map<Long, Comment> Comments = new HashMap<Long, Comment>();

	/*
	 * public Message(int id, String message, String author) { super(); this.id =
	 * id; this.message = message; this.author = author; this.created = new Date();
	 * }
	 */

	public Message(int id, String message, String author, Map<Long, Comment> comments) {

		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
		Comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Message() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return Comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		Comments = comments;
	}

	public void addLink(String url, String rel) {

		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);

	}

}
