package abdul;

public class Main {

	public static void main(String[] args) {
		
		//----------------------------------------------------------------------------------
		
		Client Faiq = new Client("Faiq", "123-456-7890", "Safin");  
		
	    Clients ClientsList = new Clients();
	    
	    ClientsList.addClient(Faiq);
	    ClientsList.removeClient(Faiq);
	    ClientsList.printClient();
	    ClientsList.findClient("Faiq");
	    
	    //----------------------------------------------------------------------------------
	    
	    SaleTransaction transaction1 = new SaleTransaction("Product1", 2, 10.0, "2024-05-01");
	    SaleTransaction transaction2 = new SaleTransaction("Product2", 1, 20.0, "2024-05-02");
        // Create a SaleTransactions object
        SaleTransactions sales = new SaleTransactions();

        // Add transactions to the list
        sales.add(transaction1);
        sales.add(transaction2);

        // Remove a transaction from the list
        sales.remove(transaction2);

        // Print all transactions
        sales.printTransactions();

        // Find a transaction by product name
        SaleTransaction foundTransaction = sales.find("Product1");
        
        //----------------------------------------------------------------------------------
		
        SalesPerson sp1 = new SalesPerson("ronaldo", "011-22666999");
        
		SalesPersons macai = new SalesPersons();
		
		macai.addsp();
		macai.removesp();
		macai.printsp();
		macai.findsp();
		
		//----------------------------------------------------------------------------------
		
		System.out.println("abdul");
	
	}

}

//DANISH SAFIN BIN ZULKARNAIN 24000149
//ABDULLAH SHAHIR BIN ZULMAJDI 24000112
//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054
//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061
//AHMAD AQIL FAHMI BIN AHMAD NOR 24000235
