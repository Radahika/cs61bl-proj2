import FileCharIterator;

/*Takes in a file name, compresses the file, and outputs the compressed file with a 
 * codemap header */
public class HuffmanEncoding {

  protected FileInputStream input;
  private String inputFileName;

  public HuffmanEncoding(String inputFileName) {
    // Assume "Test.txt" contains the string "abc"
    FileCharIterator myIter = new FileCharIterator(inputFileName);
    /*Can now make calls to myIter.next() and myIter.hasNext() */

}
}
