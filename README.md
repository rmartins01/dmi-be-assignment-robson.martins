## dmi-be-assignment-robson.martins - Server- Side Development

##How to start service: 
```mvn spring-boot:run``` in dmi-be-assignment-robson.martins folder

##Request Examples

###authentication security
```
security.user.name=usertest
security.user.password=secret
```

### How to add new book
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

### How to update existing book
```
PUT /api/v1/items/200 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{ "author" : "William Cheiquisper", "price" : "13.99", "title" : "Rei Lear" } 
```
###Response:
```
{
    "id": 200,
    "title": "Rei Lear",
    "price": 13.99,
    "link": "/api/v1/items/200",
    "author": "William Cheiquisper",
    "image": "http://assignment.gae.golgek.mobi/static/200.jpg"
}
```

### How to use book detail
```
GET /api/v1/items/7 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```
###Response:
```
{
    "id": 7,
    "title": "Seven is my lucky number",
    "price": 7.77,
    "link": "/api/v1/items/7",
    "author": "Lucy Ascot",
    "image": "http://assignment.gae.golgek.mobi/static/7.jpg"
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
    ...
]
```


### How to find all books with version 2
```
GET /api/v2/items HTTP/1.1
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
        "link": "/api/v1/items/1",
        "author": "Gerald Gierer",
        "image": "http://assignment.gae.golgek.mobi/static/1.jpg"
    },
    {
        "id": 7,
        "title": "Seven is my lucky number",
        "price": 7.77,
        "link": "/api/v1/items/7",
        "author": "Lucy Ascot",
        "image": "http://assignment.gae.golgek.mobi/static/7.jpg"
    },
    ...
```

### How to delete existing book
```
DELETE /api/v1/items/7 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```