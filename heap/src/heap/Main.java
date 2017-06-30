package heap;

import heap.Tests;

public class Main {

    public static void main(String[] args){
        System.out.println("Running tests...");
        try {
            Tests.run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("All passed");
    }
}