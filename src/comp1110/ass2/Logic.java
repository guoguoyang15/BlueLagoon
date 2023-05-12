package comp1110.ass2;

public class Logic {
    public static boolean isStateStringWellFormed1(String stateString) {
        // Written by Tyler and edited by Zhining
        String[] parts = stateString.split(";");
        // Separate strings into arrays of strings with the split function, using ";"
        if (parts[0].matches("a\\s[0-9]*[1-9][0-9]*\\s[1-9]")) {
            // Check if the game arrangement declaration is correct by means of regular expressions
            if (parts[1].matches("\\sc\\s\\d\\s[E|S]")) {
                for (int i = 2; i < parts.length; i++) {
                    // Iterate through the array to check if it is correct
                    if (parts[i].startsWith(" i")) {
                        if (parts[i].matches("\\si\\s[0-9]*[1-9][0-9]*\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Stones Statement is formatted correctly.
                    else if (parts[i].startsWith(" s")) {
                        if (parts[i].matches("\\ss\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Unclaimed Resources and Statuettes Statement is formatted correctly.
                    else if (parts[i].startsWith(" r")) {
                        if (parts[i].matches("\\sr\\sC\\s(\\d{1,2},\\d{1,2}\\s)*B\\s(\\d{1,2},\\d{1,2}\\s)*W\\s(\\d{1,2},\\d{1,2}\\s)*P\\s(\\d{1,2},\\d{1,2}\\s)*S(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Player Statement is formatted correctly.
                    else if (parts[i].startsWith(" p")) {
                        if (parts[i].matches("\\sp\\s\\d\\s\\d{1,3}\\s(\\d\\s){5}S\\s(\\d{1,2},\\d{1,2}\\s)*T(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                // Returns false if any errors are detected.
                return (stateString.endsWith(";"));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isMoveStringWellFormed1(String moveString) {
        // Written by Tyler
        // Checks if Move string is properly formatted
        return moveString.matches("[S|T]\s\\d{1,2},\\d{1,2}");
    }
}
