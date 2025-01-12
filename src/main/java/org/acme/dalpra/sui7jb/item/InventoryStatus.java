package org.acme.dalpra.sui7jb.item;


import io.quarkus.runtime.annotations.RegisterForReflection;
import java.util.Locale;

@RegisterForReflection
public enum InventoryStatus {
    INSTOCK("In Stock"),
    OUTOFSTOCK("Out of Stock"),
    LOWSTOCK("Low Stock");

    private final String text;

    InventoryStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getStatusName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
