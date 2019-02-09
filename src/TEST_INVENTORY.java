public class TEST_INVENTORY {
    public static void main(String[] args){
        Character joueur1 = new Character(100, 100);
        Item potion = new Item("Potion bleue", "", joueur1, "PV", "+", 20);
        joueur1.addItem(potion);
        System.out.println(joueur1.getItem("Potion bleue"));
    }

}
