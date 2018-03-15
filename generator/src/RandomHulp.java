import java.util.Random;

public class RandomHulp {
    int counter = 0;
    Random r = new Random();
    public RandomHulp() {
    }

    int randomValueBetween(int low, int high, int lowBoundChance, int highBoundChance){

        high+=1;
        highBoundChance+=1;
        if (lowBoundChance == 0 || highBoundChance == 0){
            return  r.nextInt(high-low) + low;
        } else {
            if (counter%3 == 0){
                return  r.nextInt(high-low) + low;
            } else  {
                return  r.nextInt(highBoundChance-lowBoundChance) + lowBoundChance;
            }
        }

    }
    int randomValueBetween(int low, int high){
        return r.nextInt(high-low) + low;
    }
}
