# sample-vertx-start-with-micrometer
Using micrometer metrics in Vertx sample "starter" application (https://github.com/vert-x3/vertx-maven-starter)

MyLauncher.java - configures Vertx to use MicrometerMetricsOptions

Routes:
/metrics - returns getMetricsSnapshot for vertx 
