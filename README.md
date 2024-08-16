## Maze solver
Oh no! Bowser has Princess Peach! You must navigate the castle, defeat Bowser first and then rescue
the Princess while avoiding any hazards.
## Input format:
The first line will contain an integer N (3<= N<= 100) that denotes the size of the matrix
Followed by an NxN grid. The Princess will be shown as a 'p', Bowser will be shown as a 'b',
the unnamed hero will be shown as an 'm'. '*' spaces are hazards and '-' spaces are clear to move into.
## Output format:
The moves can be printed out to standard out and human readable, however you want to represent
them.
There are 4 valid moves, LEFT, RIGHT, UP, and DOWN
## Task:
The input will come from STDIN(this will require reading in N+1 lines
from STDIN), and the output should be print to STDOUT. Use OOP with
Java 8 to defeat Bowser and rescue the Princess in the fewest number
of moves.
### Sample Input:
```
7
-----p-
-*****-
--*----
**-----
-------
-******
--m----
```
### Sample Output:
```
LEFT, LEFT, UP, UP, RIGHT, RIGHT, UP, UP, RIGHT, RIGHT, RIGHT,
RIGHT, UP, UP, LEFT
```
### Required
JDK 1.8 or later,
Maven 3.2+

###
Build:
```mvn clean package```

###
Run unit tests: 
```mvn clean test```

###
Run:  ```java -jar target/game-1.0-SNAPSHOT.jar```
