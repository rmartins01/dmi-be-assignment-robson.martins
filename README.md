# dmi-be-assignment-robson.martins - Server- Side Development

##How to start service: 
1º in console, go to dmi-be-assignment-robson.martins folder
2º ```mvn spring-boot:run``` 


##Request Examples

### How to create
```
POST /api/v1/items HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{ "author" : "William Cheiquisper", "price" : "12.55", "title" : "Hamlet" } 
```
###Response:
```
{
    "id": 203,
    "title": "Hamlet",
    "price": 12.55,
    "link": "/api/v1/items/203",
    "author": "William Cheiquisper",
    "image": "http://assignment.gae.golgek.mobi/static/203.jpg"
}
```

### How to update
```
PUT /api/v1/items/200 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{ "author" : "WAAAAAAam Cheiquisper", "price" : "15.99", "title" : "Hamlet" } 
```
##Response:
```{
    "id": 200,
    "title": "Hamlet",
    "price": 12.55,
    "link": "/api/v1/items/200",
    "author": "WAAAAAAam Cheiquisper",
    "image": "http://assignment.gae.golgek.mobi/static/200.jpg"
}```