class TimeMap {
    Map<String, TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        {
            map.put(key, new TreeMap<>()); // create TreeMap for a given key
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        {
            return ""; 
        }
        TreeMap<Integer, String> treeMap = map.get(key);

        Integer smallTimeStamp = treeMap.floorKey(timestamp);// return greatest key among key less than equal to key.
        if(smallTimeStamp  == null)
        {
            return "";
        }
        return treeMap.get(smallTimeStamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


 /*
 In this problem we are creating HashMap which stores key:String and TreeMap. TreeMap further stores timestamp and value.
  */

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
