//Brute force - O(k*n) + O(n)

class Solution {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if (n < 2) return 0.0; 
        int[] howMany = new int[n-1];
        Arrays.fill(howMany, 0);
        for(int i =1; i<= K; i++){
            double maxSection = -1;
            int maxInd = -1;
            for(int j =0; j<n-1; j++){
                double diff = stations[j+1] - stations[j];
                double sectionLength = diff/(howMany[j] + 1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = j;
                }
            }
            howMany[maxInd]++;
        }
        double maxAns = -1;
        for(int i =0; i<n-1; i++){
            double diff = stations[i+1] - stations[i];
            double sectionLength = diff/(howMany[i] + 1);
            maxAns = Math.max(maxAns,sectionLength);
        }
        
        return maxAns;
        
    }
}


// Using Max Heap - O(Nlogn + Klogn) 

class Segment{
    double length;
    int index;
    
    Segment(double length, int index){
        this.length = length;
        this.index = index;
    }
}
class Solution {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if (n < 2) return 0.0; 
        int[] howMany = new int[n-1];
        PriorityQueue<Segment> pq = new PriorityQueue<>((a,b) -> Double.compare(b.length, a.length));
        
        for(int i =0; i< n-1; i++){
            int diff = stations[i+1] - stations[i];
            pq.offer(new Segment(diff,i));
        }
       
        for(int i =1; i<= K; i++){
            Segment curr = pq.poll();
            int index = curr.index;
            howMany[index]++;
            int diff = stations[index + 1] - stations[index]; 
            double segmentLength = (double)diff/(howMany[index] + 1);
            
            pq.offer(new Segment(segmentLength, index));
            
        }
      
        return pq.poll().length;
        
    }
}
