import cats.effect._
import fs2.io.file.{Files, Path}
import fs2.text

object WalkExample {
  
  def getFileNameAndContent(directory: String): IO[Map[Path, String]] =  {

    def through(directory: String) =
      Path(s"/$directory")

    def getName(path: Path) =
      fs2.Stream
        .emit(path.fileName)
        .covary[IO]

    def getContent(file: Path) =
      Files[IO]
        .readAll(file)
        .through(text.utf8.decode)
        .through(text.lines)

    Files[IO].walk(through(directory))
      .tail // skip root
      .map { file =>
        getName(file) zip getContent(file)
      }
      .parJoinUnbounded
      .compile
      .to(Map)
  }
}

