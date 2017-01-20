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
* [examples](#examples)
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

Right now, there are three artifacts available:

* vertx-core
* vertx-web
* vertx-service-proxy

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

#### Boostrap runner for start programatically with cluster support

### Fluent builders with classpath scanner

#### Vertx instance builder

#### Event-bus builder

### CDI with JSpare Environemnt

#### Custom CDI injector to work with vert.

#### Service Proxy support

#### Verticle initializer with CDI support

### Utils

#### Future helpers

#### JsobObjectParser

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

## RoadMap

## Feedback

Contact us, send one message to: jspare@jspare.org or pflima92@gmail.com.

## Contributing

Contributions are definitely welcome !

## License

All JSpare projects are Open Source software released under the Apache 2.0 license.
