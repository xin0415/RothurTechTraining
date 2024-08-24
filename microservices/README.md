https://www.youtube.com/watch?v=irBEdp7XlSQ&list=PLVz2XdJiJQxz3L2Onpxbel6r72IDdWrJh&index=2
https://github.com/Java-Techie-jt
# Eureka Example
/services
Amazon-server
 * DevTools
 * Eureka Server
 * Web
 * add @EnableEurekaServer in main application

Provider:
payment-service
 * Eureka Discovery client
 * DevTools
 * Web
 * add @EnableEurekaClient in main application    - don't need to new version

Client:
amazon-shopping
* Eureka Discovery client
* DevTools
* Web
* add @EnableEurekaClient in main application    - don't need to new version

# Config Server
insurance-provider
 * DevTools
 * Web
insurance-config-server
 * DevTools
 * Web
 * Config Server
 * Actuator
 * add @EnableConfigServer in main application
insurance-client
 * DevTools
 * Web
 * Config Server

# Ribbon - Load balance
chatbook
 * Web
user-api
 * DevTools
 * Web
 * Ribbon
 * add @RibbonClient

# Feign
/feignproject
 * OpenFeign
 * DevTools
 * Lombok
 * Web

# Sleuth & Zipkin
/zipkin
payment-service
 * Web
 * Sleuth
zipkin-server
 * zipkin
 * add @EnableZipkinServer in main application

# API Gateway
spring-cloud-zuul-master used to setup API gateway - Zuul used for API gateway - setup the routes and redirect to the service to execute request

# centralize configuration
spring-cloud-consul-master used to centralize configuration

# Okata | OAuth 2.0
/oauth2
/spring-boot-okta-sso
 * Spring Security
 * Okta
 * Spring Web Starter
 * Cloud OAuth 2

# Spring Cloud Function
spring-cloud-function-example-master
is the case to use Function, Supplier, Consumer, predicate
after run the spring boot application, run the command under spring-cloud-function-example folder
curl -H "Content-Type: text/plain" localhost: 8080/reverse -d anystring
curl -H "Content-Type: application/json" localhost: 8080/getBook
curl -H "Content-Type: text/plain" localhost: 8080/printMessage -d Welcome-to-anystring

# spring cloud task
implements CommandLineRunner, TaskExecutionListener, @BeforeTask, @AfterTask, @FailedTask
spring-cloud-task-example-master

# spring cloud consul
cloud-consul-service-discovery-master
greeting-service
 * Web
 * Consul Discovery
user-service
 * Web
 * Consul Discovery
 * add @EnableDiscoveryClient in main application

# Circuit Break using Hystrix, Pivotal Cloud Foundry
circuit-breaker-pcf-master
pivotal web service provide UI to see circuit break status
circuit-break-pcf
 * Circuit Breaker Client (PCF)
 * Security
 * Web

# Cloud Config Server in Pivotal Cloud Foundry
cloud-config-pivotal-cloud-foundry-master
cloud-config-pcf
 * Actuator
 * Config Client (PCF)
 * Security
 * Web

# Service Discovery with Eureka in Pivotal Cloud Foundry
pcf-service-registry-master
service-registry-pcf
 * Service Registry Client (PCF)

# Spring Cloud Stream With Apache kafka Binder
spring-cloud-stream-example-master

# Spring Cloud Data Flow | Microservice Stream Processing
spring-cloud-data-flow-example-master