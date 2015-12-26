package codechampinzees.liveshark.storage.repository

import slick.dbio.DBIO
import slick.driver.JdbcProfile
import slick.lifted.Query

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}


/**
  * Created by Haoyuan on 12/25/2015.
  */
trait DatabaseConfig {
  val driver: JdbcProfile
  val db: driver.api.Database

  lazy val platformRepository = new PlatformRepository(driver)

  def result[C[_]](q: Query[_, _, C]) = {
    import driver.api._
    db.run(q.result)
  }

  def action[T](q: DBIO[T]) = {
    db.run(q)
  }

  def createSchema = {
    db.run(platformRepository.createSchema)
  }

  def simpleExecute[T](future: Future[T]) = {
    Await.result(future, 2 seconds)
  }
}
