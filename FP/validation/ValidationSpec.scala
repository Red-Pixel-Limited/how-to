package fp.validation

import java.time.LocalDate

import fp.typeclass._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.{FreeSpec, Matchers}

class ValidationSpec extends FreeSpec with Matchers with TypeCheckedTripleEquals {

  val form = Form(
    fullName = "John Smith",
    dayOfBirth = 1,
    monthOfBirth = 1,
    yearOfBirth = 1980,
    role = "admin"
  )

  val user = User(
    firstName = "John",
    lastName = "Smith",
    dob = LocalDate.of(1980, 1, 1),
    admin = true
  )

  "Validator should" - {
    "create a user when there are no errors" in {
      Validator.createUser(form) should ===(Success(user))
    }

    "create a list of the users when there are no errors" in {
      Validator.createUsers(List(form)) should ===(Success(List(user)))
    }
  }
}
