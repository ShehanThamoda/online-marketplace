import java.util.HashMap;
import java.util.Map;

public class DraftDelete implements OnlineSaleState {

    OnlineSaleSystem onlineSaleSystem;

    public DraftDelete(OnlineSaleSystem newOnlineSale){
        onlineSaleSystem = newOnlineSale;
    }

    @Override
    public void addDraft(HashMap<String,Integer> draftList) {
        try{
            if(draftList.size()>0) {
                for (Map.Entry<String, Integer> entry : draftList.entrySet()) {
                    onlineSaleSystem.availabeDraftList.put(entry.getKey(), entry.getValue());
                }
                System.out.println("-Add draft list to the system");
                onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getDraftState());
            }else{
                System.out.println("-Cannot add the draft due to no records");
            }
        }catch (NullPointerException ex){
            System.out.println("System error. Sorry!");
        }
    }

    @Override
    public void submitDraft(){
        System.out.println("-Now draft list available in the system");
        onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getAvailableState());
        onlineSaleSystem.printAvailabeDraftList();
    }

    @Override
    public void deleteDraftList(HashMap<String,Integer> draftList) {
        System.out.println("-Draft already deleted");
    }

    @Override
    public void createItemList(HashMap<String,Integer> itemList) {
        System.out.println("-Check available items. Now create the item list");
        onlineSaleSystem.getAvailableState();
    }

    @Override
    public void proceedPayment(double itemPrice,double cardValu) {
        System.out.println("-Cannot proceed the payment in this stage");
    }
}
