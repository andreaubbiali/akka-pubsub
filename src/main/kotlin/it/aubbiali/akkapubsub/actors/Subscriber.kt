package it.aubbiali.akkapubsub.actors

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator
import java.lang.Exception
import kotlin.jvm.Throws

class Subscriber(subscriptionList: List<String>):AbstractActor() {

    private val mediator: ActorRef

    init {
        println("init subscriber")
        try{
            mediator = DistributedPubSub.get(context.system).mediator()
        }catch(e: Exception){
            println("Exception $e")
            throw e
        }

        subscriptionList.forEach {topic ->
            mediator.tell(DistributedPubSubMediator.Subscribe(topic, self), self)
        }
    }

    override fun createReceive(): Receive {
        return receiveBuilder()
            .match(DistributedPubSubMediator.SubscribeAck::class.java){
                println("Actor ${self.path()} subscribed")
            }
            .matchAny {
                println("Actor ${self.path()} received $it")
            }.build()
    }
}