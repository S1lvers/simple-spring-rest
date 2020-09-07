# Simple spring boot app with crud operations via REST api

## How to run

### Prerequisites: 
- docker
### Launching:
- build docker image with command in project root directory : 
`docker build -t docker/simple-spring-rest .`
- run dockerImage with next command 
`docker run -p 8888:8888 docker/simple-spring-rest .`

## Usage
Swagger enabled for this project so for using it just open the following link in
browser http://localhost:8888/swagger-ui.html
