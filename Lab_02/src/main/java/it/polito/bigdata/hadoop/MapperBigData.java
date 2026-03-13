package it.polito.bigdata.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Lab 2 - Filter Prefix Mapper
 */
class MapperBigData extends Mapper<
                    LongWritable, // Input key type (byte offset)
                    Text,         // Input value type (the line of text)
                    Text,         // Output key type (the filtered word)
                    IntWritable> {// Output value type (the word count)
    
    // Define custom counters to track our filtering statistics
    public enum WordCounters {
        SELECTED_WORDS,
        DISCARDED_WORDS
    }

    private String prefix;

    /**
     * The setup method is executed exactly once per Mapper instance, 
     * before any of the lines are actually processed by the map() method.
     */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // Retrieve the prefix string that we passed from the Driver configuration
        prefix = context.getConfiguration().get("startingWord");
    }
    
    @Override
    protected void map(
            LongWritable key,   // Input key
            Text value,         // Input value (format: "word\tnumber")
            Context context) throws IOException, InterruptedException {

        // 1. Convert the Hadoop Text object to a standard Java String
        String line = value.toString();
        
        // 2. Split the line using the tab character since the input is "word\tnumber"
        String[] parts = line.split("\\t");
        
        // Safety check to ensure the line has exactly two parts (the word and the number)
        if (parts.length == 2) {
            String word = parts[0];
            int count = Integer.parseInt(parts[1]);
            
            // 3. Check if the word starts with our chosen prefix
            if (word.startsWith(prefix)) {
                // Keep the word and emit it exactly as it was
                context.write(new Text(word), new IntWritable(count));
                
                // Increment the "Selected" counter
                context.getCounter(WordCounters.SELECTED_WORDS).increment(1);
            } else {
                // Ignore the word and increment the "Discarded" counter
                context.getCounter(WordCounters.DISCARDED_WORDS).increment(1);
            }
        }
    }
}