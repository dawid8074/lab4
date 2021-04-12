import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static int symbolNewtona(int n, int k)
    {
        if (k == 0 || k == n)
            return 1;
        else
            return symbolNewtona(n-1, k-1) + symbolNewtona(n-1, k);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("punkty2.txt");
        Scanner scanner=new Scanner (plik);
        PrintWriter zapis = new PrintWriter("kubek.txt");
        double x,y,z;
        int iloscPlaszczyzn = scanner.nextInt();
        zapis.write("x, y, z"+System.lineSeparator());
        double[][][] punkty=new double[4][4][3];                      //[kolumna][wiersz][x y z]

        for(int ilosc=0;ilosc<iloscPlaszczyzn;ilosc++)
        {                                                           //pod macierz
            for(int i=0;i<4;i++)
            {                                                       //po kolumnach
                for(int j=0;j<4;j++)
                {                                                    //po wierszach
                    for (int k=0; k<3; k++)                         //po wspolrzedych x y z
                    {
                        punkty[i][j][k] =  Double.parseDouble(scanner.next());
                    }
                }
            }
            for(double v=0.0;v<=1.0;v+=0.01)
            {
                for(double w=0.0;w<=1.0;w+=0.01)
                {
                    x=0.0;
                    y=0.0;
                    z=0.0;
                    for (int i=0;i<4;i++)
                    {
                        for(int j=0; j<4 ;j++)
                        {
                            x+=punkty[i][j][0]*symbolNewtona(3,i)*Math.pow(w,i)*Math.pow(1-w,3-i)*symbolNewtona(3,j)*Math.pow(v,j)*Math.pow(1-v,3-j);
                            y+=punkty[i][j][1]*symbolNewtona(3,i)*Math.pow(w,i)*Math.pow(1-w,3-i)*symbolNewtona(3,j)*Math.pow(v,j)*Math.pow(1-v,3-j);
                            z+=punkty[i][j][2]*symbolNewtona(3,i)*Math.pow(w,i)*Math.pow(1-w,3-i)*symbolNewtona(3,j)*Math.pow(v,j)*Math.pow(1-v,3-j);
                        }
                    }
                    zapis.write(x+","+y+","+z+System.lineSeparator());
                }
            }
        }
        zapis.close();
        }

    }
