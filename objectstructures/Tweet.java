package objectstructures;

public class Tweet {
	private String tweetInnhold;
	private TwitterAccount valgtAcc;
	private Tweet reTweet;
	private int timesRT;
	
	public Tweet(TwitterAccount valgtAcc, String tweetInnhold) {
		this.valgtAcc = valgtAcc;
		this.tweetInnhold = tweetInnhold;
	}
	
	public Tweet(TwitterAccount valgtAcc, Tweet reTweet) {
		/*if(valgtAcc == reTweet.getOwner()) {
			throw IllegalArgumentException("Du kan ikke retweete din egen tweet.");
		}*/
		this.valgtAcc = valgtAcc;
		this.reTweet = reTweet;
		this.timesRT++;
	}
	
	public String getText() {
		return this.tweetInnhold;
	}
	
	public TwitterAccount getOwner() {
		return this.valgtAcc;
		
	}
	
	public Tweet getOriginalTweet() {
		return this.reTweet;
	}
	
	public int getRetweetCount() {
		return this.timesRT;
	}
	
	public static void main(String[] args) {
		TwitterAccount vigdis = new TwitterAccount("VigdisTwitter");
		TwitterAccount monika = new TwitterAccount("MonikasTwitter");
		TwitterAccount leo = new TwitterAccount("LeosTwitter");
		
		Tweet forsteTweet = new Tweet(vigdis, "Lættis");
		Tweet littyTweet = new Tweet(monika, "Denne tweeten er litty8)))");
		Tweet retweet = new Tweet(monika, forsteTweet);
		
		System.out.println("Tweetinnhold: "+ littyTweet.getText().toString());
		System.out.println("Eier av originalTweet: "+ retweet.getOriginalTweet().toString());
		System.out.println("Antall ganger tweeten "+ forsteTweet + " har blitt retweetet er: "+ String.valueOf(forsteTweet.getRetweetCount()));
	}

}
