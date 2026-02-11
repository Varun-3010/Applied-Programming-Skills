class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;

            if (counter[task - 'A'] == max) {
                maxCount++;
            } 
            else if (counter[task - 'A'] > max) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (max * maxCount);
        int idleSlots = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idleSlots;
    }
}
