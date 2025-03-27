import java.util.Scanner;

public class QuestaoA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casosTeste = Integer.valueOf(sc.nextLine());
        int sorte = 0;
        for(int i=0;i<casosTeste;i++){
            String[] valores = sc.nextLine().split(" ");
            Integer n = Integer.valueOf(valores[0]);
            Integer k = Integer.valueOf(valores[1]);
            sorte += meio(1, n, k);
        }
        System.out.println(sorte);
    }

    public static int meio(int left, int right, int k){
        if(right-left<k){
            return 0;
        }
        int meio = (left+right)/2;
        if(left==right){
            return meio;
        }
        if((right-left+1)%2==0){
            return meio(left,meio,k) + meio(meio+1,right,k);
        }
        return meio + meio(left,meio-1,k) + meio(meio+1,right,k);
    }
}