package com.association.utils;

import java.io.Serializable;

public class SumResponseByAssociation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long association;
	private double sum;

	public SumResponseByAssociation(long association, double sum) {
		super();
		this.association = association;
		this.sum = sum;
	}

	public SumResponseByAssociation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAssociation() {
		return association;
	}

	public void setAssociation(long association) {
		this.association = association;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SumResponseByAssociation [association=" + association + ", sum=" + sum + "]";
	}

}
