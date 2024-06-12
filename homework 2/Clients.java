//ABDULLAH SHAHIR BIN ZULMAJDI 24000112

import java.util.List;
import java.util.ArrayList;

public class Clients {

    //DATA
    private List<Client> clientList;

    //CONSTRUCTOR
    public Clients() {
        this.clientList = new ArrayList<>();
    }

    // PARAMETERIZED CONSTRUCTOR
    public Clients(List<Client> clientList) {
        this.clientList = clientList;
    }

    //SETTER
    public void setClientList(List<Client> clientList){
        this.clientList = clientList;
    }

    //GETTER
    public List<Client> getClientList(){
        return clientList;
    }

    //METHODS
    public void addClient(Client client) {
        clientList.add(client);
    }

    public void removeClient(Client client) {
        clientList.remove(client);
    }

    public void printClients() {
        System.out.println("");
        System.out.println("LIST OF CLIENTS");
        for (int i = 0; i < clientList.size(); i++) {
            System.out.print((i+1)+". ");
            clientList.get(i).printData();
        }
    }

    public Client findClient(String name) {
        for (int i = 0; i < clientList.size(); i++) {
            Client client = clientList.get(i);
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
}