package Greedy;

import java.util.Arrays;

//Example 1:
//
//        Input: g = [1,2,3], s = [1,1]
//        Output: 1
//        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//        You need to output 1.
public class AssignCookie {
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;

        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int g[] = {1,2,3};
        int s[] = {1,3};
        findContentChildren(g,s);
        System.out.println(findContentChildren(g,s));
    }
}
