class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, ArrayList<int[]>> mTime = new TreeMap<>(); // so that we can group meetings in sorted order

        // group meetings at same time in ascending order of time
        for(int[] m : meetings){
            int person1 = m[0];
            int person2 = m[1];
            int time = m[2];

            // if not grouped yet? start new list<>()
            mTime.computeIfAbsent(time, k -> new ArrayList<>()).add(new int[]{person1, person2});
        }

        boolean[] knowsSecret = new boolean[n]; // to track persons who knows secret
        knowsSecret[0] = true; // given
        knowsSecret[firstPerson] = true; // given

        // process in ascending order by time
        for(int t : mTime.keySet()){

            // For each person, save all the people whom he/she meets at time t
            Map<Integer, List<Integer>> meet = new HashMap<>(); // like adjacency list

            // Start traversal from those who already know the secret at time t
            // Set to avoid redundancy
            Set<Integer> start = new HashSet<>(); // just to store persons who knows secret to add later in queue uniqiuely

            // now fill adjacency list for curr time
            for(int[] meeting : mTime.get(t)){
                int p1 = meeting[0];
                int p2 = meeting[1];
                meet.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                meet.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);

                // also add persons to queue if they knows secret
                if(knowsSecret[p1]){
                    start.add(p1);
                }
                if(knowsSecret[p2]){
                    start.add(p2);
                }
            }

            Queue<Integer> q = new LinkedList<>(start); // convert the set into queue
            while(!q.isEmpty()){ // bfs
                int currP = q.poll();
                for(int nextP : meet.getOrDefault(currP, new ArrayList<>())){
                    if(!knowsSecret[nextP]){
                        knowsSecret[nextP] = true;
                        q.offer(nextP);
                    }
                }
            }
        }
        // List of people who know the secret
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }
        return result;
    }
}