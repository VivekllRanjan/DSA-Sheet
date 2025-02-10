package Array;

public class Patterns {
    public static void main(String[] args) {
        /*
        12345
        1234
        123
        12
        1
         */
        print1(5);

        /*
            *
           ***
          *****
         *******
        *********
         */
        print2(5);

        /*
        *********
         *******
          *****
           ***
            *
         */
        print3(5);

        /*
        print2+print3 combined
         */
        print4(5);

        /*
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
         */
        print5(5);

        /*
        1
        01
        101
        0101
        10101
         */
        print6(5);

        /*
        1      1
        12    21
        123  321
        12344321
         */
        print7(4);

        /*
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15
         */
        print8(5);

        /*
            A
           ABA
          ABCBA
         ABCDCBA
        ABCDEDCBA
         */
        print9(5);

        /*
        E
        D E
        C D E
        B C D E
        A B C D E
         */
        print10(5);

        /*
        *        *
        **      **
        ***    ***
        ****  ****
        **********
        ****  ****
        ***    ***
        **      **
        *        *
         */
        print11(5);

        /*
        **********
        ****  ****
        ***    ***
        **      **
        *        *
        *        *
        **      **
        ***    ***
        ****  ****
        **********
         */
        print12(5);

        /*
        ****
        *  *
        *  *
        ****
         */
        print13(4);

        /*
        4444444
        4333334
        4322234
        4321234
        4322234
        4333334
        4444444
         */
        print14(4);
    }
    private static void print1(int n) {
        for (int i=0;i<n;i++){
            for (int j=1;j<n-i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    private static void print2(int n) {
        for (int i = 1; i <=n; i++) {
            for(int j=1; j<=(n-i) ; j++)
                System.out.print(" ");
            for(int l=1; l<=2*i-1; l++)
                System.out.print("*");
            for(int m=1; m<=n-1; m++)
                System.out.print(" ");
            System.out.println();
        }
    }
    private static void print3(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
                System.out.print(" ");
            for(int k=0;k<2*(n-i)-1;k++)
                System.out.print("*");
            for(int l=0;l<i;l++)
                System.out.print(" ");
            System.out.println();
        }
    }
    private static void print4(int n) {
        print2(n);
        print3(n);

    }
    private static void print5(int n) {
        for(int i=1;i<=(2*n-1);i++){
            if(i<=n) {
                for (int j = 1; j <= i; j++)
                        System.out.print("*");
                System.out.println();
            }
            else {
                for(int j=1; j<=(2*n-i);j++)
                    System.out.print("*");
                System.out.println();
            }
        }
    }
    private static void print6(int n) {
        int s=1;
        for(int i=1;i<=n;i++){
            s= i%2==0?0:1;
            for(int j=1;j<=i;j++) {
                System.out.print(s);
                s=1-s;
            }
            System.out.println();
        }
    }
    private static void print7(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.print(j);
            for(int k=1;k<=(2*n)-(2*i);k++)
                System.out.print(" ");
            for(int l=1;l<=i;l++)
                System.out.print(l);
            System.out.println();
        }
    }
    private static void print8(int n) {
        int start=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                System.out.print(start+" ");
                start++;
            }
            System.out.println();
        }
    }
    private static void print9(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n-i; j++)
                System.out.print(" ");

            char ch='A';
            int br=(2*i-1)/2;
            for(int j=1;j<=(2*i-1);j++){
                System.out.print(ch);
                if(j<=br) ch++;
                else ch--;
            }

            for(int j=1; j<=n-i;j++)
                System.out.print(" ");

            System.out.println();
        }
    }
    private static void print10(int n) {
        for (int i=1;i<=n;i++){
            char ch='A';
            ch = (char) (ch + (n -i));
            for(int j=1;j<=i;j++){
                System.out.print(ch+ " ");
                ch++;
            }
            System.out.println();
        }
    }
    private static void print11(int n) {
        int iniSpace=2*n-2;
        for(int i=1;i<=2*n-1;i++){
            int stars=i;
            if(i>n) stars = 2*n-i;
            for(int j=1;j<=stars;j++)
                System.out.print("*");
            for(int j=1; j<=iniSpace; j++)
                System.out.print(" ");
            for(int j=1;j<=stars;j++)
                System.out.print("*");
            if(i<n) iniSpace-=2;
            else iniSpace+=2;
            System.out.println();
        }
    }
    private static void print12(int n) {
        for(int i=0;i<n;i++){
            for(int j=1;j<=n-i;j++)
                System.out.print("*");
            for(int j=1;j<=2*i;j++)
                System.out.print(" ");
            for(int j=1;j<=n-i;j++)
                System.out.print("*");
            System.out.println();
        }
        int iniSpace=2*n-2;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.print("*");
            for(int j=1;j<=iniSpace;j++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("*");
            iniSpace-=2;
            System.out.println();
        }
    }
    private static void print13(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0 || i==n-1 || j==n-1)
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static void print14(int n) {
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
               int top=i;
               int left=j;
               int right=(2*n-1)-1-j;
               int bottom=(2*n-1)-1-i;
               int ele = Math.min(Math.min(top,bottom),Math.min(left,right));
               System.out.print(n-ele);
            }
            System.out.println();
        }
    }
}
