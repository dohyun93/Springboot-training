package com.example.DHFirstSpringBootArtifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Coffee{
	private final String id; // 특정  커피 종류의 고유 식별값
	private String name; // 커피(종류)명

	public Coffee(String id, String name){
		this.id = id;
		this.name = name;
	}

	public Coffee(String name){
		this(UUID.randomUUID().toString(), name);
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public void   setName(String name){
		this.name = name;
	}
}

@SpringBootApplication
public class DhFirstSpringBootArtifactApplication {
	public static void main(String[] args) {
		SpringApplication.run(DhFirstSpringBootArtifactApplication.class, args);
	}
}

@RestController
class RestApiDemoController{
	private List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController(){
		// 객체 생성 시 생성자로 커피 목록을 초기화한다.

		coffees.addAll(List.of(
				new Coffee("Cafe Cereza"),
				new Coffee("Cafe Ganador"),
				new Coffee("Cafe Lareno"),
				new Coffee("Cafe Tres Pontas")
		));
	}

	@GetMapping("/coffees")
	Iterable<Coffee> getCoffees(){
		return coffees;
	}

}