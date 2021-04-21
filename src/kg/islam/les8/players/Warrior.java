package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() >0){
            int coefficient = RPG_Game.random.nextInt(3) + 2;
            System.out.println("Warrior hits critically " + this.getDamage() * coefficient);
            boss.setHealth(boss.getHealth() - this.getDamage() * coefficient);
        }
    }
}
