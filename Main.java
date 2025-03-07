// Base class demonstrating inheritance
abstract class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    abstract int attack(); // Attack now returns damage
}

// Subclasses inheriting from Character
class Warrior extends Character {
    private int str; // Strength attribute

    public Warrior(String name, int health, int str) {
        super(name, health);
        this.str = str;
    }

    @Override
    int attack() {
        int damage = str + (int) (Math.random() * 6 + 1); // Strength + d6 roll
        System.out.println(name + " swings a sword for " + damage + " damage!");
        return damage;
    }
}

class Mage extends Character {
    private int intelligence; // Intelligence attribute

    public Mage(String name, int health, int intelligence) {
        super(name, health);
        this.intelligence = intelligence;
    }

    @Override
    int attack() {
        int damage = intelligence + (int) (Math.random() * 8 + 1); // Intelligence + d8 roll
        System.out.println(name + " casts a fireball for " + damage + " damage!");
        return damage;
    }
}


class Rogue extends Character {
    private int dexterity; // Dexterity attribute

    public Rogue(String name, int health, int dexterity) {
        super(name, health);
        this.dexterity = dexterity;
    }

    @Override
    int attack() {
        int damage = dexterity + (int) (Math.random() * 8 + 1); // dexterity + d6 roll
        System.out.println(name + " strikes out with daggers " + damage + " damage!");
        return damage;
    }
}

// Separate interface
interface Attackable {
    void takeDamage(int damage);
}

// Implementing the interface in the Enemy class
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
        System.out.println(type + " takes " + damage + " damage! Remaining health: " + Math.max(health, 0));
    }
}

// Demonstrating method overloading (polymorphism)
class DamageCalculator {
    public int calculateDamage(int baseDamage, int modifier) {
        return baseDamage + modifier;
    }

    public int calculateDamage(int baseDamage, int modifier, int bonus) {
        return baseDamage + modifier + bonus;
    }
}

// Demonstrating method overriding (polymorphism)
class Barbarian extends Warrior {
    public Barbarian(String name, int health, int str) {
        super(name, health, str);
    }

    @Override
    int attack() {
        int damage = (super.attack() + (int) (Math.random() * 4 + 1)); // Extra d4 roll
        System.out.println(name + " rages and deals extra damage!");
        return damage;
    }
}

// Demonstrating method overriding (polymorphism)
class Sorcerer extends Mage {
    public Sorcerer(String name, int health, int mana, int intelligence) {
        super(name, health, mana, intelligence);
    }

    @Override
    int castSpell() {
        int damage = super.castSpell() + (int) (Math.random() * 6 + 1); // Extra d6 roll
        System.out.println(name + " channels chaotic energy and enhances the spell!");
        return damage;
    }
}


// Example of data coupling
class DataCouplingExample {
    public void healCharacter(int healAmount) {  // Primitive data passed
        System.out.println("Character healed by " + healAmount + " HP.");
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
        Warrior warrior = new Warrior("Thogar", 100, 16);
        Mage mage = new Mage("Elric", 80, 18);

        // Interface implementation
        Enemy goblin = new Enemy("Goblin", 50);
        
        // Attacking enemy
        goblin.takeDamage(warrior.attack());
        goblin.takeDamage(mage.attack());

        // Polymorphism examples
        DamageCalculator calculator = new DamageCalculator();
        System.out.println("Damage (normal): " + calculator.calculateDamage(10, 5));
        System.out.println("Damage (bonus): " + calculator.calculateDamage(10, 5, 3));

        Barbarian barbarian = new Barbarian("Grog", 120, 18);
        goblin.takeDamage(barbarian.attack());

        // Data Coupling
        DataCouplingExample dataCoupling = new DataCouplingExample();
        dataCoupling.healCharacter(20);

        // Stamp Coupling
        StampCouplingExample stampCoupling = new StampCouplingExample();
        stampCoupling.displayCharacter(mage);
    }
}
