

public class BossNob extends Combatant {
    private String CloseQuartersWeapon;
    public BossNob(String Name, int Toughness,int Wounds,String Weapon,String Species,String CloseQuartersWeapon) {
        super(Name,Toughness,Wounds,Weapon,Species);
        this.CloseQuartersWeapon = CloseQuartersWeapon;

    }
    public String getCloseQuartersWeapon() {return CloseQuartersWeapon;}

}