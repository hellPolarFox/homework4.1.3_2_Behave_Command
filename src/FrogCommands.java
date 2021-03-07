public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {

            @Override
            public boolean dO() {
                if (frog.jump(steps)) return true;
                else return false;
            }

            @Override
            public boolean undo() {
                if (frog.jump(-steps)) return true;
                else return false;
            }
        };
    }


}