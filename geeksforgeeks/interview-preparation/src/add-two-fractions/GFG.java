class GfG
{
    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    void addFraction(int num1, int den1, int num2, int den2)
    {
        int den = lcm(den1, den2);
        int num = (den / den1 * num1) + (den / den2 * num2);
        int gcd = gcd(num, den);
        den = den / gcd;
        num = num / gcd;
        System.out.println(num + "/" + den);
    }
}