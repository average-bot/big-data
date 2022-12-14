package com.company;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class T_Mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
    private final static IntWritable one = new IntWritable(1);
    public void map(LongWritable key, Text value,OutputCollector<Text,IntWritable> output,
                    Reporter reporter) throws IOException{
        try {
            if (key.get() == 0 && value.toString().contains("SPEED"))
                return;
            else {
                String data[] = value.toString().split(",");
                String speed_column = data[1];
                double speed = Double.parseDouble(speed_column);
                double converted_speed = Math.floor(speed / 10) * 10;
                output.collect(new Text(String.valueOf((int)converted_speed)), one);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
