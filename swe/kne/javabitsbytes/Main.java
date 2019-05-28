package swe.kne.javabitsbytes;

public class Main {

    public static void main(String[] args) {

		byte byte_1 = (byte) 0xF3D1;
		System.out.println("\nbyte 1 signed: " + byte_1 + " byte 1 unsigned: " + Byte.toUnsignedInt(byte_1) );
		System.out.println("byte_1 as a String (though converted to int before) containing the binary representation: " +
				Integer.toBinaryString((int) (byte_1 & 0x000000FF)));

		int int_1 = 0xFFFFF3D1;
		System.out.println("\nint 1 signed: " + int_1 + " int 1 unsigned: " + Integer.toUnsignedLong(int_1));

		int byte_to_int = byte_1;
		System.out.println("\nConverting byte to int, still signed: "+ byte_1);
		System.out.println("Looks like this in binary: " + Integer.toBinaryString(byte_to_int));
		byte_to_int = byte_to_int & 0x000000FF;
		System.out.println("Removing (turning to 0 in binary and hexadecimal representation), " +
				"except for the last 8 bits/1 byte of the integer, and as an ordinary base 10 number: " + byte_to_int);
		System.out.println("And the same number, in binary form: " + Integer.toBinaryString(byte_to_int));
		System.out.println("(But note that Java's Integer.toBinaryString() hides all bits to the left which are zero)");

		byte byte_2 = (byte) byte_to_int;
		System.out.println("\nIf we try to convert our new int back to a byte, we get this: " + byte_2);
		short short_1 = (short) (byte_2 & 0x00FF);
		System.out.println("If we instead store a byte (8 bits) as a short (16 bits), and use a bitwise AND, we can \n " +
				"keep our bit pattern together, with just a bit more work, and always have a positive number " + short_1);

		System.out.println("\nIf we don't particularly care about specific hexadecimal signs and binary patterns, we" +
				" \ncan just use Byte.toUnsignedInt, which gives us the base 10 number");

		System.out.println("\n\nSo playing around with unsigned values in Java mostly revolves around either not\n " +
				"caring about how a bit pattern looks, or which hexadecimal sign you get; or a combination of always\n" +
				" using a larger than necessary data type and some bitwise operations");

    }
}
