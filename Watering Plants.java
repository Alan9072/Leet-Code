class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int originalCapacity = capacity;
        String abc = "";
        int steps = 0;
        for(int j=0;j<plants.length;j++){
            
             for(int i=0;i<plants.length;i++)
                {
                    if(plants[i]==0){

                        steps++;
                        continue;
                    }
                    if(plants[i]>0){
                        
                        int needed = plants[i];
                        if(capacity>=needed)
                        {
                            steps++;
                            capacity-=needed;
                            plants[i] = 0;
                            abc+=plants[i];
                        }
                        else{
                            capacity = originalCapacity;
                            steps = steps + (i);
                            break;

                        }
                    }
                   
                }
            if(abc.length() == plants.length)
               return steps;   
            } 
      return steps; 
    }
}
