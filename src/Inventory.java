import java.awt.desktop.QuitStrategy;
import java.util.ArrayList;

public class Inventory {
    protected ArrayList<InventoryItem> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public void addItem(Item item, int quantity){
        InventoryItem it = new InventoryItem(item, quantity);
        boolean exist = false;

        for (InventoryItem i : inventory){
            if (it.equals(i)){
                exist = true;
                i.setQuantity(i.getQuantity()+1);
            }
        }
        if (exist == false) {
            inventory.add(it);
        }
    }

    public void use(Item item){
        InventoryItem it = new InventoryItem(item, 1);
        for (InventoryItem i : inventory){
            if (it.equals(i)){
                if (i.getQuantity() - 1 > 0) {
                    System.out.println("usage");
                    i.setQuantity(i.getQuantity() - 1);
                    System.out.println("qte -1 "+i.getQuantity());
                    i.getItem().use();
                }
            }
        }
    }
    public Item getItem(String item){
        for (InventoryItem i : inventory){
            if (item.equals(i.getName()) ){
                return i.getItem();
            }
        }
        return null;
    }

    public ArrayList getItems(){return this.inventory;}


    //==================================================================================================================
    public class InventoryItem{
        private int quantity;
        private Item item;
        private String name;
        public InventoryItem(Item item, int quantity){
            this.item = item;
            this.quantity = quantity;
            this.name = item.getName();
        }

        public int getQuantity(){return this.quantity;}
        public Item getItem(){return this.item;}
        public void setQuantity(int quantity){this.quantity = quantity;}
        public void setItem(Item item){this.item = item;}
        public void setName(String name){this.name = name;}
        public String getName(){return this.name;}

        public boolean equals(InventoryItem i){
            if (i.getItem().getName().equals(this.getItem().getName())){
                return true;
            }else{
                return false;
            }
        }
    }
}
