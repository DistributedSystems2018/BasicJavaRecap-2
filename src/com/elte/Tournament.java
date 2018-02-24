package com.elte;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tournament {
    List<Player> players_;
    List<Match> matches_;

    public Tournament(String[] arguments) {

        this.players_ = new ArrayList<>();
        this.matches_ = new ArrayList<>();
        Queue<Player> auxiliaryQueue = new LinkedList<>();

        int nPlayers = Integer.parseInt(arguments[0]);

        for (int i = 1; i <= nPlayers; i++) {
            Player p = new Player(arguments[i]);
            this.players_.add(p);
            auxiliaryQueue.add(p);
        }

        int threshold = nPlayers + 1;
        for (int i = threshold, round = 1; i < arguments.length; i++){

            // Round increase
            if (i - (threshold) >= nPlayers/(Math.pow(2,round))){
                threshold = i;
                round++;
            }

            Player p1 = auxiliaryQueue.remove();
            Player p2 = auxiliaryQueue.remove();

            if (arguments[i] == "1"){
                matches_.add(new Match(p1,p2,  round, i == arguments.length - 1 ));
                auxiliaryQueue.add(p1);
            }else{
                matches_.add(new Match(p2,p1,  round, i == arguments.length - 1 ));
                auxiliaryQueue.add(p2);
            }
        }
    }

    public void printMatches(){
        for (Match match: matches_) {
            System.out.println(match);
        }
    }
}
