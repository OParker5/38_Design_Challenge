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

## Overview
Gaming: A Character base class with Warrior and Mage subclass, an Attackable interface.

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
Stamp Coupling
Stamp coupling occurs when an entire object is passed to a method, even if only part of the object is used. In this example, the displayCharacter method takes a Character object as an argument and uses its name and health properties.

class StampCouplingExample {
    public void displayCharacter(Character character) {  // Object passed as argument
        System.out.println(character.name + " has " + character.health + " HP.");
    }
}

Main Class
Main class to test the implementation.

Test
<img width="661" alt="Screenshot 2025-03-07 at 6 50 36 PM" src="https://github<vscode_annotation details='%5B%7B%22title%22%3A%22hardcoded-credentials%22%2C%22description%22%3A%22Embedding%20credentials%20in%20source%20code%20risks%20unauthorized%20access%22%7D%5D'>.com</vscode_annotation>/user-attachments/assets/de2f2216-9726-4338-a0e6-6e4b480adb53" /> ```
