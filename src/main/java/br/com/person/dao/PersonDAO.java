package br.com.person.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.person.entity.Person;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer>{

}
