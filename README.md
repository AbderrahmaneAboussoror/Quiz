
# Quizz

Quizz is a learning platform to help students pass quizzes easily, provided by their trainers.


## API Documentaion

#### Get all subjects

```
  GET /api/subject
```

**Response**
```json
    "subjects": [
        {
            "id": 1,
            "title": "first subject",
            "parentSubject": null,
            "children": [
                {
                    "id": 2,
                    "title": "second subject",
                    "parentId": 1,
                    "parent": {
                        "id": 1,
                        "title": "first subject",
                        "parentId": 0,
                        "parent": null
                    }
                }
            ],
            "questions": []
        },
        {
            "id": 2,
            "title": "second subject",
            "parentSubject": {
                "id": 1,
                "title": "first subject",
                "parentSubject": null,
                "children": [
                    {
                        "id": 2,
                        "title": "second subject",
                        "parentId": 1,
                        "parent": {
                            "id": 1,
                            "title": "first subject",
                            "parentId": 0,
                            "parent": null
                        }
                    }
                ],
                "questions": []
            },
            "children": [],
            "questions": []
        }
    ]
```

#### Get one subject

```
  GET /api/subject/${id}
```

Note that the subject id is **Required**

**Response**
```json
"subject": {
            "id": 2,
            "title": "second subject",
            "parentSubject": {
                "id": 1,
                "title": "first subject",
                "parentSubject": null,
                "children": [
                    {
                        "id": 2,
                        "title": "second subject",
                        "parentId": 1,
                        "parent": {
                            "id": 1,
                            "title": "first subject",
                            "parentId": 0,
                            "parent": null
                        }
                    }
                ],
                "questions": []
            },
            "children": [],
            "questions": []
        }
```

#### Create subject

```
  POST /api/subject
```
Note that the subject id is **Required** except the *parentID*

**Payload**
```json
{
    "title" : "second subject",
    "parentId" : 1,
    "children" : [],
    "questions" : []
}
```

**Response**
```json
"subject": {
        "id": 2,
        "title": "second subject",
        "parentSubject": {
            "id": 1,
            "title": "first subject",
            "parentSubject": null,
            "children": [],
            "questions": []
        },
        "children": null,
        "questions": null
    },
"message": "subject created successfully"
```

#### Update subject

```
  PUT /api/subject/${id}
```

Note that the subject id is **Required** except the *parentID*

**Payload**
```json
{
    "title" : "second subject but updated",
    "parentId" : 1,
    "children" : [],
    "questions" : []
}
```

**Response**
```json
{
    "subject": {
        "id": 2,
        "title": "second subject",
        "parentSubject": {
            "id": 1,
            "title": "first subject",
            "parentSubject": null,
            "children": [],
            "questions": []
        },
        "children": null,
        "questions": null
    },
    "message": "subject updated successfully"
}
```

#### Delete subject

```
  DELETE /api/subject/${id}
```
Note that the subject id is **Required**

**Response**
```
"message": "subject deleted successfully"
```

