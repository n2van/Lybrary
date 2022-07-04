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
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


/**
 *
 * @author ADMIN
 */



public class Library {
    
    enum DupKeyOption {
    OVERWRITE, DISCARD
    }
    public static  TreeMap Feature_07(String URL,DupKeyOption dupKeyOption) 
    {
    TreeMap<String, String> Tree = new TreeMap<>();
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(URL))) {
        while ((line = reader.readLine()) != null) {
            String[] keyValuePair = line.split("`", 2);
            if (keyValuePair.length > 1) {
                String key = keyValuePair[0];
                String value = keyValuePair[1];
                if (DupKeyOption.OVERWRITE == dupKeyOption) {
                    Tree.put(key, value);
                } else if (DupKeyOption.DISCARD == dupKeyOption) {
                    Tree.putIfAbsent(key, value);
                }
            } else {
                System.out.println("No Key, ignore line : " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Tree;
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
    
    public static void ShowMap(TreeMap<String, String> Tree) {
        Set<String> keySet = Tree.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + Tree.get(key));
        }
    }
    
    public static void SearchKey(TreeMap<String, String> Tree,String Key) 
    {
         System.out.println( Key + " : " + Tree.get(Key));
    }
    public static void SearchListKey(TreeMap<String, String> Tree,List<String> Key)
    {
        for(String temp : Key)
        {
            SearchKey(Tree, temp);
        }
    }
    public static void Feature_01(List<String>His,TreeMap<String,String>Tree)
    {
        String Key = InputKey();
        His.add(Key);
        SearchKey(Tree, Key);
    }
    public static void Feature_02(List<String>His,TreeMap<String,String>Tree)
    {
        List<String> ListKey = new ArrayList<String>();
        ListKey = InputListKey();
        His.addAll(ListKey);
        SearchListKey(Tree, ListKey);
    }
    public static void Feature_03(List<String>His,TreeMap<String,String>Tree)
    {
        System.out.println("Slang Words History"); 
        System.out.println(His);
        System.out.println("Value it :");
        SearchListKey(Tree, His);
    }
    
    public static void Feature_04(TreeMap<String,String>Tree)
    {
        System.out.println("Add New Slang Words");
        String key = InputKey();
        String value = InputValue();
        Tree.put(key, value);
         System.out.println("Add Success !");
    }
    
    public static void Feature_05(TreeMap<String,String>Tree)
    {
         System.out.println("Edit Slang Words");
         String key = InputKey();
         if (!Tree.containsKey(key))
         {
             System.out.println("Key not contain, Error !!! ");
             return ;
         }
         String value = InputValue();
         Tree.put(key, value);
         System.out.println("Edit Success !");
    }
    public static void Feature_06(TreeMap<String,String>Tree)
    {
         System.out.println("Remove Slang Words");
         String key = InputKey();
         if (!Tree.containsKey(key))
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
         Tree.remove(key);
         System.out.println("Remove Success !");
         
    }
    
    public static void main(String[] args) {
        TreeMap<String,String> map = Feature_07("slang.txt", DupKeyOption.OVERWRITE);
        ShowMap(map);
//        List<String> History = new ArrayList<String>();
//        Feature_01(History, map);
//        Feature_02(History, map);
//        Feature_03(History, map);
//        Feature_04(map);
//        Feature_05(map);
//        Feature_06(map);



        
    }
}
