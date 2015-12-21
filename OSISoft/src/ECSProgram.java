import java.util.Scanner;

/**
 * Author : akshaysawant
 */
public class ECSProgram {

    public static void main(String[] args) {

        String line;

        if (args.length != 2) {
            System.out.println("ERROR : Need two input parameters.");
            System.out.println("USAGE : ./elevatorSystem Elevator_Count Number_Of_Floors");
            System.exit(1);
        }

        int elevatorCount = Integer.parseInt(args[0]);
        int floorCount = Integer.parseInt(args[0]);
        ElevatorControlSystem ecs = new ElevatorControlSystem(elevatorCount, floorCount);

        Scanner in = new Scanner(System.in);

        while(true) {
            line = in.nextLine();

            if (line.equals("quit")) {
                ecs.quit();
                break;

            } else if (line.equals("status")) {
                ecs.status();

            } else if (line.equals("step")) {
                ecs.step();

            } else if (line.equals("stop")) {
                ecs.stopStep();

            } else if (line.startsWith("pickup")) {
                String[] params = line.split(" ");

                if (params.length != 3) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("pickup Pickup_Floor Direction");
                    continue;
                }

                try {
                    int pickup = Integer.parseInt(params[1]);
                    int direction = Integer.parseInt(params[2]);
                    ecs.pickup(pickup, direction);
                } catch (NumberFormatException numEx) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("pickup Int Int");
                    continue;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("pickup (0 <= Pickup_Floor < " + floorCount + ") Direction");
                    continue;
                }
            } else if (line.startsWith("update")) {
                String[] params = line.split(" ");

                if (params.length != 3) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("update Elevator_ID Destination_Floor");
                    continue;
                }

                try {
                    int id = Integer.parseInt(params[1]);
                    int destFloor = Integer.parseInt(params[2]);
                    ecs.update(id, destFloor);
                } catch (NumberFormatException numEx) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("update Int Int");
                    continue;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid Arguments");
                    System.out.println("Usage : ");
                    System.out.println("pickup (0 <= Elevator_ID < " + elevatorCount + ") (0 <= Destination_Floor < " + floorCount + ")");
                    continue;
                }
            }
        }
    }
}
