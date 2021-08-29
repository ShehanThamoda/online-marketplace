import java.util.HashMap;
import java.util.Map;

public class Draft implements OnlineSaleState {

    OnlineSaleSystem onlineSaleSystem;

    public Draft(OnlineSaleSystem newOnlineSale){
      onlineSaleSystem = newOnlineSale;
    }

    @Override
    public void addDraft(HashMap<String,Integer> draftList) {
        try {
            onlineSaleSystem.printAvailabeDraftList();
            if (draftList.size() > 0) {
                if (onlineSaleSystem.availabeDraftList == null)
                    onlineSaleSystem.availabeDraftList = new HashMap<>();
                for (Map.Entry<String, Integer> entry : draftList.entrySet()) {
                    onlineSaleSystem.availabeDraftList.put(entry.getKey(), entry.getValue());
                }
                System.out.println("-Add draft list to the system");
            } else {
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
        try {
            for (Map.Entry<String, Integer> entry : draftList.entrySet()) {
                if (onlineSaleSystem.availabeDraftList.containsKey(entry.getKey())) {
                    onlineSaleSystem.availabeDraftList.remove(entry.getKey());
                }
            }
            System.out.println("-Deleted the draft List");
            onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getDraftDeleteState());
        }catch (NullPointerException ex){
            System.out.println("System error. Sorry!");
        }
    }

    @Override
    public void createItemList(HashMap<String,Integer> itemList) {
        System.out.println("-Cannot create the item list in this stage");
    }

    @Override
    public void proceedPayment(double itemPrice,double cardValu) {
        System.out.println("-Cannot proceed the payment in this stage");
    }
}
