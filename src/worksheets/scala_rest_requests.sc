import scala.io

/**
  * Returns the text (content) from a REST URL as a String.
  * Inspired by http://matthewkwong.blogspot.com/2009/09/scala-scalaiosource-fromurl-blockshangs.html
  * and http://alvinalexander.com/blog/post/java/how-open-url-read-contents-httpurl-connection-java
  *
  * The `connectTimeout` and `readTimeout` comes from the Java URLConnection
  * class Javadoc.
  *
  * @param url            The full URL to connect to.
  * @param connectTimeout Sets a specified timeout value, in milliseconds,
  *                       to be used when opening a communications link to the resource referenced
  *                       by this URLConnection. If the timeout expires before the connection can
  *                       be established, a java.net.SocketTimeoutException
  *                       is raised. A timeout of zero is interpreted as an infinite timeout.
  *                       Defaults to 5000 ms.
  * @param readTimeout    If the timeout expires before there is data available
  *                       for read, a java.net.SocketTimeoutException is raised. A timeout of zero
  *                       is interpreted as an infinite timeout. Defaults to 5000 ms.
  * @param requestMethod  Defaults to "GET". (Other methods have not been tested.)
  * @example get("http://www.example.com/getInfo")
  * @example get("http://www.example.com/getInfo", 5000)
  * @example get("http://www.example.com/getInfo", 5000, 5000)
  */
@throws(classOf[java.io.IOException])
@throws(classOf[java.net.SocketTimeoutException])
def get(
  url: String,
  connectTimeout: Int = 5000,
  readTimeout: Int = 5000,
  requestMethod: String = "GET") = {
  import java.net.{URL, HttpURLConnection}
  val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
  connection.setConnectTimeout(connectTimeout)
  connection.setReadTimeout(readTimeout)
  connection.setRequestMethod(requestMethod)
  val inputStream = connection.getInputStream
  val content = io.Source.fromInputStream(inputStream).mkString
  if (inputStream != null) inputStream.close
  content
}

try {
  val content = get("https://ohub2-keyvault-dev.vault.azure.net/secrets/DWConnString/cd5baf5a1c3948a5acaab9e4b3c5e9cc?api-version=7.0")
  println(content)
} catch {
  case ioe: java.io.IOException =>  // handle this
  case ste: java.net.SocketTimeoutException => // handle this
}
