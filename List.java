

public class List {

    /**
     * This is a list of Song objects implemented with an array. The list may
     * have duplicates. It is not in sorted order. Add and remove operate at the
     * end of the list by default, but positional information can be provided to
     * operate in the middle of the list.
     */
    /**
     * Array to store songs in queue
     */
    protected Song[] songs;

    /**
     * The maximum size of the array for all queues
     */
    protected static final int DEFAULT_CAPACITY = 500;

    /**
     * The capacity of the instance array (set to default). "capacity" is the
     * equivalent to songs.length() and can be used interchangably.
     */
    private int capacity = DEFAULT_CAPACITY;

    /**
     * The number of songs stored in the array.
     */
    private int count = 0;

    // ============== 2 Overloaded Constructors ============== //
    /**
     * Constructor
     *
     * @param size The capacity of the list (i.e. max number of elements)
     */
    public List(int size) {
        capacity = size;
        songs = new Song[capacity];
    }

    /**
     * Default Constructor
     */
    public List() {
        this(DEFAULT_CAPACITY);
    }

    // ************   SETTERS, GETTERS, toPrint ******************* //
    public int length() {
        return count;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Prints numbered list of songs.
     */
    @Override
    public String toString() {
        String printedList = "";
        for (int i = 0; i < count; i++) {
            printedList += (i + 1) + ". " + songs[i].toString() + "\n";
        }
        return printedList;
    } // end toString()

    // *******************   ADD  ******************* //
    /** Adds song to the end of SongList unless full
     */
    public void add(Song song) {
        if (!(isFull())) {
            songs[count] = song;
            count++;
        }
    } // end add(song)

    // *******************   SEARCH  ******************* //
    /** Finds and returns the value at the specified index if existing
     */
    public Song peek(int index) {
        if (index >= 0 && index <= count) {
            return songs[index];
        } else {
            return null;
        }
    } // end peek(int)

    /** Finds and returns the index of specified song, if the song is not in the
     * list, returns -1
     */
    public int location(Song song) {
        int i = 0;
        int index = -1;
        while (i < count) {
            if (peek(i).equals(song)) {
                index = i;
                break;
            } else {
                ++i;
            }
        }
        return index;
    } // end location(Song)

    // *******************   REMOVE  ******************* //

    /** Removes the specified song if it is in the list, calls remove(index)
     */
    // can you make use of your remove method above?
    public void remove(Song song) {
      int i;
      for (i=0; i<count; i++) {
        if (songs[i].equals(song)) {
          break;
        }
      }
      if (i>=count) {
        return;  // item not found
      }
      // else shift everything over
      for (int j=i; j<count; j++) {
        songs[j] = songs[j+1];
      }
      --count;
    } // end remove(Song)

} // end class List
