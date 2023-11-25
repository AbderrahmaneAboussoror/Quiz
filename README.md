
# Quizz

Quizz is a learning platform to help students pass quizzes easily, provided by their trainers.


## API Documentaion

## Question

### Get all questions

```
  GET /api/question
```

**Response**
```json
    "questions": [
        {
            "id": 1,
            "numberOfResponses": 7,
            "numberOfCorrectAnswers": 3,
            "content": "this is the content of the second question but it is updated",
            "typeQuestion": "SINGLE",
            "points": 3.5,
            "subject": {
                "id": 2,
                "title": "second subject",
                "parentId": 1,
                "parent": {
                    "id": 1,
                    "title": "first subject",
                    "parentId": 0,
                    "parent": null
                }
            },
            "level": {
                "id": 1,
                "description": "this is the first description",
                "minPoints": 0.0,
                "maxPoints": 3.0,
                "questions": [
                    {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    }
                ]
            },
            "validationList": [
                {
                    "id": 1,
                    "response": {
                        "id": 1,
                        "content": "this is the first content",
                        "validationList": [
                            {
                                "id": 1,
                                "responseId": 1,
                                "questionId": 1,
                                "points": 5.0
                            }
                        ]
                    },
                    "question": {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    },
                    "points": 5.0,
                    "answerList": []
                }
            ],
            "mediaList": [
                {
                    "id": 1,
                    "url": "this is the second url but updated",
                    "mediaType": "VIDEO",
                    "question": {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    }
                }
            ]
        }
    ]
```

#### Get one question

```
  GET /api/question/${id}
```

Note that the question id is **Required**

**Response**
```json
"question": {
            "id": 1,
            "numberOfResponses": 7,
            "numberOfCorrectAnswers": 3,
            "content": "this is the content of the second question but it is updated",
            "typeQuestion": "SINGLE",
            "points": 3.5,
            "subject": {
                "id": 2,
                "title": "second subject",
                "parentId": 1,
                "parent": {
                    "id": 1,
                    "title": "first subject",
                    "parentId": 0,
                    "parent": null
                }
            },
            "level": {
                "id": 1,
                "description": "this is the first description",
                "minPoints": 0.0,
                "maxPoints": 3.0,
                "questions": [
                    {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    }
                ]
            },
            "validationList": [
                {
                    "id": 1,
                    "response": {
                        "id": 1,
                        "content": "this is the first content",
                        "validationList": [
                            {
                                "id": 1,
                                "responseId": 1,
                                "questionId": 1,
                                "points": 5.0
                            }
                        ]
                    },
                    "question": {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    },
                    "points": 5.0,
                    "answerList": []
                }
            ],
            "mediaList": [
                {
                    "id": 1,
                    "url": "this is the second url but updated",
                    "mediaType": "VIDEO",
                    "question": {
                        "id": 1,
                        "numberOfResponses": 7,
                        "numberOfCorrectAnswers": 3,
                        "content": "this is the content of the second question but it is updated",
                        "typeQuestion": "SINGLE",
                        "points": 3.5,
                        "subjectId": 2,
                        "levelId": 1
                    }
                }
            ]
        }
```

#### Create question

```
  POST /api/question
```

**Payload**
```json
{
    "numberOfResponses" : 7,
    "numberOfCorrectAnswers" : 3,
    "content" : "this is the content of the second question",
    "typeQuestion" : "SINGLE",
    "points" : 3.5,
    "subjectId" : 2,
    "levelId": 1
}   
```

**Response**
```json
"question": {
        "id": 1,
        "numberOfResponses": 7,
        "numberOfCorrectAnswers": 3,
        "content": "this is the content of the second question",
        "typeQuestion": "SINGLE",
        "points": 3.5,
        "subject": {
            "id": 2,
            "title": "second subject",
            "parentId": 1,
            "parent": {
                "id": 1,
                "title": "first subject",
                "parentId": 0,
                "parent": null
            }
        },
        "level": {
            "id": 1,
            "description": "this is the first description",
            "minPoints": 0.0,
            "maxPoints": 3.0,
            "questions": [
                {
                    "id": 1,
                    "numberOfResponses": 7,
                    "numberOfCorrectAnswers": 3,
                    "content": "this is the content of the second question",
                    "typeQuestion": "SINGLE",
                    "points": 3.5,
                    "subjectId": 2,
                    "levelId": 1
                }
            ]
        },
        "validationList": null,
        "mediaList": null
    },
"message": "question created successfully"
```

#### Update question

```
  PUT /api/question/${id}
```

Note that the question id is **Required**

**Payload**
```json
{
    "numberOfResponses" : 7,
    "numberOfCorrectAnswers" : 3,
    "content" : "this is the content of the second question but it is updated",
    "typeQuestion" : "SINGLE",
    "points" : 3.5,
    "subjectId" : 2,
    "levelId": 1
}   
```

**Response**
```json
{
    "question": {
        "id": 1,
        "numberOfResponses": 7,
        "numberOfCorrectAnswers": 3,
        "content": "this is the content of the second question but it is updated",
        "typeQuestion": "SINGLE",
        "points": 3.5,
        "subject": {
            "id": 2,
            "title": "second subject",
            "parentId": 1,
            "parent": {
                "id": 1,
                "title": "first subject",
                "parentId": 0,
                "parent": null
            }
        },
        "level": {
            "id": 1,
            "description": "this is the first description",
            "minPoints": 0.0,
            "maxPoints": 3.0,
            "questions": [
                {
                    "id": 1,
                    "numberOfResponses": 7,
                    "numberOfCorrectAnswers": 3,
                    "content": "this is the content of the second question but it is updated",
                    "typeQuestion": "SINGLE",
                    "points": 3.5,
                    "subjectId": 2,
                    "levelId": 1
                }
            ]
        },
        "validationList": null,
        "mediaList": null
    },
    "message": "question updated successfully"
}
```

#### Delete question

```
  DELETE /api/question/${id}
```
Note that the question id is **Required**

**Response**
```
"message": "question deleted successfully"
```


## Subject

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



## Level

#### Get all levels

```
  GET /api/level
```

**Response**
```json
    "levels": [
        {
            "id": 1,
            "description": "this is the first description",
            "minPoints": 0.0,
            "maxPoints": 3.0,
            "questions": []
        }
    ]
```

#### Get one level

```
  GET /api/level/${id}
```

Note that the level id is **Required**

**Response**
```json
"level": {
            "id": 1,
            "description": "this is the first description",
            "minPoints": 0.0,
            "maxPoints": 3.0,
            "questions": []
        }
```

#### Create level

```
  POST /api/level
```

**Payload**
```json
{
    "description" : "this is the first description",
    "minPoints" : 0,
    "maxPoints" : 3,
    "questions" : []
}
```

**Response**
```json
"level": {
        "id": 1,
        "description": "this is the first description",
        "minPoints": 0.0,
        "maxPoints": 3.0,
        "questions": []
    },
"message": "level created successfully"
```

#### Update level

```
  PUT /api/level/${id}
```

Note that the level id is **Required**

**Payload**
```json
{
    "description" : "this is the first description but updated",
    "minPoints" : 1,
    "maxPoints" : 5,
    "questions" : []
}
```

**Response**
```json
{
    "level": {
        "id": 1,
        "description": "this is the first description but updated",
        "minPoints": 1.0,
        "maxPoints": 5.0,
        "questions": []
    },
    "message": "level created successfully"
}
```

#### Delete level

```
  DELETE /api/level/${id}
```
Note that the level id is **Required**

**Response**
```
"message": "level deleted successfully"
```

