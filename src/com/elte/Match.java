package com.elte;

public class Match {
    Player winner_;
    Player loser_;
    int round_;
    boolean isFinal_;

    public Player getWinner_() {
        return winner_;
    }

    @Override
    public String toString() {
        if (!isFinal_){
            return "round " + round_ + ", players: " + winner_ + " and " + loser_
                    + ", advances: " + winner_ + ", eliminated: " + loser_;
        }else{
            return "round " + round_ + " (final), players: " + winner_ + " and " + loser_
                    + ", champion: " + winner_ + ", finalist: " + loser_;
        }
    }

    public Player getLoser_() {
        return loser_;
    }

    public Match(Player winner, Player loser, int round, boolean isFinal) {
        this.winner_ = winner;
        this.loser_ = loser;
        this.round_ = round;
        this.isFinal_ = isFinal;
    }
}
