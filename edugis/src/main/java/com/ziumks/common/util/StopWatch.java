package com.ziumks.common.util;

/**
 * Useful when doing timings in a debug or test situation.
 * 
 * [사용 방법]
 * StopWatch watch = new StopWatch();
 * watch.start();
 * ...
 * watch.stop();
 * System.out.println(watch.getTimeString());
 */
public class StopWatch {

    static public int AN_HOUR = 60 * 60 * 1000;
    static public int A_MINUTE = 60 * 1000;

    private long startTime = -1;
    private long stopTime = -1;
    
    /**
     * Start the stopwatch.
     */
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    
    /**
     * Stop the stopwatch.
     */
    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    /**
     * Reset the stopwatch.
     */
    public void reset() {
        this.startTime = -1;
        this.stopTime = -1;
    }
        
    /**
     * Split the time.
     */
    public void split() {
        this.stopTime = System.currentTimeMillis();
    }

    /**
     * Remove a split.
     */
    public void unsplit() {
        this.stopTime = -1;
    }
    
    /**
     * Get the time on the stopwatch. This is either the
     * time between start and latest split, between start and stop,
     * or the time between the start and the moment this method is called.
     */
    public long getTime() {
        if(stopTime != -1) {
            return (System.currentTimeMillis() - this.startTime);
        } else {
            return this.stopTime - this.startTime;
        }
    }
    
    /**
     * 결과를 출력한다.
     * @return 출력 결
     */
    public String toString() {
        return getTimeString();
    }
    
    /**
     * Get the time gap as a String.
     * In hours, minutes, seconds and milliseconds.
     */
    public String getTimeString() {
        int hours, minutes, seconds, milliseconds;
        long time = getTime();
        hours = (int) (time / AN_HOUR);
        time = time - (hours * AN_HOUR);
        minutes = (int) (time / A_MINUTE);
        time = time - (minutes * A_MINUTE);
        seconds = (int) (time / 1000);
        time = time - (seconds * 1000);
        milliseconds = (int) time;
 
        return hours + "h:" + minutes + "m:" + seconds + "s:" + milliseconds + "ms";
    }      
} 
