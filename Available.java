import java.util.HashMap;
import java.util.Map;

public class Available implements OnlineSaleState {

    OnlineSaleSystem onlineSaleSystem;

    public Available(OnlineSaleSystem newOnlineSale){
        onlineSaleSystem = newOnlineSale;
    }

    @Override
    public void addDraft(HashMap<String,Integer> draftList) {
            System.out.println("-Move to draft list. Now add the draft list");
            onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getDraftState());
    }

    @Override
    public void submitDraft(){
        System.out.println("-Cannot submit any drafts in this stage");
    }

    @Override
    public void deleteDraftList(HashMap<String,Integer> draftList) {
        System.out.println("-Move to Draft. Try remove the list again");
        onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getDraftState());
    }

    @Override
    public void createItemList(HashMap<String,Integer> itemList) {
        try{
            onlineSaleSystem.buyItemList = new HashMap<>();
            for(Map.Entry<String,Integer> entry: itemList.entrySet()){
                if(onlineSaleSystem.availabeDraftList.get(entry.getKey())!=null) {
                    onlineSaleSystem.buyItemList.put(entry.getKey(), entry.getValue());
                    int balanceCount = onlineSaleSystem.availabeDraftList.get(entry.getKey()) - entry.getValue();
                    onlineSaleSystem.availabeDraftList.put(entry.getKey(), balanceCount);
                    onlineSaleSystem.proceedToPayment=true;
                    System.out.println("-Item added to cart successfully");
                }else{
                    System.out.println("-This item not found in the system. Item name:"+entry.getKey());
                }
            }
        }catch (NullPointerException ex){
            System.out.println("System error. Sorry!");
        }catch (Exception ex){
            System.out.println("System error. Sorry!");
        }
    }

    @Override
    public void proceedPayment(double itemPrice,double cardValue) {
        try {
            if (onlineSaleSystem.proceedToPayment) {
                if (itemPrice < cardValue) {
                    System.out.println("-Payment successfully and reserved the items");
                    onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getReserveState());
                } else {
                    System.out.println("-Payment fail and all items proceed back to the available");
                    for (Map.Entry<String, Integer> entry : onlineSaleSystem.buyItemList.entrySet()) {
                        int balanceCount = onlineSaleSystem.availabeDraftList.get(entry.getKey()) + entry.getValue();
                        onlineSaleSystem.availabeDraftList.put(entry.getKey(), balanceCount);
                    }
                    onlineSaleSystem.setOnlineSaleState(onlineSaleSystem.getAvailableState());
                }
            } else {
                System.out.println("-Payment cannot happen due to no items");
            }
        }catch (NullPointerException ex){
            System.out.println("System error. Sorry!");
        }catch (Exception ex){
            System.out.println("System error. Sorry!");
        }
    }
}
