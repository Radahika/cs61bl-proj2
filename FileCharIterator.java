import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Returns each character of an input file, one at a time, in binary string
 * format
 *
 */
public class FileCharIterator implements Iterator<String> {

    protected FileInputStream input;
    private String inputFileName;
    private int nextChar;

    public FileCharIterator(String inputFileName) {
        try {
            input = new FileInputStream(inputFileName);
            nextChar = input.read();
            this.inputFileName = inputFileName;
        } catch (FileNotFoundException e) {
            System.err.printf("No such file: %s\n", inputFileName);
            System.exit(1);
        } catch (IOException e) {
            System.err.printf("IOException while reading from file %s\n",
                    inputFileName);
            System.exit(1);
        }
    }

    @Override
    public boolean hasNext() {
        return nextChar != -1;
    }

    @Override
    public String next() {
        if (this.nextChar == -1) {
            return "";
        } else {
          //nextChar is literally the 8 bits of a character
          //Therefore b will contain this 1 byte representation of a character
            Byte b = (byte) this.nextChar;
            //the b & 0xFF is anding the 8 bits with 1111 1111. By "b & 0xFF" we are forcing b to 
            //be a positive integer between 0 and 255 bits and because Java performs a widening 
            //conversion to int, using sign extension and thus the byte gets promoted to an int!
            //Then we want to format a string of the first 8 places to hold this new Integer and replace
            //any ' ', with '0'
            String toRtn = String.format("%8s",
                    Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            try {
                this.nextChar = this.input.read();
            } catch (IOException e) {
                System.err.printf(
                        "IOException while reading in from file %s\n",
                        this.inputFileName);
            }
            return toRtn;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(
                "FileCharIterator does not delete from files.");
    }
}
