package br.com.person.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.person.dao.PersonDAO;
import br.com.person.entity.Person;
import br.com.person.entity.Risk;

@Service
public class PersonService {

	@Autowired
    private PersonDAO dao;

    public PersonService() {
    }

    public Iterable<Person> selectAll() {
        return dao.findAll();
    }
    
    public Person selectById(int id) {
    	return dao.findOne(id);
    }
    
    public void delete(int id) {
    	dao.delete(id);
    }
 
    public void insert(String name, BigDecimal creditLimit, String risk,  String shortAddress, Integer rate) {
        Person person = new Person();
        person.name = name;
        person.creditLimit = creditLimit;
        person.risk = Risk.valueOf(risk);
        person.shortAddress = shortAddress;
        person.rate =  rate;
        dao.save(person);
    }
    
    public void update(int id, String name, BigDecimal creditLimit, String risk,  String shortAddress, Integer rate) {
        Person person = dao.findOne(id);
        person.name = name;
        person.creditLimit = creditLimit;
        person.risk = Risk.valueOf(risk);
        person.shortAddress = shortAddress;
        person.rate =  rate;
        dao.save(person);
    }
    
    public Iterable<Person> updateAndSelectAll(int id, String name, BigDecimal creditLimit, String risk,  String shortAddress, Integer rate) {
        Person person = dao.findOne(id);
        person.name = name;
        person.creditLimit = creditLimit;
        person.risk = Risk.valueOf(risk);
        person.shortAddress = shortAddress;
        person.rate =  rate;
        dao.save(person);
        return dao.findAll();
    }
    
    public Iterable<Person> insertAndSelectAll(String name, BigDecimal creditLimit, String risk,  String shortAddress, Integer rate) {
    	Person person = new Person();
        person.name = name;
        person.creditLimit = creditLimit;
        person.risk = Risk.valueOf(risk);
        person.shortAddress = shortAddress;
        person.rate =  rate;
        dao.save(person);
        return dao.findAll();
    }
    
    public Integer rateCalculator(String risk) {
       	return Risk.valueOf(risk).getRiskValue();			
    }
}