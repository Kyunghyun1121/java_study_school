public class Main {
    public static void main(String[] args){
        //
    	System.out.println("List 출력");
		List myList = new List();
		myList.add(11);
		myList.add(22);
		myList.add(33);
		myList.add(33);
		myList.add(44);
		myList.show();
		System.out.println("------------------");
		System.out.println("Set 출력");
		Set mySet = new Set();
		mySet.add(11);
		mySet.add(22);
		mySet.add(33);
		mySet.add(33);
		mySet.add(44);
		mySet.show();
    }
}
