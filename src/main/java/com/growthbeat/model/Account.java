package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;

import com.growthbeat.Context;

public class Account extends Model {

	private String id;
	private String name;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static Account findById(String id, Context context) {
		return get(context, String.format("1/accounts/%s", id), new HashMap<String, Object>(), Account.class);
	}

	public static Account create(Context context) {
		return post(context, "1/accounts", new HashMap<String, Object>(), Account.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/accounts/%s", id), new HashMap<String, Object>(), Void.class);
	}
}
