package Taxi;
import java.util.Scanner;
public class Taxi 
{
    public static void main(String[] args)
    {
        int A[][]=new int[10000][10000];
        char B[][]=new char[100][100];
        int i,TID=0,TID1=0,max=0,z=0;
        Scanner sc=new Scanner(System.in);
        int a=0;
        char P,D;
        int Pt,b=0;
        for(i=0;i<4;i++)
        {
            B[i][1]='A';
        }
        while(true)
        {
            System.out.println("Enter 1 for Booking, 2 for Display, other digits to exit");
            a=sc.nextInt();
            if(a==1)
                {
                System.out.println("Enter Pickup Point: ");
                P=sc.next().charAt(0);
                System.out.println("Enter Drop Point");
                D=sc.next().charAt(0);
                if(P==D)
                {
                    System.out.println("Sorry, Pickup Point and Drop Point are same");
                }
                else
                {
                    System.out.println("Enter Pickuptime: ");
                    Pt=sc.nextInt();
                    max=7;
                    for(i=0;i<4;i++)
                    {
                        z=A[i][2];
                        if(A[i][2]>0)
                            z--;
                        if(max>Math.abs(B[i][z*2+1]-P)&&Pt>=A[i][A[i][2]*4+1])
                        {
                            max=Math.abs(B[i][z*2+1]-P);
                            TID=i;
                        }
                    }
                    if(max==7)
                    {
                        System.out.println("Sorry,No Taxi is available right now!");
                    }
                    else
                    {
                        for(i=0;i<4;i++)
                        {
                            z=A[i][2];
                            if(A[i][2]>0)
                                z--;
                            if(max==Math.abs(B[i][z*2+1]-P)&&TID!=i&&Pt>A[i][A[i][2]*4+1])
                            {
                                TID1=i;
                                if(A[TID1][1]<A[TID][1])
                                    TID=TID1;
                            }
                        }
                        A[TID][2]+=1;
                        A[TID][A[TID][2]*4-1]=b;//CID
                        A[TID][A[TID][2]*4]=Pt;//Pt
                        A[TID][A[TID][2]*4+1]=Pt+Math.abs(P-D);//Dt 
                        if(Math.abs(P-D)>1)//Earning 
                            A[TID][A[TID][2]*4+2]=200+(Math.abs(P-D)-1)*150;
                        else
                            A[TID][A[TID][2]*4+2]=200;
                        A[TID][1]+=A[TID][A[TID][2]*4+2];
                        B[TID][A[TID][2]*2-2]=P;
                        B[TID][A[TID][2]*2-1]=D;
                        b++;
                        System.out.println("Cab number "+TID+" has been booked");
                    }
                }
            }
            else if(a==2)
            {
                for(i=0;i<4;i++)
                {
                    if(A[i][2]>0)
                    {
                        System.out.println();
                        System.out.println("Taxi ID : "+i);
                        System.out.println("Amount : "+A[i][1]);
                    }
                    for(int j=1;j<=A[i][2];j++)
                    {
                        System.out.print(A[i][j*4-1]+"    "+B[i][j*2-2]+"    "+B[i][j*2-1]+"    ");
                        System.out.println(A[i][j*4]+"    "+A[i][j*4+1]+"    "+A[i][j*4+2]);
                        /*System.out.println("Customer ID : "+A[i][j*4-1]);
                        System.out.println("Pickup Point : "+B[i][j*2-2]);
                        System.out.println("Drop Point : "+B[i][j*2-1]);
                        System.out.println("Pickup Time : "+A[i][j*4]);
                        System.out.println("Drop Time : "+A[i][j*4+1]);
                        System.out.println("Earning : "+A[i][j*4+2]);*/
                    }
                }
            }
            else
                break;
        }
    }
}
