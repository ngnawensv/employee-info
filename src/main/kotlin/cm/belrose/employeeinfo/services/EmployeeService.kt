package cm.belrose.employeeinfo.services

import cm.belrose.employeeinfo.exception.EmployeeNotFoundException
import cm.belrose.employeeinfo.model.Employee
import cm.belrose.employeeinfo.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository:EmployeeRepository) {

    fun getAllEmployes():List<Employee> = employeeRepository.findAll()

    fun getEmployeesById(employeeId: Long): Employee = employeeRepository.findById(employeeId)
            .orElseThrow { EmployeeNotFoundException("No matching employee was found") }

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployeeById(employeeId: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                    Employee(
                            id = employee.id!!,
                            userName = employee.userName!!,
                            firstName = employee.firstName!!,
                            lastName = employee.lastName!!,
                            emailId = employee.emailId!!,
                            dayOfBirth = employee.dayOfBirth!!
                    )
            )
        } else throw EmployeeNotFoundException("No matching employee was found")
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
        } else throw EmployeeNotFoundException("No matching employee was found")
    }
}