# Words Counter Backend

**Words Counter Backend** is the backend side of Words Counter app. The objective is count how many words there are in a text.

The project is made with Kotlin, using Ktor framework.

## Routes

### Count Routes

- `/count` - Count how many words there are in a text, returning the date of the request, and the number of words.

Example body:

```json
{ content: "How many words there are in my sentence?" }
```

Example response:

```
{date: 2023-01-11T22:56:38.585370, number: 8}
```

# Requirements

- OpenJDK 11
- Docker 20.10.22+ (optional)

## Running

### Docker

The app can be run using `lissatransborda/words-counter-backend` image, with the command below:

```shell
docker run -i -p 8081:8081 lissatransborda/words-counter-backend
```

### Gradle

The app can be run with Gradle tasks too, using the `run` task, with the command below:

```shell
./gradlew :run
```

## Testing

The backend has a unit test, that checks if the `/count` POST route is sending the correct number of words.

To test the application, you can use the `test` gradle task, like below:

```shell
./gradlew :test
```

## Build

### Docker

To build the image of the project, use docker build, with the command below:

```shell
docker build -t lissatransborda/wordscounter-backend .
```

### Gradle

To build the JAR file of the project, use shadowjar task, with the command below:

```shell
./gradlew :shadowjar
```