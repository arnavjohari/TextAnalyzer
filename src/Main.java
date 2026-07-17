import java.util.*;

public static void WordFreq(String input , String output){
   int ans =0;
   String cleanInput = input.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
   String[] words = cleanInput.split("\\s+");
   HashMap<String , Integer> map = new HashMap<>();
   for(String word : words){
      map.put(word , map.getOrDefault(word ,0) + 1);
   }
   if(map.containsKey(output)){
       ans = map.get(output);
   } System.out.println(ans);
}
public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   String input = sc.nextLine();
   String output = sc.nextLine();
   WordFreq(input , output);

}
