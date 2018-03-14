package br.com.person;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.person.entity.Person;
import br.com.person.entity.Risk;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
    
	@Value("${local.server.port}")
    int port;
    
	@Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testSelect() throws Exception {
            Iterable<Person> persons = restTemplate.exchange("http://localhost:" + port +"/", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<Iterable<Person>>() {
            }).getBody();
            
            assertNotNull(persons);

            List<Person> result = StreamSupport.stream(persons.spliterator(), false)
            		.collect(Collectors.toList());
            
            assertThat(result.size(), is(1));
            assertThat(result.get(0).id, is(1));
            assertThat(result.get(0).name, is("Patricia"));
    }
    
    @Test
    public void testUpdate() {
    	Iterable<Person> persons = restTemplate.exchange("http://localhost:" + port + "/update?id=1&name=Carla&creditLimit=200&risk=B&shortAddress=Endereco&rate=10", HttpMethod.PUT, HttpEntity.EMPTY, new ParameterizedTypeReference<Iterable<Person>>() {
        }).getBody();
    	
    	List<Person> result = StreamSupport.stream(persons.spliterator(), false)
        		.collect(Collectors.toList());
    	
        assertThat(result.size(), is(1));
        assertThat(result.get(0).id, is(1));
        assertThat(result.get(0).name, is("Carla"));
        assertThat(result.get(0).creditLimit, is(new BigDecimal(200)));
        assertThat(result.get(0).risk, is(Risk.B));
        assertThat(result.get(0).shortAddress, is("Endereco"));
        assertThat(result.get(0).rate, is(10));
        
    }
    
}