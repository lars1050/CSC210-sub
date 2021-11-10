import java.lang.Exception.*;
import java.util.Objects;

public class Song {

  private String title = "undefined";
  private String artist = "undefined";
  private String album = "undefined";
  private Integer year = null;

  /**
   * Default Constructor Song that keeps the default values set above
   */
  public Song() {
    // sets all member variables to defaults defined above.
  }

  /**
   * Constructor for Song with 4 parameters
   * @param title the title of the song
   * @param artist the artist of the song
   * @param album the album the song appears on
   * @param year the year the song was released
   */
  public Song(String title, String artist, String album, Integer year) {
    this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
  }

  /**
   * Constructor Song for 3 String parameters, calls Constructor above
   */
  public Song(String title, String artist, String album) {
    this(title, artist, album, null);
  }

  /**
   * String representation of Song
   */
  @Override
  public String toString() {
    if (null==year) {
      return String.format("%20s by %s. %s",title,artist,album);
    }
    else {
      return String.format("%20s by %s. %s (%d)",title,artist,album,year);
    }
  }

     // ************   SETTERS, GETTERS******************* //
  
	public String title() { return title; }
	public String artist() { return artist; }
	public String album() { return album; }
	public Integer year() { return year; }

	public void title(String inTitle) { title = inTitle; }
	public void artist(String inArtist) { artist = inArtist; }
	public void album(String inAlbum) { album = inAlbum; }
	public void year(Integer inYear) { year = inYear; }
        
        /**
         * Calls setter if field is year
         * @param field String of field type i.e. title, artist, album or year
         * @param year the Integer value of year
         */
	public void set(String field, Integer year) {
		if (field.equalsIgnoreCase("year")) {
			year(year);
		} else {
			throw new IllegalArgumentException("Field "+field+" not recognized.");
		}
	}
        
        /**
         * Calls setter for whichever field the String represents
         */
  public void set(String field, String value) {
    if (field.equalsIgnoreCase("title")) {
      title(value);
			return;
		}
    if (field.equalsIgnoreCase("artist")) {
      artist(value);
			return;
		}
    if (field.equalsIgnoreCase("album")) {
      album(value);
			return;
		}
    throw new IllegalArgumentException("Field "+field+" not recognized.");
  }
  
  /**
   * Override method for checking whether Song objects are equal
   * @param o object that is being checked
   * @return true or false whether the object is equal to the compared Song
   */
  @Override
  public boolean equals(Object o){
      if (o == this){
          return true;
      }
      if(!(o instanceof Song)){
          return false;
      }
      
      Song s = (Song) o;
      
      return s.title().equalsIgnoreCase(title) && s.artist().equalsIgnoreCase(artist)
              && s.album().equalsIgnoreCase(album) && s.year().equals(year);
  }

}
