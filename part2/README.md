# stories-event-driven-study-part-1
This repo contains the code resulting from following the steps in [Event driven with Spring REST, Kafka and MongoDB - part 1](https://joaovicente.github.io/2018-02-22-event-driven-with-spring-rest-kafka-and-mongodb-part1/) blog

Start Kafka and MongoDB, and run spring boot app
```
$ docker-compose -f ./docker-compose-kafka-mongo.yml up
$ mvn spring-boot:run
```

Start Jaeger
```
 docker run -it --network=host jaegertracing/all-in-one
```

Make a call
```
$ http post localhost:8080/authors name=me email=me@gmail.com
```

Look at your trace in Jaeger http://localhost:16686

> For more on Opentracing and Jaeger see [Opentracing Spring Web dependency](https://github.com/opentracing-contrib/java-spring-web#spring-boot-auto-configuration) and [Jaeger dependency](https://github.com/jaegertracing/jaeger-client-java#importing-dependencies) as well as [this video](https://youtu.be/RvCcWltMY7U)
