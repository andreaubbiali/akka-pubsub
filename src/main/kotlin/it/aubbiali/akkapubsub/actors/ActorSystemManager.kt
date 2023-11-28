package it.aubbiali.akkapubsub.actors

import akka.actor.ActorSystem
import akka.actor.Props
import org.springframework.stereotype.Component

@Component
class ActorSystemManager {

    private val actorSystem = ActorSystem.create("actor-system")

    init {
        actorSystem.actorOf(
            Props.create(
                Subscriber::class.java, listOf("first")
            ),
            "subscriber-1"
        )

        actorSystem.actorOf(
            Props.create(
                Subscriber::class.java, listOf("second")
            ),
            "subscriber-2"
        )

        actorSystem.actorOf(
            Props.create(
                Subscriber::class.java, listOf("third")
            ),
            "subscriber-3"
        )

        actorSystem.actorOf(
            Props.create(
                Subscriber::class.java, listOf("first", "second", "third")
            ),
            "subscriber-mix"
        )

        actorSystem.actorOf(
            Props.create(
                Publisher::class.java, listOf("first", "second", "third")
            ),
            "publisher-1"
        )
    }

}