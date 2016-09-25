package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
  * Created by ruffy on 9/25/16.
  */
class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach{

  implicit val system = ActorSystem()

  describe("akkademyDb") {
    describe("give SetRequest") {
      it("should place key/value into map") {
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key", "value")
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }

}
