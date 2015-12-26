package codechampinzees.liveshark.storage.repository

import org.scalatest._

import scalaz.Reader

/**
  * Created by Haoyuan on 12/25/2015.
  */
class PlatformsTest extends FlatSpec with Matchers with BeforeAndAfter with H2DatabaseTestConfig {
  val config = new H2DatabaseTestConfig {}
  val platforms = new Platforms {}

  before {
    config.simpleExecute(config.createSchema)
  }

  "The platform" should "can be inserted" in {
    val douyu = config.simpleExecute(run(platforms.insert(Platform("Douyu", "http://douyu.tv"))))
    println(douyu)
  }

  private def run[A](reader: Reader[DatabaseConfig, A]) = {
    reader(config)
  }
}
