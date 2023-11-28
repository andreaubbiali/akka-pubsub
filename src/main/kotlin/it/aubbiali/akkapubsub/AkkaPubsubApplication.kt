package it.aubbiali.akkapubsub

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AkkaPubsubApplication

	fun main(args: Array<String>) {
		SpringApplication(AkkaPubsubApplication::class.java).run(*args)
	}