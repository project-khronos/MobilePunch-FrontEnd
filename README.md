# Project Kronos - FrontEnd
A repository for hosting the front end of mobile punch.

## Motivation
* Project management and event tracking all in one place

* Accessable up to date logs

* Quick and easy to use interface

* Accurate and with you all the time

## Project Kronos Team Members
* Alex Benedict - Database and OAuth2 

* Travis Decker - Retrofit, database, and Google maps implementation

* JR O'Grady - Styling, database, and UI interaction

* Eve Robles - UI and documentation

## Accessible Server
  https://straylense.space/projectkhronos
  
## External Services Used
* Google Sign In
* Google Maps API

## Stretch Goals
* Integrating reminders for future tasks
* Multi-user interactions(sharing projects and events)
* Report generation
* Investigate adding Permissioned Blockchain backend to store project and events in an immutable distributed ledger with COW-    semantics to allow for trustless time tracking

## [WireFrames](capstonewireframes.pdf)

## [User Story](UserStory.md)

## [ERD](DetailedERD.pdf)

## [DDL](ddl.sql)

## Functional inventory
  So far, everything is completely functional. You can save an event, project, client, or equipment to the database on your device. You can successfully link clients to projects, and equipment to events. If you restart your app with an empty database and sign back in. You will notice that any data you had previously had will be reinserted into your database to match the records that it is known to have for a given user on the back end. That covers the main goal of the app. Project Khronos would like to implement a working mapview into the event section to enable current geolocation tracking (as we had difficulty getting the API keys to work), as well as an ability to delete and update data. We would also like to add an option to delete an account and to be able to invite other people. These are implementations that we have been working towards, but have not yet integrated. 
  
## Licenses
[Project Khronos](LICENSE)

[Retrofit](https://libraries.io/github/square/retrofit)

[GSON](https://github.com/google/gson/blob/master/LICENSE)

[Stetho](https://github.com/facebook/stetho/blob/master/LICENSE)
