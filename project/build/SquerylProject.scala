
import sbt._


class SquerylProject(info: ProjectInfo) extends DefaultProject(info) {
  
  override def managedStyle = ManagedStyle.Maven
  
  val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"

  Credentials(Path.userHome / ".ivy2" / ".credentials", log)
  
  override def pomExtra =
    <licenses>
      <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
      </license>
    </licenses>
	
  /**
   * CGLIB is Squeryl's only dependency
   */
  
  val cglib = "cglib" % "cglib-nodep" % "2.2"

  /**
   * The following jars are for running the automated tests
   */
  
  val h2 = "com.h2database" % "h2" % "1.2.127" % "provided"
  
  val mysqlDriver = "mysql" % "mysql-connector-java" % "5.1.10" % "provided"
	
  val posgresDriver = "postgresql" % "postgresql" % "8.4-701.jdbc4" % "provided"

  val specs = "org.scala-tools.testing" % "specs_2.8.0.Beta1" % "1.6.4" % "test"
}