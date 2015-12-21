import java.util.*;

/**
 * Author : akshaysawant
 */
public class Elevator {

    int id;
    int currentFloor;
    LinkedList<Integer> destFloorStack;
    int stackSize;
    int direction;
    int maxFloor;
    Timer stepThread;
    TimerTask task;

    public Elevator(int id, int floorCount) {
        this.id = id;
        currentFloor = 0;
        stackSize = 0;
        direction = 0;
        maxFloor = floorCount;
        destFloorStack = new LinkedList<Integer>();
    }

    public void status() {
        String dir;
        if (direction == 0) {
            dir = "Steady";
        } else {
            dir = (direction > 0) ? "Up" : "Down";
        }

        StringBuilder destinations = new StringBuilder();

        String dest;
        if (destFloorStack.isEmpty()) {
            dest = "";
        } else {
            Iterator<Integer> iter = destFloorStack.iterator();
            while (iter.hasNext()) {
                destinations.append(" " + iter.next() + ",");
            }
            dest = destinations.substring(0, destinations.length() - 1);
        }

        System.out.println("\t" + id + "\t\t" + currentFloor + "\t" + dir + "\t\t" + dest);
    }

    public void update(int goalFloor) {
        ListIterator<Integer> iter = destFloorStack.listIterator();
        int floor, index = 0;
        boolean floorNotAdded = true;

        if (currentFloor == goalFloor) {
            return;
        }

        if (stackSize == 0) {
            destFloorStack.add(goalFloor);
            stackSize++;
            if (goalFloor > currentFloor) {
                direction = 1;
            } else if (goalFloor < currentFloor) {
                direction = -1;
            }
        } else {
            while (iter.hasNext()) {
                floor = iter.next();

                if (floor == goalFloor) {
                    floorNotAdded = false;
                    break;
                } else {
                    if (direction == 1) {
                        if (floor > goalFloor) {
                            destFloorStack.add(index, goalFloor);
                            stackSize++;
                            floorNotAdded = false;
                            break;
                        }
                    } else if (direction == -1) {
                        if (floor < goalFloor) {
                            destFloorStack.add(index, goalFloor);
                            stackSize++;
                            floorNotAdded = false;
                            break;
                        }
                    }
                }
                index++;
            }

            if (floorNotAdded) {
                destFloorStack.addLast(goalFloor);
            }

            status();
        }
    }

    void addDestination(int goalFloor) {
        destFloorStack.addLast(goalFloor);
    }

    int getDirection() {
        return direction;
    }

    int getCurrentFloor() {
        return currentFloor;
    }

    int getDestinationsCount() {
        return destFloorStack.size();
    }

    private void simulateElevator() {
        if (stackSize == 0) {
            direction = 0;
            return;
        }

        if (direction < 0) {
            currentFloor--;
        } else if (direction > 0) {
            currentFloor++;
        }

        if (destFloorStack.peek() == currentFloor) {
            destFloorStack.pop();
            stackSize--;
        }

        status();
    }

    public void step() {

        stepThread = new Timer("ElevatorStatus", true);
        task = new TimerTask() {
            @Override
            public void run() {
                simulateElevator();
            }
        };
        stepThread.schedule(task, 3000, 3000);
    }

    public void stopStep() {
        stepThread.cancel();
    }

    public void quit() {
        if (stepThread != null) {
            stepThread.cancel();
        }
    }
}
