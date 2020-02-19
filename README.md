# minesweeper-API

API for Deviget Code Test. [Instructions](CHALLENGE.md)

## LocalRunning

#### with Docker Compose

`docker-compose up`

#### with docker (mongodb running needed)

`docker build -t minesweeper .`

`docker run minesweeper -p 8080:8080`

#### with gradle (mongodb running needed)

`./gradlew bootRun`


## Public site

### Swagger
https://jordan-minesweeper.herokuapp.com/swagger-ui.html

### TODO

- Detect when yo win the game
- Add error responses when trying to flag or reveal cell when game is over 

### Notes

- The API is not completely RESTful to be easy to use the game directly without frontend
- The API is deployed with heroku, and use a Mongo Atlas db