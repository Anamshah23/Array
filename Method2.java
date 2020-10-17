
// Java program to find k'th smallest element in expected 
// linear time 
class KthSmallst 
{ 
  
    int kthSmallest(int arr[], int l, int r, int k) 
    { 
        // If k is smaller than number of elements in array 
        if (k > 0 && k <= r - l + 1) 
        { 
         
            int pos = randomPartition(arr, l, r); 
  
            // If position is same as k 
            if (pos-l == k-1) 
                return arr[pos]; 
  
            // If position is more, recur for left subarray 
            if (pos-l > k-1) 
                return kthSmallest(arr, l, pos-1, k); 
  
            return kthSmallest(arr, pos+1, r, k-pos+l-1); 
        } 
  
        // If k is more than number of elements in array 
        return Integer.MAX_VALUE; 
    } 
  
    void swap(int arr[], int i, int j) 
    { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    } 
  

    int partition(int arr[], int l, int r) 
    { 
        int x = arr[r], i = l; 
        for (int j = l; j <= r - 1; j++) 
        { 
            if (arr[j] <= x) 
            { 
                swap(arr, i, j); 
                i++; 
            } 
        } 
        swap(arr, i, r); 
        return arr; 
    } 
  
    // element using partition() 
    int randomPartition(int arr[], int l, int r) 
    { 
        int n = r-l+1; 
        int pivot = (int)(Math.random()) * (n-1); 
        swap(arr, l + pivot, r); 
        return partition(arr, l, r); 
    } 
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
        KthSmallst ob = new KthSmallst(); 
        int arr[] = {12, 3, 5, 7, 4, 19, 26}; 
        int n = arr.length,k = 3; 
        System.out.println("K'th smallest element is "+ 
                           ob.kthSmallest(arr, 0, n-1, k)); 
    } 