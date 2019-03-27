package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/27 上午10:20
 */
public class FirstBadVersion {

    /**
     * 为了加快速度
     * 使用二分查找
     * 重点是要写对 lo,mid,hi 的值处理
     */
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int hi = n;
        int lo = 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
