import java.util.*;

/* The logic I am trying to implement
 * is that most English words contain 
 * vowels. So, the sentence with the most number of vowels
 * is most likely gonna be the possible decoded form. 
 */

public class CaesarCipher2 
{
    static String encoded;
    static String decoded;
    static String decoded_final;

    static Scanner sc = new Scanner(System.in);

    public void encode()
    {
        System.out.print("Enter the encoded message: ");
        encoded = sc.nextLine();
    }
    public void decodeTry()
    {
        char ch;
        int ASC, cin=0, c=0;
        decoded_final = encoded;
        for(int j=0;j<encoded.length();j++) // Finding number of vowels in encoded String
        {
            ch=encoded.charAt(j);
            ch=Character.toUpperCase(ch);
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            {
                cin++;
            }
        }
        for(int shift=1;shift<26;shift++)
        {
            decoded="";
        for(int i=0;i<encoded.length();i++) // Logic of encoding
        {
             ch=encoded.charAt(i);
             if(Character.isLetter(ch)==true)
             {
                 ASC = (int)ch;
                 if((ASC>=65)&&(ASC<=90)) // For decoding uppercase characters
                 {
                    ASC-=shift; // Shifting the characters back by 'shift' amount
                    if(ASC<65) // eg. say shift=3, encoded_char=A, resultant is (char)(65-3+26) = X
                    ASC+=26;
                    decoded+=(char)ASC;
                 }
                 if((ASC>=97)&&(ASC<=122)) // For decoding lowercase characters
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
        c=0;
        for(int j=0;j<decoded.length();j++)
        {
            ch=decoded.charAt(j);
            ch=Character.toUpperCase(ch);
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            {
                c++;
            }
        }
        if(c>cin)
        {
            cin=c; // Variable 'cin' stores the no. of vowels in the new highest-vowels containing String
            decoded_final = decoded;
        }
        }
        System.out.println("Most likely decryption of given cipher is: " +decoded_final);
    }
    public static void main(String args[])
    {
        CaesarCipher2 ob = new CaesarCipher2();
        ob.encode();
        ob.decodeTry();
    }
}