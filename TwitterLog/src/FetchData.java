import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class FetchData {

	public String getDataFromTwitter(String data) {
		// TODO Auto-generated method stub
				 final String CONSUMER_KEY = "bZaMzyE85Q0IW3izBZR1gjSHk";
				 final String CONSUMER_KEY_SECRET = "Ypfv4aKAhzqpyJzWO7TY3kLftubXR5J2aUYYkBRRcHTugM6P2H";
			     //Instantiate a re-usable and thread-safe factory
			     TwitterFactory twitterFactory = new TwitterFactory();
			     
			     //Instantiate a new Twitter instance
			     Twitter twitter = twitterFactory.getInstance();
			     twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

			     String accessToken = "1177056179190554624-XUM5IJT8SdNRn43oWR06iXN8Va5yhb";
			     String accessTokenSecret = "WYKzbcmnKa1G0t6HBuYZp7rpGyOvJRjVT1Kpt8uscPQXX";
			     AccessToken oathAccessToken = new AccessToken(accessToken,
			      accessTokenSecret);
			     
			     twitter.setOAuthAccessToken(oathAccessToken);
			     
			     try {
			            Query query = new Query(data);
			            QueryResult result;
			            File file = new File("D:/"+ data.replaceAll("[^a-zA-Z0-9]", "") +".txt");
	                	BufferedWriter writer = Files.newBufferedWriter(file.toPath());
		                do {
			                result = twitter.search(query);
			                List<Status> tweets = result.getTweets();
			                for (Status tweet : tweets) {
			                	 String text = "@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + "\n\n"; 
			                	 int dataLength = text.getBytes("UTF-8").length;
			                         if (file.length() + dataLength < 10000 ) {
			                             writer.write(text);
			                             writer.flush();
			                         }else {
			                        	 return "100 KB file size reached for query :" + data + "\n" ; 
			                         }
			                }
			            } while ((query = result.nextQuery()) != null );
			        } catch (TwitterException te) {
			            te.printStackTrace();
			            System.out.println("Failed to search tweets: " + te.getMessage());
			            return "Failed to search tweets: " + te.getMessage()  + "\n";
			        } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return "Data Format not supported" + "\n";
					} catch (IOException e) {
                        e.printStackTrace();
                        return "File system issue noticed" + "\n";
                    }finally {
			        	System.out.println("All available tweets retriewed");
			        }
			      return "All available tweets retriewed for search condition: " + data + "\n";
	}
}
