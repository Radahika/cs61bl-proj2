HuffmanEncoding.java is a program that compresses and decompresses files 
using Huffman encoding. The program runs through the command line and
supports encoding and decoding. 

The following is a list of methods that the HuffmanEncoding class
has:

encode 
This method takes in a file and returns a compressed version of the file 
with a codemap header. The codemap header is a reference table in text 
format that lists binary strings and their encodings. encode implements
a specific modifier, the "end of file" character or "EOF" which solves 
the problem of how modern computers store data in bytes, but our encoding
encodes characters down to the bit level. 

testEncode:

