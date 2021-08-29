import java.util.HashMap;

/**
 * @des in here describe the all methods for use this system
 */
public class OnlineSaleSystem {

    OnlineSaleState onlineSaleState;

    OnlineSaleState draft;
    OnlineSaleState draftDelete;
    OnlineSaleState available;
    OnlineSaleState reserve;

    public HashMap<String,Integer> availabeDraftList;
    public HashMap<String,Integer> buyItemList;
    public boolean proceedToPayment;

    public OnlineSaleSystem(){
        draft = new Draft(this);
        draftDelete = new DraftDelete(this);
        available = new Available(this);
        reserve = new Reserve(this);
        //default state set
        onlineSaleState = draft;
        proceedToPayment = false;
    }

    void setOnlineSaleState(OnlineSaleState newOnlineSaleState){
        onlineSaleState = newOnlineSaleState;
    }
    //these methods use for doing tasks in this application
    public void addDraft(HashMap<String,Integer> draftList){
        onlineSaleState.addDraft(draftList);
    }
    public void submitDraft(){
        onlineSaleState.submitDraft();
    }
    public void deleteDraftList(HashMap<String,Integer> draftList){
        onlineSaleState.deleteDraftList(draftList);
    }
    public void createItemList(HashMap<String,Integer> itemList){
        onlineSaleState.createItemList(itemList);
    }
    public void proceedPayment(double itemPrice,double cardValu){
        onlineSaleState.proceedPayment(itemPrice,cardValu);
    }
    public void printAvailabeDraftList(){
        System.out.println("===========AVAILABLE DRAFT LIST============");
        if(availabeDraftList!=null){
            availabeDraftList.entrySet().forEach(entry -> {
                System.out.println(entry.getKey()+" "+entry.getValue());
            });
        }else{
            System.out.println("Currently no drafts on the system");
        }
        System.out.println("===========================================");
    }
    public void printBuyItemList(){
        System.out.println("===========PRINT CURRENT ITEM LIST============");
        if(buyItemList!=null) {
            buyItemList.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
        }else{
            System.out.println("Currently no items selected for purchase");
        }
        System.out.println("==============================================");
    }

    public OnlineSaleState getDraftState() {
        return draft;
    }
    public OnlineSaleState getDraftDeleteState() {
        return draftDelete;
    }
    public OnlineSaleState getAvailableState() {
        return available;
    }
    public OnlineSaleState getReserveState() {
        return reserve;
    }


}
