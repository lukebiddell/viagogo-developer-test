# viagogo-developer-test
A Java program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event.

## Building
Run the following command from the folder `/src/`.
```
javac main/*.java
```

## Running
Run the following command from the folder `/src/`.
```
java main.Main
```
To use your own seed for generating data, enter a (long) seed as an argument. For example:
```
java main.Main -123456
```

## FAQ
#### Please detail any assumptions you have made
* User enters a valid coordinate in the form `x,y`.

#### How might you change your program if you needed to support multiple events at the same location?
* I would remove the check to see if coordinates already exists in an event when adding a new event.
* Alternatively, I would have coordinates store a list of Events.

#### How would you change your program if you were working with a much larger world size?
* Storing events/coordinates in a set would give extremely poor performance in large world sizes when trying to find the nearest neighbours.
* Instead, I would store them in a quadtree, which would allow for much better performance in searching for the closest events.
