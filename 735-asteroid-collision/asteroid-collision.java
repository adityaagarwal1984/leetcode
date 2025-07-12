class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>0)
            st.push(asteroids[i]);
            else
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0)
                st.push(asteroids[i]);
                else if(Math.abs(asteroids[i])==st.peek())
                st.pop();

                 
                
                
            }

        }
        while(!st.isEmpty())
        {
            list.add(st.pop());
        }
        Collections.reverse(list);
        int arr[]= new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
        



        
    }
}