package com.avdhoot.Maven1;

public class Example {
	private String propString;

	public String getPropString() {
		return propString;
	}

	public void setPropString(String propString) {
		this.propString = propString;
	}

	@Override
	public String toString() {
		return "Example [propString=" + propString + "]";
	}

	public Example(String propString) {
		super();
		this.propString = propString;
	}
	
}
