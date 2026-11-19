class Solution {
    public int numRescueBoats(int[] people, int limit) {
      Arrays.sort(people);

      int cnt=0;

      int l=0;

      int r=people.length-1;

      while(l<=r)
      {
        if(people[l]+people[r]<=limit)
            l++;

        cnt++;

        r--;    
      }
      return cnt;
    }
}