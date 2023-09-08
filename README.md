## Helmese testtöö backend

## Project description
This is the backend for the "session" based form filling project.\
The backend has 3 main controllers:\
&ensp;&ensp;&ensp;&ensp;SessionContoller
``
Creates and returns a new sessionId
``\
&ensp;&ensp;&ensp;&ensp;SectorController
``
Returns all the sectors for the person to choose from
``\
&ensp;&ensp;&ensp;&ensp;PersonSectorsInfoController
``
Saves users entered info and returns the entered info by sessionId
``


## Project setup
```
create new postgres database "helmes_db"
run project

port: 8090
spring 3.1
Java 17
postgres 15.4
```



### NB!
If you change the frontend's port(default is 7600), then make sure to edit allowed origins in Application.corsConfigurer. 



### Tasks:

1. Correct all the deficiencies in index.html

2. "Sectors" selectbox:

   2.1. Add all the entries from the "Sectors" selectbox to database

   2.2. Compose the "Sectors" selectbox using data from database

3. Perform the following activities after the "Save" button has been pressed:

   3.1. Validate all input data (all fields are mandatory)

   3.2. Store all input data to the database (Name, Sectors, Agree to terms)

   3.3. Refill the form using stored data

   3.4. Allow the user to edit his/her own data during the session