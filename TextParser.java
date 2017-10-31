package crestaltest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class TextParser {

    private final Map<String, Long> wordsMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        TextParser parser = new TextParser();
        parser.countWords("C:\\t\\test.txt");
        parser.printWords();
    }

    private void countWords(String file) throws IOException {
        //String line = null;
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))){
            String line = null;
            while((line = rd.readLine()) != null){
                String[] words = splitWords(line);
                putWordsIfAbsent(words);
            }
            rd.close();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    private String[] splitWords(String line){
        return line.split(" ");
    }

    private void putWordsIfAbsent(String[] words){
        for(String s : words){
            Long count = wordsMap.getOrDefault(s,Long.valueOf(0));
            count++;
            wordsMap.put(s, count);
        }
    }

    private void printWords(){
        for (Map.Entry<String,Long> entry : wordsMap.entrySet()){
            System.out.println("Word: "+entry.getKey() + " Count: " + entry.getValue());
        }
    }

}
