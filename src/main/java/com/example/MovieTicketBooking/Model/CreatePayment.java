package com.example.MovieTicketBooking.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePayment {
    @SerializedName("items")
    Object[] items;
    public Object[] getItems() {
        return items;
    }
}
