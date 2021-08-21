package cm.belrose.employeeinfo.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employee")
class Employee() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "user_name", unique = true, nullable = false)
    var userName: String? = null
    @Column(name = "first_name", nullable = false)
    var firstName: String?=null
    @Column(name = "middle_name", nullable = true)
    var lastName: String?=null
    @Column(name = "email_address", nullable = false)
    var emailId: String?=null
    @Column(name = "day_of_birth", nullable = false)
    var dayOfBirth: LocalDate?=null

    constructor(id: Long, userName: String,firstName: String,lastName:String,emailId:String,dayOfBirth:LocalDate):this(){
        this.id=id
        this.userName=userName
        this.firstName=firstName
        this.lastName=lastName
        this.emailId=emailId
        this.dayOfBirth=dayOfBirth
    }

}