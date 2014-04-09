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

        long D,R, I,M ;

        M = ~1;
        R = ~1;
        I = ~0;
        D = ~1;
        int i;
        //создание маски!!!
        for(i = 0; i < text.length(); i++)
        {
                M |= pattern_mask[text[i]];
                M <<= 1;
                I &= M | (pattern_mask[text[i]]);
                I <<= 1;
                R &= M | (pattern_mask[text[i]]);
                R<<=1;
                D &= M | (pattern_mask[text[i]]);
                D<<=1;
                System.out.println("Full Match " + (i - length + 1));
        }
    }
}
