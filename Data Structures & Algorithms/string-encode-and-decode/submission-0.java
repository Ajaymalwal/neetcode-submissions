class Solution {

    public String encode(List<String> strs) {
        StringBuilder eS = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            eS.append(len).append("#").append(str);
        }
        return eS.toString();

    }

    public List<String> decode(String str) {
        
        int i =0;
        List<String> result = new ArrayList<>();
        while(i < str.length()){
            int len = 0;
            while(str.charAt(i) != '#') {
                len = (len*10)+ str.charAt(i) - '0';
                i++;
                }
                i++;
                String word = str.substring(i,i+len);
                result.add(word);
                i = i + len;
            
        }
        return result;
    }
}
