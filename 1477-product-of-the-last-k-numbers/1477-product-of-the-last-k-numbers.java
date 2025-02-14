// Approach 1 -> Basic Simulation(tle exist)
// Time Complexity -> add() : O(1), getProduct() : O(k)
// Space Coomplexity -> O(n)
/*class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int prod = 1;
        
        for(int i=list.size()-k; i<list.size();i++){
            prod *= list.get(i);
        }
        return prod;
    }
}*/

//------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Optimal approach using Cummulative Product Array
// Time Complexity -> add() : O(1), getProduct() : O(1)
// Space Complexity -> O(n)
class ProductOfNumbers {
    List<Integer> list; // Stores the prefix product of numbers(cummulative product list)
    int n; // store the number of elements in list
    public ProductOfNumbers() {
        list = new ArrayList<>();
        n = 0;
    }
    
    public void add(int num) {
        // If the number is zero, reset the list since any product involving zero is zero
        if(num==0){
            list.clear();
            n = 0;
        }else{
            // If list is empty, simply add the number
            if(list.isEmpty()){
                list.add(num);
            }else{
                // Otherwise, multiply the last stored prefix product with the new number
                list.add(list.get(n-1) * num);
            }
            n++; // Increment count of elements
        }
    }
    // Returns the product of the last k elements
    public int getProduct(int k) {
        // If k is greater than n, it means there are not enough elements, return 0
        if(k > n){
            return 0;   
        }
        // If k is equal to n, return the last stored prefix product
        else if(k==n){
            return list.get(n-1);
        }
        // Compute the last k element product using cummulative product
        // divide the last prefix product by the prefix product before the k elements.
         return list.get(n-1) / list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */