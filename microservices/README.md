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

spring-cloud-zuul-master used to setup API gateway - Zuul used for API gateway - setup the routes and redirect to the service to execute request
spring-cloud-consul-master used to centralize configuration

# Okata | OAuth 2.0
/oauth2
aa
 * Spring Security
 * Okta
 * Spring Web Starter
 * Cloud OAuth 2