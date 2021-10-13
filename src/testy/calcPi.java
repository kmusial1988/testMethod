package testy;

import java.util.ArrayList;
import java.util.List;

public class calcPi {
    public static void main(String[] args) {


        int simulationDays_Ts = 10;
        double factor_R = 2.5;
        int startInfected_I = 20;
        double mortalityFactor_M = 0.2;
        int mortalityTime_Tm = 52;
        int recoveryTime_Ti = 7;


        List<Integer> piList = new ArrayList<>();
        piList.add(0);
        double todayHel;
        double pi = 0;
        double todyDeaths = 0.0;
        boolean czyPi = false;

        for (int i = 0; i <= simulationDays_Ts; i++) {

            if (mortalityTime_Tm <= i) {
                todyDeaths = pi * factor_R * mortalityFactor_M;
                pi = pi - todyDeaths;
                czyPi = true;
            }

            if (recoveryTime_Ti <= i) {
                int pi10 = piList.get(i - recoveryTime_Ti);
                int pi9 = piList.get(i - (recoveryTime_Ti - 1));

                if (czyPi) {
                    todayHel = pi - (pi9 - pi10);
                    pi = todayHel;
                    czyPi = false;
                } else {
                    todayHel = pi * factor_R - (pi9 - pi10);
                    pi = todayHel;
                }

            } else {
                if (i == 1) {
                    pi = startInfected_I;
                } else {
                    pi = pi * factor_R;
                }
            }
            piList.add((int) pi);

            System.out.println(pi);

        }
    }
}
