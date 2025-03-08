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


This project demonstrates the key of OOP concepts including inheritance, polymorphism, method overloading, method overriding, interfaces, and coupling. The system allows characters to attack the enemics and calculate the damage to display the results in dynamically. 


## Classes

### Character
Abstract class for the character. Modifier and assigned to refer to the current instance.

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
Example of data coupling.

### Stamp Coupling
Example of stamp coupling.

## Main Class
Main class to test the implementation.
