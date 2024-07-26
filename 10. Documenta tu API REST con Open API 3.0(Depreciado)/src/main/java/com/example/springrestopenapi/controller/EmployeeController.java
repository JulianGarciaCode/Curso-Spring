package com.example.springrestopenapi.controller;

import com.example.springrestopenapi.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name= "Employee", description = "Employee API REST with CRUD Operations")
public class EmployeeController {

    //A continuación indicamos todas las respuestas para cada estado que se quieran dar
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved employees", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Employee.class)))})
            /*
             //Esta sería otra respuesta
             @ApiResponse(responseCode = "404", description = "Retrieved employees", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Message.class)))})
    }
             */
    })

    @Operation(summary = "findAll employees", description = "It retrieves all employees from database without pagination")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok( List.of(
                new Employee(1L, "JulianGarciaCode", LocalDate.of(1990, 1,1), 40000.0, true),
                new Employee(2L, "emp2", LocalDate.of(1990, 1,1), 40000.0, true),
                new Employee(3L, "emp3", LocalDate.of(1990, 1,1), 40000.0, true)
        ));
    }

}
