package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersfromtheFilesystem {
    
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> strings = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String value : folder) {
            String s = value.substring(0, value.lastIndexOf("/"));
            boolean flag = true;
            while (s.contains("/")) {
                if (map.containsKey(s)) {
                    flag = false;
                    break;
                }
                s = s.substring(0, s.lastIndexOf("/"));
            }
            if (flag) {
                strings.add(value);
                map.put(value, 0);
            }
        }
        return strings;
    }
}
