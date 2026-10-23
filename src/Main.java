import java.util.ArrayList;
static void main(String[] args) {

ArrayList<Combatant> roster = new ArrayList<>();
roster.add(new BossNob("Guz", 2, 2,"Kombi-weapon","Ork", "Power Klaw"));
roster.add(new Boy("Grunt", 2,2, "Slugga", "Ork"));


for (Combatant c : roster) {
    System.out.println(c);
}

}