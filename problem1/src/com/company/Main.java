package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


class Item
{
    String name;

    int value;

    Item(int value, String name)
    {
        this.name = name;

        this.value = value;
    }
}



class nameCompare implements Comparator<Item>
{
    @Override
    public int compare(Item s1, Item s2)
    {
        return s1.name.compareTo(s2.name);
    }
}

class valueCompare implements Comparator<Item>
{
    @Override
    public int compare(Item s1, Item s2)
    {
        return s1.value - s2.value;
    }
}

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tejas2\\OneDrive - Medtronic PLC\\Desktop\\problem1\\src\\com\\company\\input.txt"));

        ArrayList<Item> itemRecords = new ArrayList<Item>();
        ArrayList<Item> itemStrings = new ArrayList<Item>();
        String currentLine = reader.readLine();

        while (currentLine != null)
        {
            String[] ItemDetail = currentLine.split(" ");
            String name="";
            int value =0;
            if(ItemDetail.length==1) {
                name=ItemDetail[0];
                itemStrings.add(new Item(value, name));
            }else if(ItemDetail.length==2){
                name= ItemDetail[1];
                value = Integer.parseInt(ItemDetail[0]);
                itemRecords.add(new Item(value, name));
            }
            currentLine = reader.readLine();
        }
        itemStrings.sort(new nameCompare());
        itemRecords.sort(new nameCompare());
        itemRecords.sort(new valueCompare());

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (Item item : itemRecords)
        {
            writer.write(item.value +" ");

            writer.write(item.name);

            writer.newLine();
        }
        for(Item item: itemStrings) {

            writer.write(item.name);

            writer.newLine();
        }
        reader.close();

        writer.close();
    }
}
