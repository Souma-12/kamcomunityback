package com.association.utils;

import java.io.Serializable;

public class SumResponseByUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String user;
	private double sum;

	public SumResponseByUser(String user, double sum) {
		super();
		this.user = user;
		this.sum = sum;
	}

	public SumResponseByUser() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SumResponseByUser [user=" + user + ", sum=" + sum + "]";
	}

}
