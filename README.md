# javaBitsBytes

-------------------------------------------------------------------------------------

# Bits n' bytes

A number in binary form looks like this:
0110 1110 (that's 110 in base 10, the number system we use in our day-to-day life)

One can store and read these numbers in two (ok, not really, but today, usually, at least) ways: either with a sign, or without a sign. With a sign, a byte (that's 8 bits) can represent from -128 to 127. Without a signed (unsigned), it goes from 0 to 255. We're only going to use single bytes from here, until the ending part - where it will be obvious. 

The most significant bit is the bit farthest to the left, in 1010 0110 it's a 1, in 0111 0111 it's a 0. This bit also represents the sign, which marks if a number is positive or negative. 

The storage of bytes, then, looks the same to the computer (and you and me) in the cases signed and unsigned integers. 

# Java:

All numbers in Java are - by design - signed values. This means that 1001 1001 for Java represents the number -103. That's because the sign is a 1. This number, read as an unsigned byte, represents 153. 

# "a", not "the", solution. 

The accompanying Java-file shows a couple of ways to fix (or ignore) this issue. 

But the nicest one might be a combination of using a larger sized type (so, a 16 bit short for a 8 bit byte) in combination with bitwise operations. 

Take 1001 1001 again. The left-most 1 makes it negative. But, if we fit this in a twice as large data type, we get:
0000 0000 1001 1001. This gives us a positive number! 

But we can't do that conversion directly, Java translates numbers for us. So 1001 1001 turns into 1111 1111 1001 1001 with a direct conversion.

We need to use the &-operator, to force Java to give us 0000 0000 1001 1001:

    short s = (short) (byte_to_convert & 0x00FF)

# "but this only works on single bytes at the end of a variable!"

Yes.

To get, say, the E in 0xF3E8 (that's hexadecimal), we can do this:

    short s = (short) 0xF3E8;
    s = (short) (s & 0x00F0);
    s = (short) (s >>> 4);

The second line picks out the E we're after; the third line moves it to the rightmost position, i.e. 4 steps to the right, which makes it a 14 (instead of a 224). In binary: 1110 0000 --> 0000 1110.

Now we have our 14/E/0000 1110. 
