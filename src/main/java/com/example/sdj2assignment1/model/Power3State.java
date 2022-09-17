package com.example.sdj2assignment1.model;

public class Power3State implements RadiatorState
{
    private static int POWER = 3;
    Thread thread;
//Power3State has some extra functionality. When you turn to this state,
// after 10 seconds (or whatever you decide) the state will automatically turn back down to Power2State.
//
//The power is 3.
//In the Power3State constructor, you must start a new thread,
// which will sleep 10 seconds, and then switch down to Power2State. I recommend using
// a lambda expression, or alternatively an inner class inside Power3State to handle the thread.
//You should make the thread a daemon thread, do the following before calling the start() method:
// thread.setDaemon(true). This will make sure the thread is terminated, if the program is shut down.
//In the turnDown() method, you must interrupt the thread started from the constructor to prevent
// it from automatically switching state later.
// Otherwise you turn the power down, and then the thread will later change the power again.
//Create a main method to test your radiator, similar to the Mobile phone exercise.
// Use a Thread.sleep(10000) in the main method to verify the power will automatically
// go down from Power3State to Power2State after 10 seconds.
    public Power3State(Radiator radiator) {
        Thread.interrupted();
        Thread temp = new Thread(() ->
        {
            try {
                Thread.currentThread().setName("temp");
                Thread.sleep(10000);
                radiator.setPowerState(new Power2State());
                System.out.println("Too hot I cooled down");
            }
            catch(Exception e) {
            System.out.print("Dead");
            }
        });
        this.thread = temp;
        temp.setDaemon(true);// makes sure the thread is terminated, if the program shuts down
        temp.start();



    }
    public void turnUp(Radiator radiator){

    };
    public void turnDown(Radiator radiator){
        this.thread.interrupt();
        radiator.setPowerState(new Power2State());
        System.out.println("I am adding down to state 2");
    };
    public int getPower() {
        return POWER;
    };
}
