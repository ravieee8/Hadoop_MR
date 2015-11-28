package com.rreddy.mr.anagram;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class anagramReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable finalVal = new IntWritable();
	public void reduce(Text key, Iterable<IntWritable> value, Context context)
			throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : value) 
			{
				sum += val.get();
								
			}
			finalVal.set(sum);
			context.write(key, finalVal);
	}
	
	

}
