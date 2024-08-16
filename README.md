## Maze solver
Find shortest sequence of steps from 'm' to 'p', while avoiding any hazards.
### Input format:
The first line will contain an integer N (3<= N<= 100) that denotes the size of the matrix
Followed by an NxN grid; '*' spaces are hazards and '-' spaces are clear to move into.
### Output format:
The moves can be printed out to standard out and human readable.
There are 4 valid moves, LEFT, RIGHT, UP, and DOWN
### Task:
The input will come from STDIN(this will require reading in N+1 lines
from STDIN), and the output should be print to STDOUT. 
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
