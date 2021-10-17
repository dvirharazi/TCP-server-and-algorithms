# TCP-server-and-algorithms

summary:
A server that handles algorithmic operations depending on the type of task he was given.
The various operations and client care may be carried out in concurrently.

Four algorithmic tasks:
1.Find the strong connected components including diagonals (concurrently):
input: 2D array of int
output: A list of SCC sort by the size of single SCC.
example:
input-

[1, 0, 0]
[1, 0, 1]
[0, 1, 1]

output- [(0,0), (1,0), (1,2), (2,1), (2,2)]

2.Find the shortest paths between two nodes:
input- 2D array of int (50* 50 is the limit)
output- A list of the shortest paths source node and destination node.
example:
input-

[1, 1, 0]
[1, 0, 1]
[0, 1, 1]

output- [[(0, 0), (1, 0), (2,1), (2,2)], [(0, 0), (0, 1), (1, 2), (2, 2)]]

3.Submarine game (concurrently):
input- 2D array of int
output- number of proper submarine
rules:
1.At least two "1" in vertical.
2.At least two "1" in horizontal.
3.Cannot be two "1" in diagonal unless for both sections 1 and 2 are met.
4.The minimum distance between two submarines is one slot.
example:
input-

[1, 1, 0, 1, 1]
[1, 0, 0, 1, 1]
[1, 0, 0, 1, 1]

output- 1
input-

[1, 1, 0, 1, 1]
[0, 0, 0, 1, 1]
[1, 1, 0, 1, 1]

output- 3

4.Find the simplest path between two nodes:
input- 2D array source node and destination node.
output- list of the simplest paths.
example:
input-

[100, 100, 100]
[500, 900, 300]
source node - (1,0)
destination node - (1, 2)

output- [(1, 0), (0, 0), (0, 1), (0, 2), (1, 2)]

Instructions for running the code:
1.download the code.
2.Run the TCPServer first.
3.Enter any key.
4.Run the client (can be multiple).
5.Follow the menu at the program.
6.Enter "stop" at the server to stop the TCP server.
