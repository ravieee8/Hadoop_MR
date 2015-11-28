package com.rreddy.mr.bigram;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class bigramMapper extends Mapper<Object, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		
			String [] words = value.toString().split(" ");
			for	(int i = 0; i < words.length; i+=2) {
				String str1 = words[i];
				String str2 = words[i+1];
				if (str2.isEmpty()){
					continue;
				}
				String str3 = str1 + " " + str2;
				context.write(new Text(str3.toString()), one);
			}
	}
}
