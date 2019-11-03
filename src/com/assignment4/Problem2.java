package com.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class DuplicateCounter
{
    int wordCounter;
    static Map<String,Integer> dataCount;
    public DuplicateCounter()
    {
        this.dataCount = new HashMap<String,Integer>();
    }

    public void count(String dataFile) throws FileNotFoundException
    {
        Scanner scnr = new Scanner(new File(dataFile));

        while (scnr.hasNext())
        {
            String word = scnr.next();
            Integer count = dataCount.get(word);
            wordCounter++;
            if (count != null)
            {
                count = count + 1;
            }
            else
            {
                count = 1;
            }
            dataCount.put(word, count);
        }

    }

    public void write(String outputFile) throws IOException
    {
        FileWriter newCount = new FileWriter(new File(outputFile));
        for (Entry<String, Integer> entry: dataCount.entrySet())
            newCount.write(entry.getKey() + ": " + entry.getValue()+"\n");

        newCount.write(wordCounter+" words in total.");
        newCount.close();

    }
}

class Application2
{
    public static void main(String[] args) throws IOException
    {
        DuplicateCounter i = new DuplicateCounter();
        i.count("problem2.txt");
        i.write("unique_word_counts.txt");

    }

}
