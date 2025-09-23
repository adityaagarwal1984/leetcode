class Solution {
    public int compareVersion(String version1, String version2) {
         String[] parts = version1.split("\\."); 

        
        // for (int i = 0; i < parts.length; i++) {
        //     parts[i] = parts[i].replaceFirst("^0+(?!$)", "");
        //     // char[] charArr = parts[i].toCharArray(); 
        // } 

            String[] parts1 = version2.split("\\.");
         

        
        // for (int i = 0; i < parts1.length; i++) {
        //     parts1[i] = parts1[i].replaceFirst("^0+(?!$)", "");
        //     // char[] charArr1 = parts1[i].toCharArray(); 
        // }   

             int n = Math.max(parts.length, parts1.length);

        for (int i = 0; i < n; i++) {
            int v1 = i < parts.length ? Integer.parseInt(parts[i]) : 0;
            int v2 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;

            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        return 0;
    }
}