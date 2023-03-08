public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        Card card = new Card("Uzcard", 1010, 1000D, 8600332956632536L, true);
        ATM atm = new ATM(10000D, "Chilonzor", true);
    }
}