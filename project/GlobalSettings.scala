import com.typesafe.sbt.SbtScalariform
import sbt.Keys.{resolvers, _}
import sbt._
import sbtassembly.AssemblyKeys.assembly
import scalariform.formatter.preferences._
import scoverage.ScoverageKeys._

object GlobalSettings extends AutoPlugin {
  override val trigger = allRequirements
  override val requires = plugins.JvmPlugin

  override val projectSettings: Seq[Setting[_]] = Seq(
    scalaVersion := "2.12.2",
    libraryDependencies ++= projectDependencies
  ) ++ testSettings ++ scoverageSettings ++ scalariFormSettings ++ forceDepsSettings

  lazy val testSettings: Seq[Setting[_]] = {
    val flags = Seq(Tests.Argument("-oD"))
    Seq(
      assembly / test := {},
      Test / parallelExecution := false,
      Test / testOptions ++= flags
    )
  }

  lazy val scalariFormSettings: Seq[Setting[_]] = Seq(
    SbtScalariform.autoImport.scalariformPreferences :=
      SbtScalariform.autoImport.scalariformPreferences.value
        .setPreference(AlignParameters, false)
        .setPreference(AlignSingleLineCaseStatements, true)
        .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 90)
        .setPreference(DoubleIndentConstructorArguments, true)
        .setPreference(RewriteArrowSymbols, true)
        .setPreference(DanglingCloseParenthesis, Preserve)
        .setPreference(IndentSpaces, 2)
        .setPreference(IndentWithTabs, false)
        .setPreference(NewlineAtEndOfFile, true)
  )

  lazy val scoverageSettings: Seq[Setting[_]] = Seq(
    // Scoverage settings
    coverageExcludedPackages := "<empty>",
    coverageMinimum := 70.0,
    coverageFailOnMinimum := true
  )

  lazy val projectDependencies: Seq[ModuleID] = Seq(
    "org.apache.commons" % "commons-lang3" % "3.8.1",
    "org.postgresql" % "postgresql" % "42.2.5",
    "com.github.scopt" % "scopt_2.11" % "4.0.0-RC2",
    "org.scalikejdbc" %% "scalikejdbc" % "3.3.5",
    "org.scalikejdbc" %% "scalikejdbc-config" % "3.3.5",
    "org.scalatest" %% "scalatest" % "3.0.8" % "test,it",
    "org.scalamock" %% "scalamock" % "4.4.0" % "test,it",
    "org.mockito" % "mockito-core" % "2.8.47" % "test",
    "org.scalikejdbc" %% "scalikejdbc-test" % "3.3.5" % "test",
    "com.h2database" % "h2" % "1.4.197" % "test,it"
  )

  /**
    * Fixes version conflicts warnings
    * Fixes version conflicts warnings
    */
  lazy val forceDepsSettings: Seq[Setting[_]] = Seq(
    dependencyOverrides ++= Seq(
      "com.google.code.findbugs" % "jsr305" % "3.0.2",
      "io.netty" % "netty" % "3.9.9.Final",
      "commons-net" % "commons-net" % "2.2",
      "com.google.guava" % "guava" % "11.0.2",
      "com.github.mrpowers" % "spark-fast-tests" % "v0.19.0" % "test"
    )
  )
}

