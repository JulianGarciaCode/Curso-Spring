package com.example.springdatamongodbconsultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext contect = SpringApplication.run(App.class, args);
		var repo = contect.getBean(EmployeeRepository.class);
		/*
		Añadimos la siguiente línea para que al ejecutar de nuevo la app, no
		de error, por tener datos duplicado, por eso borramos antes de insertar
		Podríamos evitarlo añadiendo etiquetas en las variables de la clase Employee
		para que sean campos únicos, @Column, crear índice @Indexed
 		*/
		repo.deleteAll();

		List<Employee> employees = List.of(
				new Employee(null, "JulianGarciaCode", "emp@gmail.com", LocalDate.of(1992,1,1), true, 30000.0, LocalDate.of(1980,1,1), LocalDate.of(1992,1,1)),
				new Employee(null, "emp1", "emp1@gmail.com", LocalDate.of(1990,1,1), true, 40000.0, LocalDate.of(1980,1,1), LocalDate.of(1990,1,1)),
				new Employee(null, "emp2", "emp2@gmail.com", LocalDate.of(1980,1,1), true, 50000.0, LocalDate.of(1870,1,1), LocalDate.of(1990,1,1)),
				new Employee(null, "emp3", "emp3@gmail.com", LocalDate.of(1973,1,1), true, 60000.0, LocalDate.of(1990,1,1), LocalDate.of(1994,1,1)),
				new Employee(null, "emp4", "emp4@gmail.com", LocalDate.of(2000,1,1), false, 70000.0, LocalDate.of(1995,1,1), LocalDate.of(1996,1,1)),
				new Employee(null, "emp5", "emp5@gmail.com", LocalDate.of(2000,1,1), true, 70000.0, LocalDate.of(1995,1,1), LocalDate.of(1998,1,1))
		);
		repo.saveAll(employees);

		System.out.println("\nfindByEmail: emp3@gmail.com");
		repo.findByEmail("emp3@gmail.com").ifPresent(System.out::println);

		System.out.println("\nfindAllByMarriedTrue");
		repo.findAllByMarriedTrue().forEach(System.out::println);

		System.out.println("\nfindAllByMarriedFalse");
		repo.findAllByMarriedFalse().forEach(System.out::println);

		System.out.println("\nfindAllByName: emp2");
		repo.findAllByName("emp2").forEach(System.out::println);

		System.out.println("\nfindAllByNameQuery: emp2");
		repo.findAllByNameQuery("emp2").forEach(System.out::println);

		System.out.println("\nfindAllByBirthDateAfter");
		repo.findAllByBirthDateAfter(LocalDate.of(1985, 1, 1)).forEach(System.out::println);

		System.out.println("\nfindAllByBirthDateAfterQuery");
		repo.findAllByBirthDateAfterQuery(LocalDate.of(1985, 1, 1)).forEach(System.out::println);

		System.out.println("\nfindAllByInitAndEndDates");
		repo.findAllByInitAndEndDates(LocalDate.of(1993, 1, 1), LocalDate.of(1997, 1, 1)).forEach(System.out::println);

		System.out.println("\nfindAllIdAndName");
		repo.findAllIdAndName().forEach(System.out::println);

		System.out.println("\nfindAllIdAndNameAndEmail");
		repo.findAllIdAndNameAndEmail().forEach(System.out::println);

		System.out.println("\nfindAllNameAndEmailExcludingId");
		repo.findAllNameAndEmailExcludingId().forEach(System.out::println);
	}

}
