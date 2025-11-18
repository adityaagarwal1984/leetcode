class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       char f='@';
       char s='#';
       int i=0;
       String st="";
       while(i<bits.length)
       {
        if(bits[i]==0){
        st+=f;
        i++;
        }
        else
        {
            st+=s;
            i=i+2;

        }
        

       }
       return (st.charAt(st.length()-1)==f)?true:false;

    }
}