package com.switchfully.eurder.domain.elements;


import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ItemGroup {

    private final UUID itemId;
    private int amount;
    private final int shippingDate;

    public ItemGroup(UUID itemId, int amount, int shippingDate) {
        if(!validateInput(itemId, amount)) throw new IllegalArgumentException("Cannot create ItemGroup with given parameters");
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    // Validation of ItemId done before? TBC

    private boolean validateInput(UUID itemId, int amount) {
        return itemId != null && !itemId.toString().equals("") && !itemId.toString().equals(" ") && amount > 0;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public int getShippingDate() {
        return shippingDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return Objects.equals(itemId, itemGroup.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }


}
