class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            // Add current character to window
            sCount[s.charAt(i) - 'a']++;

            // Remove character that is out of window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}