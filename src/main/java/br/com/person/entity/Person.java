package br.com.person.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    public String name;
    
    public BigDecimal creditLimit;
    
    @Enumerated(EnumType.STRING)
    public Risk risk;
    
    public String shortAddress;
    
    public Integer rate;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", creditLimit=" + creditLimit + ", risk=" + risk
				+ ", shortAddress=" + shortAddress + ", rate=" + rate + "]";
	}
}
