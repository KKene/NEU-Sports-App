package com.example.neusportsapp.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Page {

    String year;
    String overall;
    String conference;
    String streak;
    String home;
    String away;
    String neutral;
    ArrayList<Game> games = new ArrayList<Game>();


    Page(File file) throws IOException {
        int numLines = countLines(file); //Counts the lines in the file
        ArrayList<Integer> indexes = new ArrayList<Integer>(); // Stores Indexes of columns of data
        FileUtility fu = new FileUtility();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine;

        for(int i=1; i <= numLines; i++) {
            currentLine = br.readLine();
            if (i == 3)
                year = fu.findData(currentLine, 0);
            if (i == 6)
                overall = fu.findData(currentLine, 11);
            if (i == 8)
                conference = fu.findData(currentLine, 11);
            if (i == 10)
                streak = fu.findData(currentLine, 11);
            if (i == 12)
                home = fu.findData(currentLine, 11);
            if (i ==14)
                away = fu.findData(currentLine, 11);
            if (i == 16)
                neutral = fu.findData(currentLine, 11);
            if (i == 19)
                indexes = fu.findIndexes(currentLine);
            else if (i>20 && i%2==1)
                games.add(fu.makeGame(currentLine, indexes));
        }
        br.close();
    }

    public int countLines(File file) throws IOException {
        int numLines = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));    //Creation of Buffered Reader object
        String s;
        while((s=br.readLine())!=null)    //Reading Content from the file line by line
            numLines++;
        br.close();
        return numLines;
    }
}
