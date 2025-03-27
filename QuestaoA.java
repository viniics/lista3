import java.util.Scanner;

public class QuestaoA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long casosTeste = Long.valueOf(sc.nextLine());
        Long sorte = (long) 0;
        for(int i=0;i<casosTeste;i++){
            String[] valores = sc.nextLine().split(" ");
            Long n = Long.valueOf(valores[0]);
            Long k = Long.valueOf(valores[1]);
            sorte += meio((long) 1, n, k);
            System.out.println(sorte);
            sorte = (long) 0;
        }

        sc.close();
    }

    public static Long meio(Long left, Long right, Long k){
        Long meio = (left+right)/2;        
        if((right-left+1)%2==0){
            return meio(left,meio,k) + meio(meio+1,right,k);
        }
        if(right-left<k){
            return meio;
        }
        if(left!=right){
            return meio+ meio(left,meio-1,k) + meio(meio+1,right,k);
        }
        return meio;
    }
}