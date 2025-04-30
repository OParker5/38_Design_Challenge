import java.util.concurrent.ThreadLocalRandom;

/** Anything that can inflict damage. */
interface Combatant {
    Damage attack();
}

/** Anything that can receive damage. */
interface Damageable {
    void takeDamage(Damage dmg);
}

/* Small value-object (immutable) */
record Damage(int amount) { }

abstract sealed class Character
        implements Combatant, Damageable
        permits Warrior, Mage, Rogue, Enemy {

    private final String name;
    private int health;

    protected Character(String name, int health) {
        this.name   = name;
        this.health = health;
    }

    public String  getName()   { return name;   }
    public int     getHealth() { return health; }

    /* common damage-handling */
    @Override
    public final void takeDamage(Damage dmg) {
        health = Math.max(health - dmg.amount(), 0);
        System.out.printf(
            "%s takes %d dmg → %d HP remaining%n",
            name, dmg.amount(), health
        );
        if (health == 0) System.out.printf("%s dies!%n", name);
    }

    /* helper for subclasses */
    protected final Damage roll(int modifier, int dieSides) {
        int amt = modifier + ThreadLocalRandom.current().nextInt(1, dieSides + 1);
        return new Damage(amt);
    }
}

final class Warrior extends Character {
    private final int strength;
    Warrior(String n, int hp, int str) { super(n, hp); this.strength = str; }
    @Override public Damage attack() {
        Damage dmg = roll(strength, 6);
        System.out.printf("%s swings a sword (%d dmg)%n", getName(), dmg.amount());
        return dmg;
    }
}

final class Mage extends Character {
    private final int intelligence;
    Mage(String n, int hp, int intel) { super(n, hp); this.intelligence = intel; }
    @Override public Damage attack() { return castSpell(); }

    Damage castSpell() {
        Damage dmg = roll(intelligence, 10);
        System.out.printf("%s hurls a spell (%d dmg)%n", getName(), dmg.amount());
        return dmg;
    }
}

final class Rogue extends Character {
    private final int dexterity;
    Rogue(String n, int hp, int dex) { super(n, hp); this.dexterity = dex; }
    @Override public Damage attack() {
        Damage dmg = roll(dexterity, 8);
        System.out.printf("%s backstabs (%d dmg)%n", getName(), dmg.amount());
        return dmg;
    }
}

final class Barbarian extends Warrior {
    Barbarian(String n, int hp, int str) { super(n, hp, str); }
    @Override public Damage attack() {
        Damage base = super.attack();                 // polymorphic reuse
        Damage extra = roll(0, 4);                    // extra d4
        int total = base.amount() + extra.amount();
        System.out.printf("%s RAGES for +%d!%n", getName(), extra.amount());
        return new Damage(total);
    }
}

final class Sorcerer extends Mage {
    Sorcerer(String n, int hp, int intel) { super(n, hp, intel); }
    @Override public Damage castSpell() {
        Damage base = super.castSpell();              // reuse
        Damage chaos = roll(0, 6);                    // extra d6
        int total = base.amount() + chaos.amount();
        System.out.printf("%s channels chaos for +%d!%n", getName(), chaos.amount());
        return new Damage(total);
    }
}

final class Enemy extends Character {
    Enemy(String type, int hp) { super(type, hp); }
    @Override public Damage attack() {
        Damage dmg = roll(2, 6);
        System.out.printf("%s claws you (%d dmg)%n", getName(), dmg.amount());
        return dmg;
    }
}

final class Healer {// data coupling (primitive)
    static void heal(Character c, int hp) {
        System.out.printf("%s patched for %d HP%n", c.getName(), hp);
    }
}

final class Inspector {                   // stamp coupling (object)
    static void showStats(Character c) {
        System.out.printf("%s → %d HP%n", c.getName(), c.getHealth());
    }
}

public final class App {
    public static void main(String[] args) {

        Warrior   thogar  = new Warrior("Thogar", 100, 16);
        Mage      elric   = new Mage   ("Elric",  80, 18);
        Rogue     marco   = new Rogue  ("Marco",  75, 20);

        Enemy goblin      = new Enemy  ("Goblin", 50);
        Enemy hobgoblin   = new Enemy  ("Hobgoblin", 100);

        // basic combat
        goblin.takeDamage(thogar.attack());
        goblin.takeDamage(elric.castSpell());
        goblin.takeDamage(marco.attack());

        // polymorphic override demos
        Barbarian grog    = new Barbarian("Grog", 120, 18);
        hobgoblin.takeDamage(grog.attack());

        Sorcerer  vexis   = new Sorcerer ("Vexis", 90, 20);
        hobgoblin.takeDamage(vexis.castSpell());

        // coupling examples
        Healer.heal(thogar, 20);
        Inspector.showStats(elric);
    }
}
