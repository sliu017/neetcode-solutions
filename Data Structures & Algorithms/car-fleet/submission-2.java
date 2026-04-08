class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for(int i = 0; i < n; i++){
            cars[i] = new Car(position[i],speed[i]);
        }
        Arrays.sort(cars,(a,b) -> a.position - b.position);

        Stack<Double> s = new Stack<>();
        for(int i = 0; i < n; i++){
            double finish = (double)(target - cars[i].position) / cars[i].speed;
            while(!s.isEmpty() && s.peek() <= finish){
                s.pop();
            }
            s.add(finish);
        }
        return s.size();        
    }
    public class Car {
        int position;
        int speed;
        public Car(int pp, int ss){
            position = pp;
            speed = ss;
        }
    }
}
