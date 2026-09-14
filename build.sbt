name := "shapes-oo-scala"

version := "0.5"

libraryDependencies ++= Seq(
  "org.creativescala"    %% "doodle"            % "0.34.0",
  "org.slf4j"            %  "slf4j-api"         % "2.0.16",
  "ch.qos.logback"       %  "logback-classic"   % "1.5.12",
  "com.github.sbt.junit" %  "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)
