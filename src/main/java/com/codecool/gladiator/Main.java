package com.codecool.gladiator;

import com.codecool.gladiator.controller.Tournament;
import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.model.gladiators.GladiatorFactory;
import com.codecool.gladiator.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        GladiatorFactory test = new GladiatorFactory("Names.txt");
        System.out.println(test.getRandomName());
        Tournament tournament = new Tournament(new ConsoleView(), new GladiatorFactory("Names.txt"));
        tournament.welcomeAndAskForStages();
        tournament.runSimulation();
    }

}
