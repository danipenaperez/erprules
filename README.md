# erprules project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

Before to run , start the docker dependent services using two shells 
Each service is started with -rm so after shutdown the container will be deleted

```
./runJaegerServer.sh
```
```
./runPostgres.sh
```


Now You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `erprules-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/erprules-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/erprules-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Functionallity

Crear un proyecto en una H2 con vacantes
Añadir candidatos
Apuntarse candidatos
 - Si el sueldo es mucho no
 - Si es de cuenca tampoco
 - Si esta lleno el cupo tampoco
 - si pasa enviar eventos de dominio
 
 En lo eventos de dominio
 tirar eventos de tipo "notice" o "command" si se quiere hacer algo.
 
 
 Se trabaja con PostGres
 https://quarkus.io/guides/reactive-sql-clients
 
 
 
 docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:10.5
 
 https://medium.com/@hantsy/kickstart-your-first-quarkus-application-cde54f469973
 
 Jaeger tracing
 https://quarkus.io/guides/opentracing
 ./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-opentracing"
 https://quarkus.io/guides/opentracing
 mvn quarkus:list-extensions
 mvn quarkus:add-extension -Dextension=resteasy-jsonb
 
 https://gerardo.dev/microprofile-opentracing.html
 docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:latest

docker start 1dd7c49ac7a3

 https://medium.com/jaegertracing/microprofile-tracing-in-supersonic-subatomic-quarkus-43020f89a753
 
 
 
 
 mvn quarkus:add-extension -Dextension=openapi