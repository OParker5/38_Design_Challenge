# 38_Design_Challenge
Assignment1 for CPRE 4160

## Table of Contents
- [Overview](#overview)
- [Classes](#classes)
  - [Character](#character)
  - [Warrior](#warrior)
  - [Mage](#mage)
  - [Rogue](#rogue)
  - [Barbarian](#barbarian)
  - [Sorcerer](#sorcerer)
- [Interfaces](#interfaces)
  - [Attackable](#attackable)
- [Examples](#examples)
  - [Data Coupling](#data-coupling)
  - [Stamp Coupling](#stamp-coupling)
- [Main Class](#main-class)

## Overview **Gaming: A Character base class with Warrior and Mage subclass, an Attackable interface.**

This project demonstrates the concepts of inheritance, polymorphism, method overloading, method overriding, interfaces, and coupling. In the program the characters attack the enemics and calculate the damage to display the results in dynamically. 


## Classes Structure

### Character
1. Fields: String name and int health is protected.
2. There are two constructors
3. Abstract Method: int attack():
   An abstract method that must be implemented by subclasses. It represents an attack action and returns the damage dealt.

### Warrior
Subclasses inheriting from Character. Calling the constructor of the superclass, which is two variables name and health.

### Mage
Subclasses inheriting from Character. Calling the constructor of the superclass, which is two variables name and health.

### Rogue
Subclasses inheriting from Character. Calling the constructor of the superclass, which is two variables name and health.

### Barbarian
Subclasses inheriting from Character. Calling the constructor of the superclass, which is two variables name and health.

### Sorcerer
Subclasses inheriting from Character. Calling the constructor of the superclass, which is two variables name and health.

## Interfaces

### Attackable
An interface that defines the `takeDamage` method.

## Examples

### Data Coupling
The method takes an integer as an argument, then prints a message indicating the amount of healing the console.

### Stamp Coupling
This method takes a charactor object as an argument and print name and health.

## Main Class
Main class to test the implementation.


## Test
<img width="661" alt="Screenshot 2025-03-07 at 6 50 36 PM" src="https://github.com/user-attachments/assets/de2f2216-9726-4338-a0e6-6e4b480adb53" />

