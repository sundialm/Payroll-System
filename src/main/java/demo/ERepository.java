package demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ERepository extends JpaRepository<Employee, Long> {
    List<Employee> byType(EType employeeType);
    Employee byID(long id);
    List<Employee> findAll();
}

