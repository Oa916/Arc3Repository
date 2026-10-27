import java.util.ArrayList;

public static void main(String[] args) {

ArrayList<Combatant> roster = new ArrayList<>();
roster.add(new BossNob("Guz", 2, 2,"Kombi-weapon", 4,"Ork", "Power Klaw" , 9));
roster.add(new Boy("Grunt", 2,2, "Slugga", 4,"Ork"));


for (Combatant c : roster) {
    System.out.println(c);
}

}