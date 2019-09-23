PUT+REQUEST_BODY : 
==> Necessité de connaitre l'état courant de la commande pour la modifier, cmdLine par cmdLine.


{
    "id": 8,
    "purchaseDate": null,
    "commandLine": [
        {
            "id": 1,
            "quantities": 12,
            "product": {
                "id": 1,
                "name": "Papier cul",
                "supplier": "Tasoeur",
                "retailPrice": 10,
                "stock": 50,
                "category": "QUOTIDIEN",
                "itemType": "SMARTPHONE"
            }
        },
        {
            "quantities": 10,
            "product": {
                "id": 3
            }
        },
        {
            "quantities": 9,
            "product": {
                "id": 9
            }
        }
    ],
    "customer": {
        "id": 1,
        "login": "Tag",
        "firstName": "Tag",
        "lastName": "Tag",
        "street": "Tag",
        "streetNumber": 1,
        "dOB": null,
        "password": "Tag",
        "city": "Tag",
        "country": "Tag",
        "zipCode": "20150",
        "eMail": "Tag"
    }
}

RESPONSE : 

{
    "id": 8,
    "purchaseDate": null,
    "commandLine": [
        {
            "id": 1,
            "quantities": 12,
            "product": {
                "id": 1,
                "name": "Papier cul",
                "supplier": "Tasoeur",
                "retailPrice": 10,
                "stock": 50,
                "category": "QUOTIDIEN",
                "itemType": "SMARTPHONE"
            }
        },
        {
            "id": 3,
            "quantities": 10,
            "product": {
                "id": 3,
                "name": "Papier cul",
                "supplier": "Tasoeur",
                "retailPrice": 10,
                "stock": 50,
                "category": "QUOTIDIEN",
                "itemType": "SMARTPHONE"
            }
        },
        {
            "id": 4,
            "quantities": 9,
            "product": {
                "id": 9,
                "name": "Papier cul",
                "supplier": "Tasoeur",
                "retailPrice": 10,
                "stock": 50,
                "category": "QUOTIDIEN",
                "itemType": "SMARTPHONE"
            }
        }
    ],
    "customer": {
        "id": 1,
        "login": "Tag",
        "firstName": "Tag",
        "lastName": "Tag",
        "street": "Tag",
        "streetNumber": 1,
        "dOB": null,
        "password": "Tag",
        "city": "Tag",
        "country": "Tag",
        "zipCode": "20150",
        "eMail": "Tag"
    }
}