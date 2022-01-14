package com.company;

public class Airport {
    private final boolean[] runways = {true, false, false, false, false};

    public int getFreeRunwayIndex() {
        for (int i = 0; i < runways.length; i++) {
            if (!runways[i]) return i;
        }
        for (int i = 0; i < runways.length; i++) {
            runways[i] = false;
        }
        return -1;
    }

    public void takeRunway(int freeRunwayIndex) {
        runways[freeRunwayIndex] = true;
    }
}
