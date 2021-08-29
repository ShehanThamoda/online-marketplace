import java.util.HashMap;

public class Reserve implements OnlineSaleState {

    OnlineSaleSystem onlineSaleSystem;

    public Reserve(OnlineSaleSystem newOnlineSale){
        onlineSaleSystem = newOnlineSale;
    }

    @Override
    public void addDraft(HashMap<String,Integer> draftList) {
        System.out.println("-Move to draft list. Now add the draft list");
        onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getDraftState());
    }

    @Override
    public void submitDraft(){
        System.out.println("-Cannot submit the drafts in this stage");
    }

    @Override
    public void deleteDraftList(HashMap<String,Integer> draftList) {
        System.out.println("-Move to Draft. Try remove the list again");
    }

    @Override
    public void createItemList(HashMap<String,Integer> itemList) {
        System.out.println("-Move to available list. Now create the item list");
        onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getAvailableState());
        onlineSaleSystem.printAvailabeDraftList();
    }

    @Override
    public void proceedPayment(double itemPrice,double cardValu) {
        System.out.println("-Select the items first");
    }
}
