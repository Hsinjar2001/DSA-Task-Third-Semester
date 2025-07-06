import java.util.*;

public class AlgoStart {

    public static int maximizeCapital(int k, int c, int[] revenues, int[] investments) {
        int n = revenues.length;

        // Create list of projects: [investment, revenue]
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = investments[i];
            projects[i][1] = revenues[i];
        }

        // Sort projects by investment required (ascending)
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        for (int j = 0; j < k; j++) {
            // Add all projects we can afford to maxHeap
            while (i < n && projects[i][0] <= c) {
                maxHeap.add(projects[i][1]);
                i++;
            }
            if (maxHeap.isEmpty()) break;

            // Take project with max revenue
            c += maxHeap.poll();
        }

        return c;
    }

    public static void main(String[] args) {
        int k = 2, c = 0;
        int[] revenues = {2, 5, 8};
        int[] investments = {0, 2, 3};

        int result = maximizeCapital(k, c, revenues, investments);
        System.out.println(result);  // Output: 7
    }
}
