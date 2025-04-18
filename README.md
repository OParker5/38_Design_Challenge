# 38_Design_Challenge
Assignment 1 for CPRE 4160

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

## Overview
Gaming: A Character base class with Warrior and Mage subclass, an Attackable interface.

This project is a Java based simulation of a simple role playing game system which demonstrates core object-oriented programming (OOP) concepts. It models characters, enemies, and their interactions, such as attacking, taking damage, and calculating damage. The project is designed to show the principles like inheritance, polymorphism, encapsulation, and abstraction, as well as concepts like interfaces, method overloading, method overriding, and coupling.


## Classes

### Character
1. Fields: `String name` and `int health` are protected.
2. Constructor: Initializes `name` and `health`.
3. Abstract Method: `int attack()`: An abstract method that must be implemented by subclasses. It represents an attack action and returns the damage dealt.

### Warrior
This is a subclass of `Character`. It extends `Character` and defines a class named `Warrior` that inherits from the `Character` class.

### Mage
This is a subclass of `Character`. It extends `Character` and defines a class named `Mage` that inherits from the `Character` class.

### Rogue
This is a subclass of `Character`. It extends `Character` and defines a class named `Rogue` that inherits from the `Character` class.

### Barbarian
This is a subclass of `Character`. It extends `Character` and defines a class named `Barbarian` that inherits from the `Character` class.

### Sorcerer
This is a subclass of `Character`. It extends `Character` and defines a class named `Sorcerer` that inherits from the `Character` class.

## Interfaces

### Attackable
An interface that defines the `takeDamage` method.

## Examples

### Data Coupling
Data coupling occurs when only the necessary data is passed to a method. In this example, the `healCharacter` method takes an integer `healAmount` as an argument, representing the amount of healing to be applied.

```java
class DataCouplingExample {
    public void healCharacter(int healAmount) {  // Primitive data passed
        System.out.println("Character healed by " + healAmount + " HP.");
    }
}
```
## Main Class
Main class to test the implementation.


## Test
<img width="661" alt="Screenshot 2025-03-07 at 6 50 36 PM" src="https://github.com/user-attachments/assets/de2f2216-9726-4338-a0e6-6e4b480adb53" />





