package com.example.imgflix.utilities.Item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallBack extends ItemTouchHelper.Callback {
   private final TouchHelperAdapter adapter;
   private SimpleItemTouchHelperCallBack(TouchHelperAdapter adapter){
       this.adapter= adapter;
   }
    @Override
    public boolean isLongPressDragEnabled() {//drag gesture is enabled
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {//swipe gesture is enabled
        return true;
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
       final int dragFlags= ItemTouchHelper.UP|ItemTouchHelper.DOWN;
       final int swipeFlags = ItemTouchHelper.START| ItemTouchHelper.END;
        return  makeMovementFlags(dragFlags,swipeFlags);//inform the ItemTouchHelper which movement direction is supported
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
       //notifies the adapter which element has moved
        if(viewHolder.getItemViewType()!= target.getItemViewType()){
            return false;
        }
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
       //this method notifies the adapter an item has been dismissed
        adapter.onItemDismiss(viewHolder.getAdapterPosition());

    }
}
