package io.javabrains.MovieCatalogService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
//to become eureka server's client - we need to add dependency in pom -spring-cloud-starter-netflix-eureka-client
// and add annotation to this class  @EnableEurekaClient 

// to do client side discovery - we add @LoadBalanced annotation to class
//we can run multiple instance of any microservice "" - on diff port - when client will send request to discovery server , discovry server will send request to that respective 
// service there will be multiple instance of that service will be runnnig through @LoadBalanced annotation request will go to any instance 

//What if any microver will go down -send heart beat to service registry(this is managed eby eureka)
// what if discovery server goes down  - client will check for cache data - this also eureka client will do 

@SpringBootApplication
@EnableEurekaClient 
public class MovieCatalogServiceApplication {
	
	@Bean 
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		System.out.println("**************************started MovieCatalogServiceApplication");
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
		System.out.println("**************************kkkkkkkkkkkww");

	}

}
