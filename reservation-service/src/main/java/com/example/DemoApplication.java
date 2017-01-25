package com.example;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@SpringBootApplication
public class DemoApplication {

	@Bean
	CommandLineRunner runner(ReservationRepository rr){
		return args -> {
			Arrays.asList("sumit,sumit123,sumit1234".split(","))
			.forEach(x -> rr.save(new Reservation(x)));
			rr.findAll().forEach(System.out::println);
		};
		
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}


@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation,Long>{
	@RestResource (path="by-name")
	 Collection<Reservation> findByReservationName(@Param("rn")String rn);
}


