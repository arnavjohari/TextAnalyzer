import java.util.*;

public static Map<String , Integer> WordFreq(String input){
   int ans =0;

   Set<String> excluded = Set.of("is", "am", "are", "the", "of", "for", "and", "not", "if", "with");

   String cleanInput = input.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
   String[] words = cleanInput.split("\\s+");
   HashMap<String , Integer> map = new HashMap<>();
   for(String word : words) {
      if (!excluded.contains(word)) {
         map.put(word, map.getOrDefault(word, 0) + 1);
      }
   }
   return map;
}
public static void FreqOfRequired(String output , Map<String , Integer> map){
   if(map.containsKey(output)){
      System.out.println(map.get(output));
   }
}

public static void Top5Words( Map<String , Integer> map){
   List< Map.Entry<String , Integer>> list =  new ArrayList<>();

   for(Map.Entry<String , Integer> entry : map.entrySet()) {
      list.add(entry);
   }
   list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
   if(list.size() < 5){
      System.out.println("Insufficient Words");
   }
   for(int i=0;i<Math.min(list.size() , 5);i++){
      System.out.println(list.get(i));
   }

}
public static void main(String[] args) throws IOException{
   String input = Files.readString(Path.of("input.txt"));
           Scanner sc = new Scanner(System.in);
   String output = sc.nextLine();
  Map<String , Integer> mymap = WordFreq(input);
  FreqOfRequired (output ,mymap);
   Top5Words(mymap);
}
