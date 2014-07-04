AndroidPractice
===============

Code Repository for Android Related Code. 
* Week 1
  - HelloAndroid
    * A simple android app analogous to the Hello World App with welcome text changed.
  - TheAnswer
    * A simple android app with logic computing the text to be displayed in a text view centered in a relative layout.
* Week 2
  - MapLocation
    * A simple android app that locates entereed address on map powered by the Google API.
  - MapLocationFromContacts
    * A simple android app that allows you to select a contact from your list of contacts.
    * Further, it shows the address of the contact on a google map in case his/her address has been stored in your phone
  - ActivityLab
    * A simple app that demonstrates the activity lifecycle concept.
    * Two main points are emphasized in this assignment.
      - The RUNNING to pause->stop->restart->start->resume and finally RUNNING cycle in Exercise A 
      - Exercise A is about starting a new Activity(Activity Two) and finsihing it by clicking a button to return to ActivityOne.
      - This leads to the cycle described above (in Activity One). ActivityTwo goes straight in the cycle to destruction.
      - The straight RUNNING to pause->stop->destroy->create->start->resume and finally RUNNING cycle in Exercise B
      - Exercise B is about orientation change and how that affects an activity.
      - Any of the two activities go straight to destruction and are created->started->resumed again. 
      - The results are reflected in view counts.
    * Best way to learn from this assignment is to make two activity lifecycle charts for ActivityOne and ActivityTwo and trace the method calls as they happen
