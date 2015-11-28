package com.rreddy.mr.anagram;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class anagramMapper extends Mapper<Object, Text, Text, IntWritable> {
		private Text word = new Text();
		private final static IntWritable one = new IntWritable(1);
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			StringTokenizer itr = new StringTokenizer(value.toString());
			while (itr.hasMoreTokens()){
				String str = itr.nextToken();
				char[] chararr = str.toCharArray();
				Arrays.sort(chararr);
				String sortStr = new String(chararr);
				word.set(sortStr);
				context.write(word,one);
			}
		}
			
	}

		
