class NumberContainers {
    Map<Integer, Integer> idx;
    Map<Integer, TreeSet<Integer>> num;
    public NumberContainers() {
        num = new HashMap<>();
        idx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        if(idx.containsKey(index)){
            int prevNum = idx.get(index);
            num.get(prevNum).remove(index);

            if(num.get(prevNum).isEmpty()){
                num.remove(prevNum);
            }
        }
        idx.put(index, number);
        num.putIfAbsent(number, new TreeSet<>());
        num.get(number).add(index);
    }
    
    public int find(int number) {
        
        if(num.containsKey(number)){
            return num.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */