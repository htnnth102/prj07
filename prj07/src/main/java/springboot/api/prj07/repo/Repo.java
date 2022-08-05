package springboot.api.prj07.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.api.prj07.model.Employee;

public interface Repo extends JpaRepository<Employee, Long> {

}
