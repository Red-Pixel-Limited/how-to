import EndpointBuilder._

sealed abstract case class Endpoint(url: String, port: Int)

case class EndpointBuilder[P] private (
    url: Option[String],
    port: Option[Int]
):
  def withURL(url: String) =
    new EndpointBuilder[P with URL](Some(url), port)

  def withPort(port: Int) =
    new EndpointBuilder[P with Port](url, Some(port))

  def build(implicit ev: P <:< URL with Port): Endpoint =
    new Endpoint(url.get, port.get) {}

object EndpointBuilder:
  type URL
  type Port

  def apply(): EndpointBuilder[Any] =
    new EndpointBuilder(None, None)

// val _ = EndpointBuilder().withURL("localhost").build             // error
// val _ = EndpointBuilder().withPort(8080).build                   // error

val _ = EndpointBuilder().withPort(8080).withURL("localhost").build // valid
