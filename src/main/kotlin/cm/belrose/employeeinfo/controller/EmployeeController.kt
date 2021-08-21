package cm.belrose.employeeinfo.controller

import cm.belrose.employeeinfo.model.Employee
import cm.belrose.employeeinfo.services.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController(private val employeeService: EmployeeService) {
    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeService.getAllEmployes()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): Employee =
            employeeService.getEmployeesById(employeeId)

    @PostMapping("/employees")
    fun createEmployee(@RequestBody payload: Employee): Employee = employeeService.createEmployee(payload)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @RequestBody payload: Employee): Employee =
            employeeService.updateEmployeeById(employeeId, payload)

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): Unit =
            employeeService.deleteEmployeesById(employeeId)
}