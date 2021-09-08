class Jaba
{
    public static void main(String[] args)
    {
        //task 1
        int len = 17-5+1;
        long[] a = new long[len];
        for(int i = 0; i < len; i++)
            a[i] = 17-i;
        //task 2
        len = 16;
        float[] x = new float[len];
        float min = -12;
        float max = 2;
        for(int i = 0; i < len; i++)
            x[i] = (float)Math.random()*(max - min) + min;
        //task 3
        double[][] res = new double[13][16];
        for(int i = 0; i < 13; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(a[i] == 6)
                    res[i][j] = Math.atan(Math.exp(Math.cbrt( -Math.tan(x[j])*Math.tan(x[j]) )));
                else if(a[i]==5 || a[i]==7 || a[i]==8 || a[i]==9 || a[i]==13 || a[i]==14)
                    res[i][j] = Math.pow(4/Math.exp(Math.cos(x[j])), Math.sin(Math.log(Math.abs(x[j]))));
                else
                    res[i][j] = Math.sin(Math.sin(Math.atan((x[j]-5) * (x[j]-5)/(14*14))));
            }
        }
        //task 4
        for(int i = 0; i < 13; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                System.out.printf("%10.3f", res[i][j]);
            }
            System.out.println();
        }
    }
}
