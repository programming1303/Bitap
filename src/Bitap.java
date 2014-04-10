public class Bitap
{
    public static void main(String args[])
    {
        String text = args[0];
        String pattern = args[1];
        System.out.println("Text: " + text);
        System.out.println("Pattern: "+ pattern);
        search(text, pattern);
    }

    public static void search(String text, String pattern)
    {
        int length = pattern.length() - 1;

        long M = 1, S = 1, I = 1, D = 3, vector[] = new long[256];
        int i, k;

        for(k = 0; k < 256; k++)
        {
            for (i = length; i >= 0; i--)
            {
                vector[k] |= (pattern.charAt(i) == k) ? 1 : 0;
                vector[k] <<= 1;
            }
            vector[k] |= 1;
        }

        for(i = 0; i < text.length(); i++)
        {
            S = (((S << 1) | 1) & vector[text.charAt(i)]) | (M << 1);
            I = (((I << 1) | 1) & vector[text.charAt(i)]) | M;
            M = ((M << 1) | 1) & vector[text.charAt(i)];
            D = ((M << 1) | 1) | (vector[text.charAt(i)] & (D << 1));
            if(M >= Math.pow(2, length + 1))
                System.out.println("Full Match " + (i - length + 1));
            if(S >= Math.pow(2, length + 1))
                System.out.println("Substitution " + (i - length + 1));
            if(I >= Math.pow(2, length + 1))
                System.out.println("Insertion " + (i - length));
            if(D >= Math.pow(2, length + 1))
                System.out.println("Deletion " + (i - length + 2));
        }
    }
}
