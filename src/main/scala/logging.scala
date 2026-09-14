package edu.luc.cs.laufer.cs371.shapes

import org.slf4j.LoggerFactory

/** Single point of contact with the logging backend (SLF4J + Logback).
  *
  * Debug output is configurable at runtime through src/main/resources/logback.xml
  * (or -Dlogback.configurationFile=...) without recompiling. The isDebugEnabled
  * guard keeps the message string from being built when debug is switched off.
  */
object Log:

  private val logger = LoggerFactory.getLogger("edu.luc.cs.laufer.cs371.shapes").nn

  inline def debug(inline msg: String): Unit =
    if logger.isDebugEnabled then logger.debug(msg)

end Log
