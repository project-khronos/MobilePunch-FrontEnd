# Project Kronos - Front End
A repository for hosting the front end of Project Kronos.

## Motivation
* Project management and event tracking all in one place

* Accessable up to date logs

* Quick and easy to use interface

* Accurate and with you all the time

<a name="function"></a>

## Functional Inventory
  So far, everything is completely functional. You can save an event, project, client, or equipment to the database on your device. You can successfully link clients to projects, and equipment to events. If you restart your app with an empty database and sign back in. You will notice that any data you had previously had will be reinserted into your database to match the records that it is known to have for a given user on the back end. That covers the main goal of the app. Project Khronos would like to implement a working mapview into the event section to enable current geolocation tracking (as we had difficulty getting the API keys to work), as well as an ability to delete and update data. We would also like to add an option to delete an account and to be able to invite other people. These are implementations that we have been working towards, but have not yet integrated. 

## Project Kronos Team Members
* Alex Benedict - Database and OAuth2 

* Travis Decker - Retrofit, database, and Google maps implementation

* JR O'Grady - Styling, database, and UI interaction

* Eve Robles - UI and documentation

## Accessible Server Endpoints
  https://straylense.space/projectkhronos
* /clients
* /clients/{clientId}
* /clients/{clientId}/projects
* /equipment
* /equipment/{equipmentId}
* /events/{eventId}
* /events/{eventId}/equipment
* /projects
* /projects/{projectId}
* /projects/{projectId}/clients
* /projects/{projectId}/events

## Current State
Project Khronos is still in the development stage with a few things being added as we go. Our main focus is to ensure user satisfaction and maintain consistency within the app. We are definetly open to suggestions and any requests can be sent to [Project Khronos email here]. As for functionality [click here](#function) for a fairly current answer. Main points and known bugs would be:

##### Future Elements
* Implement working map 
* Make UI easier to navigate possibly using the "two click" rule
* Add a project field along with displaying all attributes of an event in the recycler view

##### Known Bugs
* When clicking date picker rapidly, it will crash due to an instance of the widget already being open



## List of Platforms
* Java 1.8
* Android SDK 28
* Emulator Nexus 5X API 27
* Orientation is restricted to portrait

## Third Party Libraries
* Squareup.retrofit2:retrofit:2.4.0
* Google.code.gson:gson:2.8.5'
* Google.android.gms:play-services-auth:16.0.1
* Facebook.stetho:stetho:1.5.0
* Google.android.gms:play-services-maps:16.0.0
* Google.android.gms:play-services-location:16.0.0


## External Services Used
* Google Sign In
* Google Maps API

## Client Side Components Improvements
Project Khronos has many complex and in our opinion, beautiful, widgets, textfields, and UI interactives as a whole. However, we do feel that there could be improvements. We do feel that the color scheme does fit most of the needs of the clients, but there could be a little more diversity and creativity within the app. Some subtle, yet effective enhancements would include:

* Better transistions between fragements
* More customization within the ammount of available colors
* Allow users to scale UI for work with gloves
* Add a more responsive UI to notify the user of successful additions to the database

## Stretch Goals
* Integrating reminders for future tasks
* Multi-user interactions(sharing projects and events)
* Report generation
* Investigate adding Permissioned Blockchain backend to store project and events in an immutable distributed ledger with COW-    semantics to allow for trustless time tracking


  


## [Wire Frames](capstonewireframes.pdf)

## [User Stories](Userstory.pdf)

## [ERD](DetailedERD.pdf)

## [DDL](ddl.sql)
## [Build Instructions](Build2.pdf)

## [User Instructions]
  
## Licenses

[Project Khronos](LICENSE)

[Retrofit](Stetholicense.pdf)

[GSON](https://github.com/google/gson/blob/master/LICENSE)

[Stetho](https://github.com/facebook/stetho/blob/master/LICENSE)




