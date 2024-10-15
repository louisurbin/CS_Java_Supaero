package rng;

import java.util.Random;
import java.util.ArrayList;

abstract public class AbstractRNG {
    protected Random rand;

    protected AbstractRNG(){
        this.rand = new Random();
    }

    abstract public double genSample();

    public ArrayList<Double> genSamples(int n){
        ArrayList<Double> samples = new ArrayList<Double>();
        for(int i=0; i<n; i++){
            samples.add(this.genSample());
        }
        return samples;
    }
}
