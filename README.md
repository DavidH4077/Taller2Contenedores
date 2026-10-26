# pa2_u1_cc_ec
## Preguntas de analisis

1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?
IoC se aplica al momento de poner las anotaciones @ApplicationScoped y @Dependent en las clases (VentaService, CotizacionService, DescuentoRegular, DescuentoVIP y Auditoria), porque asi le dejamos a Quarkus que se encargue de crear y manejar las instancias en lugar de hacer un "new" nosotros mismos.
En cambio, DI se aplica cuando usamos @Inject para traer esas dependencias ya creadas, como hicimos en el Main y dentro de VentaService tanto por atributo (para el descuento regular y la auditoria) como por constructor (para el descuento VIP).

2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?
Sirven para indicarle a Quarkus cual implementacion exacta queremos usar cuando tenemos una interfaz implementada por varias clases. En el ejercicio son necesarios porque DescuentoRegular y DescuentoVIP implementan la misma interfaz CalculadoraDescuento, entonces con @Named("regular") y @Named("vip") especificamos cual de las dos toca inyectar en cada caso.

3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?
Con @ApplicationScoped se crea una sola instancia para toda la aplicacion y siempre se reutiliza la misma (por eso al imprimir en consola vemos que el UUID no cambia). En cambio, con @Dependent se crea una instancia nueva cada vez que se inyecta en una clase diferente, y su ciclo de vida queda atado a la clase donde fue inyectada (por eso el UUID de Auditoria en VentaService es distinto al que sale en CotizacionService).

4. ¿Por qué las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?
Porque las clases que calculan el descuento y el servicio no guardan datos de una venta en particular como atributos propios, sino que solo reciben el monto por parametro en el metodo calcular(), hacen la operacion matematica del porcentaje y devuelven el resultado. Como no guardan estado de cada cliente, se puede usar la misma instancia para todas las ventas sin que se mezclen los datos.

5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?
El programa da un error al compilar o arrancar (AmbiguousResolutionException) porque Quarkus encuentra dos clases que implementan CalculadoraDescuento (DescuentoRegular y DescuentoVIP) y al no tener el @Named no sabe cual de las dos debe inyectar.


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/pa2_u1_cc_ec-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
