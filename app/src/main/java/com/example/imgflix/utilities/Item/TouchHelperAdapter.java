package com.example.imgflix.utilities.Item;

public interface TouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);//called when a user moves an item by dragging it
    void onItemDismiss(int position);//called when an item has been dismissed with a swipe motion
}
