/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
      int length=mountainArr.length();

      if(length<3)
        return -1;

      int l=0;

      int h=length-1;

      while(l<h)
      {
            int mid=l+(h-l)/2;

            int ele=mountainArr.get(mid);

            int ele1=mountainArr.get(mid+1);

            if(ele<ele1)
                l=mid+1;
            else
                h=mid;        
      }    
      int peak=l;

      l=0;

      h=peak;

      while(l<=h)
      {
        int mid=l+(h-l)/2;

        int ele=mountainArr.get(mid);

        if(ele==target)
            return mid;
        else if(ele<target)
            l=mid+1;
        else
            h=mid-1;        
      }

      l=peak+1;

      h=length-1;

      while(l<=h)
      {
        int mid=l+(h-l)/2;

        int ele=mountainArr.get(mid);

        if(ele==target)
            return mid;
        else if(ele<target)
            h=mid-1;
        else
            l=mid+1;        
      }
      return -1;
    }
}