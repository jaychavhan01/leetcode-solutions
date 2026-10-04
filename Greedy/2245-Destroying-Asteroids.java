class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currentMass = mass;
        Arrays.sort(asteroids);
        
        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }
        
        return true;
    }
}
