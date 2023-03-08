import javax.sql.rowset.serial.SerialStruct;
import java.util.LinkedList;
import java.util.List;

public class Transaction {
    private List<ATM> atmList;
    private List<Card> cardList;
    private Integer atmIndex;
    private Integer cardIndex;
    public Transaction(){
        this.atmList = new LinkedList<>();
        this.cardList = new LinkedList<>();
        this.atmIndex = 0;
        this.cardIndex = 0;
    }

    public String addCard(Card card){
        if (card.getSumma() < 0){
            return "Not enough money";
        }
        if (card.getPinCode() != 4){
            return "Wrong pincode";
        }
        if (card.getCardCode() != 16){
            return "Wrong cardcode";
        }
        card.setCardId(++this.cardIndex);
        card.setStatus(true);
        this.cardList.add(card);
        return "Card is successfull created";
    }

    public String addATM(ATM atm){
        if (atm.getBalance() < 0){
            return "Not enough money";
        }
        atm.setMachineId(++this.atmIndex);
        atm.setStatus(true);
        this.atmList.add(atm);
        return "ATM is successful created";
    }

    public String getCard(Integer cartId){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cartId)){
               return card.toCard();
            }
        }
        return "Card is not found";
    }

    public String getATM(Integer machineId){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)){
                return atm.toATM();
            }
        }
        return "ATM is not found";
    }

    public String removeCard(Integer id){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(id)){
                this.cardList.remove(card);
                return "Card is successful deleted";
            }
        }
        return "Card is not found";
    }

    public String removeATM(Integer id){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(id)){
                this.atmList.remove(atm);
                return "ATM is successful deleted";
            }
        }
        return "ATM is not found";
    }

    public String addMoneyToCard(Integer cardId, Integer pincode, Double balance){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pincode)){
                    card.setSumma(card.getSumma() + balance);
                    return "Successful added money to Card";
                }else {
                    return "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }

    public String addMoneyToATM(Integer machineId, Double balance){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)){
                atm.setBalance(atm.getBalance() + balance);
                return "Successful added money to ATM";
            }
        }
        return "ATM is not found";
    }

    public String removeMoneyToCard(Integer cardId, Integer pinCode, Double summa){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pinCode)){
                    if (card.getSumma() > summa){
                        card.setSumma(card.getSumma() - summa);
                        this.cardList.add(card);
                        return "The money withdrawn";
                    }else {
                        return "Not eough money at Card";
                    }
                }else {
                    return "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }
    public String removeMoneyToATM(Integer machineId, Double summa){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)){
                if (atm.getBalance() > summa){
                    atm.setBalance(atm.getBalance() - summa);
                    this.atmList.add(atm);
                    return "The money withdarwn";
                }else {
                    return "Not enouhg money at ATM";
                }
            }
        }
        return "ATM is not found";
    }
    public String getCash(Integer cardId, Integer machineId, Integer pinCode, Integer cash){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pinCode)){
                    if (card.getSumma() > cash){
                        for (ATM atm : this.atmList) {
                            if (atm.getMachineId().equals(machineId)){
                                if (atm.getBalance() > cash){
                                    card.setSumma(card.getSumma() - cash);
                                    atm.setBalance(atm.getBalance() - cash);
                                    this.cardList.add(card);
                                    this.atmList.add(atm);
                                    return "Successful withdraw money";
                                }else {
                                    return "Not enough money at ATM";
                                }
                            }else {
                                return "ATM is not found";
                            }
                        }
                    }else {
                        return "Not enough money at Card";
                    }
                }else {
                    return "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }

    public String changePinCodeInCard(Integer cardId, Integer oldPin, Integer newPin){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(oldPin)){
                    card.setPinCode(newPin);
                    this.cardList.add(card);
                    return "Successful changed pincode";
                }else {
                    return "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }

    public String sendmoney(Integer senderCardId, Integer pinCode, Integer receivecardId, Long cardCode, Double summa){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(senderCardId)){
                if (card.getPinCode().equals(pinCode)){
                    for (Card card1 : this.cardList) {
                        if (card1.getCardId().equals(receivecardId)){
                            if (card1.getCardCode().equals(cardCode)){
                                if (card.getSumma() > summa){
                                    card.setSumma(card.getSumma() - summa);
                                    card1.setSumma(card1.getSumma() + summa);

                                }else {
                                    return "Not enough money at Card";
                                }
                            }else {
                                return "Wrong cardcode";
                            }
                        }else {
                            return "Card1 is not found";
                        }
                    }
                }else {
                    return "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }
}
