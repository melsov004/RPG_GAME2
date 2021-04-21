package kg.islam.les8.game;

import kg.islam.les8.players.*;

import java.net.http.HttpRequest;
import java.util.Random;

public class RPG_Game {
    private static int roundNumber =0;
    public static Random random = new Random();

    public static void start(){
        Boss boss = new Boss(3500, 90);
        Warrior warrior = new Warrior(250, 20);
        Medic doc = new Medic(220, 10, 15);
        Magic magic = new Magic(270, 25);
        Berserk berserk = new Berserk(260, 15);
        Medic assistant = new Medic(265, 15, 5);
        Thor thor = new Thor(275, 10);
        Witcher witcher = new Witcher(255, 0);
        Golem golem = new Golem(200, 5);

        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor, witcher, golem};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        System.out.println(++roundNumber + " --- ROUND"); // pre-increment
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    heroes[i].getSuperAbility() != SuperAbility.CRITICAL_DAMAGE) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("+++++++++++++++++++++");
        System.out.println("Boss health: " + boss.getHealth() + "  [" +
                boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + "  [" +
                    heroes[i].getDamage() + "]");
        }
    }
}

