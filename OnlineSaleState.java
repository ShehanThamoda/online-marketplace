import java.util.HashMap;

/**
 * @des in here has all states which are sellers and buyers doing
 */
public interface OnlineSaleState {

    void addDraft(HashMap<String,Integer> draftList);
    void submitDraft();
    void deleteDraftList(HashMap<String,Integer> draftList);
    void createItemList(HashMap<String,Integer> itemList);
    void proceedPayment(double itemPrice,double cardValue);
}
