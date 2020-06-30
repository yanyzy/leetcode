package top.zhyee.java.leetcode.medium;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StatisticsfromaLargeSample {
    
    public double[] sampleStats(int[] count) {
        double[] rs = new double[5];
        
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        int k = 0;
        int m = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > k) {
                k = count[i];
                m = i;
            }
            int j = count[i];
            while (j > 0) {
                list.add(i);
                sum += i;
                j--;
            }
        }
        
        rs[0] = list.stream().min(Integer::compareTo).get().doubleValue();
        rs[1] = list.stream().max(Integer::compareTo).get().doubleValue();
        rs[2] = (double)sum / (double)list.size();
        int t = list.size() % 2;
        rs[3] = t == 0 ? ((double)list.get(list.size() / 2) + (double)list.get(list.size() / 2 + 1)) / 2 : (double)list.get(list.size() / 2 + 1);
        rs[4] = m;
        return rs;
    }
}
