
package com.recipebook.api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Ingredient {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String quantity;

    public Ingredient() {}

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (quantity == null) {
            if (other.quantity != null) {
                return false;
            }
        } else if (!quantity.equals(other.quantity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", quantity=" + quantity + "]";
    }
}
