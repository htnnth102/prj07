package springboot.api.prj07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.api.prj07.exception.ResourceNotFound;
import springboot.api.prj07.model.Employee;
import springboot.api.prj07.repo.Repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/vi")
public class EmpController {
    @Autowired
    private Repo repo;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @PostMapping("/employee")
    public Employee addNewEmp(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmpById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEm(@PathVariable Long id, @RequestBody Employee emp) {
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Emloyee does not exist"));
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setEmailId(emp.getEmailId());

        Employee updateEmp = repo.save(employee);
        return ResponseEntity.ok(updateEmp);
    }

    @DeleteMapping("/employee/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteEmp(@PathVariable Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Emloyee does not exist"));
        repo.delete(emp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
