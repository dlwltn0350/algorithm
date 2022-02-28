package level12;
/*
 * 선택, 삽입, 버블, 합병, 퀵정렬
 * 
 */
import java.io.*;
public class 정렬 {

	static int[] arr; 
	static int[] tmp; //arr배열을 저장할 버퍼
	
	public static void selection_sort() {//선택정렬 O(n^2) : n개의 수 중에서 가장 작은 수를 선택해서 앞으로 이동
		int tmp, index;
		
		for(int i=0;i<arr.length-1;i++) {
			index=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[index]>arr[j]) index=j;//"가장 작은 값"을 찾는다
			}
			
			tmp=arr[index];
			arr[index]=arr[i];
			arr[i]=tmp;
		}
	}
	
	public static void insertion_sort() { //삽입정렬 O(n^2) : n개의 수 중에서 i번째 수를 올바른 위치에 삽입
		int key=0;
		
		for(int i=1;i<arr.length;i++) {
			key=arr[i];
			
			for(int j=i-1; j>=0 && arr[j]>key; j--) { //이미 지나간 수들을 비교하면서 (0~i) arr[j]>arr[i]지점에 해당 수를 놓는다.
				arr[j+1]=arr[j];
				arr[j]=key;//해당값(key)은 앞으로 자리이동
			}
		}
		
	}
	
	public static void merge_sort() { //합병정렬 -> https://todaycode.tistory.com/54 참고
		tmp=new int[arr.length];
		merge_sort(0,arr.length-1);
	}
	private static void merge_sort(int start, int end) {
		int mid;
		
		if(start<end) { // 원소가 2개 이상
			mid=(start+end)/2; // 2개 그룹으로 분할
			merge_sort(start,mid);
			merge_sort(mid+1,end);
			
			merge(start,mid,end); //병합
		}
	}
	private static void merge(int start, int mid, int end) {
		tmp=arr.clone(); // arr 배열 복사해둠
		
		int part1=start; //왼쪽그룹의 첫번째 인덱스
		int part2=mid+1; //오른쪽그룹의 첫번째 인덱스
		int index=start;
		
		while(part1<=mid && part2 <=end) {
			if(tmp[part1]<=tmp[part2]) {
				arr[index++]=tmp[part1++];
			}
			else
				arr[index++]= tmp[part2++];
		}
		
		for(int i=0; i<=mid-part1; i++) {//왼쪽그룹이 남는경우
			arr[index+i]=tmp[part1+i];
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(br.readLine());
		
		//merge_sort();
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
	}

}
