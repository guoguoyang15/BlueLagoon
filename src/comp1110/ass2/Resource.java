package comp1110.ass2;

import java.util.Random;

/**
 * @author Zhou Linsheng (resource enum type), Zhang Zhining (method)
 * This class deals with all things related to resources, such as their distribution and placement.
 */
public enum Resource {
    // @author Zhou Linsheng
    NULL, // initialization
    COCONUT,
    BAMBOO,
    WATER,
    PRECIOUSSTONE,
    STATUETTE;

    // @author Zhang Zhining
    // Distributes the resources after the start of each phase
    public static String distributeResources(String stateString) {
        // add a space at front to make sure that for every statement, the second char of the substring is the type of statement
        // stateString = " " + stateString;
        String[] statement = stateString.split(";");
        String target = null;
        for (int i = 0; i < statement.length - 1; i++) {
            if (statement[i].startsWith(" s")) {
                target = statement[i];
                break;
            }
        }
        // First use target to intercept a string starting with s
        target = target.replace(" s ", "");
        // Cut out the extraneous characters at the beginning
        String[] stoneCircle = target.split(" ");
        // Separating out sequential characters in a string
        String[] random = new String[32];
        // Also set up a new array of strings
        Random r = new Random();
        int[] a = new int[32];
        int rand;
        for (int i = 0; i < 32; i++) {
            do {
                rand = r.nextInt(32);
                if (a[rand] == 0) {
                    a[rand] = i;
                    break;
                }
            } while (true);
        }
        for (int i = 0; i < 32; i++) {
            random[i] = stoneCircle[a[i]];
        }
        // Randomize an array from 0 to 31 and record the new data into a new string
        String C = random[0] + " " + random[1] + " " + random[2] + " " + random[3] + " " + random[4] + " " + random[5] + " ";
        String B = random[6] + " " + random[7] + " " + random[8] + " " + random[9] + " " + random[10] + " " + random[11] + " ";
        String W = random[12] + " " + random[13] + " " + random[14] + " " + random[15] + " " + random[16] + " " + random[17] + " ";
        String P = random[18] + " " + random[19] + " " + random[20] + " " + random[21] + " " + random[22] + " " + random[23] + " ";
        String S = random[24] + " " + random[25] + " " + random[26] + " " + random[27] + " " + random[28] + " " + random[29] + " " + random[30] + " " + random[31];
        // Start with a string representation of the individual resources
        String replaceString = " r C " + C + "B " + B + "W " + W + "P " + P + "S " + S;
        // Direct string addition, first with a separate string resource declaration

        for (String s : statement) {
            if (s.startsWith(" r")) {
                stateString = stateString.replace(s, replaceString);
            }
        }
        return stateString;
    }
}
