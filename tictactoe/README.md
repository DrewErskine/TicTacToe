# Tic-Tac-Toe in Scala

A simple console-based Tic-Tac-Toe game written in Scala, utilizing functional programming principles to provide an interactive and enjoyable gaming experience.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Running the Game](#running-the-game)
- [Project Structure](#project-structure)
- [Development Guide](#development-guide)

## Introduction

Tic-Tac-Toe is a well-known game that challenges two players to place their respective marks on a 3x3 grid in an attempt to align three marks in a row, column, or diagonal. This Scala implementation strives to create a user-friendly console application that leverages Scala's powerful features for an efficient and elegant solution.

## Prerequisites

Before running the game, make sure you have the following installed:
- Scala build tool (SBT) version: Specify your SBT version here
- Scala version: Specify your Scala version here, preferably Scala 3.x
- Java version: Java 11 or above is required

...

## Running the Game

Interact with the game through the console following the on-screen instructions.

## Project Structure

The project is organized as follows:

- **build.sbt**: Contains build settings and project dependencies.
- **/src/main/scala**:
  - **Tictactoe.scala**: Orchestration of the game loop and handling game states.
  - **Board.scala**: Handling the game board's state, including displaying the board, placing marks, and checking for game end conditions.
  - **Player.scala**: Defining player behavior, including making moves.
  - **GameStatus.scala**: Enumeration of game states to determine the current status of the game.
- **/src/test/scala**:
  - **TictactoeSpec.scala**: Unit tests for the game logic and rules.
  - Additional test files as needed for thorough testing of your application.
