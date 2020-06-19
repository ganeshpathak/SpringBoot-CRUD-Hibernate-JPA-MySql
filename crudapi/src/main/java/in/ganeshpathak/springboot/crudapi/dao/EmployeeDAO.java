package in.ganeshpathak.springboot.crudapi.dao;

import in.ganeshpathak.springboot.crudapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
