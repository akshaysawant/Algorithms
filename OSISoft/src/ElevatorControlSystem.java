/**
 * Author : akshaysawant
 */
public class ElevatorControlSystem {

    int elevatorCount, floorCount;
    Elevator[] elevator;

    public ElevatorControlSystem(int elevatorCount, int floorCount) {
        this.elevatorCount = elevatorCount;
        this.floorCount = floorCount;
        elevator = new Elevator[elevatorCount];

        Elevator newElevator;
        int id = 0;
        for (int i = 0; i < elevatorCount; i++) {
            newElevator = new Elevator(id++, floorCount);
            elevator[i] = newElevator;
        }
    }

    public void status() {
        System.out.println("Elevator_ID\tCurrent_Floor\tDirection\tDestination_Floors");

        for (int i = 0; i < elevatorCount; i++) {
            elevator[i].status();
        }
    }

    public void step() {
        for (int i = 0; i < elevatorCount; i++) {
            elevator[i].step();
        }
    }

    public void stopStep() {
        for (int i = 0; i < elevatorCount; i++) {
            elevator[i].stopStep();
        }
    }

    public void pickup(int pickUpFloor, int direction) throws IllegalArgumentException {
        String dir = (direction > 0) ? "Up" : "Down";

        direction = (direction > 0) ? 1 : -1;

        Elevator currentBestElevator = null, elev, currentBestWorstElevator = null;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < elevatorCount; i++) {
            elev = elevator[i];
            if (elev.direction == 0 && (elev.getCurrentFloor() - pickUpFloor) < distance) {
                currentBestElevator = elev;
                distance = elev.getCurrentFloor() - pickUpFloor;
            } else if (elev.getDirection() == direction) {
                if (currentBestElevator == null) {
                    currentBestElevator = elev;
                } else if (currentBestElevator.getDirection() != 0
                        && elev.getDestinationsCount() < currentBestElevator.getDestinationsCount()) {
                    currentBestElevator = elev;
                }
            } else {
                if ((currentBestWorstElevator == null)
                || (elev.getDestinationsCount() < currentBestWorstElevator.getDestinationsCount())) {
                        currentBestWorstElevator = elev;
                }
            }
        }

        if (currentBestElevator == null) {
            currentBestWorstElevator.addDestination(pickUpFloor);
        } else {
            currentBestElevator.update(pickUpFloor);
        }
    }

    public void update(int evelatorID, int goalFloor) {
        elevator[evelatorID].update(goalFloor);
    }

    public void quit() {
        for (int i = 0; i < elevatorCount; i++) {
            elevator[i].quit();
        }
    }
}
