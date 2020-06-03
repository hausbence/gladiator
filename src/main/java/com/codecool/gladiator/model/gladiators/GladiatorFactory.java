package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class GladiatorFactory {

    private List<String> names;

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileOfNames).getFile());
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    public String getRandomName() {
        RandomUtils rand = new RandomUtils();
        int randomIndex = rand.nextInt(names.size());
        return names.get(randomIndex);
    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        int low = 25;
        int high = 100;

        RandomUtils random = new RandomUtils();

        int SwitchNumber = random.nextInt(5) + 1;
        int levelNumber = random.nextInt(5 - 1) + 1;
        int BaseHP = random.nextInt(high-low) + low;
        int BaseSP = random.nextInt(high-low) + low;
        int BaseDex = random.nextInt(high-low) + low;

        switch (SwitchNumber){
            case 1:
                return new Brutal(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
            case 2:
                return new Archer(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
            case 3:
                return new Assassin(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
            case 4:
                return new Swordsman(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
            case 5:
                return new Swordsman(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
        }
        return new Brutal(getRandomName(), BaseHP, BaseSP, BaseDex, levelNumber);
    }
}
