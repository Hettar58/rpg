public class test_inventory {
    public static void main(String[] args){
        Inventory inv = new Inventory();
        inv.addItem("Potion bleue", 5);
        System.out.println(inv.useItem("Potion bleue"));
        System.out.println(inv.getItem("Potion bleue").getQuantity());
    }
}
