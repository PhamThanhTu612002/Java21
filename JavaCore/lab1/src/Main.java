public class Main {
    public static void main(String[] args) {
//        int x=10;
//        long x2=x;
//        double y = 10.1;
//        float z = (float) y;
//        String name= "Tú";
//
//        System.out.println("x = " + x);
//        System.out.println("x2 = " + x2);
//        System.out.println("y = " + y);
//        System.out.println("z = " + z);
//
//        name = x+" điểm";
//        System.out.println(name);
//
//        System.out.println(Math.PI);
//        System.out.println(Math.abs(-10));
//        System.out.println(Math.pow(2,3));

        int a = 10, b = 20;
        System.out.println("Diện tích hình chữ nhật là:" + a * b);

        int S = 113;
//        S = r*r*PI
        double r = Math.sqrt(S / (Math.PI));
        System.out.println("Đường kính là:" + 2*r);

        System.out.println("Chu vi hình tròn là:" + 2*Math.PI*r);
        //Bài 4
        double Sa = 54*2.25;
        System.out.println("Quãng đường A đi được là: "+ Sa);

        double Sb = 38*2.25;
        System.out.println("Quãng đường B đi được là: "+ Sb);

        System.out.println("Quãng đường AB là:" +(Sa+Sb));
        //Bài 5
        double AB = 2.5*4.2;
        System.out.println("Quãng đường AB là " +AB);

        double vtxd = ((double) 5/2)*4.2;
        System.out.println("Vận tốc xe đạp là " +vtxd);
        System.out.println("Nếu người đó đi xe đạp với vận tốc bằng 5/2 vận tốc đi bộ thì sau "+ AB/vtxd+"h đi hết được quãng đường nói trên");


//        System.out.println("Phần dư:" + b % a);
//
//        System.out.println(a < b);
//
//        System.out.println(a!=b && b==20);
//
//        System.out.println(a==b || b==20);



    }
}