import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        int curCmd = -1;

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("0")) break;

            if (input.equals("<<")) {
                if (commands.isEmpty()) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCmd).undo();
                }
            } else if (input.equals(">>")) {
                if (commands.isEmpty()) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCmd).dO();
                }
            } else {
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, Integer.parseInt(input));
                curCmd++;
                commands.add(cmd);
                cmd.dO();
            }
        }

        printFrogPosition(frog);
    }

    public static void printFrogPosition(Frog frog) {
        String[] field = new String[Frog.MAX_POSITION + 1];
        for (int i = 0; i < field.length; i++) {
            if (i == frog.position) {
                field[i] = "F";
            } else {
                field[i] = "_";
            }
            System.out.printf("%5s", field[i]);
        }
        System.out.println("\n");
        for (int i = 0; i < field.length; i++) {
            System.out.printf("%5d", i);
        }
    }
}
