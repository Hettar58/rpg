import java.util.ArrayList;

public class Inventory {
    protected ArrayList<InventoryItem> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public void addItem(String item, int quantity){
        inventory.add(new InventoryItem(item, quantity));
    }

    public String useItem(String item){
        InventoryItem it = new InventoryItem(item, 1);
        for (InventoryItem i : inventory){
            if (it.equals(i)){
                if (i.getQuantity() -1 >= 0) {
                    i.setQuantity(i.getQuantity() - 1);
                    return i.getItem();
                }
                else{
                    return null;
                }
            }
        }
        return null;
    }

    public InventoryItem getItem(String item){
        InventoryItem it = new InventoryItem(item, 1);
        for (InventoryItem i : inventory){
            if (it.equals(i)){
                return i;
            }
        }
        return null;
    }

    public class InventoryItem{
        private int quantity;
        private String item;

        public InventoryItem(String item, int quantity){
            this.item = item;
            this.quantity = quantity;
        }

        public int getQuantity(){return this.quantity;}
        public String getItem(){return this.item;}
        public void setQuantity(int quantity){this.quantity = quantity;}
        public void setItem(String item){this.item = item;}

        public boolean equals(InventoryItem i){
            if (i.getItem() == this.getItem()){
                return true;
            }else{
                return false;
            }
        }
    }
}
