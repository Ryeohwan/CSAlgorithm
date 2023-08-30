import java.util.Arrays;

public class PGMRS_시소짝꿍 {
    private static int [] weights = {100,180,360,100,270};  // 4
    public static void main(String[] args) {
        long answer = 0;
        // 시소 짝꿍이 몇 쌍 존재하는지 구하여 return

        Arrays.sort(weights);  // 정렬해준 후

//        비례식 성질을 활용하여 풀이한다.
//        x : y = a : b
//        ay = xb

        int count = 0;
        for(int i=0; i < weights.length-1; i++){
            System.out.println(count);
            if(i > 0){  // 인덱스 밖으로 나가지 않게
                if(weights[i]==weights[i-1]){ // 정렬된 상태니까 인접한 무게가 같을 떈 아래의 비교연산 안해줘도 된다. 아래서 다음 것과 같은 것에 대한 덧셈도 해줬다.
                    count--;
                    answer += count;
                    continue;
                }
            }

            count = 0;

            for(int j=i+1; j<weights.length; j++){  // 여기가 이제 비율이 맞나 체크하는 부분 외항과 내항의 곱은 같다.
                if(weights[i]==weights[j] || weights[i]*4==weights[j]*3 ||
                        weights[i]*3==weights[j]*2 || weights[i]*2==weights[j] ) {
                    count++;
                }
            }

            answer += count;
        }

        System.out.println(answer);
    }
}
