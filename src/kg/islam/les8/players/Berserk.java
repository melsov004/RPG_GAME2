package kg.islam.les8.players;

import kg.islam.les8.game.RPG_Game;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() >0){
            System.out.println("Berserk dealt damage " + this.getDamage());
            boss.setHealth(boss.getHealth() - this.getDamage() + (boss.getDamage() - 2/5));
        }
    }
}
