class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        // Sorting in nlogn
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else
                    return a[1] - b[1];
            }
        });

        // one single pass
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1).get(1)) {
                mergedIntervals.add(Arrays.asList(interval[0], interval[1]));
            } else {
                if (interval[0] <= mergedIntervals.get(mergedIntervals.size() - 1).get(1)) {
                    mergedIntervals.get(mergedIntervals.size() - 1).set(1,
                            Math.max(interval[1], mergedIntervals.get(mergedIntervals.size() - 1).get(1)));
                }
            }
        }

        // return mergedIntervals;
        // returing answer as result [][]
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            List<Integer> row = mergedIntervals.get(i);
            result[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }
        return result;

    }
}