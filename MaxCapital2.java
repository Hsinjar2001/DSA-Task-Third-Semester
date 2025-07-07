
public class MaxCapital2 {
    public static int findMaxCapital(int k, int c, int[] revenues, int[] investments) {
        int n = revenues.length;

        // Step 1: Track visited projects
        boolean[] visited = new boolean[n];

        // Step 2: Do up to k projects
        for (int step = 0; step < k; step++) {
            int maxProfit = -1;
            int selectedProject = -1;

            // Step 3: Each round, scan all projects
            for (int i = 0; i < n; i++) {
                // If not yet chosen and investment is affordable
                if (!visited[i] && investments[i] <= c) {
                    if (revenues[i] > maxProfit) {
                        maxProfit = revenues[i];
                        selectedProject = i;
                    }
                }
            }

            // If no project can be done, break
            if (selectedProject == -1) break;

            // Take that project
            visited[selectedProject] = true;
            c += revenues[selectedProject]; // add revenue to capital
        }

        return c;
    }

    public static void main(String[] args) {
        // Example input
        int k = 3, c = 1;
        int[] revenues = {3, 6, 10};
        int[] investments = {1, 3, 5};

        int result = findMaxCapital(k, c, revenues, investments);
        System.out.println("Maximized Capital: " + result);  // Output: 19
    }
}
