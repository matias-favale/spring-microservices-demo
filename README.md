# Spring Microservices Demo

# Intro

This is a demo for Spring Cloud Microservices used for showing the capabilities and advantages of this technology.

# How to use

There are 4 branches that show the different sections used for the demo:

* Demo 1 - Services Communication: Shows a basic configuration of 3 Spring Boot Microservices that communicates using hard-coded URLs within the same local machine with communication using RestTemplate.
* Demo 2 - Eureka Configuration: Shows configuration of Client Side Load Balancing, including Service Discovery Eureka Server and changing hard-coded URLs to use dynamic urls with the service discovery server.
* Demo 3 - Timeouts: Shows a configuration for basic timeout to avoid slow microservices to propagate slowness to the rest.
* Demo 4 - Hystrix: Shows a configuration for using Circuit Breaker Pattern with Netflix Hystrix.

These services where built using Intellij IDEA Ultimate and with the help of Sprint Initializer, however this is not strictly necessary, but it certainly helps on doing things faster.

# Useful Links:

* Spring Initializer: https://start.spring.io
* Spring Cloud Netflix documentation: https://spring.io/projects/spring-cloud-netflix
