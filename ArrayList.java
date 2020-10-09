import java.util.ArrayList;
import java.util.Scanner; 
class GrocceryList{
	private static ArrayList<String> grocceryList = new ArrayList<String>();
	
	public  void addItems(String item){
		grocceryList.add(item);
		System.out.println(item + " has been added into our graccery list");
	}
	
	public  void removeItems(int i){
		System.out.println(grocceryList.get(i) + " has been removed from our gracceryList");
		grocceryList.remove(i);
	}
	
	public  void replaceItems(int i, String item){
		grocceryList.set(i, item);
		System.out.println(item + " has been placed at " + i + " position");
	}
	
	public  void printItems(){
		System.out.println("currently you have: ");
		for(int i=0; i<grocceryList.size(); i++){
			System.out.println(i+1 + ". " + grocceryList.get(i));
		}
	}
	
	public static void printInstructions(){
		System.out.println("enter 1 to add Items");
		System.out.println("enter 2 to remove Items");
		System.out.println("enter 3 to exit");
		
	}
	
	public int validation(String item){
		int indexOfItem = grocceryList.indexOf(item);
		return indexOfItem;
	}

}

class Test{
	private static Scanner scan = new Scanner(System.in);
	public static void main(String [] args){
		GrocceryList grocceryList = new GrocceryList();
		
		System.out.println("Welcome to helpdesk"); 
		
		boolean flag = false; 
		while(!flag){
			grocceryList.printInstructions();
			grocceryList.printItems();
			
			int userInput = scan.nextInt();
			scan.nextLine();
			while(userInput<1 || userInput>3){
				System.out.println("you have entered wrong number please read the instructions carefully and enter correct number");
				userInput = scan.nextInt();
			}
			
			switch(userInput){
				case 1: System.out.println("Enter what you want to add in your list");
						String item = scan.nextLine();
						//scan.nextLine();
						grocceryList.addItems(item);
						break; 
						
				case 2: System.out.println("What do you want to remove from your list");
						String removeItem = scan.nextLine();
						//scan.nextLine();
						int index = grocceryList.validation(removeItem);
						if(index != -1){
							grocceryList.removeItems(index);
						}else{
							System.out.println("list does not contains " + removeItem + " please select valid item");
							continue;
						}
						break;
				
				case 3: flag = !flag; 
						break;
						
			}
			

		}
		
	}
}