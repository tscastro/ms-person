package br.com.person.controller;

import java.math.BigDecimal;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.person.entity.Person;
import br.com.person.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
    private PersonService service;
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Response delete(
    		 @RequestParam("id") int id) {
		service.delete(id);
		return Response.status(200).entity("Registro deletado com sucesso").build();
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Busca todas as pessoas")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Iterable<Person> selectAll() {
        return service.selectAll();
    }

	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Inclui uma pessoa")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Iterable<Person> insertAndSelectAll(
            @RequestParam("name") String name,
            @RequestParam("creditLimit") BigDecimal creditLimit, 
            @RequestParam("risk") String risk,  
            @RequestParam("shortAddress") String shortAddress,
            @RequestParam("rate") Integer rate) {
		service.insertAndSelectAll(name, creditLimit, risk,  shortAddress, rate);
        return service.selectAll();
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Atualiza uma pessoa")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Iterable<Person> updateAndSelectAll(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam("name") String name,
            @RequestParam("creditLimit") BigDecimal creditLimit, 
            @RequestParam("risk") String risk,  
            @RequestParam("shortAddress") String shortAddress,
            @RequestParam("rate") Integer rate) {
        Person person = service.selectById(id);
        person.name = name;
        service.updateAndSelectAll(id, name, creditLimit, risk,  shortAddress, rate);
        return service.selectAll();
    }
	
	@RequestMapping(value = "/rateCalculator", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Calcula taxa baseada no risco")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Integer rateCalculator(
            @RequestParam("risk") String risk) {
        return service.rateCalculator(risk);
    }
}