package com.alg.mr.wc;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordcountJob {

	public static void main(String[] args) throws Exception {
		Job job = Job.getInstance();
		job.setJarByClass(WordcountJob.class);
		job.setMapperClass(WordcountMapper.class);
		//job.setCombinerClass(WordcountReducer.class);
		job.setReducerClass(WordcountReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}