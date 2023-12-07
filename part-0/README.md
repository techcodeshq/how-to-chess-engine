# Part 0: Project Setup and Utility Code

A program that is able to play chess (and is good at it!) with you… where do we even start?

## Major Concept 0: Abstraction

Think about the last time you made a sandwich (or just imagine it if you have never made a sandwich) - how do you start making a sandwich? Obviously you’d say something along the lines of “grab two slices of bread, [...sandwich materials…] from the fridge, a knife, and something to contain my sandwich.” You wouldn’t start by saying something like “go to the farm and grab some [...raw sandwich materials…]” when you have all the materials pre-made and neatly stocked in your fridge/pantry ([weeeeee](https://www.youtube.com/watch?v=URvWSsAgtJE)). Or in other words, you have a bunch of pre-made things stocked up so you don’t need to worry about making them. This makes making sandwiches for you – a novice sandwich maker – much easier, as you don’t have to worry about making bread, farming lettuce, and making cheese.

Software works the same way - everything is built upon existing pre-made software (often called libraries). Software engineers write libraries so that in the future, other people (and themselves) don’t need to worry about how the underlying code works. Some examples are:

1. print(“Hello world”) in Python: You don’t code by pushing 1s and 0s into your computer. Printing something to the screen also takes a lot of steps. Python (and literally every other programming language) hides away the intrinsic details of the computer so we, programmers, can solve actual problems.
2. The internet: … is very complicated. Every time your computer wants to communicate with another computer, it needs to serialize data, break it apart, turn something on and off a bunch of times really really quickly, and like a million other things it needs to do. However, if you ever played with the internet (e.g. with HTTP APIs or servers), you don’t need to know all the details! People before you give you building blocks (for example, Python’s requests module) so you don’t need to be an expert on computer networking to make a simple HTTP request. [article on how (a bit) of internet routing works](https://how-did-i-get-here.net/)

This is abstraction: the process of hiding away intrinsic details in favor of a more simpler and generalized public interface. (Or sandwich terms: people making sandwiches shouldn’t need to worry about farming grain.)

Programmers also choose to make abstractions for themselves. Why?

1. It makes their code simpler to understand.
2. Other programmers (and themselves) can pick up their code.

The abstractions in your code can take the form of functions, classes, interfaces, etc.. Anything that hides away unnecessary detail from the outside is an abstraction.

In this part of the chess engine series, you’ll be writing some abstractions for yourself that represent a chess game.

## THE CODE

The templates are in the `python` and `java` directories. You may use your own language if you want but you’ll need to translate the templates over if you want to follow along with the tutorial. I set up unit testing (see below!!!), which can be ran by running with `test` as the first argument.

I would tackle it in this order:

1. `piece.py` or `Piece.java`
2. `location.py` or `Location.java`
3. `board.py` or `Board.java`

### Major Concept 1: Unit Testing

Unit testing is the process of testing small units of code (e.g. functions, classes, etc..) to make sure they work as intended. This is important because it allows you to test your code without having to run the entire program. This is especially important for chess engines because you’ll be writing a lot of code and you’ll want to make sure that your code works as you write it.

In this project, I made a super-duper simple unit testing framework for you to use. It’s not the best unit testing framework out there but it’s good enough for our purposes. You can find it in `PrimitiveTestingFramework.java` or `primitive_testing_framework.py`. It only has two functions to check if two values are equal or if a value is true. See the main files for example usage.

### [1] 10x12 Board

> "A chess board is 8x8, why is this board list 10x12?"

We have 2 extra rows of "padding" (invalid squares) on the top and bottom of the board and an extra column of padding on the left and right of the board. This makes the normally 8-tall rows turn to 12 rows and 8-wide columns turn to 10 columns.

We do this so we can easily detect if a piece moves out of the board (_hint hint the invalid columns mod a number and the numbers must be within a certain range_).

[this article](https://www.chessprogramming.org/10x12_Board) on the chess programming wiki has more information.
