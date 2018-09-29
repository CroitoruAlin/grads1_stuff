package com.endava.concurrency.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.endava.concurrency.problem.BookRoom.*;


public class BookRoom {

    static AtomicInteger doubleRooms = new AtomicInteger(300);
    static AtomicInteger apartments2 = new AtomicInteger(200);
    static AtomicInteger apartments3 = new AtomicInteger(100);
    static Queue<Integer> lobby = new ConcurrentLinkedDeque<>();
    static AtomicInteger lobbyCurrentSize = new AtomicInteger(50);
    static ExecutorService receptionostsPool = Executors.newFixedThreadPool(3);
    static AtomicBoolean noMorePersons = new AtomicBoolean(false);
    static ScheduledExecutorService boatsPool = Executors.newScheduledThreadPool(5);
    static AtomicBoolean noMoreDoubleRooms = new AtomicBoolean(false);
    static AtomicBoolean noMoreApartment2Rooms = new AtomicBoolean(false);
    static AtomicBoolean noMoreApartment3Rooms = new AtomicBoolean(false);

    public static void bookRoom(int type) {
        if (type == 1) doubleRooms.decrementAndGet();
        else if (type == 2)
            apartments2.decrementAndGet();
        else
            apartments3.decrementAndGet();

    }

    public static void main(String[] args) throws InterruptedException {
        boatsPool.scheduleAtFixedRate(new Boat(),0,30,TimeUnit.MILLISECONDS);
        receptionostsPool.execute(new Receptionist());
        receptionostsPool.execute(new Receptionist());
        receptionostsPool.execute(new Receptionist());


        boatsPool.shutdown();
        receptionostsPool.shutdown();
        while (!boatsPool.awaitTermination(1,TimeUnit.MILLISECONDS) || !receptionostsPool.awaitTermination(1,TimeUnit.MILLISECONDS));
        System.out.println(doubleRooms.get()+" "+apartments2.get()+" "+apartments3.get());


    }
}

class Receptionist implements Runnable {

    @Override
    public void run() {
        while (!noMorePersons.get() || lobby.size() > 0 ) {
            Integer nbrGuests = lobby.poll();

            if (nbrGuests != null) {
                switch (nbrGuests) {
                    case 1:
                    case 2:
                        if(doubleRooms.get()!=0)
                        doubleRooms.decrementAndGet();

                        if (doubleRooms.get()==0)
                            noMoreDoubleRooms.set(true);
                        break;
                    case 3:
                    case 4:
                        if(apartments2.get()!=0) {
                            apartments2.decrementAndGet();

                        }
                        if(apartments2.get()==0)
                            noMoreApartment2Rooms.set(true);
                        break;
                    case 5:
                    case 6:

                        if(apartments3.get()!=0)
                            apartments3.decrementAndGet();
                        if(apartments3.get()==0)
                            noMoreApartment3Rooms.set(true);
                        break;
                }
                boolean update = false;
                while (!update) {
                    int lobbySize = lobbyCurrentSize.get();
                    update = lobbyCurrentSize.compareAndSet(lobbySize, lobbySize + nbrGuests);

                }

                System.out.println("Served group of " + nbrGuests + " persons");
            }
        }
    }
}

class Boat implements Runnable {
    int  nrPersonsInBoat = 250;
    List<Integer> listGroups=new ArrayList<>();

    @Override
    public void run() {
        while (!noMoreApartment2Rooms.get() || !noMoreDoubleRooms.get() || !noMoreApartment3Rooms.get()) {
            nrPersonsInBoat=250;
            while (nrPersonsInBoat != 0) {
                Random r = new Random();
                int low = 1;
                int high = 7;
                int result = r.nextInt(high - low) + low;
                nrPersonsInBoat -= Math.min(result, nrPersonsInBoat);
                listGroups.add(result);
            }

            try {
                Thread.sleep(180);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!listGroups.isEmpty()) {
                boolean added = false;
                Integer result = listGroups.get(listGroups.size() - 1);
                listGroups.remove(result);
                while (!added) {
                    int currentSize = lobbyCurrentSize.get();
                    if (currentSize - result >= 0) {
                        added = lobbyCurrentSize.compareAndSet(currentSize, currentSize - result);

                    }
                    if (added) {
                        System.out.println("Added " +result+" persons");
                        lobby.add(result);

                    }
                }
            }
            System.out.println("Empty boat");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        noMorePersons.set(true);



    }
}
