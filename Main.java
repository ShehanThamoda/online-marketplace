import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        OnlineSaleSystem onlineSaleSystem = new OnlineSaleSystem();
        HashMap<String,Integer> addDraft = new HashMap<>();
        addDraft.put("Orange",30);
        addDraft.put("Oxy meter",100);
        addDraft.put("Mask",1000);

        HashMap<String,Integer> addDraft2 = new HashMap<>();
        addDraft2.put("Apple",30000);
        addDraft2.put("Grapes",10);
        addDraft2.put("Phones",1000);

        HashMap<String,Integer> buyItems = new HashMap<>();
        buyItems.put("Orange",5);
        buyItems.put("Mask",1);

        HashMap<String,Integer> buyItems2 = new HashMap<>();
        buyItems2.put("Apple",5);
        buyItems2.put("Mask",1);

        HashMap<String,Integer> buyItems3 = new HashMap<>();
        buyItems3.put("Apple",5);
        buyItems3.put("Grapes",10);

        onlineSaleSystem.addDraft(addDraft);        // add draft list to the system by seller
        onlineSaleSystem.createItemList(buyItems);  // going to create a item list by buyer before submit the draft list
        onlineSaleSystem.addDraft(addDraft2);       // add another draft list to the system by seller
        onlineSaleSystem.printAvailabeDraftList();  // print the existing draft list by seller
        onlineSaleSystem.deleteDraftList(addDraft); // delete the first draft list before submitting it by seller
        onlineSaleSystem.printAvailabeDraftList();  // print the existing draft list and check previous deleted list whether deleted or not in the system by seller
        onlineSaleSystem.proceedPayment(120,1000);  //proceed the payment before create the item list by buyer
        onlineSaleSystem.submitDraft();             // submitting that 2nd draft list now by seller
        onlineSaleSystem.createItemList(buyItems);  // going to create the items now by buyer. But those items are not available in the system.
        onlineSaleSystem.proceedPayment(100,1000); // going to doing a payments while cart is empty
        onlineSaleSystem.createItemList(buyItems2); // going to create the items now by buyer. But only one item available and another item is not in the system.
        onlineSaleSystem.proceedPayment(100,1000); //  proceed the payment for that available item
        onlineSaleSystem.createItemList(buyItems3); // going to create the items again by buyer, then move to the available page.
        onlineSaleSystem.createItemList(buyItems3); // now add the items again by buyer
        onlineSaleSystem.printAvailabeDraftList();  //check available draft list.
        onlineSaleSystem.proceedPayment(100,10); //  proceed the payment, but credit card balance is not enough to buy the items
        onlineSaleSystem.printAvailabeDraftList();  //check available draft list.
    }

}
