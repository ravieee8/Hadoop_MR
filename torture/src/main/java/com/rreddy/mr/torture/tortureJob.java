package com.rreddy.mr.torture;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

public class tortureJob {

		public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJobName("torture");
		job.setJarByClass(tortureJob.class);
		job.setMapperClass(tortureMapper.class);
		job.setNumReduceTasks(0);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		
		System.exit(job.waitForCompletion(true)?0:1);
		
	}

}
