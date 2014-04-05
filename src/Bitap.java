public class Bitap
{
    public static void main(String args[])
    {
        String text = "SeregaLoh";
        String pattern = "Serega";
        System.out.println("Text: " + text);
        System.out.println("Pattern: "+ pattern);
        search(text, pattern);
    }

    public static void search(String text, String pattern)
    {
        int length = pattern.length();
        boolean[] M = new boolean[length+1];
        boolean[] I = new boolean[length+1];
        boolean[] D = new boolean[length+1];
        boolean[] R = new boolean[length+1];

        M[0] = true;
        R[0] = true;
        I[0] = false;
        D[0] = true;
        int i;
        for(i = 1; i < length+1; i++)
        {
            M[i] = false;
            R[i] = false;
            I[i] = false;
            D[i] = false;
        }
        D[1] = true;
        int k;
        for(i = 0; i < text.length(); i++)
        {
            for(k = length; k >= 1; k--)
                I[k] = M[k] | ((text.charAt(i) == pattern.charAt(k-1)) & I[k - 1]);
            for(k = length; k >= 1; k--)
                M[k] = M[k - 1] & (text.charAt(i) == pattern.charAt(k-1));
            for(k = length; k >= 1; k--)
                R[k] = M[k - 1] | (R[k - 1] & (text.charAt(i) == pattern.charAt(k-1)));
            for(k = length; k >= 1; k--)
                D[k] = M[k - 1] | ((text.charAt(i) == pattern.charAt(k-1)) & D[k - 1]);
            if(M[length])
                System.out.println("Full Match " + (i - length + 1));
            if(D[length])
                System.out.println("Deletion " + (i - length + 2));
            if(R[length])
                System.out.println("Replication " + (i - length + 2));
            if(I[length])
                System.out.println("Insertion " + (i - length));
        }
    }
}