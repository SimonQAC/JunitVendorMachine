package vendormachine.vendors;

import vendormachine.users.Person;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DrinkVendingMachine {

    private BRANDS brandName = null;
    private float availableCredit = 0;
    private ArrayList<Snack> drinkList = new ArrayList<Snack>();

    public DrinkVendingMachine(){
        int size = BRANDS.values().length;
        int index = (int)(Math.random()) * size;

        //Select random Brand
        this.brandName = BRANDS.values()[index];
        populateDrinkList();
    }

    public DrinkVendingMachine(float startCredit, BRANDS brand) {
        this.availableCredit = startCredit;
        this.brandName = brand;

        populateDrinkList();
    }
    

    //Don't worry this is just populating our drink list
    private void populateDrinkList(){
        this.drinkList.addAll(Arrays.asList(DefaultSnacks.snackList));
    }

    // This is how we'll select our "snack" from the array
    public Snack selectDrink(int arrayPosition){
        if(arrayPosition >=  drinkList.size() || arrayPosition > 0) {
            Snack selection = drinkList.get(arrayPosition);

            if(this.availableCredit < selection.cost()){
                //TODO replace with Log4j
                System.out.println("WARNING: you do not have enough credit!");
                System.out.println("WARNING: machine credit - £" + this.availableCredit);
                return null;
            }
            else {
                // let's deduct machine credit
                availableCredit -= selection.cost();
                return selection;
            }
        }
        else{
            //TODO replace with Log4j
            System.out.println("WARNING: Item does not exist.");
            return null;
        }
    }

    public void giveCredit(Person user, float credit){
        //TODO replace with Log4j
        System.out.println("INFO: You have entered �"+credit);
        this.availableCredit += user.getCredit(credit);
    }

	public BRANDS getBrandName() {
		return brandName;
	}

	public void setBrandName(BRANDS brandName) {
		this.brandName = brandName;
	}

	public float getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(float availableCredit) {
		this.availableCredit = availableCredit;
	}

	public ArrayList<Snack> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(ArrayList<Snack> drinkList) {
		this.drinkList = drinkList;
	}



}
