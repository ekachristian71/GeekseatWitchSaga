# Getting Started

### API Url : localhost:8080/villager/result
###Request Method : POST

### Sample request & response

#### 1. Normal Case
Request
```
[
  {
    "villager1": {
        "ageOfDeath": 10,
        "yearOfDeath": 12
    },
    "villager2": {
        "ageOfDeath": 13,
        "yearOfDeath": 17
    }
  }
]
```

Response
```
[
  {
    "villager1": {
        "ageOfDeath": 10,
        "yearOfDeath": 12,
        "totalKilledVillagerPerYear": 2
    },
    "villager2": {
        "ageOfDeath": 13,
        "yearOfDeath": 17,
        "totalKilledVillagerPerYear": 7
    },
    "result": 4.5
  }
]
```

#### 2. Bad Case Null Input

#### Case 1 - AgeOfDeath Null: 

Request
```
[
  {
    "villager1": {
        "ageOfDeath": null,
        "yearOfDeath": 12
    },
    "villager2": {
        "ageOfDeath": 13,
        "yearOfDeath": 17
    }
  }
]
```

Response
```
[
  {
    "villager1": null,
    "villager2": null,
    "result": -1.0
  }
]
```

#### Case 2 - yearOfDeath Null:

Request
```
[
  {
    "villager1": {
        "ageOfDeath": 10,
        "yearOfDeath": null
    },
    "villager2": {
        "ageOfDeath": 13,
        "yearOfDeath": 17
    }
  }
]
```

Response
```
[
  {
    "villager1": null,
    "villager2": null,
    "result": -1.0
  }
]
```

#### Case 3 - All Input Null:

Request
```
[
  {
    "villager1": {
        "ageOfDeath": null,
        "yearOfDeath": null
    },
    "villager2": {
        "ageOfDeath": null,
        "yearOfDeath": null
    }
  }
]
```

Response
```
[
  {
    "villager1": null,
    "villager2": null,
    "result": -1.0
  }
]
```

