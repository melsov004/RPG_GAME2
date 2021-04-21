package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int coefficient = RPG_Game.random.nextInt(3) * 5;
            System.out.println("Magic increased damage by " + this.getDamage() * coefficient);
            boss.setHealth(boss.getHealth()-this.getDamage()*coefficient);
        }
    }
}
