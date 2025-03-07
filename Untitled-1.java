// Base class demonstrating inheritance
abstract class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    abstract void attack();
}

// Subclasses inheriting from Character
class Warrior extends Character {
    private int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    @Override
    void attack() {
        System.out.println(name + " swings a sword with " + strength + " strength!");
    }
}

class Mage extends Character {
    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    @Override
    void attack() {
        System.out.println(name + " casts a fireball using " + mana + " mana!");
    }
}

// Separate interface
interface Attackable {
    void takeDamage(int damage);
}

// Implementing the interface in the Character class
class Enemy implements Attackable {
    private String type;
    private int health;

    public Enemy(String type, int health) {
        this.type = type;
        this.health = health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(type + " takes " + damage + " damage! Remaining health: " + health);
    }
}

// Demonstrating method overloading (polymorphism)
class DamageCalculator {
    public int calculateDamage(int baseDamage, int strength) {
        return baseDamage + strength;
    }

    public int calculateDamage(int baseDamage, int strength, int bonus) {
        return baseDamage + strength + bonus;
    }
}

// Demonstrating method overriding (polymorphism)
class Berserker extends Warrior {
    public Berserker(String name, int health, int strength) {
        super(name, health, strength);
    }

    @Override
    void attack() {
        System.out.println(name + " enters a rage and attacks with double strength!");
    }
}

// Example of data coupling
class DataCouplingExample {
    public void healCharacter(int healAmount) {  // Primitive data passed
        System.out.println("Character healed by " + healAmount + " points.");
    }
}

// Example of stamp coupling
class StampCouplingExample {
    public void displayCharacter(Character character) {  // Object passed as argument
        System.out.println(character.name + " has " + character.health + " HP.");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Inheritance demonstration
        Warrior warrior = new Warrior("Aragorn", 100, 20);
        Mage mage = new Mage("Gandalf", 80, 50);
        warrior.attack();
        mage.attack();

        // Interface implementation
        Enemy goblin = new Enemy("Goblin", 50);
        goblin.takeDamage(15);

        // Polymorphism examples
        DamageCalculator calculator = new DamageCalculator();
        System.out.println("Damage (normal): " + calculator.calculateDamage(10, 5));
        System.out.println("Damage (bonus): " + calculator.calculateDamage(10, 5, 3));

        Berserker berserker = new Berserker("Guts", 120, 30);
        berserker.attack();

        // Data Coupling
        DataCouplingExample dataCoupling = new DataCouplingExample();
        dataCoupling.healCharacter(25);

        // Stamp Coupling
        StampCouplingExample stampCoupling = new StampCouplingExample();
        stampCoupling.displayCharacter(warrior);
    }
}
