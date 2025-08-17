import java.util.*;

public class CaesarCipher
{
    static Scanner sc = new Scanner(System.in);

    static String original, encoded = "", decoded=""; 
    /*  Making 'encoded' and 'decoded' static just in case  
    if they're used inside a static method */

    int shift; // Shift value

    public void accept() // Accepts an original message from user
    {
        System.out.println("Enter the original message");
        original = sc.nextLine();
    }
    public void encode() // Decodes the encoded message
    {
        System.out.print("Enter the shift value for encoding: ");
        shift = sc.nextInt();

        if(shift>=26) // Handling edge-case, as shifting 'A' by 26 will result in A itself
        shift=shift%26;
        else if(shift<0)
        {
            System.out.println("Invalid shift value entered, terminating program!!");
            System.exit(0);
        }
        
        char ch;
        int ASC;
        for(int i=0;i<original.length();i++) // Logic of encoding
        {
             ch=original.charAt(i);
             if(Character.isLetter(ch)==true)
             {
                 ASC = (int)ch;
                 if((ASC>=65)&&(ASC<=90)) // For encoding uppercase characters
                 {
                    ASC+=shift; // Shifting the characters by 'shift' amount
                    if(ASC>90) // eg. say shift=3, char=Z, resultant is (char)(90+3-26) = C
                    ASC-=26;
                    encoded+=(char)ASC;
                 }
                 if((ASC>=97)&&(ASC<=122)) // For encoding lowercase characters
                 {
                    ASC+=shift; // Shifting the characters by 'shift' amount
                    if(ASC>122) // eg. say shift=5, char=y, resultant is (char)(121+5-26) = d
                    ASC-=26;
                    encoded+=(char)ASC;
                 }
             }
             else
             encoded+=ch; // For non-alphabetic characters 
        }
        System.out.println("Encoded message is: " +encoded);
        sc.close(); 
    }
    public void decode()
    {
        // We need the same shift value as before for the decoding process
        
        char ch;
        int ASC;
        for(int i=0;i<encoded.length();i++) // Logic of encoding
        {
             ch=encoded.charAt(i);
             if(Character.isLetter(ch)==true)
             {
                 ASC = (int)ch;
                 if((ASC>=65)&&(ASC<=90)) // For encoding uppercase characters
                 {
                    ASC-=shift; // Shifting the characters back by 'shift' amount
                    if(ASC<65) // eg. say shift=3, encoded_char=A, resultant is (char)(65-3+26) = X
                    ASC+=26;
                    decoded+=(char)ASC;
                 }
                 if((ASC>=97)&&(ASC<=122)) // For encoding lowercase characters
                 {
                    ASC-=shift; // Shifting the characters back by 'shift' amount
                    if(ASC<97) // eg. say shift=5, encoded_char=c, resultant is (char)(99-5+26) = x
                    ASC+=26;
                    decoded+=(char)ASC;
                 }
             }
             else
             decoded+=ch; // For non-alphabetic characters 
        }
        System.out.println("Decoded message is: " +decoded);
    }
    public static void main(String args[])
    {
        CaesarCipher ob = new CaesarCipher();
        ob.accept();
        ob.encode();
        ob.decode();
    }
}

// ----------------------------------------------------- END OF PROGRAM ----------------------------------------------------------