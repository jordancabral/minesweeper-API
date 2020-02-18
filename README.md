# minesweeper-API

API for Deviget Code Test. [Instructions](CHALLENGE.md)

## LocalRunning

#### with Docker Compose

`docker-compose up`

#### with docker (mongodb running needed)

`docker build -t minesweeper .`
`docker run minesweeper -p 8080:8080`

#### with gradle (mongodb running needed)

./gradlew bootRun


## Public site

### Swagger
https://jordan-minesweeper.herokuapp.com/swagger-ui.html