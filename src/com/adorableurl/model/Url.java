package com.adorableurl.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Link;

@PersistenceCapable
public class Url {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	private Link url;
	
	public Url(String url) {
		this.url = new Link(url);
	}

	public Long getId() {
		return id;
	}

	public Link getUrl() {
		return url;
	}
}
