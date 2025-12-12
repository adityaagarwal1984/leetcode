class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        // Sort by timestamp; if same, OFFLINE first
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            int cmp = Integer.compare(t1, t2);
            if (cmp != 0) return cmp;

            // same timestamp → OFFLINE first
            if (a.get(0).equals("OFFLINE") && !b.get(0).equals("OFFLINE")) return -1;
            if (!a.get(0).equals("OFFLINE") && b.get(0).equals("OFFLINE")) return 1;

            return 0;
        });

        int n = numberOfUsers;
        int[] active = new int[n];   // 0 = online, otherwise contains time they will come online
        int[] mention = new int[n];

        for (List<String> ls : events) {

            String type = ls.get(0);
            int time = Integer.parseInt(ls.get(1));
            String content = ls.get(2);

            // auto-online update BEFORE processing a message
            for (int i = 0; i < n; i++) {
                if (active[i] != 0 && time >= active[i]) {
                    active[i] = 0;   // user becomes online again
                }
            }

            if (type.equals("MESSAGE")) {

                if (content.equals("ALL")) {
                    for (int i = 0; i < n; i++) mention[i]++;
                }

                else if (content.equals("HERE")) {
                    for (int i = 0; i < n; i++) {
                        if (active[i] == 0) mention[i]++;
                    }
                }

                else { 
                    // id0 id1 id5 ...
                    String[] part = content.split(" ");
                    for (String st : part) {
                        int id = Integer.parseInt(st.substring(2));
                        mention[id]++;
                    }
                }
            }

            else if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(content);
                int offlineTime = time + 60;
                active[id] = offlineTime;
            }
        }

        return mention;
    }
}
