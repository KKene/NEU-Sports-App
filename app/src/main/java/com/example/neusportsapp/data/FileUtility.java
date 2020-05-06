package com.example.neusportsapp.data;

import java.util.ArrayList;

public class FileUtility {

    public String findData(String currentLine, int start) {
        String data = "";
        for (int index=start; index<currentLine.length(); index++) {
            if (currentLine.substring(index, index+1).equals(" "))
                break;
            else
                data+=currentLine.substring(index, index+1);
        }
        return data;
    }

    public String findData2(String currentLine) {
        int letterIndex = 0;
        for(int index=currentLine.length()-1; index>0; index--) {
            if (!currentLine.substring(index).equals(" ")) {
                letterIndex = index;
                break;
            }
        }
        return currentLine.substring(0, letterIndex);
    }

    public Game makeGame(String currentLine, ArrayList<Integer> indexes) {
        return new Game(findData2(currentLine.substring(indexes.get(0),indexes.get(1))),
                findData2(currentLine.substring(indexes.get(1),indexes.get(2))),
                findData2(currentLine.substring(indexes.get(2),indexes.get(3))),
                findData2(currentLine.substring(indexes.get(3),indexes.get(4))),
                findData2(currentLine.substring(indexes.get(4),indexes.get(5))),
                findData2(currentLine.substring(indexes.get(6),indexes.get(7))),
                findData2(currentLine.substring(indexes.get(7))));
    }

    public ArrayList<Integer> findIndexes(String currentLine) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<currentLine.length();i++)
            if(Character.isUpperCase(currentLine.charAt(i)))
                list.add(i);
        list.add(list.get(6)+2);
        return list;
    }
}
