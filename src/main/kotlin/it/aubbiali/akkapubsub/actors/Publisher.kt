package it.aubbiali.akkapubsub.actors

import akka.actor.AbstractActor
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator

class Publisher(private val topics: List<String>) : AbstractActor() {

    private val mediator = DistributedPubSub.get(context.system).mediator()

    init {
        start()
    }

    override fun createReceive(): Receive {
        return receiveBuilder()
            .matchAny {
                println("Publisher ${self.path()} received $it")
            }.build()
    }

    private fun start(){
        var i = 0
        var counter = 0
        while(true){
            Thread.sleep(5000)
            mediator.tell(DistributedPubSubMediator.Publish(topics[i], "Message $counter"), self)
            i++
            counter++
            if (i == topics.size){
                i = 0
            }
        }
    }


}