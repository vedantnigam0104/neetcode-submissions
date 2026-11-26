class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> map;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        map.putIfAbsent(f, new Stack<>());
        map.get(f).push(val);

        maxFreq = Math.max(maxFreq, f);
    }

    public int pop() {
        int val = map.get(maxFreq).pop();

        freq.put(val, freq.get(val) - 1);

        if (map.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}