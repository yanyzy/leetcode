package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    
    private Map<Integer, Integer> userMap;
    private Map<Integer, Obj> objMap;
    
    public UndergroundSystem() {
        userMap = new HashMap<>();
        objMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (userMap.containsKey(id) && userMap.get(id) == t) {
            return;
        }
        userMap.put(id, t);
        Obj obj = new Obj();
        obj.startTime = t;
        obj.id = id;
        obj.startStation = stationName;
        objMap.put(id, obj);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Obj obj = objMap.get(id);
        obj.endTime = t;
        obj.endStation = stationName;
        userMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return objMap.values().stream()
                .filter(o -> o.startStation.equals(startStation) && o.endStation != null && o.endStation.equals(endStation))
                .mapToDouble(o -> o.endTime - o.startTime)
                .average()
                .getAsDouble();
    }
    
    private class Obj {
        int id;
        int startTime;
        int endTime;
        String startStation;
        String endStation;
        
        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }
        
        public int getStartTime() {
            return startTime;
        }
        
        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }
        
        public int getEndTime() {
            return endTime;
        }
        
        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
        
        public String getStartStation() {
            return startStation;
        }
        
        public void setStartStation(String startStation) {
            this.startStation = startStation;
        }
        
        public String getEndStation() {
            return endStation;
        }
        
        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }
    }
    
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
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
