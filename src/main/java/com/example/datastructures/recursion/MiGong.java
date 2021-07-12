package com.example.datastructures.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 先創建一個二維數組 模擬迷宮
        // 地圖
        int[][] map = new int[8][7];
        // 使用1 表示墻
        // 上下行置位1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右行置位1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 設置擋板
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        System.out.println("輸出地圖");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

        // 使用遞歸回溯給小球找路
        // 因為map是引用類型，所以遞歸裡面共享這個map
        setWay(map,1,1);
        // 輸出新的地圖，小球走過，並標識過的遞歸
        System.out.println("小球走球走過，並標識過的遞歸");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

    }


    //使用遞歸回溯來各級小球找路
    //說明：
    // 1.map 表示地圖
    // 2. i j 表示從哪個位置開始出發
    //3. 如果小球找到了map[6][5] 則說明找到通路
    //4. 約定map[i][j] 為0 表示該點沒有走過，1 表示墻 2 表示通路可以走 3，表示該點已經走過，但是走不通
    //5. 在走迷宮時  需要確定一個策略，下-》右—》上-》左，如果該點走不通，再回溯
    /**
     *
     * @param map 表示地圖
     * @param i  從哪個位置找
     * @param j
     * @return 如果找到通路就返回true  否則返回false
     */
    public static boolean setWay(int[][] map ,int i,int j){

        if (map[6][5] == 2){
            return true;// 通路已經找到
        }else {
            if (map[i][j] == 0 ){// 表示這個點還沒有走過
                // 按照策略，下-》右—》上-》左
                map[i][j] = 2;// 假定這個點事可以走通的
                if (setWay(map,i+1,j)){// 向下走
                    return true;
                }else if (setWay(map,i,j+1)){// 向右走
                    return true;
                }else if (setWay(map,i-1,j)){// 向上走
                    return true;
                }else if (setWay(map,i,j-1)){// 向左走
                    return true;
                }else {
                    // 說明上下左右都走不通   該點是走不通的  是死路
                    map[i][j] = 3;
                    return false;
                }

            }else {
                // 如果map[i][j] != 0  可能等於 1，2，3
                // 1 表示墻 2 表示通路可以走 3，表示該點已經走過，但是走不通  這些都是已經走了  就不繼續走了
                return false;

            }
        }
    }
}
