package com.mclegoman.inventoryupdate.util;

public class InventoryPair<A, B> {
    private A left;
    private B right;

    public InventoryPair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    public A getLeft() {
        return this.left;
    }

    public void setLeft(A left) {
        this.left = left;
    }

    public B getRight() {
        return this.right;
    }

    public void setRight(B right) {
        this.right = right;
    }
}
