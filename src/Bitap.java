public class Bitap
{
    public static void main(String args[])
    {
        String text = "ATCGAGCATCGA";
        String pattern = "ATCGA";
        System.out.println("Text: " + text);
        System.out.println("Pattern: "+ pattern);
        search(text, pattern);
    }

    public static void search(String text, String pattern)
    {
        int length = pattern.length() - 1;

        long M = 1, vector[] = new long[256];
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
            M <<= 1;
            M |= 1;
            M &= vector[text.charAt(i)];
            if(M >= Math.pow(2, length + 1))
                System.out.println("Full Match " + (i - length + 1));
        }
    }
}
