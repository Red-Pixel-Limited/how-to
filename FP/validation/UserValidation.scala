package fp.validation

import java.time.{LocalDate, Period}
import fp.typeclass._

import scala.util.Try

case class Form(
    fullName: String,
    dayOfBirth: Int,
    monthOfBirth: Int,
    yearOfBirth: Int,
    role: String
)

case class User(
    firstName: String,
    lastName: String,
    dob: LocalDate,
    admin: Boolean
)

/*
 Return
   a) a Success[User] if everything is correct and User can be created, or
   b) an Error with the list of all problems.

 Validations to implement:
   1) the date of birth (DOB) exists, for example "30 February" is invalid
   2) the user is older than 13 years.
   3) 'fullName' contains two words exactly: first name and last name
   4) 'role' is either "admin" or "user".
 */
object Validator {

  def createUser(form: Form): Validation[User] = {

    val validatedRole: Validation[String] = {
      val roles = List("admin", "user")
      Validation.cond(
        roles.contains(form.role),
        onSuccess = form.role,
        errors = s"User must have one of the following roles: ${roles.mkString(", ")}."
      )
    }

    val validatedFullname: Validation[String] =
      Validation.cond(
        "^\\S+ \\S+$".r.pattern
          .matcher(form.fullName)
          .matches(),
        onSuccess = form.fullName,
        errors = "Fullname is invalid. Must contain firstname and lastname separated by space."
      )

    val validatedAge: Validation[LocalDate] =
      Try(LocalDate.of(form.yearOfBirth, form.monthOfBirth, form.dayOfBirth))
        .fold(
          throwable => Error(s"Invalid DoB: ${throwable.getMessage}" :: Nil),
          dob =>
            Validation.cond(
              Period.between(dob, LocalDate.now()).getYears > 13,
              onSuccess = dob,
              errors = "User must be older than 13 years"
          )
        )

    (User.apply _).curried.pure[Validation] <*>
      validatedFullname.map(_.split(" ")(0)) <*>
      validatedFullname.map(_.split(" ")(1)) <*>
      validatedAge <*>
      validatedRole.map(_ == "admin")
  }

  def createUsers(forms: List[Form]): Validation[List[User]] =
    forms.map(createUser).sequence
}
