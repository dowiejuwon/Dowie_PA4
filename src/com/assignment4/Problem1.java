package com.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


class DuplicateRemover
{
    private Set<String> uniqueWords;
    public void remove(String dataFile) throws FileNotFoundException
    {
        String word;
        uniqueWords = new HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));
        while(scnr.hasNext())
        {
            word=scnr.next();
            uniqueWords.add(word);
        }
        scnr.close();


    }

    public void Write(String outputFile) throws IOException
    {
        File a;
        FileWriter newText = null;

        a = new File(outputFile);
        if(a.exists())
        {
            newText = new FileWriter(a,true);
            Iterator itr=uniqueWords.iterator();

            while(itr.hasNext())
            {
                String str=(String)itr.next();
                newText.write(str+"\n");
            }
            newText.close();

        }
        else
        {
            a.createNewFile();
            newText = new FileWriter(a);
            Iterator itr=uniqueWords.iterator();

            while(itr.hasNext())
            {
                String str=(String)itr.next();
                newText.write(str+"\n");
            }
            newText.close();
        }

    }

}

class Application
{
    public static void main(String[] args) throws IOException
    {
        DuplicateRemover x = new DuplicateRemover();
        x.remove("problem1.txt");
        x.Write("unique_words.txt");

    }

}

