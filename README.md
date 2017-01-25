# JSpare Vert.x

[![Build Status](https://travis-ci.org/jspare-projects/vertx-jspare.svg?branch=master)](https://travis-ci.org/jspare-projects/vertx-jspare)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-yellow.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Improve your Vert.x experience with Jspare Framework

This content will be available at
[official site documentation](http://jspare.org).

Read this in other languages: [English](README.md), [简体中文](README.zh-cn.md) - 去做

## Table Of Contents

* [Overview](#overview)
  * [Intro](#intro)
  * [JSpare](#jspare)
  * [JSpare Vert.x](#jspare-vertx)
  * [Version Reference] (#version-reference)
* [vertx-jspare](#vertx-jspare)
* [vertx-jspare-web](#vertx-jspare-web)
* [Examples](#examples)
* [Getting help and Reporting Issues](#help)
* [RoadMap](#roadmap)
* [Feedback](#feedback)
* [Contributing](#contributing)
* [License](#license)



## Overview

If you stay here, that is because you know about of the incredible thinks that the Vert.x can do. I have no doubt that it is amazing and extremely versatile for their tasks. But, what if I say that we can extract more! And we can! The JSpare Vert.x will improve your experience with your Vert.x applications. We persue conventions and we seek to make bright ideas of Vert.x are used and improved. Try it, I'm sure your team and you will not regret.

### Intro

To begin, it is very important that you already know some things about vertx, I invite you to see the official documentation. Why do I say this? vertx-jspare is a framework for improving the experience with vert.x without the basics, we would not exist!

The original eclipse vert.x documentation are available at
[vertx.io](http://vertx.io). Enjoy! Vert.x is fun!

**NOTE**: In some moments we will refer citations of the official documentation, so do not be surprised to have already seen something. All quotations are exclusive to vert.x and are under your licenses, again we will seek to increase your vertx experience.

### JSpare

Let's start! JSpare Framework, A lightweight and simple container for your Java applications.

This is description of the framework, the JSpare Framework provides an environment and container out of the box. Use dependency injection providing on demand resources for your Java Applications. We are uncoupled of any other package and lightweight. You should ask yourself why to use a different framework for do this? Our answer is the following, we do not want to be compared to the giants, we were made to run out of the box, in applications that do not require JavaEE resources or a complete ecosystem ... to do this, use the others.

Oops, but let's go. Vert.x says: "Enjoy being a developer again. Unlike restrictive traditional application containers, Vert.x gives you incredible power and agility to create compelling, scalable, 21st century applications the way you want to, with a minimum of fuss, in the language you want"

Hey, it's all about! both are out of box, and believe that developing must be cool!

The original jspare framework documentation are available at
[framework.jspare.org](http://framework.jspare.org). Enjoy! Jspare is fun too!

### JSpare Vert.x

Our great goal is to try to extract the best of both worlds, keep the essence and make the development productive, organized and fun. From now on we will enter this new world, come on, without prejudice, will anything be good?

### Version Reference

Right now, there are twoo artifacts available:

* vertx-jspare
* vertx-jspare-web

| vert.x | jspare-core | vertx-jspare |
|--------|-------------|--------------|
| 3.3.3  | 2.0.1       | 1.0.0        |

We are 100% compatible with the entire ecosystem, so do not be afraid!

## vertx-jspare

The vertx-jspare is the implementation for the core of the two worlds, here we talk about:

* Customized Launcher
  * VerxtJspareLauncher extending io.vertx.core.Launcher
  * Boostrap runner for start programatically with cluster support
* Fluent builders with classpath scanner
  * Vertx instance builder
  * Event-bus builder
* CDI with JSpare Environemnt
  * Custom CDI injector to work with vert.
  * Service Proxy support
  * Verticle initializer with CDI support
* Utils
  * Future helpers
  * JsobObjectParser

### Get Started with vertx-jspare

Follow the required dependencies for start with vertx-jspare

#### Maven

```xml
<dependency>
  <groupId>org.jspare.vertx</groupId>
  <artifactId>vertx-jspare</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Gradle

```groovy
dependencies {
    compile "org.jspare.vertx:vertx-jspare:1.0.0"
}
```

### Customized Launcher

#### VerxtJspareLauncher extending io.vertx.core.Launcher

The vert.x Launcher is used in fat jar as main class, and by the vertx command line utility. It executes a set of commands such as run, bare, start...

To extract a better initialization of the two worlds a small customization was created in the launcher to use the class VertxJspareLauncher. You can add the vertx-jspare to your vertx/bin directory and start with one single cli command.

```

Initializing by cli:
vertx-jspare run MyVerticle -conf src/main/conf/conf.json

Intializing by Main class:
org.jspare.vertx.bootstrap.VertxJspareLauncher run MyVerticle -conf src/main/conf/conf.json

```

Packing your fat-jar use the org.jspare.vertx.bootstrap.VertxJspareLauncher like your main class

```
java -jar my-fat-jar.jar
```
**NOTE**: For CLI all the default commands are present, as well as all the functionality of the original Launcher class.

#### Boostrap runner for start programatically with cluster support

An alternative to initialize your application programmatically is extending org.jspare.vertx.bootstrap.VertxRunner as your main class. This class will provide all the options for you to make the bootstrap of your application standalone.


```java
import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.samples.verticle.StartVerticle;
import org.jspare.vertx.utils.VerticleInitializer;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(Bootstrap.class);
	}

	@Override
	public void start() {

		vertx.deployVerticle(VerticleInitializer.initialize(StartVerticle.class), ar -> {
			if(ar.succeeded()){
				
				vertx.eventBus().send("hello", "World!!");
			}
		});
	}
}

```

Note, when the start method is called vertx can already be invoked, this is possible because the container already created an instance of vertx for you. For clustered vertx use org.jspare.vertx.bootstrap.VertxClusteredRunner.

```java
import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxClusteredRunner;
import org.jspare.vertx.builder.ProxyServiceBuilder;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class ClusteredBootstrap extends VertxClusteredRunner{

	public static void main(String[] args) {

		Runner.run(ClusteredBootstrap.class);
	}

	@Override
	public void start() throws Exception {
		
	  	// Scan classpath to create proxy for vertx @Proxygen with @RegisterProxyService
		ProxyServiceBuilder.create(vertx).scanClasspath(true).build();
	}

	@Override
	protected ClusterManager clusterManager() {
		
		return new HazelcastClusterManager();
	}
}
```

For provide vertx instance you can provider your own implementation, just overwrite the method Future<Vertx> vertx();

```java
protected Future<Vertx> vertx() {

		return VertxBuilder.create().build().compose(vertx -> {
			
			vertx.deployVerticle(this);
		}, Future.succeededFuture());
}
```
**NOTE**: You can use jspare builders to help to build your instances, let's see this in sequence.

### Fluent builders with classpath scanner

The framework offers some useful classes for you to create and manipulate some common behaviors of your application, we call builders because we will build and delegate the behavior of the application through them.

#### Vertx instance builder

The class org.jspare.vertx.builder.VertxBuilder offers a building tool to get in the io.vertx.core.Vertx class

The use of it is very basic, we will register in the container some parameters. You can name this instance of vertx through the name(String name) method, or you can add VertxOptions through the options(VertxOptions options). See there is no secret and the final result will be a Future <Vertx>.

```java
@Override
protected Future<Vertx> vertx() {

	return VertxBuilder.create().name("my-vertx-instance")
		.options(new VertxOptions().setMaxEventLoopExecutionTime(60000l))
		.build().compose(vertx -> vertx.deployVerticle(this), Future.succeededFuture());
}
```

#### Event-bus builder

It is possible to define message handler classes of a clear event-bus that this is an item that we will soon see, EventBusBuilder just like VertxBuilder is a utility to help with reading and initializing your application. Its main features are:

* Allow classpath scanner for consumers
* Allow add programatically your controllers
* Allow parse and send quickly messages with event-bus

The eventbus builder will look for your classes that are annotated with the following annotations: @Consumer and @LocalConsumer that follow vertx.consumer() vertx.localConsumer(). Every class scanned with these annotations can be found by the container if this option is available.

```java

// For create new EventBusBuilder vertx parameter are mandatory on fluent constructor.
 // Vertx is mandatory parameter.
EventBusBuilder.create(vertx)

```

You will see that the framework provides a way to integrate with the very practical eventbus. 

### CDI with JSpare Environemnt

The jspare container provides directives so we can perform dependency injection of the vertx core components. The environment has the ability to handle a main instance or derived, this allows at any point of the application you access the vertx.

#### VertxInject

Inject at any point of your application the vertx native features, with vertxInject you have the inversion of control in your hands.

```java
// Inject vertx in your resource or component bellow jspare container
@VertxInject
private Vertx vertx;

```

**Note**: To have the vertx available in the container it is important that your application has been raised by one of vertx-jspare bootstrap mechanisms. (When using VertxJspareLauncher or VertxRunner the container will store the main instance of vertx.)

It is also possible to inject vertx direct resources through VertxInject.

```java
// The Vertx instance
@VertxInject
private Vertx vertx;

// Use directly eventbus
@VertxInject
private EventBus eventBus;

// Inject and create one worker from vertx
@VertxInject
private WorkerExecutor worker;

// Custom shared worker with SharedWokerExecutor annotation
@SharedWorkerExecutor(name = "worker-name", maxExecuteTime = 0l, poolSize = 1l)
@VertxInject
private WorkerExecutor worker;

// The async fileSystem of vertx
@VertxInject
private FileSystem fs;


// The SharedData instance
@VertxInject
private SharedData data;

// The vertx context instance
// Invoke getOrCreateContext method of vertx
@VertxInject
private Context context;

```

Usage sample of EventBus:

```java
// Some resource using jspare dependecy injection
@Resource
public class FooResource {

 @VertxInject
 private EventBus eventbus;

 public void foo(){
   
   eventbus.send("some-eb-address", "some-message");
 }

}
```

#### EventBus

Now we will understand how to optimize the use of some important vertx features, the EventBus.

The event bus is the nervous system of Vert.x.

There is a single event bus instance for every Vert.x instance and it is obtained using the method eventBus.

The event bus allows different parts of your application to communicate with each other irrespective of what language they are written in, and whether they’re in the same Vert.x instance, or in a different Vert.x instance.

Access official documentation for more details:


With vertx-jspare you can create controllers for the eventbus, just annotate a class with the annotation @EventBusController or add directly class to EventBusBuilder (See, builders section of this docs).

What really matters to the control classes, are the methods of addressing, the consumers.

Using only vertx you can access the eventBus and create consumers. 

```java

EventBus eb = vertx.eventBus();
eb.consumer("address", event -> {

});
```

Within a control class, just note the method with @Consumer so that it is registered in the eventbus as an event consumer

```java
@EventBusController
public class Hello {

 @Consumer("address")
 public void helloWorld(Message<String> event) {
   log.debug("Event driven says Hello {}", event.body());
   event.reply("Hello " + event.body());
 }
}

// Sender

vertx.eventBus().send("hello", "world");

// Output on helloWorld method
// --> Hello world
```

#### Service Proxy support

That’s the main purpose of service proxies. It lets you expose a service on the event bus, so, any other vert.x component can consume it, as soon as they know the address on which the service is published.

A service is described with a Java interface containing methods following the async pattern. Behind the hood, messages are sent on the event bus to invoke the service and get the response back. But to make it more easy to use for you, it generates a proxy that you can invoke directly (using the API from the service interface).

The jspare-vertx allow that you create the proxies services using the jspare componentization concepts. Simply create your component interface, its implementation then register it.

##### Service register

Originally:

```java
@ProxyGen
@VertxGen
public interface ProductService {

  String ADDRESS = "service.product";
  
  void findProductById(int id, Handler<AsyncResult<JsonObject>> resultHandler);

}
```

Proxy register handler:

```java

ProductService service = new ProductServiceImpl();
// Register the handler
ProxyHelper.registerService(ProductService.class, vertx, service, ProductService.ADDRESS);
```

With vertx-jspare you need only:

```java
@ProxyGen
@VertxGen
@Component // JSpare container annotation to handle you impl without manual instantiation
@RegisterProxyService(ProductService.ADDRESS) // Register service automatically
public interface ProductService {

  String ADDRESS = "service.product";
  
  void findProductById(int id, Handler<AsyncResult<JsonObject>> resultHandler);

}
```

It`s done, the purpose here is to simplify, in our interface we define that a component is a member of the service proxy and will be available to be consumed.

##### Consuming

Originally:

```java
ProductService service = ProxyHelper.createProxy(ProductService.class, vertx, ProductService.ADDRESS);
```

With container injetio:

```java
@VertxProxyInject
private ProductService service;
```

Using vertx-jspare, VertxProxyInject will inject the proxy service for you.

**Note**: No vertix feature is overwritten with the displayed functions or calls. The expected behavior is the native one by the framework, and there is no impact on the merge of the methodologies.

#### Utils

##### Verticle initializer

To create a verticle using the jspare container internally, use the VerticleInitializer, it takes care of making a call processing the control inversion using the jspare lifecycle.

```java
// Some verticle class
Verticle verticle = VerticleInitializer.initialize(MyVerticleClass.class);

// SOme verticle classname
Verticle verticle = VerticleInitializer.initialize("mypackage.MyVerticleClass");
```

##### Future helpers

In some cases you will need to sequence futures, use the FutureSupplier class for this.

```java
Future<String> future = FutureSupplier.supply(() -> {

 return "future string";
});
```

## vertx-jspare-web

The vertx-jspare-web was made to increase your experience in writing web applications, microservices etc...

* Fluent builders with classpath scanner
  * HttpServer builder
  * Router builder
* Annotated Route mapping
  * Methods
  * Patch
  * Sub Router
  * Handlers
  * Content-Type
  * Handling request paramaters
  * Auth
  * Authorities
  * SockjsHandler
  * Documentation (Raml support)
* Utils
  * Future helpers
  * JsobObjectParser

### Get Started with vertx-jspare-web

Follow the required dependencies for start with vertx-jspare

#### Maven

```xml
<dependency>
  <groupId>org.jspare.vertx</groupId>
  <artifactId>vertx-jspare-web</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Gradle

```groovy
dependencies {
    compile "org.jspare.vertx:vertx-jspare-web:1.0.0"
}
```

### Fluent builders with classpath scanner

#### HttpServer builder

#### Router builder

### Annotated Route mapping

#### Methods

#### Patch

#### Sub Router

#### Handlers

#### Content-Type

#### Handling request paramaters

#### Auth

#### Authorities

#### SockjsHandler

#### Documentation (Raml support

## Examples

* [vertx-jspare samples](https://github.com/jspare-projects/vertx-jspare-samples/) - JSpare Vertx Core samples, including runners, builders, cdi, proxy and vertx functions.
* [vertx-jspare-web samples](https://github.com/jspare-projects/vertx-jspare-web-samples/) - JSpare Vertx Web samples, including builders, web routes, sockjs, auth and others.
* [Complete Microservice Ecossystem ](https://github.com/pflima92/jspare-vertx-ms-blueprint) - Complete Microservice ecossystem with vertx-jspare, including service discovery, circuit breaker, load balance, api-gateway, proxy, inter communication, jdbc, mongo and all vertx-jspare features. Simply unbelievable!!!

## Getting help and Reporting Issues

Having trouble with vertx-jspare? We’d like to help!

* Check the reference documentation at [vertx.jspare.org](http://vertx.jspare.org) — they provide solutions to the most common questions.
* Report bugs and issues at https://github.com/jspare-projects/vertx-jspare/issues

## RoadMap

We are working to improve each times more. Soon more news!

## Feedback

Contact us, send one message to: jspare@jspare.org or pflima92@gmail.com.

## Contributing

Contributions are definitely welcome !

## License

All JSpare projects are Open Source software released under the Apache 2.0 license.
