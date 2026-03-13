package it.polito.bigdata.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * MapReduce program - Lab 2 (Filter Prefix)
 */
public class DriverBigData extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    // Ensure we have exactly 3 parameters: Input, Output, and Prefix
    if (args.length != 3) {
      System.err.println("Usage: DriverBigData <input path> <output path> <prefix>");
      return -1;
    }

    Path inputPath = new Path(args[0]);
    Path outputDir = new Path(args[1]);
    String prefix = args[2];

    Configuration conf = this.getConf();
    
    // Pass the prefix parameter to the Mapper class
    conf.set("startingWord", prefix);

    // Define a new job
    Job job = Job.getInstance(conf); 

    // Assign a name to the job
    job.setJobName("Lab 2 - Filter Prefix Map-Only");
    
    // Set path of the input file/folder
    FileInputFormat.addInputPath(job, inputPath);
    
    // Set path of the output folder
    FileOutputFormat.setOutputPath(job, outputDir);
    
    // Specify the class of the Driver for this job
    job.setJarByClass(DriverBigData.class);
    
    // Set job input format
    job.setInputFormatClass(TextInputFormat.class);

    // Set job output format
    job.setOutputFormatClass(TextOutputFormat.class);
       
    // Set map class
    job.setMapperClass(MapperBigData.class);
    
    // Set map output key and value classes
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    
    // CRITICAL: This is a Map-only job, so we bypass the Reducer entirely
    job.setNumReduceTasks(0);
   
    int exitCode = 0;
    
    // Execute the job and wait for completion
    if (job.waitForCompletion(true)) {
      exitCode = 0;
      
      // Fetch and print the counters after the job finishes successfully
      Counters counters = job.getCounters();
      
      long selected = counters.findCounter(MapperBigData.WordCounters.SELECTED_WORDS).getValue();
      long discarded = counters.findCounter(MapperBigData.WordCounters.DISCARDED_WORDS).getValue();
      
      System.out.println("========================================");
      System.out.println("Total Selected Words: " + selected);
      System.out.println("Total Discarded Words: " + discarded);
      System.out.println("========================================");
      
    } else {
      exitCode = 1;
    }
      
    return exitCode;
  }

  /** Main of the driver */
  public static void main(String args[]) throws Exception {
    int res = ToolRunner.run(new Configuration(), new DriverBigData(), args);
    System.exit(res);
  }
}