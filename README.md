# Tic-Tac-Toe-Game-using-AI
A GUI-based Tic-tac-toe game in Java with three different playing modes: Single Player, Multi Player and Impossible Mode, created using NetBeans IDE

The AI in the impossible mode of the game cannot be defeated. I have used Minimax algorithm with some optimization to implement this game. The minimax algorithm is a backtracking algorithm that is used to find the optimal move for a player. In Minimax, there is a maximizer and a minimizer. The maximizer tries to get a score as negative as possible while the maximizer as positive as possible.

The optimization technique we apply is:
Assume that there are multiple ways for a player to win the game from a given board state. A smarter AI should select the move which results in a quicker win (or slower loss). We therefore consider an extra argument (depth). We subtract this depth from the maximizer and choose the move with the greatest score of all optimal moves. Similarly, we add depth to the minimzer. 

# My version of the game supports three playing modes
In this game, I have added three playing modes:
1. Multiplayer where two people can play
2. Single Player (Normal Mode) where the CPU plays a random move
3. Single Player (Impossible Mode) where the CPU plays the most optimal move

# What inspired me to take the project
Google's Tic-Tac-Toe game which can be played in search

# My experiences with the project
It was a interesting basic project to start with. I learned basic usage of some Java Swing components and basic AI needed to create this game. 

# Things that can be done to improve the efficiency of the project
The Minimax algorithm is a bit slower as it also evaluates moves that are not going to produce the desired results. As there are less moves to evaluate in Tic-tac-toe, this is not too much of a concern. But for larger games like Chess with 64 postions, this algorithm turns out to be slow. An imrovement over the algorithm is Minimax along with Alpha-Beta Pruning to prevent evaluation of redundant cases.
