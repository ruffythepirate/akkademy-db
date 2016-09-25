package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetRequest

import scala.collection.mutable

/**
  * Created by ruffy on 9/25/16.
  */
class AkkademyDb extends Actor{
  val map = new mutable.HashMap[String, Object]
  val log = Logging(context.system, this)
  override def receive = {
    case SetRequest(key, value) => {
      log.info("received SetREquest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("received unknown message; {}", o)
  }
}
