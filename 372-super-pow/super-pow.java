class Solution {
    int mod = 1337;

    // Function to compute (a^k) % mod efficiently
    private int modPow(int a, int k) {
        a %= mod;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % mod;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1;

        // Remove the last digit
        int lastDigit = b[b.length - 1];

        // Create a subarray without the last digit
        int[] rest = new int[b.length - 1];
        System.arraycopy(b, 0, rest, 0, b.length - 1);

        // Recursive relation:
        // superPow(a, b) = (superPow(a, rest)^10 * a^lastDigit) % mod
        int part1 = modPow(superPow(a, rest), 10);
        int part2 = modPow(a, lastDigit);

        return (part1 * part2) % mod;
    }
}
