package agh.cs.sejm;

/**
 * Created by Joanna on 2017-01-10.
 */
public abstract class Analiser {

    protected boolean is7thTermandSetTerms(int term){
        if (term != 7 && term != 8)
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII lub VIII kadencji. " + term);
        if (term == 7) return true;
        return false;}
}
