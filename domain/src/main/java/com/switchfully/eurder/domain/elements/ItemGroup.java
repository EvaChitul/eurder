package com.switchfully.eurder.domain.elements;


import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ItemGroup {

    // Add price - retrieve from item by id?

    private final UUID itemId;
    private final int amount;
    private final int shippingDate;

    public ItemGroup(UUID itemId, int amount, int shippingDate) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
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
