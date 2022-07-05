/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;


/**
 *
 * @author ADMIN
 */



public class Library {
    
    enum DupKeyOption {
    OVERWRITE, DISCARD
    }
    public static  HashMap Feature_07(String URL,DupKeyOption dupKeyOption) 
    {
    HashMap<String, String> Hash = new HashMap<>();
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(URL))) {
        while ((line = reader.readLine()) != null) {
            String[] keyValuePair = line.split("`", 2);
            if (keyValuePair.length > 1) {
                String key = keyValuePair[0];
                String value = keyValuePair[1];
                if (DupKeyOption.OVERWRITE == dupKeyOption) {
                    Hash.put(key, value);
                } else if (DupKeyOption.DISCARD == dupKeyOption) {
                    Hash.putIfAbsent(key, value);
                }
            } else {
                System.out.println("No Key, ignore line : " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Hash;
    }
    
    public static String InputKey()
    {
         Scanner sc = new Scanner(System.in);
         System.out.println("Input Key: ");
         String Key = sc.nextLine();
         return Key;
    }
    
    public static List<String> InputListKey()
    {
        int num;
        List<String> ListKey = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number Key for Search : ");
        num = Integer.parseInt(sc.nextLine());
        for (int i =0;i<num;i++)
        {
            System.out.println("Key " + (i+1));
            ListKey.add(InputKey());
        }
        return ListKey;
        
    }
       public static String InputValue()
    {
         Scanner sc = new Scanner(System.in);
         System.out.println("Input Value: ");
         String Value = sc.nextLine();
         return Value;
    }
    
    public static void ShowMap(HashMap<String, String> Hash) {
        Set<String> keySet = Hash.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + Hash.get(key));
        }
    }
    
    public static void SearchKey(HashMap<String, String> Hash,String Key) 
    {
         System.out.println( Key + " : " + Hash.get(Key));
    }
    public static String KeyToValue(HashMap<String, String> Hash,String Key)
    {
        return Hash.get(Key);
    }
    
    public static void SearchListKey(HashMap<String, String> Hash,List<String> Key)
    {
        for(String temp : Key)
        {
            SearchKey(Hash, temp);
        }
    }
    public static void Feature_01(List<String>His,HashMap<String,String>Hash)
    {
        String Key = InputKey();
        His.add(Key);
        SearchKey(Hash, Key);
    }
    public static void Feature_02(List<String>His,HashMap<String,String>Hash)
    {
        List<String> ListKey = new ArrayList<String>();
        ListKey = InputListKey();
        His.addAll(ListKey);
        SearchListKey(Hash, ListKey);
    }
    public static void Feature_03(List<String>His,HashMap<String,String>Hash)
    {
        System.out.println("Slang Words History"); 
        System.out.println(His);
        System.out.println("Value it :");
        SearchListKey(Hash, His);
    }
    
    public static void Feature_04(HashMap<String,String>Hash)
    {
        System.out.println("Add New Slang Words");
        String key = InputKey();
        String value = InputValue();
        Hash.put(key, value);
         System.out.println("Add Success !");
    }
    
    public static void Feature_05(HashMap<String,String>Hash)
    {
         System.out.println("Edit Slang Words");
         String key = InputKey();
         if (!Hash.containsKey(key))
         {
             System.out.println("Key not contain, Error !!! ");
             return ;
         }
         String value = InputValue();
         Hash.replace(key, value);
         System.out.println("Edit Success !");
    }
    public static void Feature_06(HashMap<String,String>Hash)
    {
         System.out.println("Remove Slang Words");
         String key = InputKey();
         if (!Hash.containsKey(key))
         {
             System.out.println("Key not contain, Error !!! ");
             return ;
         }
         boolean Confirm = false;
         System.out.println("Are you sure about that ?");
         System.out.println("If you are sure, press type input 'true', else press type 'false'");
         Scanner sc = new Scanner(System.in);
         Confirm = sc.nextBoolean();
         if(Confirm==false)
         {
             System.out.println("No change, complete !");
             return;
         }
         Hash.remove(key);
         System.out.println("Remove Success !");
         
    }
    public static void Feature_08(HashMap<String,String>Hash)
    {
      
        Random generator = new Random();
        int randomInt = generator.nextInt(7662) + 1;//num of Hash
        Set<String> keySet = Hash.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        String randomKey = keyList.get(randomInt);
        SearchKey(Hash, randomKey);
        
    }
    public static void Feature_09(HashMap<String,String>Hash)
    {
        Random generator = new Random();
        int randomInt = generator.nextInt(7662) + 1;//num of Hash
        int randomInt01 = generator.nextInt(7662) + 1;
        int randomInt02 = generator.nextInt(7662) + 1;
        int randomInt03 = generator.nextInt(7662) + 1;
        
        Set<String> keySet = Hash.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        List<String> Bucket = new ArrayList<>();
        
        
        Bucket.add(KeyToValue(Hash,keyList.get(randomInt)));
        Bucket.add(KeyToValue(Hash,keyList.get(randomInt01)));
        Bucket.add(KeyToValue(Hash,keyList.get(randomInt02)));
        Bucket.add(KeyToValue(Hash,keyList.get(randomInt03)));

        System.out.println("Choice a meaning of the word : " + keyList.get(randomInt));
        
        Collections.shuffle(Bucket);
 
        System.out.println("1-"+ Bucket.get(0));
        System.out.println("2-" + Bucket.get(1));
        System.out.println("3-"+ Bucket.get(2));
        System.out.println("4-"+ Bucket.get(3));
        
        
        System.out.println("Please choice : ");
        Scanner sc = new Scanner(System.in);
        int Choice = Integer.parseInt(sc.nextLine());
         System.out.println("You're choice : "+Bucket.get(Choice-1));
        if (Bucket.get(Choice-1)== KeyToValue(Hash,keyList.get(randomInt)))
            System.out.println("You're Right !!!");
        else
        {
            System.out.println("You're Wrong!!!");
            System.out.println("The correct answer is : " + KeyToValue(Hash, keyList.get(randomInt)));
        }
    }
    
    
        public static void TestPerformance(HashMap<String, String> Hash) {
        Set<String> keySet = Hash.keySet();
           for (int i =0;i<100;i++){
        for (String key : keySet) {
            SearchKey(Hash, key);
         }
        }
    }
    
    
    public static void main(String[] args) {
        HashMap<String,String> Hash = Feature_07("slang.txt", DupKeyOption.OVERWRITE);//7662
//        ShowMap(Hash);
//        List<String> History = new ArrayList<String>();
//        Feature_01(History, Hash);
//        Feature_02(History, Hash);
//        Feature_03(History, Hash);
//        Feature_04(Hash);
//        Feature_05(Hash);
//        Feature_06(Hash);
        TestPerformance(Hash);
//        Feature_08(Hash);
//        Feature_09(Hash);
        
    }
}
