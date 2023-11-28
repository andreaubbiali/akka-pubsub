package it.aubbiali.akkapubsub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AkkaPubsubApplication

fun main(args: Array<String>) {
	runApplication<AkkaPubsubApplication>(*args)
}
