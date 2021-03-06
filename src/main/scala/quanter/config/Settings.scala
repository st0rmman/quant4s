/**
  *
  */
package quanter.config

import java.util

import akka.actor.ActorSystem
import akka.actor.Extension
import akka.actor.ExtensionId
import akka.actor.ExtensionIdProvider
import akka.actor.ExtendedActorSystem

import scala.concurrent.duration.Duration
import com.typesafe.config.Config
import java.util.concurrent.TimeUnit

/**
  *
  */
class Quant4sSettings(config: Config) extends Extension{
  val providers = config.getAnyRefList("quant4s.dataProviders")
  val channelTypes = config.getAnyRefList("quant4s.chanelTypes")
//  val riskControllers = config.getAnyRef("quant4s.riskControllers")
//
//  def getRiskController(name: String): String = {
//    for(risk <- riskControllers)
//      (risk.asInstanceOf[util.HashMap[String, String]])._1
//  }
}

object Settings extends ExtensionId[Quant4sSettings] with ExtensionIdProvider {
  override def lookup = Settings

  override def createExtension(system: ExtendedActorSystem) = new Quant4sSettings(system.settings.config)

  override def get(system: ActorSystem): Quant4sSettings = super.get(system)
}