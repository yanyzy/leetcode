package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/4/2 下午5:20
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int next = 0;

        while (aIndex >= 0 && bIndex >= 0) {
            int add = (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0') + next;
            next = 0;

            if (add >= 2) {
                next = add / 2;
                add = add % 2;
            }
            stringBuilder.append(add);
            aIndex--;
            bIndex--;
        }

        if (aIndex >= 0) {
            while (aIndex >= 0) {
                int add = (a.charAt(aIndex) - '0') + next;
                next = 0;

                if (add >= 2) {
                    next = add / 2;
                    add = add % 2;
                }
                stringBuilder.append(add);
                aIndex--;
            }
        } else if (bIndex >= 0) {
            while (bIndex >= 0) {
                int add = (b.charAt(bIndex) - '0') + next;
                next = 0;

                if (add >= 2) {
                    next = add / 2;
                    add = add % 2;
                }
                stringBuilder.append(add);
                bIndex--;
            }
        }

        if (next > 0) {
            stringBuilder.append(next);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }

}
