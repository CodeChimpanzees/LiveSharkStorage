package codechampinzees.liveshark.storage.repository

/**
  * Created by Haoyuan on 12/25/2015.
  */


trait Platforms {

  def get(id: Int) = scalaz.Reader((config: DatabaseConfig) =>
    config.result(config.platformRepository.get(id))
  )

  def insert(platform: Platform) = scalaz.Reader((config: DatabaseConfig) =>
    config.action(config.platformRepository.insert(platform))
  )

}
