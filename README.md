# dmi-be-assignment-robson.martins - Server- Side Development

##How to start service: 
in console, go to dmi-be-assignment-robson.martins folder
```mvn spring-boot:run```
 

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
###Response:
```
{
    "id": 200,
    "title": "Hamlet",
    "price": 12.55,
    "link": "/api/v1/items/200",
    "author": "WAAAAAAam Cheiquisper",
    "image": "http://assignment.gae.golgek.mobi/static/200.jpg"
}
```

### How to find all books with version 1
```
GET /api/v1/items HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```
###Response:
```
[
    {
        "id": 1,
        "title": "Enterprise Application Development with Ext JS and Spring",
        "price": 153.55,
        "link": "/api/v1/items/1"
    },
    {
        "id": 7,
        "title": "Seven is my lucky number",
        "price": 7.77,
        "link": "/api/v1/items/7"
    },
    {
        "id": 8,
        "title": "A Dance with Dragons",
        "price": 19.01,
        "link": "/api/v1/items/8"
    },
    {
        "id": 10,
        "title": "Ten ways to a better mind",
        "price": 10,
        "link": "/api/v1/items/10"
    },
    {
        "id": 42,
        "title": "The Hitch-hikers Guide to the Galaxy",
        "price": 5.62,
        "link": "/api/v1/items/42"
    },
    {
        "id": 200,
        "title": "Hamlet",
        "price": 12.55,
        "link": "/api/v1/items/200"
    },
    {
        "id": 201,
        "title": "Book title #201",
        "price": 45,
        "link": "/api/v1/items/201"
    },
    {
        "id": 202,
        "title": "Hamlet",
        "price": 12.55,
        "link": "/api/v1/items/202"
    },
    {
        "id": 203,
        "title": "Hamlet",
        "price": 12.55,
        "link": "/api/v1/items/203"
    }
]
```