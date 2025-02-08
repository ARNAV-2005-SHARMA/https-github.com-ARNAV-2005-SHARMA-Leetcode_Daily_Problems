// Approach 1 -> Using Two map and one TreeSet
// Time Complexity -> O(log n)
// Space Complexity -> O(n)
class NumberContainers {
    Map<Integer, Integer> idx; // key -> index,  value -> number
    Map<Integer, TreeSet<Integer>> num; // key -> number,  value -> sorted set of indices
    public NumberContainers() {
        num = new HashMap<>();
        idx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // If the index already exists, remove it from the previous number's set
        if(idx.containsKey(index)){
            int prevNum = idx.get(index);
            num.get(prevNum).remove(index); // O(log n)

            if(num.get(prevNum).isEmpty()){
                num.remove(prevNum); // Remove the number if no indices left (from num map)
            }
        }
        idx.put(index, number); // Update index to new number
        num.putIfAbsent(number, new TreeSet<>()); // Add new number and new set in num map
        num.get(number).add(index); // Add only index in treeSet in existing number
    }
    
    public int find(int number) { // O(1)
        if(num.containsKey(number)){
            return num.get(number).first(); // return the index from treeSet (first value)
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