package top.zhyee.java.leetcode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystemPair {
    
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Integer, Integer>> historyMap;
    
    public UndergroundSystemPair() {
        checkInMap = new HashMap<>();
        historyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (checkInMap.containsKey(id)) {
            return;
        }
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = checkInMap.get(id);
        String k = pair.getKey() + stationName;
        Pair<Integer, Integer> history;
        if (historyMap.containsKey(k)) {
            history = historyMap.get(k);
            int count = history.getKey() + 1;
            int time = history.getValue() + t - pair.getValue();
            history = new Pair<>(count, time);
        } else {
            history = new Pair<>(1, t - pair.getValue());
        }
        historyMap.put(k, history);
        checkInMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String k = startStation + endStation;
        Pair<Integer, Integer> integerIntegerPair = historyMap.get(k);
        return integerIntegerPair.getValue() / integerIntegerPair.getKey();
    }
    
    public static void main(String[] args) {
        UndergroundSystemPair undergroundSystem = new UndergroundSystemPair();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");
        
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        
    }
}
