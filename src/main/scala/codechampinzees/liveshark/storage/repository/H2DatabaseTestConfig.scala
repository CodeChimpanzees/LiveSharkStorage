package codechampinzees.liveshark.storage.repository

import slick.jdbc.JdbcBackend.Database

/**
  * Created by Haoyuan on 12/25/2015.
  */
trait H2DatabaseTestConfig extends DatabaseConfig {
  val driver = slick.driver.H2Driver
  val db = Database.forURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
}
