package com.endava.concurrency._7.bonus;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HotelRoomReservationApp {

    static AtomicInteger doubleRoom = new AtomicInteger(300);
    static AtomicInteger apartment2Rooms = new AtomicInteger(200);
    static AtomicInteger apartment3Rooms = new AtomicInteger(100);

    static Queue<Integer> lobby = new ConcurrentLinkedQueue<>();
    static AtomicInteger lobbyCurrentSize = new AtomicInteger(50);

    static Executor receptionistsPool = Executors.newFixedThreadPool(3);

    static AtomicBoolean stopFlag = new AtomicBoolean(false);

    static class Receptionist implements Runnable {
        @Override
        public void run() {

            while (!stopFlag.get() || lobby.size() > 0) {
                Integer nbrGuests = lobby.poll();
                if (nbrGuests != null) {
                    switch (nbrGuests) {
                        case 2:
                            doubleRoom.decrementAndGet();
                            // TODO verify if there are available rooms
                            break;
                        case 3:
                        case 4:
                            apartment2Rooms.decrementAndGet();
                            break;
                        case 5:
                        case 6:
                            apartment3Rooms.decrementAndGet();
                            break;
                    }
                    boolean updated = false;
                    while (!updated) {
                        int lobbySize = lobbyCurrentSize.get();
                        updated = lobbyCurrentSize.compareAndSet(lobbySize, lobbySize + nbrGuests);
                    }
                    System.out.println(" Served grop of " + nbrGuests + " persons");
                }


            }
            System.out.println("Receptionist is exiting");
        }
    }

    public static void main(String[] args) {

        receptionistsPool.execute(new Receptionist());
        receptionistsPool.execute(new Receptionist());
        receptionistsPool.execute(new Receptionist());

        Random r = new Random();

        for(int i = 0; i < 100; i++) {

            // generate random number of guests
            Integer group = 2 + r.nextInt(5);

            // update the counter
            boolean updated = false;
            while (!updated) {

                // get current counter size
                int currentSize = lobbyCurrentSize.get();
                if (currentSize - group >= 0) {

                    // if no other thread has updated the counter, update it
                    // otherwise try to update again -> start again from the beggning of the while
                    updated = lobbyCurrentSize.compareAndSet(currentSize, currentSize - group);
                    if (updated) {
                        System.out.println(group + " came into the lobby");
                        lobby.add(group);
                    }
                }

            }
        }
        System.out.println("No more persons are coming");
        stopFlag.set(true);


    }
}
