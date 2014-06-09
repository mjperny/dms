name := "dms"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
	javaJpa,
  cache,
	"mysql" % "mysql-connector-java" % "5.1.18",
	"org.hibernate" % "hibernate-entitymanager" % "4.2.2.Final"
)     

play.Project.playJavaSettings
