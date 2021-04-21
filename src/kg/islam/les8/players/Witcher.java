package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Witcher extends Hero{
    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.CHANCE_TO_REVIVE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()<=0){
                heroes[i].setHealth(heroes[i].getHealth() + heroes[6].getHealth());
                heroes[6].setHealth(0);
                System.out.println("Witcher gived his health for " + heroes[i].getClass().getSimpleName());
            }
        }
    }
}
