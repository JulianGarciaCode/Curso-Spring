package com.example.springpaginationthymeleaf.service;

import com.example.springpaginationthymeleaf.entity.Employee;
import com.example.springpaginationthymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Page<Employee> findAllPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
