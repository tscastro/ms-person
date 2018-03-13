package br.com.person.entity;

public enum Risk {
	
	A(0), B(10), C(20);
	
	private final int riskValue;
	
	Risk(int value) {
		this.riskValue = value;
	}
	
   public int getRiskValue() {
        return riskValue;
    }
}
