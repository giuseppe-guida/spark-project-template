name := "spark-workbook"

lazy val `spark-jobs` = project.in(file("."))
  .enablePlugins(SparkDependencies, GlobalSettings)
  .configs(IntegrationTest)