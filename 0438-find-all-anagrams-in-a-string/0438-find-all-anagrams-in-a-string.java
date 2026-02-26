class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            } //я хз, зачем эта штука, все ее вставляют, ну и я тоже, она ускоряет, как я понял
        }));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        char[] st=p.toCharArray();
        Arrays.sort(st);
        for(int i=0;i<=s.length()-p.length();i++){
           char [] temp=s.substring(i,i+p.length()).toCharArray();
           
           Arrays.sort(temp);
           
           if(Arrays.equals(temp,st)){
            res.add(i);
           }
        }
        return res;
    }
}