public class SpaceMarineLieutenant extends Combatant implements Combatant.MeleeAttack {

    private String CloseQuartersWeapon;
    private int CloseQuartersWeaponStrength;
    public SpaceMarineLieutenant(String Name, int Toughness,int Wounds,String Weapon,int WeaponStrength ,String Species,String CloseQuartersWeapon, int CloseQuartersWeaponStrength) {
        super(Name,Toughness,Wounds,Weapon,WeaponStrength,Species);
        this.CloseQuartersWeapon = CloseQuartersWeapon;
        this.CloseQuartersWeaponStrength = CloseQuartersWeaponStrength;

    }
    public String getCloseQuartersWeapon() {return CloseQuartersWeapon;}
    public int getCloseQuartersWeaponStrength() {return CloseQuartersWeaponStrength;}

    @Override
    public void UseSpecialMelee() {

    }

    @Override
    public void Attack(Combatant Target) {

    }


}
