package xiaoluangao;

/**
 * @author fengjie
 * @date 2019:04:09
 */
public class Posts {

    public synchronized void solution(int[] rooms, int[] postNums) {
        for (int post : postNums) {
            int buildNum = 0;
            int preTotal = 0;
            while (post > preTotal + rooms[buildNum]) {
                preTotal += rooms[buildNum++];
            }
            System.out.println((buildNum + 1) + " " + (post - preTotal));
        }
    }

}
