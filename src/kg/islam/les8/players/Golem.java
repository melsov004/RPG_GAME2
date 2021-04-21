package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.DAMAGE_ABSORPTION);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                heroes[i].setHealth((heroes[i].getHealth() + (boss.getDamage() /5)));
            }
        }

    }
}
