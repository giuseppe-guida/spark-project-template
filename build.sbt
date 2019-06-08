name := "spark-project-template"

lazy val `spark-jobs` = project.in(file("."))
  .enablePlugins(SparkDependencies, GlobalSettings)
  .configs(IntegrationTest)