import java.util.*;

class Spreadsheet {
    private HashMap<Character, int[]> map;  // Each column letter → row array

    // Constructor initializes spreadsheet with given number of rows
    public Spreadsheet(int rows) {
        map = new HashMap<>();
        for (int i = 65; i <= 90; i++) { // ASCII A-Z
            char ch = (char) i;
            map.put(ch, new int[rows]);  // Each column has its own row array
        }
    }

    // Set value in a specific cell, e.g., "A1" = 5
    public void setCell(String cell, int value) {
        char ch = cell.charAt(0);               // Column (A, B, C…)
        int row = Integer.parseInt(cell.substring(1)) - 1; // Convert "1" → index 0
        map.get(ch)[row] = value;
    }

    // Reset a specific cell to 0
    public void resetCell(String cell) {
        char ch = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1)) - 1;
        map.get(ch)[row] = 0;
    }
    public boolean digit(String st)
    {
        
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            if(Character.isDigit(ch)==false)
            return false;
        }
        return true;
    }

    // Evaluate simple formula of type "=A1+B2"
    public int getValue(String formula) {
        // Remove '=' if present
        if (formula.charAt(0) == '=') {
            formula = formula.substring(1);
        }

        // Split by '+'
        String[] parts = formula.split("\\+");
        int sum = 0;

        for (String cell : parts) {
            if(digit(cell))
            {
                sum+=Integer.parseInt(cell);
            }
            else
            {
            char ch = cell.charAt(0);  // Column
            int row = Integer.parseInt(cell.substring(1)) - 1;
            sum += map.get(ch)[row];
        }
        }

        return sum;
    }
}

/**
 * Usage:
 * Spreadsheet obj = new Spreadsheet(5);
 * obj.setCell("A1", 10);
 * obj.setCell("B2", 20);
 * System.out.println(obj.getValue("=A1+B2")); // Output: 30
 */
