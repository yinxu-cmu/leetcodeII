package array;

public class _605_Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
        考虑各种边界条件
        00000
        0-0-?0_
        0-0-end +1
        [1,0,0,0,0,0,1]
        [0,0,0,0,1]
        */
//        int count = 0;
//        if (flowerbed.length == 1 && flowerbed[0] == 0) {
//            return n <= 1;
//        }
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0) {
//                if (i == 0 && flowerbed[i+1] == 0) {
//                    count++;
//                } else if (i+1 < flowerbed.length && i+2 < flowerbed.length && flowerbed[i+1] == 0 && flowerbed[i+2] == 0) {
//                    count++;
//                    i = i+1;
//                } else if (i+1 == flowerbed.length - 1 && flowerbed[i+1] == 0) {
//                    count++;
//                }
//            }
//        }
//        return count >= n;

        /**
         * much cleaner solution
         */
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}
