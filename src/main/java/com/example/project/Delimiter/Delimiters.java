package com.example.project.Delimiter;
import java.util.ArrayList;

public class Delimiters {
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> delimiters = new ArrayList<>();
        for (String token : tokens) {
            if (token.equals(openDel) || token.equals(closeDel)) {
                delimiters.add(token);
            }
        }
        return delimiters;
    }
    

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        int openDelims = 0;
        int closeDelims = 0;
        for (int i = 0; i < delimiters.size(); i++) {
            String delim = delimiters.get(i);
            if (delim.equals(openDel)) {
                openDelims++;
            }
            if (delim.equals(closeDel)) {
                closeDelims++;
                int openDelimBefore = 0;
                int closeDelimBefore = 0;
                for (int j = 0; j <= i; j++) {
                    if (delimiters.get(j).equals(openDel)) {
                        openDelimBefore++;
                    }
                    if (delimiters.get(j).equals(closeDel)) {
                        closeDelimBefore++;
                    }
                }
                if (openDelimBefore < closeDelimBefore) {
                    return false;
                }
            }
        }
        return openDelims == closeDelims;
    }
}
