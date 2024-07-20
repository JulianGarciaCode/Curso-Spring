package com.example.springbootapirest.controller;

import com.example.springbootapirest.entity.Manufacturer;
import com.example.springbootapirest.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    private ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    /*
    GET http://localhost:8080/api/manufactures
     */
    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll(){
        List<Manufacturer> manufacturers = this.service.findAll();
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(manufacturers);
    }

    /*
    GET http://localhost:8080/api/manufactures/year/1990
     */
    @GetMapping("/manufacturers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer year){
        List<Manufacturer> manufacturers = this.service.findAllbyYear(year);
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(manufacturers);
    }

    /*
    GET http://localhost:8080/api/manufactures/7
     */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id){
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    Post http://localhost:8080/api/manufactures/7
     */
    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer){
        // Aquí haríamos comprobaciones
        if (manufacturer.getId() != null)
            return ResponseEntity.badRequest().build();

        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer>update(@RequestBody Manufacturer manufacturer){
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }
    /*
    DELETE http://localhost:8080/api/manufactures/delete/7
     */
    @DeleteMapping("/manufacturers/delete/{id}")
    public ResponseEntity<Manufacturer>deleteById(@PathVariable("identifier") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    DELETE http://localhost:8080/api/manufactures/delete-all
     */
    @DeleteMapping("/manufacturers/delete-all")
    public ResponseEntity<Manufacturer>deleteAll(){
        this.service.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
