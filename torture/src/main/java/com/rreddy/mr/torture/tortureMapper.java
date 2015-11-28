package com.rreddy.mr.torture;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class tortureMapper extends Mapper<Object, Text, Text, NullWritable>{

	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		if (line.toLowerCase().matches("torture")) {
			context.write(value, NullWritable.get());
		}
		
	}
	
	

}
