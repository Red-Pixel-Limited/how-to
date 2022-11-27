import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Sequencing {
  def parallel: Future[Int] =
    Future.sequence(
      Future.successful(1) :: Future.successful(4) :: Nil
    ).map(_.sum)   
}
