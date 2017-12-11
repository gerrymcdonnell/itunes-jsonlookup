package course.examples.Networking.AndroidHttpClientJSON.ITunes;

public class ITunesRecord {
	
	private String sArtist;
	private String sAlbum;
	private String sTrack;
	private String sGenre;
	private String sReleaseDate;
	private long lTrackTimeMilliSecs;
	private String sImgURL;
	private String sYear;
	
	
	public ITunesRecord(){
		
	}
	
	
	
	public ITunesRecord(String sArtist, String sAlbum, String sTrack,
			String sGenre, String sReleaseDate, long lTrackTimeMilliSecs) {
		super();
		this.sArtist = sArtist;
		this.sAlbum = sAlbum;
		this.sTrack = sTrack;
		this.sGenre = sGenre;
		this.sReleaseDate = sReleaseDate;
		this.lTrackTimeMilliSecs = lTrackTimeMilliSecs;
	}

	//this will be calculated
	//formatted string of track duration "03:45"
	public String getDuration(){
		return "0:00";
	}
	
	
	
	
	
	
	public String getsImgURL() {
		return sImgURL;
	}



	public void setsImgURL(String sImgURL) {
		this.sImgURL = sImgURL;
	}



	public long getlTrackTimeMilliSecs() {
		return lTrackTimeMilliSecs;
	}
	public void setlTrackTimeMilliSecs(long lTrackTimeMilliSecs) {
		this.lTrackTimeMilliSecs = lTrackTimeMilliSecs;
	}
	public String getsArtist() {
		return sArtist;
	}
	public void setsArtist(String sArtist) {
		this.sArtist = sArtist;
	}
	public String getsAlbum() {
		return sAlbum;
	}
	public void setsAlbum(String sAlbum) {
		this.sAlbum = sAlbum;
	}
	public String getsTrack() {
		return sTrack;
	}
	public void setsTrack(String sTrack) {
		this.sTrack = sTrack;
	}
	public String getsGenre() {
		return sGenre;
	}
	public void setsGenre(String sGenre) {
		this.sGenre = sGenre;
	}
	public String getsReleaseDate() {
		return sReleaseDate;
	}
	
	public void setsRealeaseDate(String sRealeaseDate) {
		//eg "2010-06-15T07:00:00Z"
		this.sReleaseDate = sRealeaseDate;
		
		//set the year firt 4 chars
		setsYear(sRealeaseDate.substring(0, 4));
	}



	public String getsYear() {
		return sYear;
	}



	public void setsYear(String sYear) {
		this.sYear = sYear;
	}
	
	
	

}
