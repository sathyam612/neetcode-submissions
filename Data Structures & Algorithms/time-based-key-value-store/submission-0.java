class TimeMap {
    private Map<String, Map<Integer,String>> keyStore;
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key,k-> new HashMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key)){
            return "";
        }

        Map<Integer, String> values = keyStore.get(key);

        int bestTimeStamp = -1;

        for(int value: values.keySet()){
            if(value<=timestamp){
                bestTimeStamp = Math.max(bestTimeStamp,value);
            }
        }

        return bestTimeStamp == -1 ? "" : values.get(bestTimeStamp);
    }
}
