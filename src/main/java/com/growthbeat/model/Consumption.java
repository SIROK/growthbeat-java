package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.growthbeat.Context;

public class Consumption extends Model {

	private int count;
	private Date created;
	private Account account;
	private Action action;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public static Consumption create(String accountId, String actionId, int count, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("actionId", actionId);
		params.put("count", count);
		return post(context, "1/consumptions", params, Consumption.class);
	}

}
