public class Main {
    public static void main(String[] args) {

        if(runProg6("LSSSS") == -1)
            System.out.println("test 1 passed");
        else
            System.out.println("test 1 failed");

        if(runProg6("SSLSLSLSSRSRS") == 5)
            System.out.println("test 2 passed");
        else
            System.out.println("test 2 failed");

        if(runProg6("LSSSRSSSSRSSSSLSLLLL") == -1)
            System.out.println("test 4 passed");
        else
            System.out.println("test 4 failed");
    }

    public static int runProg5(String prog) {
        int maxCountS = 10;

        Robot k79 = new Robot(maxCountS, maxCountS, 0);
        int res = k79.runProgramUntilCross(prog);
        return res;
    }

    public static int runProg6(String prog) {
        int maxCountS = 10;

        RobotWithSet k79 = new RobotWithSet(maxCountS, maxCountS, 0);
        int res = k79.runProgramUntilCross(prog);
        return res;
    }
}

