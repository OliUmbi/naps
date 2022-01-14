# naps

Node, Angular, Postgresql, Spring

## setup

### database

Tested with Postgresql version 14.

Setup files are in the folder `docs/db`. Changes to the db should be documented immediately.

Login credentials are defined in `application.properties`

``` 
spring.datasource.username=postgres
spring.datasource.password=root	
```

## documentation

### api

Api documentation is found under [localhost:8080/docs](http://localhost:8080/docs)

### auth

The auth protocol is oAuth3.0 (it stands for `Oli Authentication 3.0`). Login steps:

1. login under `POST /security/token` with admin@admin.ch and test
2. use generated access token to authenticate with header `auth`
3. refresh your token under `PUT /security/token` with refresh token
4. crud operations for account are found under `/security/account`

## code style

ask oli

## todo

- [X] breaking prod
- [x] api implementation
- [x] angular auth
- [x] shenanigans
- [x] jobs
- [x] logging
- [ ] naming + structure
- [ ] websockets
- [ ] api docs + health + actuator
