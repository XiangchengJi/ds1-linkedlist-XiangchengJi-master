package com.applilcation.answer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyQueueAdapter extends RecyclerView.Adapter<MyQueueAdapter.HomeViewHolder> {
    private MyQueue<String> myQueue;

    public MyQueueAdapter(MyQueue<String> myQueue) {
        this.myQueue = myQueue;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(parent.getContext(), R.layout.item_my_queue, null);
        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        holder.tv_msg.setText(myQueue.get(position));
    }

    @Override
    public int getItemCount() {
        return myQueue.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_msg;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_msg = itemView.findViewById(R.id.tv_msg);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}