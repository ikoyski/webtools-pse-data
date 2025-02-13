# webtools-pse-data 

This is an wrapper app for getting geo-ip data from a geo-ip provider.

Click on the downloaded Lombok-{version}.jar and select your IDE to install lombok
Restart the IDE after successful Lombok installation

## Pre-commit checks

In Windows run

```
mvnw.cmd clean verify
```

In Linux/MacOs run

```
./mvnw clean verify
```

This should build and run all the tests in the same way as on the continuous integration server.  If the build is successful, you can commit to git and push to Git.

## Run the app

In Windows run

```
cd /path/of/the/project/
mvnw.cmd clean package
java -jar target/*.jar
```
In Linux/MacOs run

```
cd /path/of/the/project/
./mvnw clean package
java -jar target/*.jar
```

## Smoke test services

There is a `/health` endpoint that provides basic information about the application’s health:

```
curl http://localhost:8080/actuator/health
```

The endpoint should display the following.

```
{
    "status": "UP"
}
```

The status will be UP as long as the application is healthy. It will show DOWN if the application gets 
unhealthy due to any issue like connectivity with the database or lack of disk space etc. 

The build and version information can be checked by calling the `/info` endpoint.  This allows checking of the git tags, maven version, build date etc.

```
curl http://localhost:8080/actuator/info
```

This endpoint will return something like the following.

```
{
  "git": {
    "commit": {
      "id": "2028dd7a66f135d2fdb557e03349cc982053f9bd"
    },
    "branch": "master"
  }
}
```

Hit the functional endpoint (**localhost**)

```
curl --location --request GET 'http://localhost:8080/api/v1/ipLocation/8.8.8.8'
```

Hit the functional endpoint (**render**)

```
curl --location --request GET 'https://webtools-pse-data.onrender.com/api/v1/ipLocation/8.8.8.8'
```

This should return something like

```
{
    "query": "8.8.8.8",
    "status": "success",
    "country": "United States",
    "countryCode": "US",
    "region": "VA",
    "regionName": "Virginia",
    "city": "Ashburn",
    "zip": "20149",
    "lat": "39.03",
    "lon": "-77.5",
    "timezone": "America/New_York",
    "isp": "Google LLC",
    "org": "Google Public DNS",
    "as": "AS15169 Google LLC"
}
```

## Configuration file

application.properties

## Swagger / OpenAPI

openapi.yaml

## SonarCloud

https://sonarcloud.io/summary/overall?id=ikoyski_webtools-pse-data
