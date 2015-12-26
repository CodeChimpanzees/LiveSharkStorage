package codechampinzees.liveshark.storage.repository

import slick.driver.JdbcProfile

/**
  * Created by Haoyuan on 12/25/2015.
  */
case class Platform(name: String, url: String, id: Int = 0)

class PlatformRepository(val driver: JdbcProfile) {

  import driver.api._


  class Platforms(tag: Tag) extends Table[Platform](tag, "platforms") {
    def id = column[Int]("platform_id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("platform_name")

    def url = column[String]("platform_url")

    def * = (name, url, id) <>(Platform.tupled, Platform.unapply)
  }

  val platforms = TableQuery[Platforms]
  val platformReturningRow = platforms returning platforms.map(_.id) into { (platform, id) =>
    platform.copy(id = id)
  }

  def createSchema = platforms.schema.create

  def get(id: Int) = platforms.filter(_.id === id).take(1)

  def insert(platform: Platform) = {
    platformReturningRow += platform
  }

  //  def insert(platform: Platform)(implicit session: Session): Platform = {
  //    val id = idAutoInc.insertOrUpdate(platform.name, platform.url)
  //    platform.copy(id = id)
  //  }
}
