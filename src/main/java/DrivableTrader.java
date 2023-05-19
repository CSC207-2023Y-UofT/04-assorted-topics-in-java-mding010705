/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;
public class DrivableTrader<T> extends Trader<T>{
    private final List<T> inventory;
    private final List<T> wishlist;
    private int money;
    public DrivableTrader(List<T> inventory, List<T> wishlist,
                          int money){
        super(inventory, wishlist, money);
        this.inventory = inventory;
        this.wishlist = wishlist;
        this.money = money;
        for (T i : this.inventory){
            if (!(i instanceof Drivable)){
                this.inventory.remove(i);
            }
        }
        for (T w : this.wishlist){
            if(!(w instanceof Drivable)){
                this.wishlist.remove(w);
            }
        }
    }

    public DrivableTrader(int money){
        super(money);
        this.inventory = new ArrayList<T>();
        this.wishlist = new ArrayList<T>();
        this.money = money;
    }
    @Override
    public int getSellingPrice(T obj){
        if (obj instanceof Tradable){
            return ((Tradable) obj).getPrice() + ((Drivable) obj).getMaxSpeed();
        }
        return Tradable.MISSING_PRICE;
    }
}