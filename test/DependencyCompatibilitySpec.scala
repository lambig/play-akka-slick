import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.typesafe.config.ConfigFactory
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json
import slick.basic.DatabaseConfig
import slick.jdbc.MySQLProfile

class DependencyCompatibilitySpec extends PlaySpec {
  "The patched JSON stack" should {
    "preserve the public response shape and Unicode text" in {
      val response = Json.obj("Whiskies" -> Json.arr(Json.obj("Name" -> "fixture", "Distillery" -> "蒸溜所")))
      Json.parse(Json.stringify(response)) mustBe response
    }

    "load the aligned Scala Jackson module" in {
      val mapper = new ObjectMapper().registerModule(DefaultScalaModule)
      mapper.readTree(mapper.writeValueAsString(Map("values" -> List(1, 2))))
        .get("values").get(1).asInt() mustBe 2
    }
  }

  "The Slick configuration" should {
    "load the MySQL profile without opening a database connection" in {
      val config = DatabaseConfig.forConfig[MySQLProfile]("slick.dbs.default", ConfigFactory.load())
      config.profile mustBe MySQLProfile
    }
  }
}
