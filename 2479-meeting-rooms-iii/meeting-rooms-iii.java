class Solution {

    class Room {
        int roomNo;
        long freeAt;

        Room(int r, long f) {
            roomNo = r;
            freeAt = f;
        }
    }

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // available rooms by room number
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // busy rooms by freeAt, then roomNo
        PriorityQueue<Room> busy = new PriorityQueue<>(
            (a, b) -> a.freeAt == b.freeAt
                    ? a.roomNo - b.roomNo
                    : Long.compare(a.freeAt, b.freeAt)
        );

        int[] count = new int[n];

        for (int i = 0; i < n; i++)
            available.offer(i);

        for (int[] m : meetings) {
            long start = m[0], end = m[1];
            long duration = end - start;

            // free up rooms
            while (!busy.isEmpty() && busy.peek().freeAt <= start) {
                available.offer(busy.poll().roomNo);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.offer(new Room(room, end));
            } else {
                Room r = busy.poll();
                count[r.roomNo]++;
                busy.offer(new Room(r.roomNo, r.freeAt + duration));
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans])
                ans = i;
        }
        return ans;
    }
}
