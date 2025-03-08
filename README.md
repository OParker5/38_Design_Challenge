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
