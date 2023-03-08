public class Card {
    private Integer cardId;
    private String cardName;
    private Integer pinCode; // length = 1000 | 9999
    private Double summa; // balance >= 0
    private Long cardCode; // length = 16

    public String toCard() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", pinCode=" + pinCode +
                ", summa=" + summa +
                ", cardCode=" + cardCode +
                ", status=" + status +
                '}';
    }
    public String getCardName() {
        return cardName;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Long getCardCode() {
        return cardCode;
    }

    public void setCardCode(Long cardCode) {
        this.cardCode = cardCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Card(String cardName, Integer pinCode, Double summa, Long cardCode, Boolean status) {
        this.cardName = cardName;
        this.pinCode = pinCode;
        this.summa = summa;
        this.cardCode = cardCode;
        this.status = status;
    }

    private Boolean status; // status = true
}
