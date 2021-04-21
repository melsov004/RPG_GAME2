package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.DEAFEN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coefficient  = RPG_Game.random.nextInt(2);
        if (boss.getHealth() > 0 && coefficient == 1) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 ){
                    heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage() -(boss.getDamage() / 5) );
                }
            }
            System.out.println("Thor stunned Boss " );
        } else {
            System.out.println("Тор облажался");
        }
    }
}
