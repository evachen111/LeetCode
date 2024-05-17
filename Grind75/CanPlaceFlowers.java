package Grind75;

// 605
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0){
            return true;
        }

        if (n == 0){
            return true;
        }

        for (int i = 0; i< flowerbed.length; i++){
            if (flowerbed[i] == 0){
                if (i > 0 && i < flowerbed.length-1){
                    if (flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else if (i == 0){
                    if (flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else if (i == flowerbed.length-1){
                    if (flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
            if (n == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,1,0,0};

        CanPlaceFlowers sol = new CanPlaceFlowers();

        System.out.println(sol.canPlaceFlowers(a,0));
    }
}
