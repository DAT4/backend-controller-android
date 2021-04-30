# Controller for the game
This app is a controller for the game developed in the backend course.

The app simply has an XML file with the required buttons and then allowed internet in the manifest file

All the logic og the app comes from the AAR module which is imported as controller

The module is developed in Go and ported to NDK with GoMobile

The module has a Callback interface which is implemented by the MainActivity in the app. 
This is used to print the possible errors which could happen inside the module.

When you play a game you will be looking add the screen so I added a vibration to the buttons so you can feel when you press them.