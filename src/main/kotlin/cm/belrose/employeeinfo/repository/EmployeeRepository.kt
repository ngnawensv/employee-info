package cm.belrose.employeeinfo.repository

import cm.belrose.employeeinfo.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository:JpaRepository<Employee,Long> {
}